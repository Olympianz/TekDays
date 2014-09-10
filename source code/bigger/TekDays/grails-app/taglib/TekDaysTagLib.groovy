/***
 * Excerpted from "Grails: A Quickstart Guide",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/dkgrails for more book information.
***/
class TekDaysTagLib {

  def messageThread = {attrs ->
    def messages = attrs.messages.findAll{!it.parent}
    processMessages(messages, 0)
  }
  
  void processMessages(messages, indent){
    messages.each{msg ->

      def body = "${msg?.author} - ${msg?.subject}"
      out << "<div style='height:30; margin-left:${indent * 20};'>"
      out << "${remoteLink(action:'showDetail', id:msg.id, update:'details', body)}"
      out << "</div>"
      
      def children = Message.findAllByParent(msg)
      if (children){
          processMessages(children, indent + 1)
      }
    }
  }

  def loginToggle = {
    out << "<div>"
    if (session.user){
      out << "<span style='float:left;margin:5px 0px 0px 10px'>"
      out << "Welcome ${session.user}."
      out << "</span><span style='float:right;margin:5px 10px 0px 0px'>"
      out << "<a href='${createLink(controller:'tekUser', action:'logout')}'>"
      out << "Logout </a></span>"
    }
    else{
      out << "<span style='float:right;margin:5px 10px 0px 0px'>"
      out << "<a href='${createLink(controller:'tekUser', action:'login')}'>"
      out << "Login </a></span>"
    }
    out << "</div><br/>"
  }

}

