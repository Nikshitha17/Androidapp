package com.nikapps.androidapp1.kotlinexs;

public class Student {
        String name;
        int age;
        String postalAddress;

        public Student(String name, int age, String postalAddress) {
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

