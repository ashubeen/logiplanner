<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

 <%--   <link href='<c:url value="/resources/js/jtable//themes/standard/blue/jtable_blue.css"/>' rel="stylesheet" type="text/css" />
   <script type="text/javascript" src='<c:url value="/resources/js/jtable/jquery.jtable.js"/>'></script>
      <script type="text/javascript" src='<c:url value="/resources/js/jtable/jquery.jtable.min.js"/>'></script>
   <script src='<c:url value="/resources/js/jquery/js/jquery-1.8.0.min.js"/>' type="text/javascript"></script>
   <script src='<c:url value="/resources/js/jquery/js/jquery-ui-1.8.23.custom.min.js"/>' type="text/javascript"></script>
    --%>
   
   
    <link href='<c:url value="/resources/Content/Site.css"/>' rel="stylesheet" type="text/css" />
    <link href='<c:url value="/resources/Content/themes/redmond/jquery-ui-1.8.16.custom.css"/>' rel="stylesheet"
        type="text/css" />
    <!-- jTable style file -->
    <link href='<c:url value="/resources/JScripts/jtable/themes/standard/blue/jtable_blue.css"/>' rel="stylesheet"
        type="text/css" />
    <script src='<c:url value="/resources/JScripts/jquery-1.6.4.min.js"/>' type="text/javascript"></script>
    <script src='<c:url value="/resources/JScripts/jquery-ui-1.8.16.custom.min.js"/>' type="text/javascript"></script>
    <script src='<c:url value="/resources/JScripts/modernizr-1.7.min.js"/>' type="text/javascript"></script>
    <script src='<c:url value="/resources/JScripts/jtablesite.js"/>' type="text/javascript"></script>
    <!-- A helper library for JSON serialization -->
    <script type="text/javascript" src='<c:url value="/resources/JScripts/jtable/external/json2.js"/>'></script>
    <!-- Core jTable script file -->
    <script type="text/javascript" src='<c:url value="/resources/JScripts/jtable/jquery.jtable.js"/>'></script>
    <!-- ASP.NET Web Forms extension for jTable -->
    <script type="text/javascript" src='<c:url value="/resources/JScripts/jtable/extensions/jquery.jtable.aspnetpagemethods.js"/>'></script>

    <style>
        .child-opener-image
        {
            cursor: pointer;
        }
        .child-opener-image-column
        {
            text-align: center;
        }
        .jtable-dialog-form
        {
            min-width: 220px;
        }
        .jtable-dialog-form input[type="text"]
        {
            min-width: 200px;
        }
    </style>

</head>
<body>
<div id="PersonTable" style="width: 580px; margin: auto;"></div>

<script type="text/javascript">
var ctxaaa='<c:url value="/"/>';
    $(document).ready(function () {
        //Prepare jtable plugin
        $('#PersonTable').jtable({
            title: 'Persons',
            actions: {
                listAction: ctxaaa+'/admin/person/listPersons',
                createAction: ctxaaa+'/admin/person/addPerson',
                updateAction: ctxaaa+'/admin/person/updatePerson',
                deleteAction: ctxaaa+'/admin/person/deletePerson'
            },
            fields: {
                id: {
                    key: true,
                    create: false,
                    edit: false,
                    list: false
                },
                firstName: {
                    title: 'First Name',
                    width: '15%'
                },
                middleName: {
                    title: 'Middle Name',
                    width: '15%'
                },
                lastName: {
                    title: 'Last Name',
                    width: '20%'                    
                },
                dob: {
                    title: 'Date of Birth',
                    width: '15%',
                    type: 'date',
                    displayFormat: 'yy-mm-dd'
                 
                },
                nationality: {
                    title: 'Nationality',
                    width: '15%'
                },
                countryOfResidence: {
                    title: 'Country of Residence',
                    width: '15%'
                },
                companyId: {
                    title: 'Company',
                    width: '15%',
                    options: ctxaaa+'/admin/company/getCompanyOptions' 
                }
            }
        });

        //Load person list from server
        $('#PersonTable').jtable('load');
    });

</script>
</body>
</html>