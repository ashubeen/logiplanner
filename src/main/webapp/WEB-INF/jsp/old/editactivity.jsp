<%@ include file="taglibs.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="saveUrl" value="/admin/activity/editactivity?id=${activityAttribute.id}" />
<form:form modelAttribute="activityAttribute" method="POST" action="${saveUrl}">
	<table>
	<tr><td>&nbsp;</td></tr>
		<tr>
			<td><form:label path="activity">Activity Name:</form:label></td>
			<td><form:input path="activity"/></td>
		</tr>
		<tr>
			<td><form:label path="level">Level:</form:label></td>
			<td><form:select path="level"><form:option value="1" label="Level1" /><form:option value="2" label="Level2" />
				</form:select></td>
		</tr>
		<tr>
			<td><form:label path="parentId">Parent:</form:label></td>
			<td><form:select items="${parentActivities}" path="parentId" /></td>
		</tr>


	</table>
	
	<input type="submit" value="Save" />
</form:form>
