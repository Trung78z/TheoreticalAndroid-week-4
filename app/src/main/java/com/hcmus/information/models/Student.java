package com.hcmus.information.models;

import java.io.Serializable;

public class Student implements Serializable {

    private String name;
    private String mssv;
    private String studentClass;
    private String phone;
    private String year;
    private String major;

    public Student(String name, String mssv, String studentClass, String phone, String year, String major) {
        this.name = name;
        this.mssv = mssv;
        this.studentClass = studentClass;
        this.phone = phone;
        this.year = year;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
