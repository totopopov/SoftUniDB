package foto.services;

import foto.entities.DSLR;
import foto.repositories.DSLRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DSLRServiceImpl implements DSLRService {

    private final DSLRRepository dslrRepository;

    @Autowired
    public DSLRServiceImpl(DSLRRepository dslrRepository) {
        this.dslrRepository = dslrRepository;
    }

    @Override
    public List<DSLR> findAll() {
        return this.dslrRepository.findAll();
    }

    @Override
    public DSLR findById(long id) {
        return this.dslrRepository.findOne(id);
    }

    @Override
    public DSLR create(DSLR dslr) {
        return this.dslrRepository.save(dslr);
    }

    @Override
    public List<DSLR> multipleCreate(Iterable<DSLR> dslrs) {
        return this.dslrRepository.save(dslrs);
    }

    @Override
    public void deleteById(long id) {
        this.dslrRepository.delete(id);
    }

}
