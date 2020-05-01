package com.app

class Receptionist {

String recepName
String recepEmail
String username
String password
String recepPhone

static hasOne = [surgery:Surgery]

    static constraints = {
	recepName blank: false, size: 3..100
        username blank: false
        recepEmail email: true, blank: false
        password blank: false 
        recepPhone blank: false
    }
}
