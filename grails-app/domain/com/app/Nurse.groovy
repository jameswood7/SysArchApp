package com.app

class Nurse {

String nurseName
String qualifications
String nurseEmail
String nurseOffice
String nursePhone

static hasMany = [doctors: Doctor]
static hasOne = [surgery: Surgery]
    static constraints = {
	nurseName blank: false, size: 3..100
        qualifications blank: false
        nurseEmail email: true, blank: false
        nurseOffice blank: false, size:1..5
        nursePhone blank: false
    }
}
