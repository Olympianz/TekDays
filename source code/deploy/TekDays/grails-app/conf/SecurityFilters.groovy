/***
 * Excerpted from "Grails: A Quickstart Guide",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/dkgrails for more book information.
***/
class SecurityFilters {
  def filters = {
    doLogin(controller:'*', action:'*'){
        before = {
	        if (!controllerName)
	          return true
            def allowedActions = ['show', 'index', 'list', 'login', 
                                  'validate', 'search']
            if (!session.user && !allowedActions.contains(actionName)){
              redirect(controller:'tekUser', action:'login', 
                       params:['cName': controllerName, 'aName':actionName])
              return false
            }
        }
    }     
  }
}