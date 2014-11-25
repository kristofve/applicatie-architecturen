<%-- 
    Document   : TeVervangen
    Created on : 25-nov-2014, 8:41:37
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>test pagina</title>
    </head>
    <body>
        <h1>Test pagina</h1>
        <form method = "post" action=<%= response.encodeURL("Controller")%>>
            <input type="submit" value="Onkosten">
            <input type="hidden" name="state" value="Onkosten">
        </form>
        <form method = "post" action=<%= response.encodeURL("Controller")%>>
            <input type="hidden" name="state" value="Keuren">
            <input type="submit" value="Keuren">
        </form>
        <form method = "post" action=<%= response.encodeURL("Controller")%>>
            <input type="hidden" name="state" value="Kredieten">
            <input type="submit" value="Kredieten">
        </form>
    </body>
</html>
