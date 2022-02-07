
'use strict';
const map = require('map-stream');

// Load asciidoctor.js and asciidoctor-reveal.js
var asciidoctor = require('@asciidoctor/core')()
var asciidoctorRevealjs = require('@asciidoctor/reveal.js')
asciidoctorRevealjs.register()

/**
 * This function receives a stream with different metadata on asciidoc files. For example
 *
 * The aim is to replace adoc extension by html extensions
 *
 * @returns {stream}
 */
module.exports = function () {

  return map((file, next) => {
    // Convert the document 'presentation.adoc' using the reveal.js converter
    const attributes = {'revealjsdir': 'node_modules/reveal.js@'};
    const options = {safe: 'safe', backend: 'revealjs', attributes: attributes};
    asciidoctor.convertFile(file.path, options);

    next(null, file);
  });
};