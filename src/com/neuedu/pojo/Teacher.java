package com.neuedu.pojo;

public class Teacher {
private Integer id;
private  String name;
private  Integer password;
private  Integer flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password=" + password +
                ", flag=" + flag +
                '}';
    }

    public Teacher(Integer id, String name, Integer password, Integer flag) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.flag = flag;
    }

    public Teacher() {
    }
}
