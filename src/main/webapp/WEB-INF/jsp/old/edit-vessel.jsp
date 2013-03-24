<%@ include file="taglibs.jsp"%>
<c:url var="saveUrl" value="/admin/vessel/edit?id=${vesselAttribute.vesselId}" />
<form:form modelAttribute="vesselAttribute" method="POST" action="${saveUrl}">

<table>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td><form:label path="imoNum">IMO Number</form:label></td>
			<td><form:input path="imoNum" /></td>
		</tr>

		<tr>
			<td><form:label path="vesselName">Name</form:label></td>
			<td><form:input path="vesselName" /></td>
		</tr>
		
		<tr>
			<td><form:label path="ownerCompany">Owner Company</form:label></td>
			<td><form:select items="${companies}" path="ownerCompany" /></td>
		</tr>
		
	    <tr>
			<td><form:label path="type">Type</form:label></td>
	   		<td><form:input path="type" /></td>
	   	</tr>
	   <tr>
			<td> <form:label path="baseLocation">Base Location</form:label></td>
	   		<td>
	    <form:input path="baseLocation" />
	    <tr>
			<td><form:label path="specs">Specs</form:label></td>
	   		<td><form:input path="specs" />
	    <tr>
			<td><form:label path="classification">Classification</form:label></td>
	   		<td><form:input path="classification" /></td>
	   	</tr>
	    <tr>
			<td><form:label path="certifier">Certifier</form:label></td>
	   		<td><form:input path="certifier" /></td>
	   	</tr>
	    <tr>
			<td><form:label path="comments">Comments</form:label></td>
	   		<td><form:input path="comments" /></td>
	   	</tr>
	   <tr>
			<td> <form:label path="quarters">Quarters</form:label></td>
	   		<td><form:input path="quarters" /></td>
	   	</tr>
	   <tr>
			<td> <form:label path="grossTonnage">Gross Tonnage</form:label></td>
	   		<td><form:input path="grossTonnage" /></td>
	   	</tr>
	   <tr>
			<td> <form:label path="uom">Unit of Measure</form:label></td>
	   		<td><form:input path="uom" /></td>
	   	</tr>
	    <tr>
			<td><form:label path="length">Length</form:label></td>
	   		<td><form:input path="length" /></td>
	   	</tr>
	    <tr>
			<td><form:label path="beam">Beam</form:label></td>
	   		<td><form:input path="beam" /></td>
	   	</tr>
	    <tr>
			<td><form:label path="draft">Draft</form:label></td>
	   		<td><form:input path="draft" /></td>
	   	</tr>
	    <tr>
			<td><form:label path="maxWaterDepth">Max Water Depth</form:label></td>
	   		<td><form:input path="maxWaterDepth" /></td>
	   	</tr>
	    <tr>
			<td><form:label path="maxDrillingDepth">Max Drilling Depth</form:label></td>
	   		<td><form:input path="maxDrillingDepth" /></td>
	   	</tr>
	   <tr>
			<td> <form:label path="vesselFlag">Flag</form:label></td>
	   		<td><form:input path="vesselFlag" /></td>
	   	</tr>
	   <tr>
			<td><form:label path="drillingHp">Drilling HP</form:label></td>
	   		<td> <form:input path="drillingHp" /></td>
	   	</tr>
	    <tr>
			<td><form:label path="yearBuilt">Year Built</form:label></td>
	   		<td><form:input path="yearBuilt" /></td>
	   	</tr>
	    <tr>
			<td><form:label path="companyBuilt">Company Built</form:label></td>
	   		<td><form:input path="companyBuilt" /></td>
	   	</tr>
	    <tr>
			<td><form:label path="otherNames">Other Names</form:label></td>
	   		<td><form:input path="otherNames" /></td>
	   	</tr>
	</table>
	
	<input type="submit" value="Save" />
</form:form>
