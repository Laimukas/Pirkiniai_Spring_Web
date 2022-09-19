<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pirkiniu apskaita</title>
    </head>
    <body>
        <div align="center">
        <h1>Pirkinių apskaita</h1>
        <hr>
        <a href="<%=application.getContextPath()%>/cekis">Čekių sąrašas</a><br>
        <br>
        <a href="<%=application.getContextPath()%>/tipas">Tipų sąrašas</a>
        <hr>
        <br>
        <a href="<%=application.getContextPath()%>/preke/pagalTipa">Išlaidos pagal tipą</a><br>
        <br>
        <hr>
        <a href="<%=application.getContextPath()%>/cekis/pagalLaika">Išlaidos už nurodytą laiko tarpą</a>
        </div>
    </body>
</html>
