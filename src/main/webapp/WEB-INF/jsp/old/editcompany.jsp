<%@ include file="taglibs.jsp"%>
<c:url var="saveUrl" value="/admin/company/editcompany?id=${companyAttribute.id}" />
<form:form modelAttribute="companyAttribute" method="POST" action="${saveUrl}">
	<table>
	<tr><td>&nbsp;</td></tr>
		<tr>
			<td><form:label path="id">Id:</form:label></td>
			<td><form:input path="id" disabled="true"/></td>
		</tr>
	
		<tr>
			<td><form:label path="companyName">Company Name:</form:label></td>
			<td><form:input path="companyName"/></td>
		</tr>
	</table>
	
	<input type="submit" value="Save" />
</form:form>
