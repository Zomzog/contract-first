package bzh.zomzog.prez.contract_first.controller.v2.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DogDto extends PetDto {
    private int category;

    public DogDto(Long id, String name, PetType type, Integer category) {
        super(id, name, type);
        this.category = category;
    }
}
