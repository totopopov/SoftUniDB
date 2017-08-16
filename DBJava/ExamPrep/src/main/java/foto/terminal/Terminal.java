package foto.terminal;

import foto.dto.Bind.*;
import foto.dto.View.BasicCameraDtoView;
import foto.dto.View.PhotographerDtoJson;
import foto.dto.View.PhotographerDtoViewBasic;
import foto.services.*;
import foto.utils.ModelParser;
import foto.utils.io.JsonParser;
import foto.utils.io.XMLParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 12.8.2017 г. at 20:55.
 */


@Component
public class Terminal implements CommandLineRunner {

    private final JsonParser jsonParser;
    private final XMLParser xmlParser;

    private final LensService lensService;
    private final BasicCamerService basicCamerService;
    private final PhotographerService photographerService;
    private final AccessoryService accessoryService;
    private final WorkshopService workshopService;

    @Autowired
    public Terminal(JsonParser jsonParser, XMLParser xmlParser, LensService lensService, BasicCamerService basicCamerService, PhotographerService photographerService, AccessoryService accessoryService, WorkshopService workshopService) {
        this.jsonParser = jsonParser;
        this.xmlParser = xmlParser;
        this.lensService = lensService;
        this.basicCamerService = basicCamerService;
        this.photographerService = photographerService;
        this.accessoryService = accessoryService;
        this.workshopService = workshopService;
    }


    @Override
    public void run(String... strings) throws Exception {

        //importLences();
        //importCameras();
        //importPhotographers();
        //importAccesories();
        //importWorkshops();

        exportPhotographers();
    }

    private void exportPhotographers() {
        String path="/src/main/resources/files/out/photographers-ordered.json";


        List<PhotographerDtoJson> allByOrderByFirstNameAscLastNameDesc = this.photographerService.findAllByOrderByFirstNameAscLastNameDesc();
        for (PhotographerDtoJson photographerDtoJson : allByOrderByFirstNameAscLastNameDesc) {
            if (photographerDtoJson.getPhone()==null){
                photographerDtoJson.setPhone("null");
            }
        }

        try {
            this.jsonParser.writeObject(allByOrderByFirstNameAscLastNameDesc,path);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void importWorkshops() {
        String path = "/files/in/workshops.xml";

        try {
            WorkshopDtoRegisterWrapper workshopsWrapped = this.xmlParser.getObject(WorkshopDtoRegisterWrapper.class, path);
            for (WorkshopDtoRegister workshopDtoRegister : workshopsWrapped.getWorkshops()) {

                if (workshopDtoRegister.getTrainerString() == null) {
                    System.out.println("Error. Invalid data provided");
                    continue;
                }

                String[] names = workshopDtoRegister.getTrainerString().split("\\s+");

                PhotographerDtoViewBasic trainer = this.photographerService.findAllByFirstNameAndLastName(names[0], names[1]);
                WorkshopDtoRegisterAdapter mapped = ModelParser.map(workshopDtoRegister, WorkshopDtoRegisterAdapter.class);
                mapped.setTrainer(trainer);
                Set<PhotographerDtoViewBasic> participants = new HashSet<>();
                Set<PotographerDtoFullName> participantsStrings = workshopDtoRegister.getParticipantsString();
                if (participantsStrings==null) {
                    System.out.println(this.workshopService.register(mapped));
                    continue;
                }
                for (PotographerDtoFullName participant : participantsStrings) {
                    PhotographerDtoViewBasic photographerBasic = this.photographerService.findAllByFirstNameAndLastName(participant.getFirstName(), participant.getSecondName());
                    if (photographerBasic != null) {
                        participants.add(photographerBasic);
                    }
                }

                mapped.setParticipants(participants);
                System.out.println(this.workshopService.register(mapped));
            }

        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    private void importAccesories() {
        String path = "/files/in/accessories.xml";

        try {


            AccessoryDtoRegisterWrapper wrapper = this.xmlParser.getObject(AccessoryDtoRegisterWrapper.class, path);
            List<PhotographerDtoViewBasic> all = this.photographerService.getAll();
            Random random = new Random();
            for (AccessoryDtoRegister accessoryDtoRegister : wrapper.getAccessries()) {
                Integer photoId = random.nextInt(all.size());
                PhotographerDtoViewBasic photographer = all.get(photoId);
                accessoryDtoRegister.setOwner(photographer);
                System.out.println(this.accessoryService.register(accessoryDtoRegister));

            }


        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    private void importPhotographers() {
        String path = "/files/in/photographers.json";
        Random random = new Random();
        try {

            PhotographDtoRegister[] photographers = this.jsonParser.getObject(PhotographDtoRegister[].class, path);

            List<BasicCameraDtoView> cameras = this.basicCamerService.findCameras();


            for (PhotographDtoRegister photographer : photographers) {
                photographer.setPrimaryCamera(cameras.get(random.nextInt(cameras.size())));
                photographer.setSecondaryCamera(cameras.get(random.nextInt(cameras.size())));

                System.out.println(this.photographerService.register(photographer));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importCameras() {
        String path = "/files/in/cameras.json";
        try {
            CameraDtoRegister[] cameras = this.jsonParser.getObject(CameraDtoRegister[].class, path);
            for (CameraDtoRegister camera : cameras) {
                System.out.println(this.basicCamerService.register(camera));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importLences() {

        String path = "/files/in/lenses.json";
        try {
            LensDtoRegister[] lens = this.jsonParser.getObject(LensDtoRegister[].class, path);
            for (LensDtoRegister len : lens) {

                String output = this.lensService.register(len);
                System.out.println(output);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
