package foto.services;

import foto.dto.Bind.PhotographDtoRegister;
import foto.dto.View.PhotographerDtoJson;
import foto.dto.View.PhotographerDtoViewBasic;
import foto.entities.Photographer;

import java.util.List;

public interface PhotographerService {

    List<Photographer> findAll();

    Photographer findById(long id);

    Photographer create(Photographer photographer);

    List<Photographer> multipleCreate(Iterable<Photographer> photographers);

    void deleteById(long id);

    String register(PhotographDtoRegister photographDtoRegister);

    List<PhotographerDtoViewBasic> getAll();

    PhotographerDtoViewBasic findAllByFirstNameAndLastName(String firstName, String lastName);

    List<PhotographerDtoJson> findAllByOrderByFirstNameAscLastNameDesc();

}
