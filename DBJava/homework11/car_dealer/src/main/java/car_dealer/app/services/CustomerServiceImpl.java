package car_dealer.app.services;

import car_dealer.app.entities.Customer;
import car_dealer.app.repositories.CustomerRepository;
import car_dealer.app.utils.ModelParser;
import car_dealer.dto.Bind.CustomerDtoRegister;
import car_dealer.dto.View.CustomerDtoViewBasic;
import car_dealer.dto.View.CustomerDtoViewInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDtoViewBasic> findAll() {
        List<Customer> all = this.customerRepository.findAll();
        List<CustomerDtoViewBasic> mapped = new ArrayList<>();
        for (Customer customer : all) {
            CustomerDtoViewBasic map = ModelParser.map(customer, CustomerDtoViewBasic.class);
            mapped.add(map);
        }
        return mapped;
    }

    @Override
    public Customer findById(long id) {
        return this.customerRepository.findOne(id);
    }


    @Override
    public Customer create(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public void register(CustomerDtoRegister customer) {
        Customer mapped = ModelParser.map(customer, Customer.class);
        this.customerRepository.save(mapped);
    }

    @Override
    public List<Customer> multipleCreate(Iterable<Customer> customers) {
        return this.customerRepository.save(customers);
    }

    @Override
    public void deleteById(long id) {
        this.customerRepository.delete(id);
    }

    @Override
    public List<CustomerDtoViewInfo> findAllByOrderByBirthDateAscYoungDriverAsc() {
        List<Customer> allByOrderByBirthDateAscYoungDriverAsc = this.customerRepository.findAllByOrderByBirthDateAscYoungDriverAsc();
        List<CustomerDtoViewInfo> customers = new LinkedList<>();
        for (Customer customer : allByOrderByBirthDateAscYoungDriverAsc) {
            CustomerDtoViewInfo mapped = ModelParser.map(customer, CustomerDtoViewInfo.class);
            customers.add(mapped);
        }

        return customers;
    }

}
