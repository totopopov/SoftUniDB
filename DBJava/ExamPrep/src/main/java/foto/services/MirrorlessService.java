package foto.services;

import foto.entities.Mirrorless;

import java.util.List;

public interface MirrorlessService {

    List<Mirrorless> findAll();

    Mirrorless findById(long id);

    Mirrorless create(Mirrorless mirrorless);

    List<Mirrorless> multipleCreate(Iterable<Mirrorless> mirrorlesss);

    void deleteById(long id);
}
