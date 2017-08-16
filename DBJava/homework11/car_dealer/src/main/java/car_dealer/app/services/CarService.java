package car_dealer.app.services;

import car_dealer.app.entities.Car;
import car_dealer.dto.Bind.CarDtoRegister;
import car_dealer.dto.View.CarDtoViewBasic;
import car_dealer.dto.View.CarDtoViewDetailedInfo;
import car_dealer.dto.View.CarDtoViewInfo;

import java.util.List;

public interface CarService {

    List<CarDtoViewBasic> findAll();

    Car findById(long id);

    Car create(Car car);

    void register(CarDtoRegister car);

    List<Car> multipleCreate(Iterable<Car> cars);

    void deleteById(long id);

    List<CarDtoViewInfo> findAllByMakeEqualsOrderByModelAscTravelDistanceDesc(String make);

    List<CarDtoViewDetailedInfo> findAllDetailed();

}
