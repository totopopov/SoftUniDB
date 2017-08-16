package car_dealer.app.Terminal;

import car_dealer.app.entities.Supplier;
import car_dealer.app.services.*;
import car_dealer.app.utils.io.JsonParser;
import car_dealer.app.utils.io.XMLParser;
import car_dealer.dto.Bind.*;
import car_dealer.dto.View.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;


/**
 * Created by Todor Popov using Lenovo on 3.8.2017 г. at 21:35.
 */

@Component
public class Ternimal implements CommandLineRunner {


    private final JsonParser jsonParser;
    private final XMLParser xmlParser;

    private final CarService carService;
    private final CustomerService customerService;
    private final PartService partService;
    private final SaleService saleService;
    private final SupplierService supplierService;

    @Autowired
    public Ternimal(JsonParser jsonParser, CarService carService, CustomerService customerService, PartService partService, SaleService saleService, SupplierService supplierService, XMLParser xmlParser) {
        this.jsonParser = jsonParser;
        this.carService = carService;
        this.customerService = customerService;
        this.partService = partService;
        this.saleService = saleService;
        this.supplierService = supplierService;
        this.xmlParser = xmlParser;
    }

    @Override
    public void run(String... strings) throws Exception {

        //seedDB();
        // seedDBXMl();
        //export1();
       // export2();
        //export3();
        //export4();
        // export5();
        export6();
    }

    private void export6() {
        String path="/src/main/resources/files/out/photographers-ordered.json";

        SaleDtoViewDetailedWrapper saleDetailedInfo = this.saleService.findSaleDetailedInfo();

        try {
            this.xmlParser.writeObject(saleDetailedInfo,path);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    private void export5() {
        String path="/src/main/resources/files/out/customers-total-sales.xml";

        SaleDtoViewInfoWrapper customersWithCars = this.saleService.findCustomersWithCars();

        try {
            this.xmlParser.writeObject(customersWithCars,path);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    private void export4() {
        String path="/src/main/resources/files/out/cars-and-parts.xml";

        List<CarDtoViewDetailedInfo> allDetailed = this.carService.findAllDetailed();

        CarDtoViewDetailedInfoWrapper car=new CarDtoViewDetailedInfoWrapper();
        car.setCars(allDetailed);

        try {
            this.xmlParser.writeObject(car,path);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

    }

    private void export3() {
        String path="/src/main/resources/files/out/cars-and-parts.xml";
        List<SupplierViewInfo> allByImportedFalse = this.supplierService.findAllByImportedFalse();
        SupplierViewInfoWrapper suppliers= new SupplierViewInfoWrapper();
        suppliers.setSuppliers(allByImportedFalse);

        try {
            this.xmlParser.writeObject(suppliers,path);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

    }

    private void export2() {
        String path="/src/main/resources/files/out/toyota-cars.xml";
        List<CarDtoViewInfo> toyotaCars = this.carService.findAllByMakeEqualsOrderByModelAscTravelDistanceDesc("Toyota");
        CarDtoViewInfoWrapper cars= new CarDtoViewInfoWrapper();
        cars.setCars(toyotaCars);

        try {
            this.xmlParser.writeObject(cars,path);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }


    }

    private void export1() {

        String path="/src/main/resources/files/out/ordered-customers.xml";
        List<CustomerDtoViewInfo> all = this.customerService.findAllByOrderByBirthDateAscYoungDriverAsc();

        CustomerDtoViewInfoWrapper customers= new CustomerDtoViewInfoWrapper();

        customers.setCustomers(all);

        try {
            this.xmlParser.writeObject(customers,path);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

    }

    private void seedDBXMl() {
        importSuppliersXml();
        importPartsXml();
        importCarsXml();
        importCustomersXml();
        importSales();
    }


    private void importCustomersXml() {

        String path = "/files/in/customers.xml";
        try {
            CustomerDtoRegisterWrapper customers = this.xmlParser.getObject(CustomerDtoRegisterWrapper.class, path);

            for (CustomerDtoRegister customerDtoRegister : customers.getCustomers()) {

                this.customerService.register(customerDtoRegister);

            }
        } catch (IOException | NullPointerException | JAXBException e) {
            System.out.println(e.getMessage());
        }

    }

    private void importCarsXml() {

        String path = "/files/in/cars.xml";
        Random random = new Random();

        List<PartDtoViewBasic> allParts = this.partService.findAll();

        try {
            CarDtoRegisterWrapper cars = this.xmlParser.getObject(CarDtoRegisterWrapper.class, path);

            for (CarDtoRegister car : cars.getCars()) {

                populateCar(random, allParts, car);
            }
        } catch (IOException | NullPointerException | JAXBException e) {
            System.out.println(e.getMessage());
        }

    }

    private void populateCar(Random random, List<PartDtoViewBasic> allParts, CarDtoRegister car) {
        int size = 10 + random.nextInt(10);
        int count = 0;
        Set<PartDtoViewBasic> parts = new HashSet<>();
        while (parts.size() < size) {
            PartDtoViewBasic part = allParts.get(random.nextInt(allParts.size()));
            parts.add(part);
        }

        car.setParts(parts);

        this.carService.register(car);
    }

    private void importPartsXml() {
        Random random = new Random();

        List<SupplierViewBasic> allSuppliers = this.supplierService.findAll();

        String path = "/files/in/parts.xml";
        try {
            PartDtoRegisterWrapper parts = this.xmlParser.getObject(PartDtoRegisterWrapper.class, path);

            for (PartDtoRegister part : parts.getParts()) {

                SupplierViewBasic supplier = allSuppliers.get(random.nextInt(allSuppliers.size()));
                part.setSupplier(supplier);
                this.partService.register(part);
            }
        } catch (IOException | NullPointerException | JAXBException e) {
            System.out.println(e.getMessage());
        }


    }

    private void importSuppliersXml() {
        String path = "/files/in/suppliers.xml";
        try {
            SupplierDtoRegisterWrapper suppliers = this.xmlParser.getObject(SupplierDtoRegisterWrapper.class, path);

            for (SupplierDtoRegister supplier : suppliers.getSuppliers()) {
                this.supplierService.register(supplier);
            }
        } catch (IOException | NullPointerException | JAXBException e) {
            System.out.println(e.getMessage());
        }
    }

    private void seedDB() {
        importSuppliers();
        importParts();
        importCars();
        importCustomers();
        importSales();


    }

    private void importSales() {
        Random random = new Random();

        List<CarDtoViewBasic> allCars = this.carService.findAll();
        List<CustomerDtoViewBasic> allCustomers = this.customerService.findAll();
        List<SaleDtoRegister> allSales = new ArrayList<>();
        String[] discounts = new String[]{"0", "5", "10", "15", "20", "30", "40", "50"};

        long id = 0;
        for (CarDtoViewBasic car : allCars) {
            SaleDtoRegister sale = new SaleDtoRegister();
            sale.setCar(car);
            CustomerDtoViewBasic customerDtoViewBasic = allCustomers.get(random.nextInt(allCustomers.size()));
            sale.setCustomer(customerDtoViewBasic);
            sale.setDiscount(new BigDecimal(discounts[random.nextInt(discounts.length)]));
            long a = car.getId();
            long b = customerDtoViewBasic.getId();
            id = ((a + b) * (a + b + 1)) / 2 + b; //Cantor pairing function
            sale.setId(id);
            allSales.add(sale);
        }

        for (SaleDtoRegister sale : allSales) {
            this.saleService.register(sale);
        }

    }

    private void importCustomers() {
        String path = "/files/in/customers.json";
        try {
            CustomerDtoRegister[] customers = this.jsonParser.getObject(CustomerDtoRegister[].class, path);

            for (CustomerDtoRegister customerDtoRegister : customers) {

                this.customerService.register(customerDtoRegister);
            }
        } catch (IOException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    private void importCars() {
        String path = "/files/in/cars.json";
        Random random = new Random();

        List<PartDtoViewBasic> allParts = this.partService.findAll();

        try {
            CarDtoRegister[] cars = this.jsonParser.getObject(CarDtoRegister[].class, path);

            for (CarDtoRegister car : cars) {
                populateCar(random, allParts, car);
            }
        } catch (IOException | NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

    private void importParts() {

        Random random = new Random();

        List<SupplierViewBasic> allSuppliers = this.supplierService.findAll();

        String path = "/files/in/parts.json";
        try {
            PartDtoRegister[] parts = this.jsonParser.getObject(PartDtoRegister[].class, path);

            for (PartDtoRegister part : parts) {

                SupplierViewBasic supplier = allSuppliers.get(random.nextInt(allSuppliers.size()));
                part.setSupplier(supplier);
                this.partService.register(part);
            }
        } catch (IOException | NullPointerException e) {
            System.out.println(e.getMessage());
        }


    }

    private void importSuppliers() {

        String path = "/files/in/suppliers.json";
        try {
            SupplierDtoRegister[] suppliers = this.jsonParser.getObject(SupplierDtoRegister[].class, path);

            for (SupplierDtoRegister supplier : suppliers) {
                this.supplierService.register(supplier);
            }
        } catch (IOException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
