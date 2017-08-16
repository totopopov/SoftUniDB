package exam.hiber_spring.services;

import exam.hiber_spring.dto.bind.EmployeeCardDtoRegister;
import exam.hiber_spring.dto.view.EmployeeCardDtoView;
import exam.hiber_spring.entitites.EmployeeCard;

import java.util.List;

public interface EmployeeCardService {

    List<EmployeeCard> findAll();

    EmployeeCard findById(long id);

    EmployeeCard create(EmployeeCard employeecard);

    List<EmployeeCard> multipleCreate(Iterable<EmployeeCard> employeecards);

    void deleteById(long id);

    String register(EmployeeCardDtoRegister uniqueCard);

    List<EmployeeCardDtoView> getCardsWithNoEmployee();
}
