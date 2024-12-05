package emsi.mbds.todolist

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ElementController {

    ElementService elementService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond elementService.list(params), model:[elementCount: elementService.count()]
    }

    def show(Long id) {
        respond elementService.get(id)
    }

    def create() {
        respond new Element(params)
    }

    def save(Element element) {
        if (element == null) {
            notFound()
            return
        }

        try {
            elementService.save(element)
        } catch (ValidationException e) {
            respond element.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'element.label', default: 'Element'), element.id])
                redirect element
            }
            '*' { respond element, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond elementService.get(id)
    }

    def update(Element element) {
        if (element == null) {
            notFound()
            return
        }

        try {
            elementService.save(element)
        } catch (ValidationException e) {
            respond element.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'element.label', default: 'Element'), element.id])
                redirect element
            }
            '*'{ respond element, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        elementService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'element.label', default: 'Element'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'element.label', default: 'Element'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
