/***
 * Excerpted from "Grails: A Quickstart Guide",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/dkgrails for more book information.
***/

def family = [boys:7, girls:6, Debbie:1, Dave:1]
def empty = [:]

assert family instanceof Map
assert empty instanceof Map
assert empty.getClass().name == 'java.util.LinkedHashMap'



def favoriteColors = [Ben:'Green',Solomon:'Blue',Joanna:'Red']
favoriteColors.each{key, value ->
    println "${key}'s favorite color is ${value}."
}



assert favoriteColors.Joanna == 'Red'



favoriteColors.Rebekah = 'Pink'
assert favoriteColors.size() == 4
assert favoriteColors.containsKey('Rebekah')




