<%@ include file="taglibs.jsp"%>

<c:url var="editImgUrl" value="/resources/img/edit.png" />
<c:url var="deleteImgUrl" value="/resources/img/delete.png" />
<c:url var="emptyImgUrl" value="/resources/img/empty.png" />
<c:url var="addImgUrl" value="/resources/img/add.png" />
<c:url var="addUrl" value="/admin/location/add" />
  <table>
	  <tr><td>&nbsp;</td></tr>
	  <tr><td><a href="${addUrl}">Create new record</a></td></tr>
  </table>
<table style="border: 1px solid; width: 100%; text-align:center">
	<thead style="background:#d3dce3">
	  
		<tr>
			<th>Name</th>
			<th>Type</th>
			<th>Country</th>			
			<th colspan="2"></th>
			<th>Longitude</th>
			<th>Latitude</th>
			<th>DecimalX</th>
			<th>DecimalY</th>
			<th colspan="3">
			</th>
		</tr>
	</thead>
	<tbody style="background:#ccc">
	<c:forEach items="${locations}" var="location">
		<c:url var="editUrl" value="/admin/location/edit?id=${location.locationId}" />
		<c:url var="deleteUrl" value="/admin/location/delete?id=${location.locationId}" />
			<tr>
		
			<td><c:out value="${location.locName}" /></td>
			<td><c:out value="${location.locType}" /></td>
			<td><c:out value="${location.locCountry}" /></td>
			<td><a href="${editUrl}"><img src="${editImgUrl}"></img></a></td>
			<td><a href="${deleteUrl}"><img src="${deleteImgUrl}"></img></a></td>
			
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
		</tr>
		<c:if test="${!empty location.locCoordintes}">
			<c:forEach items="${location.locCoordintes}" var="locCoordinates">
			<tr >
			
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				
				<td><c:out value="${locCoordinates.locLongitute}" /></td>
				<td><c:out value="${locCoordinates.locLatitude}" /></td>
				<td><c:out value="${locCoordinates.locDecimalX}" /></td>
				<td><c:out value="${locCoordinates.locDecimalY}" /></td>
				<c:url var="addLocCoordUrl" value="/admin/locationCoordinates/add?id=${location.locationId}" />
				<c:url var="editLocCoordUrl" value="/admin/locationCoordinates/edit?id=${locCoordinates.locCordinatesId}" />
				<c:url var="deleteLocCoordUrl" value="/admin/locationCoordinates/delete?id=${locCoordinates.locCordinatesId}" />
				<td><a href="${addLocCoordUrl}">+</a></td>
				<td><a href="${editLocCoordUrl}"><img src="${editImgUrl}"></img></a></td>
				<td><a href="${deleteLocCoordUrl}"><img src="${deleteImgUrl}"></img></a></td>
			</tr>
			</c:forEach>
		</c:if>
		
		<c:if test="${empty location.locCoordintes}">
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				
				<td>N/A</td>
				<td>N/A</td>
				<td>N/A</td>
				<td>N/A</td>
				<c:url var="addLocCoordUrl" value="/admin/locationCoordinates/add?id=${location.locationId}" />
				<td><a href="${addLocCoordUrl}"><img src="${addImgUrl}"></a></td>
				<td><img src="${emptyImgUrl}"></img></td>
				<td><img src="${emptyImgUrl}"></img></td>
				
			</tr>
		</c:if>
		
	</c:forEach>
	</tbody>
</table>

<c:if test="${empty locations}">
	No records found. 
</c:if>


