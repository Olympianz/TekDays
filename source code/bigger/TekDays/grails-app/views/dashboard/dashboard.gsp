<!-- START:basics -->
<html>
  <head>
    <title>TekDays - Dashboard</title>
    <meta name="layout" content="main" />
  </head>
  <body>
<!-- END:basics -->
<!-- START:menu -->
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
<!-- END:menu -->
<!-- START:body -->
    <div id="event" style='margin:10px 10px 10px 10px'>
      <g:render template="event" model="${['event':event]}" />
    </div>
    <div id="tasks" style='margin:10px 10px 10px 10px'>
      <g:render template="tasks" model="${['tasks':tasks]}" />
    </div>
    <div id="volunteers" style='margin:10px 10px 10px 10px'>
      <g:render template="volunteers" model="${['volunteers':volunteers]}" />
    </div>
    <div id="messages" style='margin:10px 10px 10px 10px'>
      <g:render template="messages" model="${[messages:messages]}" />
    </div>
    <div id="sponsors" style='margin:10px 10px 10px 10px'>
      <g:render template="sponsors" model="${[sponsorships:sponsorships]}" />
    </div>
<!-- END:body -->    
<!-- START:basics -->
  </body>
</html>
<!-- END:basics -->
