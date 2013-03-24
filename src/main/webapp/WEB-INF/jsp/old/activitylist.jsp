<%@ include file="taglibs.jsp"%>

<c:url var="editImgUrl" value="/resources/img/edit.png" />
<c:url var="deleteImgUrl" value="/resources/img/delete.png" />
<c:url var="addUrl" value="/admin/activity/add" />

<table>
<tr>
	<td>&nbsp;</td>
</tr>
<tr>
	<td><a href="${addUrl}">Create new Actvity</a></td>
</tr>
</table>
<table style="border: 1px solid; width: 50%; text-align:center">
	<thead style="background:#d3dce3">
		<tr>
			<th>Id</th>
			<th>Activity Name</th>
			<th>Parent Activity</th>
			<th colspan="2"></th>
		</tr>
	</thead>
	<tbody style="background:#ccc">
	<c:forEach items="${activities}" var="activitymain">
		<c:url var="editUrl" value="/admin/activity/editactivity?id=${activitymain.id}" />
		<c:url var="deleteUrl" value="/admin/activity/deleteactivity?id=${activitymain.id}" />
			
		
			<tr>
				<td><c:out value="${activitymain.id}" /></td>
				<td><c:out value="${activitymain.activity}" /></td>
				<td><c:out value="${activitymain.parentActivityName}" /></td>
				<td><a href="${editUrl}"><img src="${editImgUrl}"></img></a></td>
				<td><a href="${deleteUrl}"><img src="${deleteImgUrl}"></img></a></td>
			
				
<%-- 			</tr>
				<tr><td colspan="5" align="right">
				<table style="background-color: lime; " border="1">
				

				<c:if test="${!empty activitymain.activities}">
				<c:forEach items="${activitymain.activities}" var="address">
				<tr>
				<td><c:out value="${activity.id}" /></td>
				<td><c:out value="${activity.activity}" /></td>
				<td>Parent: <c:out value="${activitymain.name}" />:<c:out value="${activitymain.id}" /></td>
				<c:url var="editadrUrl" value="/admin/companyaddress/editaddress?cid=${company.id}&aid=${activitymain.id}" />
				<c:url var="deleteCcUrl" value="/admin/companyaddress/deleteaddress?id=${activitymain.id}" />
				<td><a href="${editadrUrl}"><img src="${editImgUrl}"></img></a></td>
				<td><a href="${deleteCcUrl}"><img src="${deleteImgUrl}"></img></a></td>
				</tr>
				
				</c:forEach>
		</c:if>
				</table>
				</td></tr>
 --%>
	</c:forEach>
	</tbody>
</table>
