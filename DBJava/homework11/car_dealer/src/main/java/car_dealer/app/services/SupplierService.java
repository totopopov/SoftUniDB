package car_dealer.app.services;

import car_dealer.app.entities.Supplier;
import car_dealer.dto.Bind.SupplierDtoRegister;
import car_dealer.dto.View.SupplierViewBasic;
import car_dealer.dto.View.SupplierViewInfo;

import java.util.List;

public interface SupplierService {

    List<SupplierViewBasic> findAll();

    Supplier findById(long id);

    Supplier create(Supplier supplier);

    void register(SupplierDtoRegister supplier);

    List<Supplier> multipleCreate(Iterable<Supplier> suppliers);

    void deleteById(long id);

    List<SupplierViewInfo> findAllByImportedFalse();

}
