<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Išlaidos pagal laiką</title>
    </head>
    <body>
        <form method="POST" action="<%=application.getContextPath()%>/cekis/laikas">
             <div align="center">
             <h2> Tikrinam išlaidas pagal laiko rėžius </h2>
                <table border="1" cellpadding="5">
                    <tr>
                        <th>Tipas</th>
                        <th>Reikšmės</th>
                    </tr>
                    <tr>
                        <th>Data nuo:</th>
                        <th><input type="date" name="dataNuo" value="${value.dataNuo}"></th>
                    </tr>
                    <tr>
                        <th>Data iki:</th>
                        <th><input type="date" name="dataIki" value="${value.dataIki}"></th>
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
