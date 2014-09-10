/***
 * Excerpted from "Grails: A Quickstart Guide",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/dkgrails for more book information.
***/
dataSource {
	pooled = true
	driverClassName = "com.mysql.jdbc.Driver"
	username = "dave"
	password = "1234"
}
hibernate {
    cache.use_second_level_cache=true
    cache.use_query_cache=true
    cache.provider_class='com.opensymphony.oscache.hibernate.OSCacheProvider'
}
// environment specific settings
environments {
	development {
		dataSource {
		  dbCreate = "update"//one of 'create', 'create-drop','update'
		  url = "jdbc:mysql://localhost:3306/tekdays"
		}
	}
	test {
		dataSource {
			dbCreate = "update"
			url = "jdbc:hsqldb:mem:testDb"
		}
	}

	production {
		dataSource {
			jndiName = "java:comp/env/jdbc/TekDaysDS"
		}
	}

}