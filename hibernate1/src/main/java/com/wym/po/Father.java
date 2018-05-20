package com.wym.po;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Father {
    private int fid;
    private String fname;
    private Set<Son> sons = new HashSet<Son>();

    @Id
    @Column(name = "fid", nullable = false)
    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    @Basic
    @Column(name = "fname", nullable = true, length = 20)
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Father father = (Father) o;

        if (fid != father.fid) return false;
        if (fname != null ? !fname.equals(father.fname) : father.fname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fid;
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "father",cascade = CascadeType.ALL,fetch =FetchType.LAZY)
    public Set<Son> getSons() {
        return sons;
    }

    public void setSons(Set<Son> sons) {
        this.sons = sons;
    }
}
