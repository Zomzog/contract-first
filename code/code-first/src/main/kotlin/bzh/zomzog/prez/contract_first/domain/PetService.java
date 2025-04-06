package bzh.zomzog.prez.contract_first.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PetService {

    private Map<Long, Pet> db = new HashMap<>();

    public Pet createPet(Pet pet) {
        var next = db.keySet().stream().mapToLong(it -> it).max().orElse(1);
        pet.setId(next);
        db.put(next, pet);
        return pet;
    }

    public Pet updatePet(Pet pet) {
        db.put(pet.getId(), pet);
        return pet;
    }

    public Page<Pet> pagePets(String name, Pageable page) {
        var val = db.values().stream();

        if (name == null) {
            val = val.filter(it -> it.getName().equals(name));
        }
       var result = val.skip(page.getOffset()).limit(page.getPageSize()).toList();
        return new PageImpl<>(result);
    }
}
