package org.openapitools.api;

import org.openapitools.model.Pony;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-12-02T22:26:12.093+01:00[Europe/Paris]")

@Controller
@RequestMapping("${openapi.myLittlePony.base-path:}")
public class PoniesApiController implements PoniesApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PoniesApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<Pony>> list(@Valid String name) {
        return ResponseEntity.ok(Arrays.asList(new Pony().id("id").name("name")));
    }
}
