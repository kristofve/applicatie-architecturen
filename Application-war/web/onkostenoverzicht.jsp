<%-- 
    Document   : overzicht
    Created on : 25-nov-2014, 8:36:14
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Onkosten</title>
    </head>
    <body>
        <h1>Overzicht van de onkosten</h1>
        
        <table class="overzicht">
            <tr>
                <th>Onkost-ID</th>
                <th>Invoerdatum</th>
                <th>Bedrag (EUR)</th>
                <th>Status</th>
            </tr>
            <tr>
                <td>1234</td>
                <td>30/12/1991</td>
                <td>322</td>
                <td>In aanmaak</td>
            </tr>
        </table>
        
        <input type="button" value="Create new expense" name="onkosten">
        <input type="button" value="Log-out" name ="logout">
        
    </body>
</html>
