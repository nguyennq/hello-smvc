package vn.nguyen.response;

import java.io.Serializable;

/**
 * Created by quocnguyen on 12/01/2016.
 */
public class UserResponse implements Serializable {
    private String userid;
    private String name;
    private Integer age;
    private Double salary;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
