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
<div id="VesselTable" style="width: 580px; margin: auto;"></div>

<script type="text/javascript">

    $(document).ready(function () {

        //Prepare jtable plugin
        $('#VesselTable').jtable({
            title: 'Vessels',
            actions: {
                listAction: '/admin/vessel/listVessels',
                createAction: '/admin/vessel/addVessel',
                updateAction: '/admin/vessel/updateVessel',
                deleteAction: '/admin/vessel/deleteVessel'
            },
            fields: {
                id: {
                    key: true,
                    create: false,
                    edit: false,
                    list: false
                },
                imoNum: {
                    title: 'IMO Number',
                    width: '10%'
                },
                vesselName: {
                    title: 'Name',
                    width: '15%'
                },
                ownerCompany: {
                    title: 'Owner Company',
                    width: '15%',
                    options: '/admin/company/getCompanyOptions' 
                },
                type: {
                    title: 'Type',
                    width: '10%'
                },
                baseLocation: {
                    title: 'Base Location',
                    width: '15%'
                },
                specs: {
                    title: 'Specifications',
                    width: '15%'
                },
                classification: {
                    title: 'Classification',
                    width: '15%'
                },
                certifier: {
                    title: 'Certifier',
                    width: '15%'
                },
                comments: {
                    title: 'Comments',
                    width: '15%'
                },
                quarters: {
                    title: 'Quarters',
                    width: '15%'
                },
                grossTonnage: {
                    title: 'Gross Tonnage',
                    width: '15%'
                },
                uom: {
                    title: 'UOM',
                    width: '15%'
                },
                length: {
                    title: 'length',
                    width: '15%'
                },
                beam: {
                    title: 'beam',
                    width: '15%'
                },
                draft: {
                    title: 'Draft',
                    width: '15%'
                },
                maxWaterDepth: {
                    title: 'Max Water Depth',
                    width: '15%'
                },
                maxDrillingDepth: {
                    title: 'Max Drilling Depth',
                    width: '15%'
                },
                vesselFlag: {
                    title: 'Vessel Flag',
                    width: '15%'
                },
                drillingHp: {
                    title: 'Drilling HP',
                    width: '15%'
                },
                yearBuilt: {
                    title: 'Year Built',
                    width: '2%'
                },
                companyBuilt: {
                    title: 'Company Built',
                    width: '2%'
                },
                otherNames: {
                    title: 'Other Names',
                    width: '2%'
                }
            }
        });

        //Load person list from server
        $('#VesselTable').jtable('load');
    });

</script>
</body>
</html>