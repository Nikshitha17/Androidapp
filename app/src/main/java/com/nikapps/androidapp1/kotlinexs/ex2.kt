package com.nikapps.androidapp1.kotlinexs

fun main() {

    var myStudent: Student = Student("Nikshitha",20,"Bangalore")
    println(myStudent.name)
    myStudent.name = "Niharika"
    println(myStudent.name)

    var myEmployee: Employee = Employee("Riya",27,"Chennai")
    println(myEmployee.getName())
    println(myEmployee.name)

}