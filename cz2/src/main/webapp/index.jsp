<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tytuł strony</title>
</head>
    <body>
        <h1>
            <%= "Można sprawdzić działanie serwera w: " %>
        </h1>
        <ul style="font-size: 20px">
            <li>
                <a href="http://localhost:8080/JavaSoap/HelloWorldImplService">Lista metod</a>
            </li>
            <li>
                <a href="http://localhost:8080/JavaSoap/HelloWorldImplService?WSDL">WSDL</a>
            </li>
            <li>
                <a href="http://localhost:8080/JavaSoap/HelloWorldImplService?Tester">Tester Glassfisha</a>
            </li>
        </ul>
        <br/>
        <a href="simple-servlet">Odnosnik do Servletu</a>
    </body>
</html>