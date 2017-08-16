package foto.dto.Bind;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import foto.dto.View.BasicCameraDtoView;
import foto.entities.BasicCamer;

import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 12.8.2017 г. at 22:03.
 */
public class PhotographDtoRegister {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private String phone;

    @Expose
    @SerializedName(value = "lenses")
    private Set<Integer> integersLences;

    private BasicCameraDtoView primaryCamera;

    private BasicCameraDtoView secondaryCamera;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Integer> getLenses() {
        return integersLences;
    }

    public void setLenses(Set<Integer> lenses) {
        this.integersLences = lenses;
    }

    public BasicCameraDtoView getPrimaryCamera() {
        return primaryCamera;
    }

    public void setPrimaryCamera(BasicCameraDtoView primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public BasicCameraDtoView getSecondaryCamera() {
        return secondaryCamera;
    }

    public void setSecondaryCamera(BasicCameraDtoView secondaryCamera) {
        this.secondaryCamera = secondaryCamera;
    }
}
