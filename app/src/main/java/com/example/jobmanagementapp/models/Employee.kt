package com.example.jobmanagementapp.models

class Employee {
    var name: String =""
    var contact: String = ""
    var email: String = ""
    var id: String = ""

    constructor(name: String,contact:String, email:String,id:String){
        this.name = name
        this.contact = contact
        this.email = email
        this.id=id
    }
    constructor()
}