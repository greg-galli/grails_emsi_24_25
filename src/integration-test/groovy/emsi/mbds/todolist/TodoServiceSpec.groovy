package emsi.mbds.todolist

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TodoServiceSpec extends Specification {

    TodoService todoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Todo(...).save(flush: true, failOnError: true)
        //new Todo(...).save(flush: true, failOnError: true)
        //Todo todo = new Todo(...).save(flush: true, failOnError: true)
        //new Todo(...).save(flush: true, failOnError: true)
        //new Todo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //todo.id
    }

    void "test get"() {
        setupData()

        expect:
        todoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Todo> todoList = todoService.list(max: 2, offset: 2)

        then:
        todoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        todoService.count() == 5
    }

    void "test delete"() {
        Long todoId = setupData()

        expect:
        todoService.count() == 5

        when:
        todoService.delete(todoId)
        sessionFactory.currentSession.flush()

        then:
        todoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Todo todo = new Todo()
        todoService.save(todo)

        then:
        todo.id != null
    }
}
