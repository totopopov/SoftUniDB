package exam.hiber_spring.services;

import exam.hiber_spring.dto.bind.EmployeeDtoRegister;
import exam.hiber_spring.dto.view.EmployeeDtoViewProjected;
import exam.hiber_spring.entitites.Branch;
import exam.hiber_spring.entitites.Employee;
import exam.hiber_spring.entitites.EmployeeCard;
import exam.hiber_spring.repositories.BranchRepository;
import exam.hiber_spring.repositories.EmployeeCardRepository;
import exam.hiber_spring.repositories.EmployeeRepository;
import exam.hiber_spring.utils.ModelParser;
import exam.hiber_spring.utils.ProjectInfo;
import exam.hiber_spring.utils.valids.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final BranchRepository branchRepository;
    private final EmployeeCardRepository employeeCardRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, BranchRepository branchRepository, EmployeeCardRepository employeeCardRepository) {
        this.employeeRepository = employeeRepository;
        this.branchRepository = branchRepository;
        this.employeeCardRepository = employeeCardRepository;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findById(long id) {
        return this.employeeRepository.findOne(id);
    }

    @Override
    public Employee create(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public List<Employee> multipleCreate(Iterable<Employee> employees) {
        return this.employeeRepository.save(employees);
    }

    @Override
    public void deleteById(long id) {
        this.employeeRepository.delete(id);
    }

    @Override
    public String register(EmployeeDtoRegister employeeDtoRegister) {
        String branchName=employeeDtoRegister.getBranchString();
        String cardNumber=employeeDtoRegister.getCardString();
        Employee mappedEmployee = ModelParser.map(employeeDtoRegister, Employee.class);

        Branch branch = this.branchRepository.findByName(branchName);
        EmployeeCard card = this.employeeCardRepository.findByNumber(cardNumber);

        mappedEmployee.setBranch(branch);
        mappedEmployee.setCard(card);

        String validate = DataValidator.validate(mappedEmployee);

        if (validate==null){
            this.employeeRepository.save(mappedEmployee);
            return String.format("Successfully imported Employee %s %s.",mappedEmployee.getFirstName(),mappedEmployee.getLastName());
        }


        return ProjectInfo.ERROR_INVALID_DATA;
    }

    @Override
    public List<EmployeeDtoViewProjected> employeesAtBranchWihProductsNative() {

        List<Object[]> dataRaw = this.employeeRepository.employeesInBranchWithProducts();
        List<EmployeeDtoViewProjected> dataExport=new LinkedList<>();
        for (Object[] employee : dataRaw) {

            EmployeeDtoViewProjected employeeDto=new EmployeeDtoViewProjected();
            employeeDto.setFullName(employee[0].toString());
            employeeDto.setPosition(employee[1].toString());
            employeeDto.setNumber(employee[2].toString());
            dataExport.add(employeeDto);
        }

        return dataExport;
    }

}
