<%@ include file="taglibs.jsp"%>

<form:form method="post" action="locationCoordinates/add" commandName="locationCoordinates" class="form-vertical">

<form:label path="locLongitute">Longitude</form:label>
    <form:input path="locLongitute" />
    <form:label path="locLatitude">Latitude</form:label>
    <form:input path="locLatitude" />
    <form:label path="locDecimalX">DecimalX</form:label>
    <form:input path="locDecimalX" />
    <form:label path="locDecimalY">DecimalY</form:label>
    <form:input path="locDecimalY" />
    <input type="submit" value="Add Location" class="btn"/>
</form:form>


<c:if  test="${!empty locationCoordinatesList}">
    <h3>Location</h3>
    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>Longitude</th>
            <th>Latitude</th>
            <th>DecimalX</th>
            <th>DecimalY</th>
            <th>&nbsp;</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${locationCoordinatesList}" var="locCoord">
            <tr>
                <td>${locCoord.locLongitute}</td>
                <td>${locCoord.locLatitude}</td>
                <td>${locCoord.locDecimalX}</td>
                <td>${locCoord.locDecimalY}</td>
                <td><form action="location/delete/${locCoord.locCordinatesId}" method="post"><input type="submit" class="btn btn-danger btn-mini" value="Delete"/></form></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
      