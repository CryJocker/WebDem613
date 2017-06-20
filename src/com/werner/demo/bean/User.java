package com.werner.demo.bean;


import java.io.Serializable;

public class User  implements Serializable{
    private Long tuid;
    private String tusername;
    private String tpassword;

    public User() {
    }
    public Long getTuid() {
        return tuid;
    }

    public void setTuid(Long tuid) {
        this.tuid = tuid;
    }

    public String getTusername() {
        return tusername;
    }

    public void setTusername(String tusername) {
        this.tusername = tusername;
    }

    public String getTpassword() {
        return tpassword;
    }

    public void setTpassword(String tpassword) {
        this.tpassword = tpassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "tuid = " + tuid +
                ", tusername ='" + tusername + '\'' +
                ", tpassword ='" + tpassword + '\'' +
                '}';
    }
}
