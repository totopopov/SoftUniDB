package car_dealer.app.services;

import car_dealer.app.entities.Sale;
import car_dealer.app.repositories.SaleRepository;
import car_dealer.app.utils.ModelParser;
import car_dealer.dto.Bind.SaleDtoRegister;
import car_dealer.dto.View.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

@Transactional
@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public List<Sale> findAll() {
        return this.saleRepository.findAll();
    }

    @Override
    public Sale findById(long id) {
        return this.saleRepository.findOne(id);
    }

    @Override
    public Sale create(Sale sale) {
        return this.saleRepository.save(sale);
    }

    @Override
    public void register(SaleDtoRegister sale) {
        Sale mapped = ModelParser.map(sale, Sale.class);
        this.saleRepository.save(mapped);
    }

    @Override
    public List<Sale> multipleCreate(Iterable<Sale> sales) {
        return this.saleRepository.save(sales);
    }

    @Override
    public void deleteById(long id) {
        this.saleRepository.delete(id);
    }

    @Override
    public SaleDtoViewInfoWrapper findCustomersWithCars() {

        List<Object[]> customersWithCars = this.saleRepository.findCustomersWithCars();
        List<SaleDtoViewInfo> customers=new LinkedList<>();

        for (Object[] customersWithCar : customersWithCars) {
            String name = customersWithCar[0].toString();
            Integer cars = Integer.valueOf(customersWithCar[1].toString());
            BigDecimal price= new BigDecimal(customersWithCar[2].toString());
            SaleDtoViewInfo customer= new SaleDtoViewInfo(name,cars,price);
            customers.add(customer);
        }

        SaleDtoViewInfoWrapper all=new SaleDtoViewInfoWrapper();
        all.setCustomers(customers);
        return all;
    }

    @Override
    public SaleDtoViewDetailedWrapper findSaleDetailedInfo() {
        List<Object[]> saleDetailedInfo = this.saleRepository.findSaleDetailedInfo();
        List<SaleDtoViewDetailed>  sales= new LinkedList<>();
        for (Object[] objects : saleDetailedInfo) {
            String carMake=objects[0].toString();
            String carModel=objects[1].toString();
            BigInteger carTravelled=new BigInteger(objects[2].toString());
            CarDtoViewSalesInfo car = new CarDtoViewSalesInfo(carMake,carModel,carTravelled);

            String name=objects[3].toString();
            BigDecimal discount = new BigDecimal(objects[4].toString());
            BigDecimal price = new BigDecimal(objects[5].toString());
            BigDecimal discountPRice = new BigDecimal(objects[6].toString());
            SaleDtoViewDetailed sale = new SaleDtoViewDetailed(car,name,discount,price,discountPRice);
            sales.add(sale);
        }
        SaleDtoViewDetailedWrapper allSale= new SaleDtoViewDetailedWrapper();

        allSale.setSales(sales);


        return allSale;
    }

}
