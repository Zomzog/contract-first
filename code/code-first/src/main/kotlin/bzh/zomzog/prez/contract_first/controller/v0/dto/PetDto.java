package bzh.zomzog.prez.contract_first.controller.v0.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PETS")
public class PetDto {
    @Id
    @NotNull
    @Min(0)
    private Long id;
    @NotNull
    @Size(min = 2, max = 30)
    private String name;
    @NotNull
    private PetType type;
    @Size(min = 10, max = 100)
    private String description;

    @JsonIgnore
    private boolean iDoSomething;
}
