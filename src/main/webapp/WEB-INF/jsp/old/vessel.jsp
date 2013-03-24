<%@ include file="taglibs.jsp"%>

<c:url var="editImgUrl" value="/resources/img/edit.png" />
<c:url var="deleteImgUrl" value="/resources/img/delete.png" />
<c:url var="addUrl" value="/admin/vessel/add" />
<c:url var="editUrl" value="/admin/vessel/edit?id="/>
<c:url var="deleteUrl" value="/admin/vessel/delete?id="/>


<table>
<tr>
	<td>&nbsp;</td>
</tr>
<tr>
	<td><a href="${addUrl}">Create new Vessel</a></td>
</tr>
</table>
	
<c:if  test="${!empty vesselList}">
<table style="border: 1px solid; width: 100%; text-align:center">
    <thead style="background:#d3dce3">
    <tr>
        <th>IMO Number</th>
        <th>Name</th>
        <th>Owner Company</th>
        <th>Type</th>
        <th>Base Location</th>
        <th>Classification</th>
        <th>Certifier</th>
        <th>Year Built</th>
        <th colspan = "2">&nbsp;</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${vesselList}" var="vessel">
 		<tr style="background:#f2f2f2">
          <td>${vessel.imoNum}</td>
          <td>${vessel.vesselName}</td>
          <td>${vessel.ownerCompany}</td>
          <td>${vessel.type}</td>
          <td>${vessel.baseLocation}</td>
          <td>${vessel.classification}</td>
          <td>${vessel.certifier}</td>
          <td>${vessel.yearBuilt}</td>
          <td><a href="${editUrl}${vessel.vesselId}"><img src="${editImgUrl}"></img></a></td>
		  <td><a href="${deleteUrl}${vessel.vesselId}"><img src="${deleteImgUrl}"></img></a></td>
       
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

