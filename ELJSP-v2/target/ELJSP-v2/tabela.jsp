<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
    <head>
        <title>Tabela</title>
        <style>
        table, th, td {
            border: 1px solid;
            text-align: center;
        }
        </style>
    </head>
    <body>

        <jsp:useBean id="convert" class="br.ufscar.dc.dsw.beans.Convert" />

        <c:choose> 
            <c:when test="${empty param.minimo}">
                <c:set var="minimo" value="-100"/>
            </c:when>
                <c:otherwise>
                    <c:set var="minimo" value="${param.minimo}"/>
                </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${empty param.maximo}">
                <c:set var="maximo" value="-100"/>
            </c:when>
                <c:otherwise>
                    <c:set var="maximo" value="${param.maximo}"/>
                </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${empty param.incremento}">
                <c:set var="incremento" value="-100"/>
            </c:when>
                <c:otherwise>
                    <c:set var="incremento" value="${param.incremento}"/>
                </c:otherwise>
        </c:choose>

        <jsp:setProperty name="convert" property="min" value="${minimo}"/>
        <jsp:setProperty name="convert" property="max" value="${maximo}"/>
        <jsp:setProperty name="convert" property="inc" value="${incremento}"/>

       <table>
            <tr>
                <th>Celsius</th>
                <th>Fahrenheit</th>
                <th>Kelvin</th>
            </tr>
            <c:forEach var="i" begin="0" end="${fn:length(convert.fahr)-1}">
                <tr>
                    <td>${convert.celsius[i]}</td>
                    <td>${convert.fahr[i]}</td>
                    <td>${convert.kelvin[i]}</td>
                </tr>
            </c:forEach>
       </table>

</body>
</html>

