package car_dealer.app.services;

import car_dealer.app.entities.Part;
import car_dealer.dto.Bind.PartDtoRegister;
import car_dealer.dto.View.PartDtoViewBasic;

import java.util.List;

public interface PartService {

    List<PartDtoViewBasic> findAll();

    Part findById(long id);

    Part create(Part part);

    void register(PartDtoRegister part);

    List<Part> multipleCreate(Iterable<Part> parts);

    void deleteById(long id);
}
