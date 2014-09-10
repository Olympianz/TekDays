/***
 * Excerpted from "Grails: A Quickstart Guide",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/dkgrails for more book information.
***/


class TekUserController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ tekUserInstanceList: TekUser.list( params ), tekUserInstanceTotal: TekUser.count() ]
    }

    def show = {
        def tekUserInstance = TekUser.get( params.id )

        if(!tekUserInstance) {
            flash.message = "TekUser not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ tekUserInstance : tekUserInstance ] }
    }

    def delete = {
        def tekUserInstance = TekUser.get( params.id )
        if(tekUserInstance) {
            try {
                tekUserInstance.delete()
                flash.message = "TekUser ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "TekUser ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "TekUser not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def tekUserInstance = TekUser.get( params.id )

        if(!tekUserInstance) {
            flash.message = "TekUser not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ tekUserInstance : tekUserInstance ]
        }
    }

    def update = {
        def tekUserInstance = TekUser.get( params.id )
        if(tekUserInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(tekUserInstance.version > version) {
                    
                    tekUserInstance.errors.rejectValue("version", "tekUser.optimistic.locking.failure", "Another user has updated this TekUser while you were editing.")
                    render(view:'edit',model:[tekUserInstance:tekUserInstance])
                    return
                }
            }
            tekUserInstance.properties = params
            if(!tekUserInstance.hasErrors() && tekUserInstance.save()) {
                flash.message = "TekUser ${params.id} updated"
                redirect(action:show,id:tekUserInstance.id)
            }
            else {
                render(view:'edit',model:[tekUserInstance:tekUserInstance])
            }
        }
        else {
            flash.message = "TekUser not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def tekUserInstance = new TekUser()
        tekUserInstance.properties = params
        return ['tekUserInstance':tekUserInstance]
    }

    def save = {
        def tekUserInstance = new TekUser(params)
        if(!tekUserInstance.hasErrors() && tekUserInstance.save()) {
            flash.message = "TekUser ${tekUserInstance.id} created"
            redirect(action:show,id:tekUserInstance.id)
        }
        else {
            render(view:'create',model:[tekUserInstance:tekUserInstance])
        }
    }
    

    def login = {
        if (params.cName)
            return [cName:params.cName, aName:params.aName]      
    }



    def validate = {
        def user = TekUser.findByUserName(params.username)
        if (user && user.password == params.password){
            session.user = user
            if (params.cName)
                redirect(controller:params.cName, action:params.aName)
            else
                redirect(controller:'tekEvent', action:'list')
        }
        else{
          flash.message = "Invalid username and password."
          render(view:'login')
        }
    }



    def logout = { 
        session.user = null 
        redirect(url:resource(dir:''))
    }

}