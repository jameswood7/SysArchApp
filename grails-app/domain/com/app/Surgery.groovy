package com.app

class Surgery {

String name
String address
String telephone
int numberOfPatients
String description
String openingTime
Boolean registeringNewPatients

static hasMany = [doctors:Doctor,receptionists:Receptionist,nurses:Nurse,patients:Patient]

    static constraints = {
	name blank: false, size: 3..100
        address blank: false
        telephone blank: false
        numberOfPatients blank: false 
        description blank: false
	openingTime blank: false
    }
}
