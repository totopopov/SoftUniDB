package foto.services;

import foto.dto.Bind.PhotographDtoRegister;
import foto.dto.View.PhotographerDtoJson;
import foto.dto.View.PhotographerDtoViewBasic;
import foto.entities.Lens;
import foto.entities.Photographer;
import foto.repositories.PhotographerRepository;
import foto.utils.ModelParser;
import foto.utils.valids.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Transactional
@Service
public class PhotographerServiceImpl implements PhotographerService {

    private final PhotographerRepository photographerRepository;
    private final LensService lensService;


    @Autowired
    public PhotographerServiceImpl(PhotographerRepository photographerRepository, LensService lensService) {
        this.photographerRepository = photographerRepository;
        this.lensService = lensService;
    }

    @Override
    public List<Photographer> findAll() {
        return this.photographerRepository.findAll();
    }

    @Override
    public Photographer findById(long id) {
        return this.photographerRepository.findOne(id);
    }

    @Override
    public Photographer create(Photographer photographer) {
        return this.photographerRepository.save(photographer);
    }

    @Override
    public List<Photographer> multipleCreate(Iterable<Photographer> photographers) {
        return this.photographerRepository.save(photographers);
    }

    @Override
    public void deleteById(long id) {
        this.photographerRepository.delete(id);
    }

    @Override
    public String register(PhotographDtoRegister photographDtoRegister) {
        Set<Integer> lensesIds = photographDtoRegister.getLenses();
        photographDtoRegister.setLenses(null);

        Photographer photographer = ModelParser.map(photographDtoRegister, Photographer.class);

        String validate = DataValidator.validate(photographer);

        if (validate == null) {
            Random random = new Random();
            Set<Lens> photoLesn = new HashSet<>();

            for (Integer lensesId : lensesIds) {

                Lens byId = this.lensService.findById(lensesId);
                if (byId != null) {
                    if (byId.getCompatibleWith().equals(photographer.getPrimaryCamera().getMake()) ||
                            byId.getCompatibleWith().equals(photographer.getSecondaryCamera().getMake())) {
                        photoLesn.add(byId);
                        byId.setOwner(photographer);
                    }
                }
            }
            photographer.setLens(photoLesn);

            this.photographerRepository.save(photographer);
            return String.format("Successfully imported %s %s | Lenses: %d",
                    photographer.getFirstName(), photographer.getLastName(), photoLesn.size());
        }


        return "Error. Invalid data provided";
    }

    @Override
    public List<PhotographerDtoViewBasic> getAll() {
        return ModelParser.map(this.photographerRepository.findAll(), PhotographerDtoViewBasic.class);
    }

    @Override
    public PhotographerDtoViewBasic findAllByFirstNameAndLastName(String firstName, String lastName) {

        List<Photographer> allByFirstNameAndLastName = this.photographerRepository.findAllByFirstNameAndLastName(firstName, lastName);

        if (allByFirstNameAndLastName == null || allByFirstNameAndLastName.size() != 1) {
            return null;
        }
        return ModelParser.map(allByFirstNameAndLastName.get(0), PhotographerDtoViewBasic.class);

    }

    @Override
    public List<PhotographerDtoJson> findAllByOrderByFirstNameAscLastNameDesc() {

        return ModelParser.map(this.photographerRepository.findAllByOrderByFirstNameAscLastNameDesc(), PhotographerDtoJson.class);

    }

}
