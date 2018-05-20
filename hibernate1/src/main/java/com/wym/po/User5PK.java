package com.wym.po;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class User5PK implements Serializable {
    private String username;
    private String sex;

    @Column(name = "username", nullable = false, length = 20)
    @Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "sex", nullable = false, length = 1)
    @Id
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User5PK user5PK = (User5PK) o;

        if (username != null ? !username.equals(user5PK.username) : user5PK.username != null) return false;
        if (sex != null ? !sex.equals(user5PK.sex) : user5PK.sex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }
}
