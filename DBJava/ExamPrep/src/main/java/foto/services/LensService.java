package foto.services;

import foto.dto.Bind.LensDtoRegister;
import foto.entities.Lens;

import java.util.List;

public interface LensService {

    List<Lens> findAll();

    Lens findById(long id);

    Lens create(Lens lens);

    List<Lens> multipleCreate(Iterable<Lens> lenss);

    void deleteById(long id);

    String register(LensDtoRegister lens);
}
