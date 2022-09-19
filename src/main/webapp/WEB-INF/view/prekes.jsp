<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prekės</title>
    </head>
    <body>
        <div align="center">
        <h1> ${cekis.data} Čekio iš ${cekis.parduotuve} prekės</h1>
        </div>
        <a href="<%=application.getContextPath()%>/preke/edit?cekisId=${cekis.id}">Nauja prekė</a>
        <hr>
        <div align="center">
            <table border="1" cellpadding="5">

                <tr>
                    <th>Objektai</th>
                    <th>Funkcijos</th>
                </tr>  
        
                    <c:forEach var="preke" items="${cekis.prekes}">
                        <tr>
                            <td>${preke.preke}</td>
                            <td>
                            <a href="<%=application.getContextPath()%>/preke/edit?id=${preke.id}&cekisId=${cekis.id}">Edit</a>
                            <a href="<%=application.getContextPath()%>/preke/delete?id=${preke.id}&cekisId=${cekis.id}">Delete</a>  
                            </td>                             
                        </tr>
                    </c:forEach>

            </table>
        </div>
        <hr>        
        <a href="<%=application.getContextPath()%>/cekis">Čekių sąrašas</a>
    </body>
</html>
