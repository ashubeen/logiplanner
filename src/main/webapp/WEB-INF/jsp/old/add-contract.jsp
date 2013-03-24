<%@ include file="taglibs.jsp"%>
<c:url var="saveUrl" value="/admin/contract/add" />

<form:form modelAttribute="contractAttribute" method="POST" action="${saveUrl}">

<table>
	<tr><td>&nbsp;</td></tr>

	<tr>
		<td><form:label path="contractName">Contract Name:</form:label></td>
		<td><form:input path="contractName"/></td>
	</tr>

	<tr>
		<td><form:label path="vesselId">Vessel :</form:label></td>
		<td><form:select items="${vessels}" path="vesselId" /></td>
	</tr>
	
	<tr>
		<td><form:label path="startDate">Start Date</form:label></td>
		<td><form:input path="startDate"  class="datepicker"/></td>			
		
	</tr>
	
	<tr>
		<td><form:label path="endDate">End Date</form:label></td>
		<td><form:input path="endDate"  class="datepicker"/></td>
	</tr>
	
	<tr>
		<td><form:label path="country">Country</form:label></td>
		<td><form:input path="country"/></td>
	</tr>
	
	<tr>
		<td><form:label path="comments">Comments</form:label></td>
		<td><form:input path="comments"/></td>
	</tr>
</table>

<input type="submit" value="Save" />
</form:form>
     