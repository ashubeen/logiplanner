<%@ include file="taglibs.jsp"%>

<c:url var="editImgUrl" value="/resources/img/edit.png" />
<c:url var="deleteImgUrl" value="/resources/img/delete.png" />
<c:url var="addUrl" value="/admin/people/add" />
<c:url var="editUrl" value="/admin/people/edit?id="/>
<c:url var="deleteUrl" value="/admin/people/delete?id="/>


<table>
<tr>
	<td>&nbsp;</td>
</tr>
<tr>
	<td><a href="${addUrl}">Create new Person Record</a></td>
</tr>
</table>
	
<c:if  test="${!empty peopleList}">
<table style="border: 1px solid; width: 100%; text-align:center">
    <thead style="background:#d3dce3">
    <tr>
        <th>Fist Name</th>
        <th>Middle Name</th>
        <th>Last Name</th>
        <th>Date of Birth</th>
        <th>Nationality</th>
        <th>Country of Residence</th>
        <th>Company</th>
        <th colspan = "2">&nbsp;</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${peopleList}" var="people">
 		<tr style="background:#f2f2f2">
          <td>${people.firstName}</td>
          <td>${people.middleName}</td>
          <td>${people.lastName}</td>
          <td>${people.dob}</td>
          <td>${people.nationality}</td>
          <td>${people.countryOfResidence}</td>
          <td>${people.companyId}</td>
          <td><a href="${editUrl}${people.personId}"><img src="${editImgUrl}"></img></a></td>
		  <td><a href="${deleteUrl}${people.personId}"><img src="${deleteImgUrl}"></img></a></td>
       
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

