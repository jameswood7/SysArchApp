package com.app

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AppoitmentController {

    AppoitmentService appoitmentService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond appoitmentService.list(params), model:[appoitmentCount: appoitmentService.count()]
    }

    def show(Long id) {
        respond appoitmentService.get(id)
    }

    def create() {
        respond new Appoitment(params)
    }

    def save(Appoitment appoitment) {
        if (appoitment == null) {
            notFound()
            return
        }

        try {
            appoitmentService.save(appoitment)
        } catch (ValidationException e) {
            respond appoitment.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'appoitment.label', default: 'Appoitment'), appoitment.id])
                redirect appoitment
            }
            '*' { respond appoitment, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond appoitmentService.get(id)
    }

    def update(Appoitment appoitment) {
        if (appoitment == null) {
            notFound()
            return
        }

        try {
            appoitmentService.save(appoitment)
        } catch (ValidationException e) {
            respond appoitment.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'appoitment.label', default: 'Appoitment'), appoitment.id])
                redirect appoitment
            }
            '*'{ respond appoitment, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        appoitmentService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'appoitment.label', default: 'Appoitment'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'appoitment.label', default: 'Appoitment'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
