<%-- 
    Document   : userForm
    Created on : Jun 18, 2020, 8:45:19 PM
    Author     : glamb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="springform" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Form</title>
        <style>
            .error{
                color: red;
                
            }
        </style>
    </head>
    <body>
        <h1>Hello there!</h1><hr>
        <springform:form action="doInsertUser" method="post" modelAttribute="formUser">
            Name: <springform:input  path="name" cssErrorClass=""/> 
            <springform:errors path="name" cssClass="error"/>
            <br>
            Email: <springform:input path="email"/> 
            <springform:errors path="email" cssClass="error"/>
            <br>
            <input type="submit" value="Submit"/>
            <input type="reset" value="Reset"/>
        </springform:form>
    </body>
</html>
