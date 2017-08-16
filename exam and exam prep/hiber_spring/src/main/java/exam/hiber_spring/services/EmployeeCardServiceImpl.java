package exam.hiber_spring.services;

import exam.hiber_spring.dto.bind.EmployeeCardDtoRegister;
import exam.hiber_spring.dto.view.EmployeeCardDtoView;
import exam.hiber_spring.entitites.EmployeeCard;
import exam.hiber_spring.repositories.EmployeeCardRepository;
import exam.hiber_spring.utils.ModelParser;
import exam.hiber_spring.utils.ProjectInfo;
import exam.hiber_spring.utils.valids.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class EmployeeCardServiceImpl implements EmployeeCardService {

    private final EmployeeCardRepository employeecardRepository;

    @Autowired
    public EmployeeCardServiceImpl(EmployeeCardRepository employeecardRepository) {
        this.employeecardRepository = employeecardRepository;
    }

    @Override
    public List<EmployeeCard> findAll() {
        return this.employeecardRepository.findAll();
    }

    @Override
    public EmployeeCard findById(long id) {
        return this.employeecardRepository.findOne(id);
    }

    @Override
    public EmployeeCard create(EmployeeCard employeecard) {
        return this.employeecardRepository.save(employeecard);
    }

    @Override
    public List<EmployeeCard> multipleCreate(Iterable<EmployeeCard> employeecards) {
        return this.employeecardRepository.save(employeecards);
    }

    @Override
    public void deleteById(long id) {
        this.employeecardRepository.delete(id);
    }

    @Override
    public String register(EmployeeCardDtoRegister uniqueCard) {
        EmployeeCard mappedCard = ModelParser.map(uniqueCard, EmployeeCard.class);
        String validate = DataValidator.validate(mappedCard);
        if (validate==null){
            this.employeecardRepository.saveAndFlush(mappedCard);
            return String.format("Successfully imported Employee Card %s.",mappedCard.getNumber());
        }

        return ProjectInfo.ERROR_INVALID_DATA;
    }

    @Override
    public List<EmployeeCardDtoView> getCardsWithNoEmployee() {
        List<EmployeeCard> allFree = this.employeecardRepository.findAllFree();

        return ModelParser.map(allFree, EmployeeCardDtoView.class);
    }

}
