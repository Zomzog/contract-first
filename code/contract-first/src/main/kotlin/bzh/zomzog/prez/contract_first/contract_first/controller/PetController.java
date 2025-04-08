package bzh.zomzog.prez.contract_first.contract_first.controller;

import bzh.zomzog.prez.contract_first.contract_first.controller.api.PetControllerApi;
import bzh.zomzog.prez.contract_first.contract_first.controller.dto.PagePetDto;
import bzh.zomzog.prez.contract_first.contract_first.controller.dto.PetDto;
import bzh.zomzog.prez.contract_first.contract_first.domain.Cat;
import bzh.zomzog.prez.contract_first.contract_first.domain.Dog;
import bzh.zomzog.prez.contract_first.contract_first.domain.Pet;
import bzh.zomzog.prez.contract_first.contract_first.domain.PetService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static bzh.zomzog.prez.contract_first.contract_first.controller.dto.PetDto.TypeEnum.CAT;
import static bzh.zomzog.prez.contract_first.contract_first.controller.dto.PetDto.TypeEnum.DOG;

@RestController
@AllArgsConstructor
public class PetController implements PetControllerApi {

    private final PetService service;

    private final DtoMapper mapper;

    @Override
    public ResponseEntity<PagePetDto> pagePets(String name, Pageable page) {
        var result = service.pagePets(name, page)
                .map(mapper::toDto);
        return ResponseEntity.ok(mapper.map(result));
    }

    @Override
    public ResponseEntity<PetDto> createPet(PetDto petDto) {
        var domain = mapper.toDomain(petDto);
        var result = service.createPet(domain);
        return ResponseEntity.ok(mapper.toDto(result));
    }

    @PostMapping("/pets/{petId}")
    public ResponseEntity<PetDto> updatePet(@PathVariable Long petId, @RequestBody PetDto pet) {
        var domain = mapper.toDomain(pet);
        var result = service.updatePet(domain);
        return ResponseEntity.ok(mapper.toDto(result));
    }

}
