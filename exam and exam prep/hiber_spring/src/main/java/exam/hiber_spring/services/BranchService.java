package exam.hiber_spring.services;

import exam.hiber_spring.dto.bind.BranchDtoRegister;
import exam.hiber_spring.dto.view.BranchDtoViewInfo;
import exam.hiber_spring.entitites.Branch;

import java.util.List;

public interface BranchService {

    List<Branch> findAll();

    Branch findById(long id);

    Branch create(Branch branch);

    List<Branch> multipleCreate(Iterable<Branch> branchs);

    void deleteById(long id);

    String register(BranchDtoRegister branch);

    List<BranchDtoViewInfo> getBranchesInfo();
}
