package com.app

import grails.gorm.services.Service

@Service(Appoitment)
interface AppoitmentService {

    Appoitment get(Serializable id)

    List<Appoitment> list(Map args)

    Long count()

    void delete(Serializable id)

    Appoitment save(Appoitment appoitment)

}