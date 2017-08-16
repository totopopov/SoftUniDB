package car_dealer.app.services;

import car_dealer.app.entities.Supplier;
import car_dealer.app.repositories.SupplierRepository;
import car_dealer.app.utils.ModelParser;
import car_dealer.dto.Bind.SupplierDtoRegister;
import car_dealer.dto.View.SupplierViewBasic;
import car_dealer.dto.View.SupplierViewInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Transactional
@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<SupplierViewBasic> findAll() {
        List<Supplier> all = this.supplierRepository.findAll();
        List<SupplierViewBasic> mapped = new LinkedList<>();

        for (Supplier supplier : all) {
            SupplierViewBasic map = ModelParser.map(supplier, SupplierViewBasic.class);
            mapped.add(map);
        }

        return mapped;
    }


    @Override
    public Supplier findById(long id) {
        return this.supplierRepository.findOne(id);
    }

    @Override
    public Supplier create(Supplier supplier) {
        return this.supplierRepository.save(supplier);
    }

    @Override
    public void register(SupplierDtoRegister supplier) {
        Supplier mapped = ModelParser.map(supplier, Supplier.class);
         this.supplierRepository.save(mapped);
    }

    @Override
    public List<Supplier> multipleCreate(Iterable<Supplier> suppliers) {
        return this.supplierRepository.save(suppliers);
    }

    @Override
    public void deleteById(long id) {
        this.supplierRepository.delete(id);
    }

    @Override
    public List<SupplierViewInfo> findAllByImportedFalse() {
        List<Supplier> allByImportedFalse = this.supplierRepository.findAllByImportedFalse();
        List<SupplierViewInfo> mapped = new LinkedList<>();
        for (Supplier supplier : allByImportedFalse) {
            SupplierViewInfo map = ModelParser.map(supplier, SupplierViewInfo.class);
            mapped.add(map);
        }
        return mapped;
    }

}
