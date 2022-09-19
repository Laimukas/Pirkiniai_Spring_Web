<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tipu sarasas</title>
    </head>
    <body>
        <div align="center">
            <h1>Tipų sąrašas</h1>
            </div>
    <a href="<%=application.getContextPath()%>/tipas/edit">Naujas tipas</a>
    <hr>

    <div align="center">
        <table border="1" cellpadding="5">

        <tr>
            <th>Objektai</th>
            <th>Funkcijos</th>
        </tr>    

        
        <c:forEach var="tipas" items="${list}">
                    <tr>
                        <td>${tipas.pavadinimas}</td>
                        <td>
                        <a href="<%=application.getContextPath()%>/tipas/edit?id=${tipas.id}">Edit</a>
                        <a href="<%=application.getContextPath()%>/tipas/delete?id=${tipas.id}">Delete</a>
                        </td>
                    </tr>
        </c:forEach>

        </table>
    </div>
    <hr>
    <a href="<%=application.getContextPath()%>/">Pagrindinis puslapis</a>
    </body>
</html>