<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<portlet:defineObjects />

<c:set var="n"><portlet:namespace/></c:set>
<portlet:actionURL var="actionUrl" escapeXml="false">
	<portlet:param name="action" value="processFavoriteSport"/>
</portlet:actionURL>


<h3>Spring MVC Portlet Example</h3>



<form id="favoriteSportForm" action="${actionUrl}" method="post">
    
    <p>Do you like football or baseball more?</p>
    <p><input id="favoriteSportFootball" 
               type="radio" name="favoriteSport" value="football" 
               <c:if test="${selectedFavoriteSport eq 'football'}">checked="checked" </c:if> />Football


                   
           
       <input id="favoriteSportBaseball" 
               type="radio" name="favoriteSport" value="baseball" 
               <c:if test="${selectedFavoriteSport eq 'baseball'}">checked="checked" </c:if> />Baseball
    </p>

        <p style="margin-left:180px;margin-top:30px"><input type="submit" name="update" value="Submit" /></p>

    


</form>



