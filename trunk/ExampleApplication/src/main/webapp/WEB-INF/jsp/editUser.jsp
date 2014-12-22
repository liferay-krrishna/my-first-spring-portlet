<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    <%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  

<portlet:actionURL var="userUpdateFormURL">
	<portlet:param name="action" value="userUpdateAction" />
</portlet:actionURL>
<form:form id="registerForm" modelAttribute="user" method="post"
			action="${userUpdateFormURL}">
			<table width="400px" height="150px">
			<tr>
					<td><form:label path="id">User Id</form:label>
					</td>
					<td><form:input path="id" />
					</td>
				</tr>
				<tr>
					<td><form:label path="firstName">First Name</form:label>
					</td>
					<td><form:input path="firstName" />
					</td>
				</tr>
				<tr>
					<td><form:label path="lastName">Last Name</form:label>
					</td>
					<td><form:input path="lastName" />
					</td>
				</tr>
				<tr>
					<td><form:label path="gender">Gender</form:label>
					</td>
					<td><form:input path="gender" />
					</td>
				</tr>
				<tr>
					<td><form:label path="city">City</form:label>
					</td>
					<td><form:input path="city" />
					</td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="Save" /></td>
				</tr>
			</table>
		</form:form>
