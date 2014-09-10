/***
 * Excerpted from "Grails: A Quickstart Guide",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/dkgrails for more book information.
***/
def employees = ['Susannah','Noah','Samuel','Gideon'] as Set
Set empty = []

assert employees instanceof Set
assert empty instanceof Set
assert empty.class.name == 'java.util.HashSet'

employees << 'Joshua'

assert employees.contains('Joshua')

println employees.toList()[4]
