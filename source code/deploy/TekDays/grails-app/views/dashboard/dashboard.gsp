<html>
  <head>
    <title>TekDays - Dashboard</title>
    <meta name="layout" content="main" />
  </head>
  <body>
    <div class="nav">
        <span class="menuButton">
          <a class="home" href="${resource(dir:'')}">Home</a>
        </span>
        <span class="menuButton">
          <g:link class="create" controller="task" action="create">
            Create Task
          </g:link>
        </span>
        <span class="menuButton">
          <g:link class="create" controller="sponsorship" action="create">
            Add Sponsor
          </g:link>
        </span>
        <span class="menuButton">
          <g:link class="list" controller="sponsor" action="list">
            All Sponsors
          </g:link>
        </span>
    </div>
<!-- START:blurb -->
    <div id="event" style='margin:10px 10px 10px 10px'>
      <g:render template="event" model="${[event:event]}" />
    </div>
<!-- START_HIGHLIGHT -->
    <div id="blurb" style='margin:10px 10px 10px 10px'>
      <g:render template="blurb" model="${[blurb:blurb, event:event]}" />
    </div>
<!-- END_HIGHLIGHT -->
    <div id="tasks" style='margin:10px 10px 10px 10px'>
      <g:render template="tasks" model="${['tasks':tasks]}" />
    </div>
<!-- END:blurb -->
    <div id="volunteers" style='margin:10px 10px 10px 10px'>
      <g:render template="volunteers" model="${['volunteers':volunteers]}" />
    </div>
    <div id="messages" style='margin:10px 10px 10px 10px'>
      <g:render template="messages" model="${[messages:messages]}" />
    </div>
<!-- START:twitter -->
    <div id="sponsors" style='margin:10px 10px 10px 10px'>
      <g:render template="sponsors" model="${[sponsorships:sponsorships]}" />
    </div>
<!-- START_HIGHLIGHT -->
    <g:if test="${event.twitterId}">
      <div id="twitter" style='margin:10px 10px 10px 10px'>
        <g:render template="twitter" model="${[event:event]}" />
      </div>
    </g:if>
<!-- END_HIGHLIGHT -->
  </body>
</html>
<!-- END:twitter -->