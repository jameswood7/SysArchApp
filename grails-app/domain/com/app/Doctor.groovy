package com.app

class Doctor {

int doctorID
String doctorName
String qualifications
String position
String doctorEmail
String password
String doctorOffice
String doctorPhone
String bio

static hasMany = [presciptions: Prescription, nurses: Nurse, patients: Patient, appoitments: Appoitment]
static hasOne = [surgery:Surgery]

    static constraints = {
	doctorID unique: true, blank: false
	doctorName blank: false, size: 3..100
        position blank: false
	qualifications blank: false
        doctorEmail email: true, blank: false
	password blank: false
        doctorOffice blank: false, size:1..5 
        doctorPhone blank: false
	bio blank: false
    }
}
