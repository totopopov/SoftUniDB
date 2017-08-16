package foto.services;

import foto.dto.Bind.CameraDtoRegister;
import foto.dto.View.BasicCameraDtoView;
import foto.entities.BasicCamer;
import foto.entities.DSLR;
import foto.entities.Mirrorless;
import foto.repositories.BasicCamerRepository;
import foto.utils.ModelParser;
import foto.utils.valids.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BasicCamerServiceImpl implements BasicCamerService {

    private final BasicCamerRepository basiccamerRepository;

    @Autowired
    public BasicCamerServiceImpl(BasicCamerRepository basiccamerRepository) {
        this.basiccamerRepository = basiccamerRepository;
    }

    @Override
    public List<BasicCamer> findAll() {
        return this.basiccamerRepository.findAll();
    }

    @Override
    public BasicCamer findById(long id) {
        return this.basiccamerRepository.findOne(id);
    }

    @Override
    public BasicCamer create(BasicCamer basiccamer) {
        return this.basiccamerRepository.save(basiccamer);
    }

    @Override
    public List<BasicCamer> multipleCreate(Iterable<BasicCamer> basiccamers) {
        return this.basiccamerRepository.save(basiccamers);
    }

    @Override
    public void deleteById(long id) {
        this.basiccamerRepository.delete(id);
    }

    @Override
    public String register(CameraDtoRegister cameraDtoRegister) {
        BasicCamer basicCamer=null;
        if (cameraDtoRegister.getType()!=null){
            switch (cameraDtoRegister.getType()){
                case "DSLR":
                    basicCamer= ModelParser.map(cameraDtoRegister,DSLR.class);
                    break;
                case "Mirrorless":
                    basicCamer= ModelParser.map(cameraDtoRegister,Mirrorless.class);
                    break;
                    default:
                        return "Error. Invalid data provided";
            }

            String validate = DataValidator.validate(basicCamer);
            if (validate==null){
                this.basiccamerRepository.save(basicCamer);
                return String.format("Successfully imported %s %s %s",
                        cameraDtoRegister.getType(),basicCamer.getMake(),basicCamer.getModel());
            }

        }

        return "Error. Invalid data provided";
    }

    @Override
    public List<BasicCameraDtoView> findCameras() {
        return ModelParser.map(this.basiccamerRepository.findAll(),BasicCameraDtoView.class);
    }


}
