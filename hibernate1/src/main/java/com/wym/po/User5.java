package com.wym.po;

import javax.persistence.*;

@Entity
@IdClass(User5PK.class)
public class User5 {
    private String username;
    private String sex;
    private Integer age;

    @Id
    @Column(name = "username", nullable = false, length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Id
    @Column(name = "sex", nullable = false, length = 1)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User5 user5 = (User5) o;

        if (username != null ? !username.equals(user5.username) : user5.username != null) return false;
        if (sex != null ? !sex.equals(user5.sex) : user5.sex != null) return false;
        if (age != null ? !age.equals(user5.age) : user5.age != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }
}
