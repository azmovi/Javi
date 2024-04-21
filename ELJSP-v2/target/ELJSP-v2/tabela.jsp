<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tabela</title>
    <style>
        table, th, td {
            border: 1px solid;
            text-align: center;
        }
    </style>
</head>
<body>

    <p>Valor Mínimo: <%= request.getParameter("minimo") %></p>

</body>
</html>

