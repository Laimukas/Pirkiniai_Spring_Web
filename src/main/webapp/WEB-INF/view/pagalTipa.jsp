<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Išlaidos pagal tipą</title>
    </head>
    <body>
         <form method="POST" action="<%=application.getContextPath()%>/preke/tipas">

             <div align="center">
             <h2> Tikrinam išlaidas pagal prekių tipą </h2>
                <table border="1" cellpadding="5">
                    <tr>
                       <th></th>
                       <th>Pasirinkimas</th>
                    </tr>

                    <tr>
                        <th>Tipai:</th>
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
                    <th> <input type="submit" value="Tikrinam"></th>
                    <th> <a href="<%=application.getContextPath()%>/">Cancel</a></th>
                    </tr>

                </table>
                </div>
        </form>
    </body>
</html>
