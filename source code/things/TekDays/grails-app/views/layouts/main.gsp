<html>
  <head>
    <title><g:layoutTitle default="Grails" /></title>
    <link rel="stylesheet" 
          href="${resource(dir:'css',file:'main.css')}" />
    <link rel="shortcut icon" 
          href="${resource(dir:'images',file:'favicon.ico')}" 
          type="image/x-icon" />
    <g:layoutHead />
    <g:javascript library="application" />				
  </head>
  <body>
    <div id="spinner" class="spinner" style="display:none;">
      <img src="${resource(dir:'images',file:'spinner.gif')}" alt="Spinner"/>
    </div>
    <!-- START:logo -->	
    <div class="logo">
      <img src="${resource(dir:'images',file:'td_logo.png')}" alt="TekDays"/>
    </div> 
    <!-- END:logo -->
    <g:layoutBody />	
  </body>	
</html>


<!-- 
  <div style="width:120px; background:white; height:100%; float:left; margin:0.8em 0 0.3em; border-right:thin solid;">
      <div style="width:118; height:80; border-top:thin solid; border-bottom:thin solid">
        <h4>This would be a good place for announcements or links to related resources</h4>
      </div>
  </div>  
  <div style="float:left; width:75%">
  
  
-->

