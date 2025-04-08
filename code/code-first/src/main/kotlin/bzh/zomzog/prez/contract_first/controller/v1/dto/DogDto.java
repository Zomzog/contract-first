package bzh.zomzog.prez.contract_first.controller.v1.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DogDto extends PetDto {
    @Min(0)
    @Max(10)
    @NotNull
    private int category;

    public DogDto(Long id, String name, PetType type, Integer category) {
        super(id, name, type, "");
        this.category = category;
    }
}
