package com.app

class Appoitment {

int appoitmentID
Date appDay
String appTime
int appDuration
int rooNumber

static belongsTo = [doctor:Doctor]
static hasOne = [patient:Patient]

    static constraints = {
	appoitmentID blank: false, unique: true
	appDay blank: false
	appTime blank: false
	appDuration blank: false
	rooNumber blank: false
    }
}
