package exam.hiber_spring.services;

import exam.hiber_spring.dto.bind.BranchDtoRegister;
import exam.hiber_spring.dto.view.BranchDtoViewInfo;
import exam.hiber_spring.entitites.Branch;
import exam.hiber_spring.entitites.Town;
import exam.hiber_spring.repositories.BranchRepository;
import exam.hiber_spring.repositories.TownRepository;
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
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final TownRepository townRepository;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository, TownRepository townRepository) {
        this.branchRepository = branchRepository;
        this.townRepository = townRepository;
    }

    @Override
    public List<Branch> findAll() {
        return this.branchRepository.findAll();
    }

    @Override
    public Branch findById(long id) {
        return this.branchRepository.findOne(id);
    }

    @Override
    public Branch create(Branch branch) {
        return this.branchRepository.save(branch);
    }

    @Override
    public List<Branch> multipleCreate(Iterable<Branch> branchs) {
        return this.branchRepository.save(branchs);
    }

    @Override
    public void deleteById(long id) {
        this.branchRepository.delete(id);
    }

    @Override
    public String register(BranchDtoRegister branch) {
        String townName=branch.getTownString();
//        if (townName==null){
//            return ProjectInfo.ERROR_INVALID_DATA;
//        }
        Town town = this.townRepository.findByName(townName);
        Branch mappedBranch = ModelParser.map(branch, Branch.class);
        mappedBranch.setTown(town);
        String validate = DataValidator.validate(mappedBranch);

        if (validate==null){
            this.branchRepository.saveAndFlush(mappedBranch);
            return String.format("Successfully imported Branch %s.",mappedBranch.getName());
        }

        return ProjectInfo.ERROR_INVALID_DATA;
    }

    @Override
    public List<BranchDtoViewInfo> getBranchesInfo() {

        List<Object[]> branchesRaw = this.branchRepository.branchRawInfo();
        List<BranchDtoViewInfo> branches=new LinkedList<>();

        for (Object[] branchData : branchesRaw) {
            BranchDtoViewInfo branchDtoViewInfo=new BranchDtoViewInfo();
            branchDtoViewInfo.setName(branchData[0].toString());
            branchDtoViewInfo.setTownStirng(branchData[1].toString());
            branchDtoViewInfo.setClinets(branchData[2]!=null?Long.valueOf(branchData[2].toString()):0L);
            branches.add(branchDtoViewInfo);
        }

        return branches;
    }

}
