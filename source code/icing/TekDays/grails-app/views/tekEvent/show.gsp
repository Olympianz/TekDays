<html>
<!-- START:head -->
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
<!-- START_HIGHLIGHT -->
    <gui:resources components="['dialog']"/>
<!-- END_HIGHLIGHT -->
    <title>Show TekEvent</title>
  </head>
<!-- END:head -->
  <body>
<!-- START:volunteerButton -->
    <div class="nav">
      <span class="menuButton">
        <a class="home" href="${resource(dir:'')}">Home</a>
      </span>
      <span class="menuButton">
        <g:link class="list" action="list">TekEvent List</g:link>
      </span>
      <span class="menuButton">
        <g:link class="create" action="create">New TekEvent</g:link>
      </span>
      <span class="menuButton">
        <g:link class="list" controller="dashboard" action="dashboard" 
                id="${tekEventInstance.id}">Event Dashboard</g:link>
      </span>
<!-- START_HIGHLIGHT -->
      <g:volunteerButton eventId="${tekEventInstance.id}" />
<!-- END_HIGHLIGHT -->
    </div>
<!-- END:volunteerButton -->

<!-- START:gui -->
    <gui:dialog
          title="${'Volunteer for ' + tekEventInstance.name}"
          form="true"
          controller="tekEvent"
          action="volunteer"
          update="volunteerSpan"
          triggers="[show:[id:'volunteerButton', on:'click']]">
          <input type="hidden" name="id" value="${tekEventInstance.id}" />
        Welcome to the team!  
        Your help will make a huge difference.
    </gui:dialog>
<!-- END:gui -->

<!-- START:body -->
    <div class="body">
      <h1>${fieldValue(bean:tekEventInstance, field:'name')}</h1>
      <!-- END:name -->
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <div class="dialog">
        <table>
          <tbody>
            <tr class="prop">
              <td valign="top" class="name">Description:</td>
              <td valign="top" class="value">
                ${fieldValue(bean:tekEventInstance, field:'description')}
              </td>
            </tr>
            <tr class="prop">
              <td valign="top" class="name">Location:</td>
              <td valign="top" class="value">
                ${fieldValue(bean:tekEventInstance, field:'venue')},  
                  ${fieldValue(bean:tekEventInstance, field:'city')}
              </td>
            </tr>
            </tr>
            <tr class="prop">
              <td valign="top" class="name">Start Date:</td>
              <td valign="top" class="value">
                <g:formatDate format="MMMM dd, yyyy" 
                              date="${tekEventInstance.startDate}"/>
              </td>
            </tr>
            </tr>
            <tr class="prop">
              <td valign="top" class="name">End Date:</td>
              <td valign="top" class="value">
                <g:formatDate format="MMMM dd, yyyy" 
                              date="${tekEventInstance.endDate}"/>
              </td>
            </tr>
            <tr class="prop">
              <td valign="top" class="name">Sponsored By:</td>
              <td  valign="top" style="text-align:left;" class="value">
                <ul>
                  <g:each var="s" in="${tekEventInstance.sponsorships}">
                    <li><g:link controller="sponsorship" action="show" id="${s.id}">
                      ${s.sponsor?.encodeAsHTML()}
                    </g:link></li>
                  </g:each>
                </ul>
              </td>
            </tr>
          </tbody>
        </table>
<!-- START_HIGHLIGHT -->
        <div style="width:100%">
          <g:blurb name="custom_${tekEventInstance?.id}" />
        </div>
<!-- END_HIGHLIGHT -->
      </div>
      <div class="buttons">
        <g:form>
          <input type="hidden" name="id" value="${tekEventInstance?.id}" />
          <span class="button">
            <g:actionSubmit class="edit" value="Edit" />
          </span>
          <span class="button">
            <g:actionSubmit class="delete" 
               onclick="return confirm('Are you sure?');" value="Delete" />
          </span>
        </g:form>
      </div>
    </div>
  </body>
<!-- END:body -->
</html>
