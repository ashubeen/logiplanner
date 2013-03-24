<%@ include file="taglibs.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="saveUrl" value="/admin/title/addtitle" />

&nbsp;
<form:form modelAttribute="titleAttribute" method="POST" action="${saveUrl}">
	<table>
		<tr>
			<td><form:label path="titleName">Title Name:</form:label></td>
			<td><form:input path="titleName"/></td>
		</tr>
			<tr>
		<td><form:label path="highestQualification">Highest Qualification:</form:label></td>
			<td><form:input path="highestQualification"/></td>
		</tr>
	</table>
	
	<input type="submit" value="Save" />
</form:form>
