package com.example.jobmanagementapp.models

class CheckIn{
    var name:String=""
    var contact:String=""
    var email:String=""
    var password:String=""
    var arrivaltime:String=""
    var id:String=""

    constructor(name:String,contact:String,email:String,password:String,arrivaltime:String,id:String){
        this.name=name
        this.contact= contact
        this.email=email
        this.password=password
        this.arrivaltime=arrivaltime
        this.id=id
    }
    constructor()
}