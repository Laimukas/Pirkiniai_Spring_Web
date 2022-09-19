<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Čekių sąrašas</title>
    </head>
    <body>
        <div align="center">
        <h1>Visų čekių sąrašas</h1>
        </div>
        <a href="<%=application.getContextPath()%>/cekis/edit">Naujas cekis</a>
        <hr>

        <div align="center">
        <table border="1" cellpadding="5">

        <tr>
            <th>Objektai</th>
            <th>Funkcijos</th>
        </tr>     
        
        <c:forEach var="cekis" items="${list}">
            <tr>
                <td><h3>${cekis.parduotuve} </h3> ${cekis.data}  </td>
                <td>
                <a href="<%=application.getContextPath()%>/cekis/edit?id=${cekis.id}">Edit</a>
                <a href="<%=application.getContextPath()%>/cekis/delete?id=${cekis.id}">Delete</a>
                <a href="<%=application.getContextPath()%>/preke?cekisId=${cekis.id}">Čekio prekės</a>   
                </td>
            </tr>
            <tr>
                <ul>
                    <c:forEach var="preke" items="${cekis.prekes}">
                        <tr>
                         <td>${preke.preke}, kiekis: ${preke.kiekis}, kaina: ${preke.kaina}, tipas: ${preke.tipas.pavadinimas}</td>
                        </tr>
                    </c:forEach>
                </ul>
            </tr>
        </c:forEach>
         </table>
        </div>
        <div align="center">
        <c:if test = "${suma!=null}">
                Bendra suma: ${suma}
        </c:if>
        </div>
        <hr>
        <a href="<%=application.getContextPath()%>/">Pagrindinis puslapis</a>
    </body>
</html>
