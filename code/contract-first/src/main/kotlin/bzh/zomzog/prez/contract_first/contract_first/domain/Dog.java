package bzh.zomzog.prez.contract_first.contract_first.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Dog extends Pet {
    private Integer category;

    public Dog(Long id, String name, Integer category) {
        super(id, name);
        this.category = category;
    }
}
