package car_dealer.app.services;

import car_dealer.app.entities.Car;

import car_dealer.app.repositories.CarRepository;
import car_dealer.app.utils.ModelParser;
import car_dealer.dto.Bind.CarDtoRegister;
import car_dealer.dto.View.CarDtoViewBasic;
import car_dealer.dto.View.CarDtoViewDetailedInfo;
import car_dealer.dto.View.CarDtoViewInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Transactional
@Service
public class CarServiceImpl implements car_dealer.app.services.CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<CarDtoViewBasic> findAll() {
        List<Car> all = this.carRepository.findAll();
        List<CarDtoViewBasic> mapped=new ArrayList<>();
        for (Car car : all) {
            CarDtoViewBasic map = ModelParser.map(car, CarDtoViewBasic.class);
            mapped.add(map);
        }
        return mapped;
    }

    @Override
    public Car findById(long id) {
        return this.carRepository.findOne(id);
    }

    @Override
    public Car create(Car car) {
        return this.carRepository.save(car);
    }


    @Override
    public void register(CarDtoRegister car) {
        Car mapped = ModelParser.map(car, Car.class);
        this.carRepository.save(mapped);
    }

    @Override
    public List<Car> multipleCreate(Iterable<Car> cars) {
        return this.carRepository.save(cars);
    }

    @Override
    public void deleteById(long id) {
        this.carRepository.delete(id);
    }

    @Override
    public List<CarDtoViewInfo> findAllByMakeEqualsOrderByModelAscTravelDistanceDesc(String make) {
        List<Car> allcars = this.carRepository.findAllByMakeEqualsOrderByModelAscTravelDistanceDesc(make);
        List<CarDtoViewInfo> map=new LinkedList<>();
        for (Car allcar : allcars) {
            CarDtoViewInfo mappped = ModelParser.map(allcar, CarDtoViewInfo.class);
            mappped.setTravelledDistance(allcar.getTravelDistance());
            map.add(mappped);
        }
        return map;
    }

    @Override
    public List<CarDtoViewDetailedInfo> findAllDetailed() {
        List<Car> all = this.carRepository.findAll();
        List<CarDtoViewDetailedInfo> mapped= new LinkedList<>();

        for (Car car : all) {
            CarDtoViewDetailedInfo map = ModelParser.map(car, CarDtoViewDetailedInfo.class);
            map.setTravelledDistance(car.getTravelDistance());
            mapped.add(map);
        }

        return mapped;
    }

}
