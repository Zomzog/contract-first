package bzh.zomzog.prez.contract_first.controller.v2;

import bzh.zomzog.prez.contract_first.controller.v2.dto.CatDto;
import bzh.zomzog.prez.contract_first.controller.v2.dto.DogDto;
import bzh.zomzog.prez.contract_first.domain.Cat;
import bzh.zomzog.prez.contract_first.domain.Dog;
import bzh.zomzog.prez.contract_first.domain.Pet;
import bzh.zomzog.prez.contract_first.domain.PetService;
import bzh.zomzog.prez.contract_first.controller.v2.dto.PetDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static bzh.zomzog.prez.contract_first.controller.v2.dto.PetType.CAT;
import static bzh.zomzog.prez.contract_first.controller.v2.dto.PetType.DOG;

@RestController
@RequestMapping("/v2")
@AllArgsConstructor
public class PetControllerV2 {

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
        return ResponseEntity.ok(toDto(result));
    }

    @PostMapping("/pets/{petId}")
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
