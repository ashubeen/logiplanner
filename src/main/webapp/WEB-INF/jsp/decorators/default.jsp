<%@ include file="../taglibs.jsp" %>

<!DOCTYPE html>

<html lang="en">
<head>
    <title><decorator:title default="Welcome"/> | <fmt:message key="webapp.name"/></title>
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link rel="shortcut icon" href="${ctx}/resources/images/favicon.ico" type="image/x-icon"/>
           
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/styles/deliciouslyblue/theme.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/styles/css3menu1/style.css" /><style>._css3m{display:none}</style>
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/styles/custom/style_pop.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/ui.css" />
   	<link rel="stylesheet" type="text/css" media="screen" href="${ctx}/resources/css/jquery/ui-lightness/jquery-ui-1.8.6.custom.css" />
	<link rel="stylesheet" type="text/css" media="screen" href="${ctx}/resources/css/jqgrid/ui.jqgrid.css" />
    
    <script type="text/javascript" src="${ctx}/resources/scripts/global.js"></script>
    <script type="text/javascript" src="${ctx}/resources/scripts/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${ctx}/resources/scripts/jquery-ui-1.8.23.custom.min.js"></script>
    <script type="text/javascript" src="${ctx}/resources/scripts/jquery.windowName-0.9.1.plugin.js"></script> 
    
    <!-- <link type="text/css" href="${ctx}/resources/css/jquery-ui-1.8.23.custom.css" rel="stylesheet"/>-->
    <!--  <script type="text/javascript" src="${ctx}/resources/scripts/ui/jquery.ui.widget.js"></script>-->
    <!--  <script type="text/javascript" src="${ctx}/resources/scripts/ui/jquery.ui.datepicker.js"></script>
    <script type="text/javascript" src="${ctx}/resources/scripts/ui/jquery.ui.core.js"></script>-->
    
    
   
	
	<script type="text/javascript">
	    var jq = jQuery.noConflict();
	</script>
	
	<script type="text/javascript">
jQuery(document).ready(function ($) {
	
    $('.datepicker').datepicker({
    	
    	dateFormat: 'yy-mm-dd',
    	        onClose: function(dateText, inst) { 
    	            var month = $("#ui-datepicker-div.ui-datepicker-month :selected").val();
    	            var year = $("#ui-datepicker-div.ui-datepicker-year :selected").val();
    	            var day  = $("#ui-datepicker-div.ui-datepicker-day :selected").val();
    	            $(jQuery(document)).datepicker('setDate', new Date(year, month, day));
    	        }
    });
       
	});
	</script>
	
<style>
	ui-datepicker .ui-datepicker-prev, .ui-datepicker .ui-datepicker-next { position:absolute; top: 2px; width: 1.8em; height: 1.8em; }
</style>
	

    <decorator:head/>
</head>
<body onload="openOffersDialog();" style="background-image: '${ctx}/resources/images/oil.jpg'">
<div id="ajaxLoading" style="display: none; position: absolute; top: 0; right: 0; background: red; padding: 5px 10px; color: white">Loading...</div>
<a name="top"></a>
<div id="page">
    <div id="header" class="clearfix">
        <h1 style="cursor: pointer;display: compact;" onclick="location.href='${ctx}/'">Logi<i>planner</i></h1>

        <div id="branding">
            <a href="${ctx}" title="logiplanner">
                <img src="${ctx}/resources/images/boat-icon.gif" width="100" height="80" alt="Testing" align="right"/></a>
        </div>

       <%--  <p><fmt:message key="webapp.tagline"/></p> --%>
    </div>
    <div id="content">
		
<!--         <div id="main">
 -->            <h1><decorator:title/></h1>
<%--             <security:authorize ifAnyGranted="ROLE_USER,ROLE_ADMIN">
                <div class="logout">Welcome, <%=request.getRemoteUser() %> &nbsp;<a href="${ctx}/logout">Logout</a></div>
            </security:authorize>
            <security:authorize ifNotGranted="ROLE_USER,ROLE_ADMIN">
                <div class="logout"><a id="demo">Login</a></div>
            </security:authorize>
 --%>

            
            <%--shiro:authenticated>
                <div class="logout"><a href="${ctx}/logout">Logout</a></div>
            </shiro:authenticated--%>
            <%--<c:if test="${not empty pageContext.request.remoteUser}">
                <div class="logout"><a href="${ctx}/logout">Logout</a></div>
            </c:if>--%>
            <div id="body">
                <%@ include file="/messages.jsp"%>
                <decorator:body/>
                <div id="underground"><decorator:getProperty property="page.underground"/></div>
            </div>
    <!--     </div> -->

<%--         <div id="sub">
            <h3>Resources</h3>

            <p>The following is a list of resources that I used to create this project..</p>

            <ul class="glassList">
                <li><a href="http://raibledesigns.com/rd/entry/implementing_ajax_authentication_using_jquery">Ajax Authentication using jQuery and Spring Security</a></li>
                <li><a href="http://raibledesigns.com/rd/entry/integration_testing_with_http_https">Integration Testing with HTTP, HTTPS and Maven</a></li>
                <li><a href="http://static.springsource.org/spring-security/site/reference.html">Spring Security Reference</a></li>
                <li><a href="http://www.sitepen.com/blog/2008/07/22/windowname-transport/">window.name Transport</a></li>
                <li><a href="http://stackoverflow.com/questions/1099787/jquery-ajax-post-sending-options-as-request-method-in-firefox">jQuery OPTIONS Request</a></li>
            </ul>

            <img src="${ctx}/images/image.gif" alt="" width="150" height="112" class="right" style="margin: 10px 0 20px 0"/>
        </div>
 --%>
        
 <%--   
 <div id="nav">
          <div class="wrapper">
                <h2 class="accessibility">Navigation</h2>
                <ul class="clearfix">
                    <li><a href="${ctx}/" title="Home"><span>Home</span></a></li>
                    <li><a href="${ctx}/users" title="View Users"><span>Users</span></a></li>
                </ul>
            </div> 
            </div>
            --%>


			<div id="navtest">
				<ul id="css3menu1" class="topmenu">
					<li class="topmenu"><a href="localhost:8080" title="Home"
						style="height: 16px; line-height: 16px;">Home</a></li>
					<li class="topmenu"><a href="#"
						style="height: 16px; line-height: 16px;"><span>Admin</span></a>
						<ul>
							<li class="subfirst"><a href="${ctx}/admin/person/persons">Persons</a></li>
							<li class="sublast"><a href="${ctx}/admin/company/companies">Company</a></li>
							<li class="sublast"><a href="${ctx}/admin/location/locations">Location</a></li>
							<li class="sublast"><a href="${ctx}/admin/activity/activities">Activity</a></li>
							<li class="sublast"><a href="${ctx}/admin/vessel/vessels">Vessel</a></li>
							<li class="sublast"><a href="${ctx}/admin/title/titles">Title</a></li>
							<li class="sublast"><a href="${ctx}/admin/contract/contracts">Contract</a></li>
						</ul></li>

					<li class="topmenu"><a href="#"
						style="height: 16px; line-height: 16px;"><span>Schedule</span></a>
						<ul>
							<li class="subfirst"><a href="#">Item 1 0</a></li>
							<li><a href="#">Item 1 1</a></li>
							<li class="sublast"><a href="#">Item 1 2</a></li>
						</ul></li>
					<li class="topmenu"><a href="#"
						style="height: 16px; line-height: 16px;">Item 2</a></li>
					<li><a href="#"
						style="height: 16px; line-height: 16px; width: 460px;">&nbsp;</a></li>
				</ul>

			</div>
			<!-- end nav -->

    </div><!-- end content -->

    <div id="footer">
        <p> @CopyRights
<!--             <a href="http://www.oswd.org/design/preview/id/2634">Theme</a> from <a href="http://www.oswd.org/">OSWD</a> |
            Design by <a href="http://www.oswd.org/user/profile/id/8377">super j man</a>
 -->        </p>
    </div>
</div>
</body>
</html>
