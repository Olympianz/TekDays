/***
 * Excerpted from "Grails: A Quickstart Guide",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/dkgrails for more book information.
***/
class DashboardController {

    def index = { }
    
    def dashboard = {
        def event = TekEvent.get(params.id)
        if (event){
            if(event.organizer.userName == session.user.userName ||
               event.volunteers.collect{it.userName}.contains(
                                                         session.user.userName)){
                def tasks = Task.findAllByEventAndCompleted(event, false, 
                                                            [max:5, sort:'dueDate'])
                def volunteers = event.volunteers
                def messages = Message.findAllByEventAndParentIsNull(event,
                                                                     [sort:'id',
                                                                      order:'desc'])
                def sponsorships = event.sponsorships
                return [event:event, tasks:tasks, volunteers:volunteers, 
                        messages:messages, sponsorships:sponsorships]
            }
            else{
              flash.message = "Access to dashboard for ${event.name} denied."
              redirect(controller:'tekEvent', action:'list')  
          }     
        }
        else{
            flash.message = "No event was found with an id of ${params.id}"
            redirect(controller:'tekEvent', action:'list')
        }
    }
}
