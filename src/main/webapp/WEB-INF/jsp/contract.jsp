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
<div id="ContractTable" style="width: 580px; margin: auto;"></div>

<script type="text/javascript">

    $(document).ready(function () {

        //Prepare jtable plugin
        $('#ContractTable').jtable({
            title: 'Contracts',
            actions: {
                listAction: '/logistics/admin/contract/listContracts',
                createAction: '/logistics/admin/contract/addContract',
                updateAction: '/logistics/admin/contract/updateContract',
                deleteAction: '/logistics/admin/contract/deleteContract'
            },
            fields: {
                id: {
                    key: true,
                    create: false,
                    edit: false,
                    list: false
                },
                contractName: {
                    title: 'Name',
                    width: '15%'
                },
                vesselId: {
                    title: 'Vessel',
                    width: '15%',
                    options: '/logistics/admin/vessel/getVesselOptions' 
                },
                startDate: {
                    title: 'Start Date',
                    width: '20%',
                    type: 'date',
                    displayFormat: 'yy-mm-dd'
                    
                },
                endDate: {
                    title: 'End Date',
                    width: '15%',
                    type: 'date',
                    displayFormat: 'yy-mm-dd'
                 
                },
                country: {
                    title: 'Country',
                    width: '15%'
                },
                comments: {
                    title: 'Comments',
                    width: '15%'
                }                
            }
        });

        //Load person list from server
        $('#ContractTable').jtable('load');
    });

</script>
</body>
</html>