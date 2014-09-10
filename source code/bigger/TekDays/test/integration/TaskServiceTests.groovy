/***
 * Excerpted from "Grails: A Quickstart Guide",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/dkgrails for more book information.
***/
import grails.test.*

class TaskServiceTests extends GrailsUnitTestCase {
    def taskService
    
    protected void setUp() {
        super.setUp()
        new TekUser(fullName:'Tammy Tester',
                    userName:'tester',
                    email:'tester@test.com',
                    website:'test.com',
                    bio:'A test person').save()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testAddDefaultTasks() {
        def e = new TekEvent(name:'Test Event',
                             city:'TestCity, USA',
                             description:'Test Description',
                             organizer:TekUser.findByUserName('tester'),
                             venue:'TestCenter',
                             startDate:new Date(),
                             endDate:new Date() + 1)
        taskService.addDefaultTasks(e)
        assertEquals e.tasks.size(), 6
    }
}
