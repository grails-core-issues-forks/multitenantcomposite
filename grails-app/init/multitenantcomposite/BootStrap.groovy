package multitenantcomposite

import grails.gorm.multitenancy.Tenants
import groovy.transform.CompileStatic

@CompileStatic
class BootStrap {

    BookService bookService

    def init = { servletContext ->
        String grailsId = UUID.randomUUID().toString()
        Tenants.withId("grails") {
            bookService.save(grailsId, "The definitive Guide to Grails 2")
        }
        String groovyId = UUID.randomUUID().toString()
        Tenants.withId("groovy") {
            bookService.save(groovyId, "Groovy in Action")
        }
        /*
        Tenants.withId("grails") {
            bookService.save(groovyId,"grails", "Grails in Action")
        }
         */
    }

    def destroy = {
    }
}
