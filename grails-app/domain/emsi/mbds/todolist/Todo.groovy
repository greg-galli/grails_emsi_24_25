package emsi.mbds.todolist

class Todo {

    String title
    String description
    Date dateCreated
    Date lastUpdated
    List elements

    static hasMany = [elements: Element, collaborators: User]

    static belongsTo = [author: User]

    static constraints = {
        title blank: false, nullable: false
        description blank: false, nullable: false
    }

    static mappedBy = [
            collaborators: 'none'
    ]
}
