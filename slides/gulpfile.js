const { src, dest, watch, series, parallel } = require('gulp');
const tap = require('gulp-tap')

const convertToHtml = require('./convert-to-html');
const browsersync = require("browser-sync").create();

function addRevealJsDependencies(cb) {
    return src('node_modules/reveal.js/{css,js,lib,plugin}/**/*.*')
        .pipe(dest('build/dist/node_modules/reveal.js'))
    cb();
}

function addNoJekyllForGithub(cb) {
    src('src/**/*.nojekyll')
        .pipe(dest('build/dist'))
    cb();
}
const init = series(addRevealJsDependencies, addNoJekyllForGithub)

function convert(cb) {
    return src('src/**/*.adoc')
        .pipe(convertToHtml())
    cb();
}

function copyHtml(cb) {
    src('src/**/*.html')
        .pipe(tap((file) => {
        const newFile = file.contents.toString();
        const newContents = newFile.replace('</body>', '<script src="js/custom.js"></script>');
        file.contents = Buffer.from(newContents);
        return file;
        }))
        .pipe(dest('build/dist'))
    cb();
}

function copyStatics(cb) {
  src('src/**/*.{svg,png,jpg,gif,css,js}')
    .pipe(dest('build/dist'))
    cb();
}

const build = series(convert, parallel(copyHtml, copyStatics))

function watchFiles() {
    watch("src/css/**/*", series(copyStatics, browserSyncStream))
    watch("src/js/**/*", series(copyStatics, browserSyncReload))
    watch("src/images/**/*", series(copyStatics, browserSyncReload))
    watch('src/**/*.adoc', series(build, browserSyncReload))
};

// BrowserSync
function browserSync(done) {
    browsersync.init({
      server: {
        baseDir: "./build/dist/"
      },
      notify: false,
      port: 3000
    });
    done();
}
function browserSyncReload(done) {
    browsersync.reload();
    done();
}
function browserSyncStream(done) {
    browsersync.reload();
    done();
}

exports.default = series(init, build)
exports.serve = series(init, build, parallel(watchFiles, browserSync))