<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<html>
<head>
    <title>Conversor Servlet</title>
    <style>
        form { width: 30%; }
    </style>
</head>
<body>
    <fmt:bundle basename="messages">
        <form name="conversor_forms" action="tabela.jsp" method="post">
            <fieldset>
                <legend><fmt:message key="titulo" /></legend>

                <label for="valor_minimo"><fmt:message key="minimo" /></label> <br>
                <input type="number" id="valor_minimo" name="valor_minimo" min="-459"/><br>

                <br>

                <label for="valor_maximo"><fmt:message key="maximo" /></label> <br>
                <input type="number" id="valor_maximo" name="valor_maximo"/> <br>

                <br>

                <label for="valor_incremento"><fmt:message key="incremento" /></label> <br>
                <input type="number" id="valor_incremento" name="valor_incremento"/> <br>

                <br>
                <button type="button" onclick="valoresDefault()"><fmt:message key="padrao" /></button>
                <input type="submit" value="<fmt:message key="conversao" />">
            </fieldset>
        </form>
    </fmt:bundle>
    <script>
        function valoresDefault() {
            document.getElementById("valor_minimo").value = -100;
            document.getElementById("valor_maximo").value = 100;
            document.getElementById("valor_incremento").value = 5;
        }
    </script>
</body>
</html>
