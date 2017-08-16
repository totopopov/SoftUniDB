package foto.services;

import foto.dto.Bind.AccessoryDtoRegister;
import foto.dto.Bind.AccessoryDtoRegisterWrapper;
import foto.entities.Accessory;
import foto.repositories.AccessoryRepository;
import foto.repositories.PhotographerRepository;
import foto.utils.ModelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AccessoryServiceImpl implements AccessoryService {

    private final AccessoryRepository accessoryRepository;
    private final PhotographerRepository photographerRepository;

    @Autowired
    public AccessoryServiceImpl(AccessoryRepository accessoryRepository, PhotographerRepository photographerRepository) {
        this.accessoryRepository = accessoryRepository;
        this.photographerRepository = photographerRepository;
    }

    @Override
    public List<Accessory> findAll() {
        return this.accessoryRepository.findAll();
    }

    @Override
    public Accessory findById(long id) {
        return this.accessoryRepository.findOne(id);
    }

    @Override
    public Accessory create(Accessory accessory) {
        return this.accessoryRepository.save(accessory);
    }

    @Override
    public List<Accessory> multipleCreate(Iterable<Accessory> accessorys) {
        return this.accessoryRepository.save(accessorys);
    }

    @Override
    public void deleteById(long id) {
        this.accessoryRepository.delete(id);
    }

    @Override
    public String register(AccessoryDtoRegister wrapper) {
        Accessory map = ModelParser.map(wrapper, Accessory.class);
        this.accessoryRepository.saveAndFlush(map);
        return String.format("Successfully imported %s",map.getName());
    }
}