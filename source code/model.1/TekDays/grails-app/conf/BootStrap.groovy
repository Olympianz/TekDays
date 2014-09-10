/***
 * Excerpted from "Grails: A Quickstart Guide",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/dkgrails for more book information.
***/
class BootStrap {

    def init = { servletContext ->
        new TekUser(fullName: 'John Doe', 
                    userName: 'jdoe',
                    password: 't0ps3cr3t',
                    email: 'jdoe@johnsgroovyshop.com',
                    website: 'blog.johnsgroovyshop.com',
                    bio: 'John has been programming for over 40 years. ...').save()
        new TekUser(fullName: 'John Deere', 
                    userName: 'tractorman',
                    password: 't0ps3cr3t',
                    email: 'john.deere@porkproducers.org',
                    website: 'www.perl.porkproducers.org',

                    bio: 'John is a top notch Perl programmer and a ...').save()
                            
        new TekEvent(name: 'Gateway Code Camp',
                     city: 'Saint Louis, MO',
                     organizer: TekUser.findByFullName('John Doe'),
                     venue: 'TBD',
                     startDate: new Date('9/19/2009'),
                     endDate: new Date('9/19/2009'),
                     description: 'This conference will bring coders ...').save()
        new TekEvent(name: 'Perl Before Swine',
                     city: 'Austin, MN',
                     organizer: TekUser.findByFullName('John Deere'),
                     venue: 'SPAM Museum',
                     startDate: new Date('9/1/2009'),
                     endDate: new Date('9/1/2009'),
                     description: 'Join the Perl programmers of the ...').save()  


        def g1 = TekEvent.findByName('Gateway Code Camp')
        g1.addToVolunteers(new TekUser(fullName: 'Sarah Martin',
                                       userName: 'sarah',
                                       password: '54321',
                                       email: 'sarah@martinworld.com',
                                       website: 'www.martinworld.com',  
                                       bio: 'Web designer and Grails afficianado.'))

        g1.addToVolunteers(new TekUser(fullName: 'Bill Smith',
                                       userName: 'Mr_Bill',
                                       password: '12345',
                                       email: 'mrbill@email.com',
                                       website: 'www.mrbillswebsite.com',
                                       bio: 'Software developer and claymation artist.'))
        
        
        g1.addToRespondents('ben@grailsmail.com')
        g1.addToRespondents('zachary@linuxgurus.org')
        g1.addToRespondents('solomon@bootstrapwelding.com')
        
        g1.save()



    }

    
    def destroy = {
    }
} 