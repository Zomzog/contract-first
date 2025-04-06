package bzh.zomzog.prez.contract_first.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Cat extends Pet {
    public Cat(Long id, String name) {
        super(id, name);
    }
}
