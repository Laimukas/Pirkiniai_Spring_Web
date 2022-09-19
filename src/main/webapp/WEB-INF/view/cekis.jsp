<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="<%=application.getContextPath()%>/cekis/save">
            <c:if test="${value != null}">
                <input type="hidden" name="id" value="${value.id}">
            </c:if>

            <div align="center">
                <table border="1" cellpadding="5">
                    <tr>
                        <th>Tipas</th>
                        <th>Reikšmės</th>
                    </tr>
                    <tr>
                        <th>Data:</th>
                        <th><input type="date" name="data" value="${value.data}"></th>
                    </tr>
                    <tr>
                        <th>Parduotuve:</th>
                        <th><input type="text" name="parduotuve" value="${value.parduotuve}"></th>
                    </tr>
                    <tr>
                        <th>Aprašymas:</th>
                        <th><input type="text" name="aprasymas" value="${value.aprasymas}"></th>
                    </tr>
                    <tr>
                    <th> <input type="submit" value="Save"></th>
                    <th> <a href="<%=application.getContextPath()%>/cekis">Cancel</a></th>
                    </tr>
    
                </table>
                </div>
        </form>
    </body>
</html>
