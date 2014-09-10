/***
 * Excerpted from "Grails: A Quickstart Guide",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/dkgrails for more book information.
***/

def colors = ['Red', 'Green', 'Blue', 'Yellow']
def empty = [] 

assert colors instanceof List
assert empty instanceof List
assert empty.class.name == 'java.util.ArrayList'



def names = ['Nate', 'Matthew', 'Craig', 'Amanda']

names.each{
  println "The name $it contains ${it.size()} characters."
}



assert names.min() == 'Amanda'
assert names.max() == 'Nate'



def sortedNames = names.sort()
assert sortedNames == ['Amanda','Craig','Matthew','Nate']

sortedNames = names.sort{it.size()}
assert sortedNames == ['Nate','Craig','Amanda','Matthew']

sortedNames = names.sort{obj1, obj2 ->
  obj1[2] <=> obj2[2]
}
assert sortedNames == ['Craig','Amanda','Nate','Matthew']



names << 'Jim'
assert names.contains('Jim')

