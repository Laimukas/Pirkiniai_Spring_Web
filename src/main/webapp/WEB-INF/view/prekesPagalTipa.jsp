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
        <h2> Išlaidos pagal prekių tipą. </h2>
        </div>

        <hr>
        <div align="center">
            <table border="1" cellpadding="5">
                <tr>
                    <th>Pirkinys</th>
                    <th>Kiekis</th>
                    <th>Kaina</th>
                </tr>
            <c:forEach var="preke" items="${list}">
                <tr>
                    <td>${preke.preke}</td>
                    <td>${preke.kiekis}</td>
                    <td>${preke.kaina}</td>

                </tr>
            </c:forEach>

            </table>
        </div>
        <hr>
        <div align="center">
                <c:if test = "${suma!=null}">
                        Bendra suma: ${suma}
                </c:if>
                </div>
        <a href="<%=application.getContextPath()%>/">Pagrindinis puslapis</a>
    </body>
</html>
