<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Edit Existing CompanyAddress </h1>

<c:url var="saveUrl" value="/admin/companyaddress/editaddress?id=${companyAddressAttribute.id}" />
<form:form modelAttribute="companyAddressAttribute" method="POST" action="${saveUrl}">
	<table>
	
		<tr>
			<td>Company Id:</td>
			<td><input type="text" value="${companyId}" disabled="true"/>
		</tr>
		
		<tr>
			<td><form:label path="addressType">Address Type:</form:label></td>
			<td><form:input path="addressType"/></td>
		</tr>
		
		<tr>
			<td><form:label path="address">Address:</form:label></td>
			<td><form:input path="address"/></td>
		</tr>

		<tr>
			<td><form:label path="city">City:</form:label></td>
			<td><form:input path="city"/></td>
		</tr>
		<tr>
			<td><form:label path="state">State:</form:label></td>
			<td><form:input path="state"/></td>
		</tr>
		<tr>
			<td><form:label path="country">Country:</form:label></td>
			<td><form:input path="country"/></td>
		</tr>
		<tr>
			<td><form:label path="zipCode">Zip COde:</form:label></td>
			<td><form:input path="zipCode"/></td>
		</tr>
	</table>
	
	<input type="submit" value="Save" />
</form:form>

</body>
</html>