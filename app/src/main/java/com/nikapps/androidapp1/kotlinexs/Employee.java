package com.nikapps.androidapp1.kotlinexs;

public class Employee {
    String name;
    int age;
    String postalAddress;

    public Employee(String name, int age, String postalAddress) {
        Student vitStudent = new Student("Nikshitha",20,"VIT");
        System.out.println("Employee is getting created "+ vitStudent.getName());
        this.name = name;
        this.age = age;
        this.postalAddress = postalAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }
}
