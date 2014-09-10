/***
 * Excerpted from "Grails: A Quickstart Guide",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/dkgrails for more book information.
***/

class TaskService {

    boolean transactional = true

    def serviceMethod() {

    }


    def addDefaultTasks(tekEvent){
      if (tekEvent.tasks?.size() > 0)
        return //We only want to add tasks to a new event
          
      tekEvent.addToTasks new Task(title:'Identify potential venues')
      tekEvent.addToTasks new Task(title:'Get price / availability of venues')
      tekEvent.addToTasks new Task(title:'Compile potential sponsor list')
      tekEvent.addToTasks new Task(title:'Design promotional materials')
      tekEvent.addToTasks new Task(title:'Compile potential advertising avenues')
      tekEvent.addToTasks new Task(title:'Locate swag provider (preferably local)')
      tekEvent.save()
    }


}

