
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%--     <%response.sendRedirect("register.html"); %> --%>


Welcome
<portlet:defineObjects />
 <portlet:renderURL var="userlist">
	<portlet:param name="myaction" value="userList"></portlet:param>
</portlet:renderURL>
 
<%-- <a href="${userlist}">Click Here to see User List</a>
<br/> --%>
<%-- <portlet:renderURL var="userlist">
	<portlet:param name="myaction" value="register"></portlet:param>
</portlet:renderURL> --%>

<a href="${userlist}">User Details</a>
