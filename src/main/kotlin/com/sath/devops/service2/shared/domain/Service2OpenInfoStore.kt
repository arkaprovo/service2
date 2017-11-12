package com.sath.devops.service2.shared.domain

class Service2OpenInfoStore(val key:String,val information: String,val optionalInfo:String) {
    //This is added because for json transfer default constructor is required
    constructor():this("","","")
}