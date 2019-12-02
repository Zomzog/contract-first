package org.openapitools.api;

import org.openapitools.model.Pony;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PonyController implements PoniesApi {

    @Override
    public ResponseEntity<Pony> getOne(String ponyId) {
        return ResponseEntity.ok(new Pony().name("Rainbow Dash"));
    }
}
