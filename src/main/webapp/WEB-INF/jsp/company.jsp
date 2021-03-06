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
<div id="CompanyTable" style="width: 580px; margin: auto;"></div>

<script type="text/javascript">

    $(document).ready(function () {

        //Prepare jtable plugin
        $('#CompanyTable').jtable({
            title: 'Companies',
            actions: {
                listAction: '/logistics/admin/company/listCompanies',
                createAction: '/logistics/admin/company/addCompany',
                updateAction: '/logistics/admin/company/updateCompany',
                deleteAction: '/logistics/admin/company/deleteCompany'
            },
            fields: {
                id: {
                    key: true,
                    create: false,
                    edit: false,
                    list: false
                },
                //CHILD TABLE DEFINITION FOR "PHONE NUMBERS" 
                Address: { 
                    title: '', 
                    width: '1%', 
                    sorting: false, 
                    edit: false, 
                    create: false, 
                    display: function (companyData) { 
                        //Create an image that will be used to open child table 
                        var $img = $('<img src="/logistics/resources/img/add.png" title="Edit phone numbers" />'); 
                        //Open child table when user clicks the image 
                        $img.click(function () { 
                            $('#CompanyTable').jtable('openChildTable', 
                                    $img.closest('tr'), 
                                    { 
                                        title: companyData.record.companyName + ' - Company Address', 
                                        actions: { 
                                            listAction: '/logistics/admin/companyAddress/listAddress?id=' + companyData.record.id, 
                                            deleteAction: '/logistics/admin/companyAddress/deleteAddress', 
                                            updateAction: '/logistics/admin/companyAddress/updateAddress', 
                                            createAction: '/logistics/admin/companyAddress/addAddress?id=' + companyData.record.id
                                        }, 
                                        fields: {                                        
                                            id: { 
                                                key: true, 
                                                create: false, 
                                                edit: false, 
                                                list: false
                                            }, 
                                            addressType: { 
                                                title: 'Address type', 
                                                width: '30%', 
                                                options: { 'Mailing': 'Mailing', 'Head Qu': 'Head Qu', 'Office': 'Office' } 
                                            }, 
                                            city: { 
                                                title: 'City', 
                                                width: '30%'
                                            }, 
                                            state: { 
                                                title: 'State', 
                                                width: '20%', 
                                                //type: 'date', 
                                                //displayFormat: 'yy-mm-dd', 
                                                //create: false, 
                                                //edit: false
                                            },
                                            country: { 
                                                title: 'Country', 
                                                width: '20%', 
                                                //type: 'date', 
                                                //displayFormat: 'yy-mm-dd', 
                                                //create: false, 
                                                //edit: false
                                            },
                                            zipCode: { 
                                                title: 'Zip Code', 
                                                width: '20%', 
                                                //type: 'date', 
                                                //displayFormat: 'yy-mm-dd', 
                                                //create: false, 
                                                //edit: false
                                            }
                                        } 
                                    }, function (data) { //opened handler 
                                        data.childTable.jtable('load'); 
                                    }); 
                        }); 
                        //Return image to show on the person row 
                        return $img; 
                    } 
                }, 
                companyName: {
                    title: 'Company Name',
                    width: '15%'
                }
            }
        });

        //Load person list from server
        $('#CompanyTable').jtable('load');
    });

</script>
</body>
</html>