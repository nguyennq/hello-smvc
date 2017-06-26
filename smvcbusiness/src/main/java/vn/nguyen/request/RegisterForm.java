package vn.nguyen.request;

import org.hibernate.validator.constraints.NotBlank;
import vn.nguyen.validator.PasswordMatch;
import vn.nguyen.validator.UniqueEmail;
import vn.nguyen.validator.UniqueUsername;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@PasswordMatch
public class RegisterForm {

    @UniqueUsername
    @NotBlank
    @Size(min = 6,max = 255)
    private String username;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @UniqueEmail
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    private String email;

    @Size(min = 5,max = 255)
    private String password;

    @Size(min = 5,max = 255)
    private String rePassword;

    @NotBlank
    private String country;

    @NotBlank
    @Size(min = 5,max = 13)
    private String phonenumber;

    @NotBlank
    private String city;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
