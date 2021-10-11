<%-- 
    Document   : input
    Created on : Oct 9, 2021, 2:06:21 PM
    Author     : Stefan
--%>
<%@page import="com.mycompany.lab2.Languages"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Input page</title>
    </head>
    <body>
        <form action="controller">
            <label>Key:</label>
            <input type="text" name="key" />
            <label>Value:</label>
            <input type="text" name="value" />
            <label>Language:</label>
            <select name=language>
            <%  ArrayList<Languages> languages =(ArrayList<Languages>)request.getAttribute("data");
     for (int s = 0; s < languages.size(); s++) {%>
            <OPTION><%=languages.get(s).getLanguages()%></OPTION>
                <%  }%>
        </select>
        <input type="submit" value="Submit" />
    </form>

</body>
</html>
