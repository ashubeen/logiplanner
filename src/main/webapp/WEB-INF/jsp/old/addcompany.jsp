<%@ include file="taglibs.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="saveUrl" value="/admin/oldcompany/addcompany" />

&nbsp;
<form:form modelAttribute="companyAttribute" method="POST" action="${saveUrl}">
	<table>
		<tr>
			<td><form:label path="companyName">Company Name:</form:label></td>
			<td><form:input path="companyName"/></td>
		</tr>
	</table>
	
	<input type="submit" value="Save" />
</form:form>
