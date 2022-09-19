<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prekė</title>
    </head>
    <body>
        <form method="POST" action="<%=application.getContextPath()%>/preke/save">
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
                    <th>Cekis id:</th>
                    <td><input type="text" name="cekis_id" value="${value.cekis.id}"></td>
                </tr>
                <tr>
                    <th>Preke:</th>
                    <td><input type="text" name="preke" value="${value.preke}"></td>
                </tr>
                <tr>
                    <th>Kiekis:</th>
                    <td><input type="text" name="kiekis" value="${value.kiekis}"></td>
                </tr>
                <tr>
                    <th>Kaina:</th>
                    <td><input type="text" name="kaina" value="${value.kaina}"></td>
                </tr>
                <tr>
                    <th>Tipas id:</th>
                    <td>
                    <select name="tipas_id">
                        <c:forEach var="tipas" items="${tipai}">
                        <option value="${tipas.id}" <c:if test="${tipas.id==value.tipas.id}">selected</c:if>>
                        ${tipas.pavadinimas}
                        </option>
                        </c:forEach>
                    </select>
                    </td>
                </tr> 
                <tr>
                <td> <input type="submit" value="Save"></td>
                <td> <a href="<%=application.getContextPath()%>/cekis">Cancel</a></td>
                </tr>

            </table>
            </div>
        </form>
    </body>
</html>