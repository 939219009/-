package com.wym.po;


import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class User implements Serializable {
    @NotEmpty
    private  String username;
    @NotEmpty
    private  String password;
    @NotEmpty
    @Pattern(regexp = "^\\d+$")
    @Range(min = 0,max = 256)
    private String age;
    public User(){};
    public User(String username, String password,String age) {
        this.username = username;
        this.password = password;
        this.age=age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
