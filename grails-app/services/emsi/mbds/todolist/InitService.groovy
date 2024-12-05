package emsi.mbds.todolist

import grails.gorm.transactions.Transactional

@Transactional
class InitService {

    def init()
    {

        def adminRole = new Role(authority: 'ROLE_ADMIN').save()
        def userRole = new Role(authority: 'ROLE_USER').save()

        def adminUser = new User(username: "admin", password: "admin").save()
        UserRole.create(adminUser, adminRole, true)

        ["Younesse","Daniel","Mestapha"].each {
            String username ->
                def userInstance = new User(username: username, password: "password").save()
                UserRole.create(userInstance, userRole, true)
                def todoInstance = new Todo(title: "Todo $username", description: "Description de la todo de $username")
                (1..5).each {
                    def elementInstance = new Element(title: "Titre de l'élement $it pour $username")
                    todoInstance.addToElements(elementInstance)
                }
                userInstance.addToTodos(todoInstance)
                userInstance.save(flush: true, failOnError: true)
        }
        Todo.list().each {
            Todo todoInstance ->
                User.list().each {
                    todoInstance.addToCollaborators(it)
                }
                todoInstance.save()
        }
    }
}
