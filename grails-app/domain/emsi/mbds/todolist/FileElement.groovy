package emsi.mbds.todolist

class FileElement extends Element {

    String name

    static constraints = {
        name nullable: false, blank: false
    }
}
