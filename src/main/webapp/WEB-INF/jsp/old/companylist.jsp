<%@ include file="taglibs.jsp"%>

<c:url var="editImgUrl" value="/resources/img/edit.png" />
<c:url var="deleteImgUrl" value="/resources/img/delete.png" />
<c:url var="addImgUrl" value="/resources/img/add.png" />
<c:url var="emptyImgUrl" value="/resources/img/empty.png" />
<c:url var="addUrl" value="/admin/oldcompany/addcompany" />

<table>
<tr>
	<td>&nbsp;</td>
</tr>
<tr>
	<td><a href="${addUrl}">Create new Company</a></td>
</tr>
</table>
<table  style="border: 1px solid; width: 100%; text-align:center">

	<thead style="background:#d3dce3">
		<tr>
			<th>Id</th>
			<th nowrap>Company Namee</th>
			<th colspan="2"></th>
			<th nowrap>Address Type</th>
			<th>Address</th>
			<th nowrap>City</th>
			<th>State</th>
			<th>Country</th>
			<th>ZipCode</th>
			<th colspan="3"></th>
		</tr>
	</thead>
	<tbody >
	<c:forEach items="${companies}" var="company">
		<c:url var="editUrl" value="/admin/company/editcompany?id=${company.id}" />
		<c:url var="deleteUrl" value="/admin/company/deletecompany?id=${company.id}" />
				<c:url var="addaddrUrl" value="/admin/companyaddress/addaddress?id=${company.id}" />
		
		
			<tr style="background:#ccc">
				<td><c:out value="${company.id}" /></td>
				<td><c:out value="${company.companyName}" /></td>
				<td><a href="${editUrl}"><img src="${editImgUrl}"></img></a></td>
				<td><a href="${deleteUrl}"><img src="${deleteImgUrl}"></img></a></td>
						
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<c:if test="${!empty company.addresses}">
			<c:forEach items="${company.addresses}" var="address">
			<tr style="background:#f2f2f2">
			
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><c:out value="${address.addressType}" /></td>
				<td><c:out value="${address.address}" /></td>
				<td><c:out value="${address.city}" /></td>
				<td><c:out value="${address.state}" /></td>
				<td><c:out value="${address.country}" /></td>
				<td><c:out value="${address.zipCode}" /></td>
				
				
				<c:url var="editadrUrl" value="/admin/companyaddress/editaddress?cid=${company.id}&aid=${address.id}" />
				<c:url var="deleteCcUrl" value="/admin/companyaddress/deleteaddress?id=${address.id}" />
				<td><a href="${addaddrUrl}"><img src="${addImgUrl}"></a></td>
				<td><a href="${editadrUrl}"><img src="${editImgUrl}"></img></a></td>
				<td><a href="${deleteCcUrl}"><img src="${deleteImgUrl}"></img></a></td>
				
				</tr>
				
				</c:forEach>
		</c:if>
		<c:if test="${empty company.addresses}">
			<tr style="background:#ccc">
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				
				<td>N/A</td>
				<td>N/A</td>
				<td>N/A</td>
				<td>N/A</td>
				<td>N/A</td>
				<td>N/A</td>
				<c:url var="addLocCoordUrl" value="/admin/locationCoordinates/add?id=${location.locationId}" />
				<td><a href="${addaddrUrl}"><img src="${addImgUrl}"></a></td>
				<td><img src="${emptyImgUrl}"></img></td>
				<td><img src="${emptyImgUrl}"></img></td>
				
			</tr>
		</c:if>				
	</c:forEach>
	</tbody>
</table>
