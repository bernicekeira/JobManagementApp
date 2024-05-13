package com.example.jobmanagementapp.models

class CheckOut {
    var name:String=""
    var contact:String=""
    var email:String=""
    var password:String=""
    var departuretime:String=""
    var id:String=""

    constructor(name:String,contact:String,email:String,password:String,departuretime:String,id:String){
        this.name=name
        this.contact= contact
        this.email=email
        this.password=password
        this.departuretime=departuretime
        this.id=id
    }
    constructor()
}