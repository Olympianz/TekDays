/***
 * Excerpted from "Grails: A Quickstart Guide",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/dkgrails for more book information.
***/
class TekEvent {
    
    String city
    String name
    TekUser organizer
    String venue
    Date startDate

    Date endDate
    String description
    
    
    static hasMany = [volunteers : TekUser]
    String toString(){
        "$name, $city"
    }
    

    
    static constraints = {
        name()
        city()
        description(maxSize : 5000)
        organizer()
        venue()
        startDate()
        endDate()
        volunteers(nullable : true)
    }  
    
    
}