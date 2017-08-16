package foto.services;

import foto.dto.Bind.CameraDtoRegister;
import foto.dto.View.BasicCameraDtoView;
import foto.entities.BasicCamer;

import java.util.List;

public interface BasicCamerService {

    List<BasicCamer> findAll();

    BasicCamer findById(long id);

    BasicCamer create(BasicCamer basiccamer);

    List<BasicCamer> multipleCreate(Iterable<BasicCamer> basiccamers);

    void deleteById(long id);

    String register(CameraDtoRegister cameraDtoRegister);

    List<BasicCameraDtoView> findCameras();
}
