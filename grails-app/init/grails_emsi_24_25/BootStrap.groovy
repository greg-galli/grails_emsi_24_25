package grails_emsi_24_25

import emsi.mbds.todolist.Role
import emsi.mbds.todolist.User
import emsi.mbds.todolist.UserRole

class BootStrap {

    def initService

    def init = { servletContext ->
        initService.init()
    }
    def destroy = {
    }
}
