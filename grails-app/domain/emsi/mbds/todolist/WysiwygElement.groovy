package emsi.mbds.todolist

class WysiwygElement extends Element {

    String content

    static constraints = {
        content nullable: false, blank: false
    }

    static mapping = {
        content type: 'text'
    }
}
