package car_dealer.app.services;

import car_dealer.app.entities.Part;
import car_dealer.app.repositories.PartRepository;
import car_dealer.app.utils.ModelParser;
import car_dealer.dto.Bind.PartDtoRegister;
import car_dealer.dto.View.PartDtoViewBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;

    @Autowired
    public PartServiceImpl(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public List<PartDtoViewBasic> findAll() {
        List<Part> all = this.partRepository.findAll();
        List<PartDtoViewBasic> mapped=new ArrayList<>();

        for (Part part : all) {
            PartDtoViewBasic map = ModelParser.map(part, PartDtoViewBasic.class);
            mapped.add(map);
        }

        return mapped;
    }

    @Override
    public Part findById(long id) {
        return this.partRepository.findOne(id);
    }

    @Override
    public Part create(Part part) {
        return this.partRepository.save(part);
    }

    @Override
    public void register(PartDtoRegister part) {
        Part mapped = ModelParser.map(part, Part.class);
         this.partRepository.save(mapped);
    }

    @Override
    public List<Part> multipleCreate(Iterable<Part> parts) {
        return this.partRepository.save(parts);
    }

    @Override
    public void deleteById(long id) {
        this.partRepository.delete(id);
    }

}
