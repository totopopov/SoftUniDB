package car_dealer.app.services;

import car_dealer.app.entities.Sale;
import car_dealer.dto.Bind.SaleDtoRegister;
import car_dealer.dto.View.SaleDtoViewDetailedWrapper;
import car_dealer.dto.View.SaleDtoViewInfoWrapper;

import java.util.List;

public interface SaleService {

    List<Sale> findAll();

    Sale findById(long id);

    Sale create(Sale sale);

    void register(SaleDtoRegister sale);

    List<Sale> multipleCreate(Iterable<Sale> sales);

    void deleteById(long id);

    SaleDtoViewInfoWrapper findCustomersWithCars();

    SaleDtoViewDetailedWrapper findSaleDetailedInfo();
}
