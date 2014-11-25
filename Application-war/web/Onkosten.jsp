<%-- 
    Document   : Onkosten
    Created on : 25-nov-2014, 8:02:47
    Author     : student
--%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Onkosten</title>
    </head>
    <body>
        <h1>Onkosten 
            <%--<c:out value="${requestScope.id}"/>--%>
        </h1>
        
        <c:forEach var="Onkost" items="${requestScope.onkosten}">       
            <fieldset>
                <legend>Personalia:</legend>
                Name: <input type="text"><br>
                Email: <input type="text"><br>
                Date of birth: <input type="text">
            </fieldset>
        </c:forEach> 
         <form method = "post" action=<%= response.encodeURL("Controller")%>>
            <input type="hidden" name="state" value="TeVervangen">
            <input type="submit" value="TeVervangen">
        </form>
         <form method = "post" action=<%= response.encodeURL("Controller")%>>
            <input type="hidden" name="state" value="Aanpassen">
            <input type="submit" value="Aanpassen">
        </form>
    </body>
</html>
