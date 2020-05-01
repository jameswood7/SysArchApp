package com.app

class Patient {

String patientName
String patientAddress
Date patientDOB
int patientID
Date dateRegistered
String patientPhone

static hasMany = [doctors:Doctor,prescriptions:Prescription,surgerys:Surgery]
static hasOne = [appoitments:Appoitment]

    static constraints = {
	patientName blank: false, size: 3..100
        patientAddress blank: false
        patientDOB blank: false
        patientID blank: false, unique: true 
        dateRegistered blank: false
	patientPhone blank:false, maxSize: 15
    }
}
