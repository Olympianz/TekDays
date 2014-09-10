

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Message</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <!-- START:list -->
            <span class="menuButton">
              <g:link class="list" action="list" id="${messageInstance?.event?.id}">
                Message List
              </g:link>
            </span>
            <!-- END:list -->
        </div>
        <div class="body">
            <!-- START:heading -->
            <h1>${messageInstance?.event?.name} Forum - New Message</h1>
            <!-- END:heading -->
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${messageInstance}">
            <div class="errors">
                <g:renderErrors bean="${messageInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                            <!-- START:reply -->
                            <g:if test="${messageInstance.parent}">
                              <input type="hidden" name="parent.id" value="${messageInstance.parent.id}" />
                              <tr class="prop">
                                  <td valign="top" class="name">
                                      <label>In Reply to:</label>
                                  </td>
                                  <td valign="top" class="value"> 
                                      ${messageInstance.parent.author}
                                  </td>
                              </tr> 
                            </g:if>
                            <!-- END:reply -->
                            <!-- START:subject -->
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="subject">Subject:</label>
                                </td>
                                <td valign="top" 
                                    class="value ${hasErrors(bean:messageInstance,field:'subject','errors')}">
                                    <input type="text" class="messageField" id="subject" name="subject" 
                                        value="${fieldValue(bean:messageInstance,field:'subject')}"/>
                                </td>
                            </tr> 
                            
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="content">Content:</label>
                                </td>
                                <td valign="top" 
                                    class="value ${hasErrors(bean:messageInstance,field:'content','errors')}">
                                  <textarea class="messageField" rows="5" cols="60" name="content">
                                    ${fieldValue(bean:messageInstance, field:'content')}
                                  </textarea>
                                </td>
                            </tr> 
                            <!-- END:subject -->
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="author">Author:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:messageInstance,field:'author','errors')}">
                                    <g:select optionKey="id" from="${TekUser.list()}" name="author.id" value="${messageInstance?.author?.id}" ></g:select>
                                </td>
                            </tr> 
                        </tbody>
                    </table>
                    <!-- START:event -->
                    <input type="hidden" name="event.id" value="${messageInstance?.event?.id}" />
                    <!-- END:event -->
                </div>
                <div class="buttons">
                    <span class="button"><input class="save" type="submit" value="Create" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
