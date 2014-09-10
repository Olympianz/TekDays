
<!-- START:beginning -->
<html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
<!-- END:beginning -->    
<!-- START:js -->
    <g:javascript library="prototype" />
<!-- END:js -->
<!-- START:beginning -->
    <title>Messages</title>
  </head>
  <body>
    <div class="nav">
      <span class="menuButton">
        <a class="home" href="${resource(dir:'')}">Home</a>
      </span>
      <span class="menuButton">
        <g:link class="create" action="create" 
            params='[eventId:"${event?.id}"]'>New Message
        </g:link>
      </span>
    </div>
    
<!-- END:beginning -->
<!-- START:list -->
    <div class="body">
      <h1>${event?.name} - Forum Messages</h1>
      <div id="messageList">
<!-- START:remoteLink -->
        <g:each in="${messageInstanceList}" var="messageInstance">
<!-- END:list -->
<!-- START_HIGHLIGHT -->
          <g:remoteLink action="showDetail" id="${messageInstance?.id}" 
              update="details">
            ${messageInstance.author.fullName} - ${messageInstance.subject}
          </g:remoteLink>
<!-- END_HIGHLIGHT -->
<!-- START:list -->
        </g:each>
<!-- END:remoteLink -->
      </div>
      <h3>Message Details</h3>
      <div id="details">
      </div>  
    </div>    
<!-- END:list -->
<!-- START:beginning --> 
  </body>
</html>
<!-- END:beginning -->
