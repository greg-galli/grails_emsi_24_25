package emsi.mbds.todolist

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ElementServiceSpec extends Specification {

    ElementService elementService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Element(...).save(flush: true, failOnError: true)
        //new Element(...).save(flush: true, failOnError: true)
        //Element element = new Element(...).save(flush: true, failOnError: true)
        //new Element(...).save(flush: true, failOnError: true)
        //new Element(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //element.id
    }

    void "test get"() {
        setupData()

        expect:
        elementService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Element> elementList = elementService.list(max: 2, offset: 2)

        then:
        elementList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        elementService.count() == 5
    }

    void "test delete"() {
        Long elementId = setupData()

        expect:
        elementService.count() == 5

        when:
        elementService.delete(elementId)
        sessionFactory.currentSession.flush()

        then:
        elementService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Element element = new Element()
        elementService.save(element)

        then:
        element.id != null
    }
}
