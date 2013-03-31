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
   
   <link rel="stylesheet" type="text/css" href="${ctx}/resources/styles/pagecss/395229.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/styles/css3menu1/navstyle.css" /><style>._css3m{display:none}</style>
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
<body onload="openOffersDialog();">
<div id="ajaxLoading" style="display: none; position: absolute; top: 0; right: 0; background: red; padding: 5px 10px; color: white">Loading...</div>
<a name="top"></a>
<div id="page">


   <div id="wrapper">
        <div id="headerwrap">
        <div id="header">
            <p>This is the Header</p>
        </div>
        </div>
        <div id="navigationwrap">
        <div id="navigation">
          	<ul id="css3menu1" class="topmenu">
				<li class="topfirst"><a href="#" style="height:14px;line-height:14px;">Home</a></li>
				<li class="topmenu"><a href="#" style="height:14px;line-height:14px;"><span>Schedule</span></a>
					<ul>
						<li class="subfirst"><a href="#">Item 1 2</a></li>
					</ul>
				</li>
				<li class="toplast"><a href="#" style="height:14px;line-height:14px;"><span>Administration</span></a>
					<ul>
							<li class="subfirst"><a href="${ctx}/admin/person/persons">Persons</a></li>
							<li class="sublast"><a href="${ctx}/admin/company/companies">Company</a></li>
							<li class="sublast"><a href="${ctx}/admin/location/locations">Location</a></li>
							<li class="sublast"><a href="${ctx}/admin/activity/activities">Activity</a></li>
							<li class="sublast"><a href="${ctx}/admin/vessel/vessels">Vessel</a></li>
							<li class="sublast"><a href="${ctx}/admin/title/titles">Title</a></li>
							<li class="sublast"><a href="${ctx}/admin/contract/contracts">Contract</a></li>
					</ul>
				</li>
			</ul>
        </div>
        
        
               </div>
        <div id="contentliquid"><div id="contentwrap">
        <div id="content">
                   <%@ include file="/messages.jsp"%>
                <decorator:body/>
                <div id="underground"><decorator:getProperty property="page.underground"/></div>
        </div>
        </div></div>
        <div id="footerwrap">
        <div id="footer">
            <p>@CopyRights</p>
        </div>
        </div>
    </div>
 

</div>
</body>
</html>
