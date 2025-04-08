package bzh.zomzog.prez.contract_first.controller.v1.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CatDto extends PetDto {

    public CatDto(Long id, String name, PetType type) {
        super(id, name, type, "");
    }
}
