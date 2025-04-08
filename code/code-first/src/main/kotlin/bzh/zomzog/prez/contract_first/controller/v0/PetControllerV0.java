package bzh.zomzog.prez.contract_first.controller.v0;

import bzh.zomzog.prez.contract_first.controller.v0.dto.PetDto;
import bzh.zomzog.prez.contract_first.domain.Pet;
import bzh.zomzog.prez.contract_first.domain.PetService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static bzh.zomzog.prez.contract_first.controller.v0.dto.PetType.DOG;

@RestController
@RequestMapping("/v0")
@AllArgsConstructor
public class PetControllerV0 {

    private final PetService service;

    @GetMapping("/pets")
    public ResponseEntity<Page<PetDto>> pagePets(@RequestParam String name, Pageable page) {
        var result = service.pagePets(name, page)
                .map(this::toDto);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/pets")
    public ResponseEntity<PetDto> createPet(@RequestBody PetDto pet) {
        var domain = toDomain(pet);
        var result = service.createPet(domain);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(toDto(result));
    }

    @PostMapping("/pets/{petId}")
    public ResponseEntity<PetDto> updatePet(@PathVariable Long petId, @RequestBody PetDto pet) {
        var domain = toDomain(pet);
        var result = service.updatePet(domain);
        return ResponseEntity.ok(toDto(result));
    }

    private PetDto toDto(Pet p) {
        return new PetDto(p.getId(), p.getName(), DOG, "", false);
    }

    private Pet toDomain(PetDto p) {
        return new Pet(p.getId(), p.getName());
    }
}
