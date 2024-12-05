package emsi.mbds.todolist

class Element {

    String title
    String description
    Boolean isChecked = Boolean.FALSE

    static belongsTo = [todo: Todo]

    static constraints = {
        title nullable: false, blank: false
        description nullable: true, blank: true
        isChecked nullable: false
    }

    static mapping = {
        description type: "text"
    }
}
