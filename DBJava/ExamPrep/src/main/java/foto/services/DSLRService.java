package foto.services;

import foto.entities.DSLR;

import java.util.List;

public interface DSLRService {

    List<DSLR> findAll();

    DSLR findById(long id);

    DSLR create(DSLR dslr);

    List<DSLR> multipleCreate(Iterable<DSLR> dslrs);

    void deleteById(long id);
}
