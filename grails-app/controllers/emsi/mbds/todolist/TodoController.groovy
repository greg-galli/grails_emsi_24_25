package emsi.mbds.todolist

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TodoController {

    TodoService todoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond todoService.list(params), model:[todoCount: todoService.count()]
    }

    def show(Long id) {
        respond todoService.get(id)
    }

    def create() {
        respond new Todo(params)
    }

    def save(Todo todo) {
        if (todo == null) {
            notFound()
            return
        }

        try {
            todoService.save(todo)
        } catch (ValidationException e) {
            respond todo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'todo.label', default: 'Todo'), todo.id])
                redirect todo
            }
            '*' { respond todo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond todoService.get(id)
    }

    def update(Todo todo) {
        if (todo == null) {
            notFound()
            return
        }

        try {
            todoService.save(todo)
        } catch (ValidationException e) {
            respond todo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'todo.label', default: 'Todo'), todo.id])
                redirect todo
            }
            '*'{ respond todo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        todoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'todo.label', default: 'Todo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'todo.label', default: 'Todo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
