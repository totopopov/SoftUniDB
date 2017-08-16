package foto.services;

import foto.dto.Bind.WorkshopDtoRegisterAdapter;
import foto.entities.Workshop;

import java.util.List;

public interface WorkshopService {

    List<Workshop> findAll();

    Workshop findById(long id);

    Workshop create(Workshop workshop);

    List<Workshop> multipleCreate(Iterable<Workshop> workshops);

    void deleteById(long id);

    String register(WorkshopDtoRegisterAdapter mapped);
}
