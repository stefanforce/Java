<%-- 
    Document   : result
    Created on : Oct 9, 2021, 2:09:23 PM
    Author     : Stefan
--%>
<%@page import="com.mycompany.lab2.Entry"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result page</title>
    </head>
    <body>
        <h1>The entry  ${entry.key} in the language <c:if test="${not empty entry.language}">${entry.language}</c:if>
            <c:if test="${empty entry.language}">${language}</c:if>has the definition ${entry.value} </h1>
        

    </body>
</html>
