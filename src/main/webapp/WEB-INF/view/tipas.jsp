<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tipas</title>
    </head>
    <body>

        <form method="POST" action="<%=application.getContextPath()%>/tipas/save">
            <c:if test="${value != null}">
                <input type="hidden" name="id" value="${value.id}">
            </c:if>
            <div align="center">
                <table border="1" cellpadding="5">
                    <caption><h2>Tipas</h2></caption>
                    <tr>
                        <th>Tipas</th>
                        <th>Reikšmės</th>
                    </tr>
                    <tr>
                            <td>Pavadinimas:</td>
                            <td><input type="text" name="pavadinimas" value="${value.pavadinimas}"></td>                            
                    </tr>
                    <tr>
                        <td><input type="submit" value="Save"></td>
                        <td><a href="<%=application.getContextPath()%>/tipas">Cancel</a></td>
                    </tr>
                </table>
            </div>
        </form>

    </body>
</html>