package bzh.zomzog.prez.contract_first.contract_first.controller;

import bzh.zomzog.prez.contract_first.contract_first.controller.dto.PetDto;
import bzh.zomzog.prez.contract_first.contract_first.domain.Cat;
import bzh.zomzog.prez.contract_first.contract_first.domain.Dog;
import bzh.zomzog.prez.contract_first.contract_first.domain.Pet;
import org.mapstruct.Mapper;
import bzh.zomzog.prez.contract_first.contract_first.controller.dto.PagePetDto;
import org.springframework.data.domain.Page;
import bzh.zomzog.prez.contract_first.contract_first.controller.dto.DogDto;
import bzh.zomzog.prez.contract_first.contract_first.controller.dto.CatDto;

@Mapper(componentModel = "spring")
public abstract class DtoMapper {

    public PetDto toDto(Pet pet) {
        return switch (pet) {
            case Dog d -> toDto(d);
            case Cat c -> toDto(c);
            default -> throw new RuntimeException("todo");
        };
    }

    protected abstract DogDto toDto(Dog dog);

    protected abstract CatDto toDto(Cat cat);

    public Pet toDomain(PetDto dto) {
        return switch (dto) {
            case DogDto d -> toDomain(d);
            case CatDto c -> toDomain(c);
            default -> throw new RuntimeException("todo");
        };
    }

    protected abstract Dog toDomain(DogDto dto);

    protected abstract Cat toDomain(CatDto dto);

    public abstract PagePetDto map(Page<PetDto> page);
}
