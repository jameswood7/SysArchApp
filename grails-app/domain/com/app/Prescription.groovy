package com.app

class Prescription {

String pharmacyName
int prescriptionNumber
String medicine
int daysSupply
int totalCost
Date dateIssued
boolean patientPaying

static hasOne = [doctor: Doctor]
static belongsTo = [patient:Patient]

    static constraints = {
	prescriptionNumber unique:true, blank: false
        medicine blank: false
        daysSupply blank: false
        totalCost blank: false 
        dateIssued blank: false
    }
}
