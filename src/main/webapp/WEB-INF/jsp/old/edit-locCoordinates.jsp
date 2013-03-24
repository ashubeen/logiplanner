<%@ include file="taglibs.jsp"%>
<c:url var="saveUrl" value="/admin/locationCoordinates/edit?id=${locCoordinationAttribute.locCordinatesId}" />
<form:form modelAttribute="locCoordinationAttribute" method="POST" action="${saveUrl}">
	<table>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td><form:label path="locLongitute">Longitude</form:label></td>
			<td><form:input path="locLongitute"/></td>
		</tr>

		<tr>
			<td><form:label path="locLatitude">Latitude</form:label></td>
			<td><form:input path="locLatitude"/></td>
		</tr>
		
		<tr>
			<td><form:label path="locDecimalX">DecimalX</form:label></td>
			<td><form:input path="locDecimalX"/></td>
		</tr>
		
		<tr>
			<td><form:label path="locDecimalY">DecimalY</form:label></td>
			<td><form:input path="locDecimalY"/></td>
		</tr>
	</table>
	
	<input type="submit" value="Save" />
</form:form>
