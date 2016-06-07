<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>


<div>
<h2>New Person Form</h2>

<sf:form method="POST" modelAttribute="person" action="/person/add"
			enctype="multipart/form-data">
	<fieldset>
		<table cellspacing="0">
			<tr>
				<th><label for="name">Name:</label></th>
				
				<td><sf:input path="name" id="name"/></td>
				<td><sf:errors path="name"/></td>
			</tr>
			<tr>
				<th><label for="age">Age:</label></th>
				<td><sf:input path="age" id="age"/></td>
				<td><sf:errors path="age" /></td>
			</tr>
			<tr>
				<th><label for="image">Image (in JPEG format only):</label></th>
				<td><input name="image" type="file"/>
			</tr>
			<tr>
				<th><input type="Submit" value="Submit"/></th>
				<td></td>
			</tr>
		</table>
	</fieldset>
</sf:form>
		
</div>
		