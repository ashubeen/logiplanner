<%@ include file="taglibs.jsp"%>
<c:url var="saveUrl" value="/admin/location/edit?id=${locationAttribute.locationId}" />
<form:form modelAttribute="locationAttribute" method="POST" action="${saveUrl}">
	<table>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td><form:label path="locName">Location Name:</form:label></td>
			<td><form:input path="locName"/></td>
		</tr>

		<tr>
			<td><form:label path="locType">Type</form:label></td>
			<td><form:input path="locType"/></td>
		</tr>
		
		<tr>
			<td><form:label path="locCountry">Country</form:label></td>
			<td><form:input path="locCountry"/></td>
		</tr>
	</table>
	
	<input type="submit" value="Save" />
</form:form>
