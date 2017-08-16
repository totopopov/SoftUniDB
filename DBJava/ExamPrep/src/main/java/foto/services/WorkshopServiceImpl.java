package foto.services;

import foto.dto.Bind.WorkshopDtoRegisterAdapter;
import foto.entities.Workshop;
import foto.repositories.WorkshopRepository;
import foto.utils.ModelParser;
import foto.utils.valids.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class WorkshopServiceImpl implements WorkshopService {

    private final WorkshopRepository workshopRepository;

    @Autowired
    public WorkshopServiceImpl(WorkshopRepository workshopRepository) {
        this.workshopRepository = workshopRepository;
    }

    @Override
    public List<Workshop> findAll() {
        return this.workshopRepository.findAll();
    }

    @Override
    public Workshop findById(long id) {
        return this.workshopRepository.findOne(id);
    }

    @Override
    public Workshop create(Workshop workshop) {
        return this.workshopRepository.save(workshop);
    }

    @Override
    public List<Workshop> multipleCreate(Iterable<Workshop> workshops) {
        return this.workshopRepository.save(workshops);
    }

    @Override
    public void deleteById(long id) {
        this.workshopRepository.delete(id);
    }

    @Override
    public String register(WorkshopDtoRegisterAdapter mapped) {
        Workshop map = ModelParser.map(mapped, Workshop.class);
        String validate = DataValidator.validate(map);

        if (validate==null){
            this.workshopRepository.save(map);
            return String.format("Successfully imported %s",map.getName());
        }
        return "Error. Invalid data provided";
    }

}
