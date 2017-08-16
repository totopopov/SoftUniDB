package exam.hiber_spring.services;

import exam.hiber_spring.dto.bind.TownDtoRegister;
import exam.hiber_spring.dto.view.TownDtoViewInfo;
import exam.hiber_spring.entitites.Town;

import java.util.List;

public interface TownService {

    List<Town> findAll();

    Town findById(long id);

    Town create(Town town);

    List<Town> multipleCreate(Iterable<Town> towns);

    void deleteById(long id);

    String register(TownDtoRegister town);

    List<TownDtoViewInfo> townsData();
}
