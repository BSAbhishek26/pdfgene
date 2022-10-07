<%-- 
    Document   : Download
    Created on : 6 Oct 2022, 23:25:21
    Author     : abhi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>PDF</title>
        <link rel="icon" href="images/favicon.png" type="image/png" />
    </head>
    <body>
        <center>
        <form action="Download" method="POST">
            <input type="hidden"name="filename" value="<%=request.getAttribute("filename")%>">
            <input type="hidden"name="filepath" value="<%=request.getAttribute("filepath")%>">
            <h1>Pdf created successfully</h1>
            <button>Download</button>
        </form>
        <button><a href="/" style='text-decoration: none;color:Black;'>Back</a></button>
        </center>
    </body>
</html>
