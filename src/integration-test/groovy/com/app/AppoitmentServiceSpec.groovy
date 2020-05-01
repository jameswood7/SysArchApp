package com.app

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AppoitmentServiceSpec extends Specification {

    AppoitmentService appoitmentService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Appoitment(...).save(flush: true, failOnError: true)
        //new Appoitment(...).save(flush: true, failOnError: true)
        //Appoitment appoitment = new Appoitment(...).save(flush: true, failOnError: true)
        //new Appoitment(...).save(flush: true, failOnError: true)
        //new Appoitment(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //appoitment.id
    }

    void "test get"() {
        setupData()

        expect:
        appoitmentService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Appoitment> appoitmentList = appoitmentService.list(max: 2, offset: 2)

        then:
        appoitmentList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        appoitmentService.count() == 5
    }

    void "test delete"() {
        Long appoitmentId = setupData()

        expect:
        appoitmentService.count() == 5

        when:
        appoitmentService.delete(appoitmentId)
        sessionFactory.currentSession.flush()

        then:
        appoitmentService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Appoitment appoitment = new Appoitment()
        appoitmentService.save(appoitment)

        then:
        appoitment.id != null
    }
}
