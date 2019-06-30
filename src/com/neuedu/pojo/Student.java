package com.neuedu.pojo;

public class Student {
private Integer id;
private Integer sno;
private  String sname;
private  Integer spaw;
private  String sage;
private  String ssex;
private  double sheight;
private  double sweight;
private  String sbirthday;
private  Integer sflag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSpaw() {
        return spaw;
    }

    public void setSpaw(Integer spaw) {
        this.spaw = spaw;
    }

    public String getSage() {
        return sage;
    }

    public void setSage(String sage) {
        this.sage = sage;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public double getSheight() {
        return sheight;
    }

    public void setSheight(double sheight) {
        this.sheight = sheight;
    }

    public double getSweight() {
        return sweight;
    }

    public void setSweight(double sweight) {
        this.sweight = sweight;
    }

    public String getSbirthday() {
        return sbirthday;
    }

    public void setSbirthday(String sbirthday) {
        this.sbirthday = sbirthday;
    }

    public Integer getSflag() {
        return sflag;
    }

    public void setSflag(Integer sflag) {
        this.sflag = sflag;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sno=" + sno +
                ", sname='" + sname + '\'' +
                ", spaw=" + spaw +
                ", sage='" + sage + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sheight=" + sheight +
                ", sweight=" + sweight +
                ", sbirthday='" + sbirthday + '\'' +
                ", sflag=" + sflag +
                '}';
    }

    public Student(Integer id, Integer sno, String sname, Integer spaw, String sage, String ssex, double sheight, double sweight, String sbirthday, Integer sflag) {
        this.id = id;
        this.sno = sno;
        this.sname = sname;
        this.spaw = spaw;
        this.sage = sage;
        this.ssex = ssex;
        this.sheight = sheight;
        this.sweight = sweight;
        this.sbirthday = sbirthday;
        this.sflag = sflag;
    }

    public Student() {
    }
}
