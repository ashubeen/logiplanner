<%@ include file="taglibs.jsp"%>

<c:url var="editImgUrl" value="/resources/img/edit.png" />
<c:url var="deleteImgUrl" value="/resources/img/delete.png" />
<c:url var="addUrl" value="/admin/contract/add" />
  <table>
	  <tr><td>&nbsp;</td></tr>
	  <tr><td><a href="${addUrl}">Create new record</a></td></tr>
  </table>
<table style="border: 1px solid; width: 100%; text-align:center">
	<thead style="background:#d3dce3">
	  
		<tr>
			<th>Name</th>
            <th>Vessel</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Country</th>
            <th>Comments</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
		</tr>
	</thead>
	<tbody style="background:#ccc">
	<c:forEach items="${contracts}" var="contract">
		<c:url var="editUrl" value="/admin/contract/edit?id=${contract.contractId}" />
		<c:url var="deleteUrl" value="/admin/contract/delete?id=${contract.contractId}" />
			<tr>
		<tr>
                <td>${contract.contractName}</td>
                <td>${contract.vesselId}</td>
                <td>${contract.startDate}</td>
                <td>${contract.endDate}</td>
                <td>${contract.country}</td>
                <td>${contract.comments}</td>
                <td><a href="${editUrl}"><img src="${editImgUrl}"></img></a></td>
				<td><a href="${deleteUrl}"><img src="${deleteImgUrl}"></img></a></td>
              
            </tr>
			
	</c:forEach>
	</tbody>
</table>

<c:if test="${empty contracts}">
	No records found. 
</c:if>

     