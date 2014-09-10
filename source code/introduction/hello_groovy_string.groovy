/***
 * Excerpted from "Grails: A Quickstart Guide",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/dkgrails for more book information.
***/
def name = 'Zachary'
def x = 3
def y = 7
def groovyString = "Hello ${name}, did you know that $x x $y equals ${x*y}?"

assert groovyString == 'Hello Zachary, did you know that 3 x 7 equals 21?'