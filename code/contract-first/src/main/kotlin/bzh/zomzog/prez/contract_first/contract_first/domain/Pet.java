package bzh.zomzog.prez.contract_first.contract_first.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Pet {
    private Long id;
    private String name;
}
