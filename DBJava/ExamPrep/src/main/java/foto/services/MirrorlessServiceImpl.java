package foto.services;

import foto.entities.Mirrorless;
import foto.repositories.MirrorlessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MirrorlessServiceImpl implements MirrorlessService {

    private final MirrorlessRepository mirrorlessRepository;

    @Autowired
    public MirrorlessServiceImpl(MirrorlessRepository mirrorlessRepository) {
        this.mirrorlessRepository = mirrorlessRepository;
    }

    @Override
    public List<Mirrorless> findAll() {
        return this.mirrorlessRepository.findAll();
    }

    @Override
    public Mirrorless findById(long id) {
        return this.mirrorlessRepository.findOne(id);
    }

    @Override
    public Mirrorless create(Mirrorless mirrorless) {
        return this.mirrorlessRepository.save(mirrorless);
    }

    @Override
    public List<Mirrorless> multipleCreate(Iterable<Mirrorless> mirrorlesss) {
        return this.mirrorlessRepository.save(mirrorlesss);
    }

    @Override
    public void deleteById(long id) {
        this.mirrorlessRepository.delete(id);
    }

}
