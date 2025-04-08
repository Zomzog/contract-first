package bzh.zomzog.prez.contract_first.demo;

import bzh.zomzog.prez.contract_first.demo.controller.api.PoniesApi;
import bzh.zomzog.prez.contract_first.demo.controller.dto.PonyDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PonyController implements PoniesApi {

    @Operation(
            operationId = "callList",
            summary = "List",
            tags = { "ponies" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Status 200", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PonyDto.class)))
                    }),
                    @ApiResponse(responseCode = "400", description = "Status 400")
            }
    )
    @GetMapping(
            value = "/ponies",
            produces = { "application/json" }
    )
    public ResponseEntity<List<PonyDto>> callList(String name) {
        return ResponseEntity.ok(List.of(new PonyDto().id("1").name(name)));
    }

    @Operation(
            operationId = "create",
            summary = "Create",
            tags = { "ponies" },
            responses = {
                    @ApiResponse(responseCode = "201", description = "Status 201", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = PonyDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Status 400")
            }
    )
    @PostMapping(
            value = "/ponies",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<PonyDto> create(@Valid @RequestBody PonyDto ponyDto) {
        return ResponseEntity.status(201).body(ponyDto);
    }
}
