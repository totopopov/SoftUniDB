package exam.hiber_spring.services;

import exam.hiber_spring.dto.bind.TownDtoRegister;
import exam.hiber_spring.dto.view.TownDtoViewInfo;
import exam.hiber_spring.entitites.Town;
import exam.hiber_spring.repositories.TownRepository;
import exam.hiber_spring.utils.ModelParser;
import exam.hiber_spring.utils.ProjectInfo;
import exam.hiber_spring.utils.valids.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Transactional
@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;

    @Autowired
    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public List<Town> findAll() {
        return this.townRepository.findAll();
    }

    @Override
    public Town findById(long id) {
        return this.townRepository.findOne(id);
    }

    @Override
    public Town create(Town town) {
        return this.townRepository.save(town);
    }

    @Override
    public List<Town> multipleCreate(Iterable<Town> towns) {
        return this.townRepository.save(towns);
    }

    @Override
    public void deleteById(long id) {
        this.townRepository.delete(id);
    }

    @Override
    public String register(TownDtoRegister town) {

        Town mappedTown = ModelParser.map(town, Town.class);

        String validate = DataValidator.validate(mappedTown);

        if (validate == null) {
            this.townRepository.saveAndFlush(mappedTown);
            return String.format("Successfully imported Town %s.", mappedTown.getName());
        }

        return ProjectInfo.ERROR_INVALID_DATA;
    }

    @Override
    public List<TownDtoViewInfo> townsData() {
        List<Object[]> townsData = this.townRepository.townsData();
        List<TownDtoViewInfo> towns= new LinkedList<>();

        for (Object[] singleEntry : townsData) {
            TownDtoViewInfo town=new TownDtoViewInfo();
            town.setName(singleEntry[0].toString());
            town.setPopulation(Integer.parseInt(singleEntry[1].toString()));
            town.setClinets(singleEntry[2]!=null?Long.valueOf(singleEntry[2].toString()):0L);
            towns.add(town);
        }

        return towns;
    }

}
