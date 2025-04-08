package bzh.zomzog.prez.contract_first.controller.v1;

import bzh.zomzog.prez.contract_first.controller.v1.dto.CatDto;
import bzh.zomzog.prez.contract_first.controller.v1.dto.DogDto;
import bzh.zomzog.prez.contract_first.domain.*;
import bzh.zomzog.prez.contract_first.controller.v1.dto.PetDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import static bzh.zomzog.prez.contract_first.controller.v1.dto.PetType.CAT;
import static bzh.zomzog.prez.contract_first.controller.v1.dto.PetType.DOG;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class PetControllerV1 {

    private final PetService service;

    @GetMapping("/pets")
    public ResponseEntity<Page<PetDto>> pagePets(@RequestParam String name, Pageable page) {
        var result = service.pagePets(name, page)
                .map(this::toDto);
        return ResponseEntity.ok(result);
    }

    @Operation(
            summary = "Create a new pet",
            description = "Create a new pet after validating it is not already exist in the database",
            operationId = "createPet",
            tags = { "pet-controller-v-1" },
            responses = {
                    @ApiResponse(responseCode = "201", description = "Pet created", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = PetDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "The request is invalid", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MyError.class))
                    })
            }
    )
    @PostMapping("/pets")
    public ResponseEntity<PetDto> createPet(@RequestBody PetDto pet) {
        var domain = toDomain(pet);
        var result = service.createPet(domain);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(toDto(result));
    }

    @Operation(
            summary = "Update an existing pet",
            description = "Update an existing pet, only allow an update of the description and the category",
            operationId = "createPet",
            tags = { "pet-controller-v-1" },
            responses = {
                    @ApiResponse(responseCode = "201", description = "Pet created", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = PetDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "The request is invalid", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MyError.class))
                    })
            }
    )
    @PutMapping("/pets/{petId}")
    public ResponseEntity<PetDto> updatePet(@PathVariable Long petId, @RequestBody PetDto pet) {
        var domain = toDomain(pet);
        var result = service.updatePet(domain);
        return ResponseEntity.ok(toDto(result));
    }

    private PetDto toDto(Pet p) {
        return switch (p) {
            case Dog d -> new DogDto(d.getId(), d.getName(), DOG, d.getCategory());
            case Cat c -> new CatDto(c.getId(), c.getName(), CAT);
            default -> throw new RuntimeException("failed");
        };
    }

    private Pet toDomain(PetDto p) {
        return switch (p) {
            case DogDto d -> new Dog(d.getId(), d.getName(), d.getCategory());
            case CatDto c -> new Cat(c.getId(), c.getName());
            default -> throw new RuntimeException("failed");
        };
    }
}
