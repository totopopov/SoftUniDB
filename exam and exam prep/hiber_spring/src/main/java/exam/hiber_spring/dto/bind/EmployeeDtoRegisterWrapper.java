package exam.hiber_spring.dto.bind;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


/**
 * Created by Todor Popov using Lenovo on 13.8.2017 г. at 9:15.
 */

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeDtoRegisterWrapper {

    @XmlElement(name = "employee")
    private List<EmployeeDtoRegister> employees;

    public List<EmployeeDtoRegister> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDtoRegister> employees) {
        this.employees = employees;
    }
}
