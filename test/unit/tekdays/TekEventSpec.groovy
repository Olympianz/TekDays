package tekdays

import grails.test.mixin.TestFor
// import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(TekEvent)
class TekEventSpec {

   	protected void setup() {
    }

    protected void cleanup() {
    }

    void testToString() {
    	def tekEvent = new TekEvent(
    		name: 'Groovy One',
    		city: 'San Francisco, CA',
    		organizer: [fullName: 'John Doe'] as TekUser,
    		venue: 'Moscone Center',
    		startDate: new Date('6/2/2009'),
    		endDate: new Date('6/5/2009'),
    		description: 'This conference will cover all...' )
    	assertEquals 'Groovy One, San Francisco, CA', tekEvent.toString()
    }
}
