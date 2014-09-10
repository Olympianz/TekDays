/***
 * Excerpted from "Grails: A Quickstart Guide",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/dkgrails for more book information.
***/

class DashboardController {
    
    def twitterService
    //Existing dashboard code snipped


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
                def blurb = Blurb.findByName("custom_${event.id}")
                if (!blurb){
                    blurb = new Blurb(name:"custom_${event.id}", 
                                      content:"").save()
                }
                return [event:event, tasks:tasks, volunteers:volunteers, 
                        messages:messages, sponsorships:sponsorships,
                        blurb:blurb]
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


    def updateBlurb = {
	    def blurb = Blurb.get(params.id)
	    blurb.content = params.content
	    blurb.save()
	    redirect(action:'dashboard', id:params.eventId)
    }


    def tweet = {
	    def event = TekEvent.get(params.id)
	    if (event){
		    twitterService.setStatus(params.status, 
                                     [username:event.twitterId,
                                      password:event.twitterPassword])
	    }
	    redirect(action:dashboard, id:event.id)
    }
}

