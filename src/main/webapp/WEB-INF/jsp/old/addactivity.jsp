<%@ include file="taglibs.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="saveUrl" value="/admin/activity/add" />

&nbsp;
<form:form modelAttribute="activityAttribute" method="POST" action="${saveUrl}">
	<table>
		<tr>
			<td><form:label path="activity">Activity Name:</form:label></td>
			<td><form:input path="activity"/></td>
		</tr>
		<tr>
			<td><form:label path="level">Level:</form:label></td>
			<td><form:select items="${levels}" path="level"  />
				</td>
		</tr>		
		<tr>
		<td><form:label path="parentId">Parent:</form:label></td>
		       <c:if test="${activityAttribute.level=='1'}" var="tempvar">  
                  
              <td><form:select disabled="${tempvar}" items="${parentActivities}" path="parentId" /></td>
            </c:if>
              
		
			
			
			
		</tr>


	</table>
	
	<input type="submit" value="Save" />
</form:form>
