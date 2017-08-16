package foto.services;

import foto.dto.Bind.AccessoryDtoRegister;
import foto.entities.Accessory;

import java.util.List;

public interface AccessoryService {

    List<Accessory> findAll();

    Accessory findById(long id);

    Accessory create(Accessory accessory);

    List<Accessory> multipleCreate(Iterable<Accessory> accessorys);

    void deleteById(long id);

    String register(AccessoryDtoRegister wrapper);
}
