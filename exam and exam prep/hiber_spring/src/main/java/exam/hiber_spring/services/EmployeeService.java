package exam.hiber_spring.services;

import exam.hiber_spring.dto.bind.EmployeeDtoRegister;
import exam.hiber_spring.dto.view.EmployeeDtoViewProjected;
import exam.hiber_spring.entitites.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(long id);

    Employee create(Employee employee);

    List<Employee> multipleCreate(Iterable<Employee> employees);

    void deleteById(long id);

    String register(EmployeeDtoRegister employeeDtoRegister);

    List<EmployeeDtoViewProjected> employeesAtBranchWihProductsNative();
}
