<%@ include file="taglibs.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="saveUrl" value="/admin/people/add" />

&nbsp;
<form:form modelAttribute="personAttribute" method="POST" action="${saveUrl}">
	<table>
		<tr>
			<td><form:label path="firstName">First Name:</form:label></td>
			<td><form:input path="firstName"/></td>
		</tr>
		<tr>
			<td><form:label path="middleName">Middle Name:</form:label></td>
			<td><form:input path="middleName"/></td>
		</tr>
		<tr>
			<td><form:label path="lastName">Last Name:</form:label></td>
			<td><form:input path="lastName"/></td>
		</tr>
		<tr>
			<td><form:label path="dob">Date of Birth</form:label></td>
			<td><form:input path="dob" class="datepicker"/></td>
		</tr>
		<tr>
			<td><form:label path="nationality">Nationality:</form:label></td>
			<td><form:input path="nationality"/></td>
		</tr>
		<tr>
			<td><form:label path="countryOfResidence">Country of Residence:</form:label></td>
			<td><form:input path="countryOfResidence"/></td>
		</tr>		
		<tr>
			<td><form:label path="companyId">Company:</form:label></td>
			<td><form:select items="${companies}" path="companyId"  /></td>
		</tr>		
		


	</table>
	
	<input type="submit" value="Save" />
</form:form>
