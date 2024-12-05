package emsi.mbds.todolist

import grails.gorm.services.Service

@Service(Element)
interface ElementService {

    Element get(Serializable id)

    List<Element> list(Map args)

    Long count()

    void delete(Serializable id)

    Element save(Element element)

}