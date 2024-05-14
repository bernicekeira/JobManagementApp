package com.example.jobmanagementapp.models

class Upload{
    var name:String=""
    var contact:String=""
    var email:String=""
    var imageUrl:String=""
    var id:String=""

    constructor(name:String,contact:String,email:String,imageUrl:String,id:String){

        this.name=name
        this.contact=contact
        this.email=email
        this.imageUrl=imageUrl
        this.id=id

    }
    constructor()
}