package exam.hiber_spring.dto.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


/**
 * Created by Todor Popov using Lenovo on 13.8.2017 г. at 9:20.
 */


@XmlRootElement(name = "branches")
@XmlAccessorType(XmlAccessType.FIELD)
public class BranchDtoViewInfoWrapper {

    @XmlElement(name = "branch")
    private List<BranchDtoViewInfo> branches;

    public List<BranchDtoViewInfo> getBranches() {
        return branches;
    }

    public void setBranches(List<BranchDtoViewInfo> branches) {
        this.branches = branches;
    }
}
