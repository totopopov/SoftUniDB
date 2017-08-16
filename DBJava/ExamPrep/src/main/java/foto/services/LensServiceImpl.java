package foto.services;

import foto.dto.Bind.LensDtoRegister;
import foto.entities.Lens;
import foto.repositories.LensRepository;
import foto.utils.ModelParser;
import foto.utils.valids.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class LensServiceImpl implements LensService {

    private final LensRepository lensRepository;

    @Autowired
    public LensServiceImpl(LensRepository lensRepository) {
        this.lensRepository = lensRepository;
    }

    @Override
    public List<Lens> findAll() {
        return this.lensRepository.findAll();
    }

    @Override
    public Lens findById(long id) {
        return this.lensRepository.findOne(id);
    }

    @Override
    public Lens create(Lens lens) {
        return this.lensRepository.save(lens);
    }

    @Override
    public List<Lens> multipleCreate(Iterable<Lens> lenss) {
        return this.lensRepository.save(lenss);
    }

    @Override
    public void deleteById(long id) {
        this.lensRepository.delete(id);
    }

    @Override
    public String register(LensDtoRegister lens) {

        Lens len = ModelParser.map(lens, Lens.class);

        String validate = DataValidator.validate(lens);

        if (validate==null){
            this.lensRepository.save(len);
            return String.format("Successfully imported %s %dmm f%s",len.getMake(),len.getFocalLenght(),len.getMaxApreture());
        }

        return validate;
    }

}
