<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<portlet:defineObjects />


<h3>Spring MVC Portlet Example</h3>

<p>You have selected ${selectedFavoriteSport} as your favorite sport.</p>



<p style="margin-left:20px"><input type="button" class="btn btn-info" onclick="window.location.href='<portlet:renderURL portletMode="view"></portlet:renderURL>'" value="Home"/></p>
