<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    <%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  

<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title> User Details</title>  
</head>  
<body> 
<portlet:renderURL var="register">
	<portlet:param name="myaction" value="register"></portlet:param>
</portlet:renderURL>
<center>  
  
<div style="color: teal;font-size: 30px"> User Details</div>   
<c:if test="${!empty user}">  
<table border="1" bgcolor="black" width="600px">  
<tr style="background-color: teal;color: white;text-align: center;" height="40px">  
<td>User Id</td>  
<td>First Name</td>  
<td>Last Name</td>  
<td>Gender</td>  
<td>City</td>
<td>Edit</td>
<td>Delete</td>
<!-- <th colspan="2">operations</th>  -->
</tr>  
<c:forEach items="${user}" var="user1">
<portlet:renderURL var="editUserURL">
			<portlet:param name="action" value="editUserInfo" />
			<portlet:param name="userId" value="${user1.id}" />
		</portlet:renderURL>
		<portlet:actionURL var="deleteUserURL">
			<portlet:param name="action" value="deleteUserInfo" />
			<portlet:param name="userId" value="${user1.id}" />
		</portlet:actionURL>

<tr style="background-color:white;color: black;text-align: center;" height="30px" >  
<td><c:out value="${user1.id}"/></td>  
<td><c:out value="${user1.firstName}"/></td>  
<td><c:out value="${user1.lastName}"/></td>  
<td><c:out value="${user1.gender}"/></td>  
<td><c:out value="${user1.city}"/></td> 
<td><a href="${editUserURL}"> <input type="button"
					value="Edit" onclick="editUser(${user1.id})" /></a></td>
<td><form id="user" name="user" method="post" action="${deleteUserURL}" htmlEscape="false">
<input type="submit" value="Remove" /></form></td> 
</tr>  
</c:forEach>  
</table>  
</c:if>   
  
<a href="${register}" >Click Here to add new User</a>  
</center>  
</body>  
</html>  
