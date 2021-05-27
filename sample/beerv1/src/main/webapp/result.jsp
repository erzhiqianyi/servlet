<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Beer Recommendations Jsp</title>
</head>
<body>

<div style="text-align: center;">
    <h1>Beer Recommendations Jsp</h1>
    <p>
        <%
            List<String> styles = (List<String>) request.getAttribute("styles");
            if (null != styles){
                for (String style : styles){
                    out.print("<br>try: " + style);
                }
            }
        %>
    </p>
</div>
</body>
</html>
