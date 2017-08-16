package car_dealer.app.services;

import car_dealer.app.entities.Customer;
import car_dealer.dto.Bind.CustomerDtoRegister;
import car_dealer.dto.View.CustomerDtoViewBasic;
import car_dealer.dto.View.CustomerDtoViewInfo;

import java.util.List;

public interface CustomerService {

    List<CustomerDtoViewBasic> findAll();

    Customer findById(long id);

    Customer create(Customer customer);

    void register(CustomerDtoRegister customer);

    List<Customer> multipleCreate(Iterable<Customer> customers);

    void deleteById(long id);

    List<CustomerDtoViewInfo> findAllByOrderByBirthDateAscYoungDriverAsc();
}
