<%-- 
    Document   : confirmDelete
    Created on : May 22, 2016, 5:57:59 PM
    Author     : GiangTruong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm delete</title>
    </head>
    <body>
        <h1>Confirm delete product:</h1>
        <table>
            <tr>
                <td>Product code: </td>
                <td><c:out value="${Code}"/></td>
            </tr>
            <tr>
                <td>Product description: </td>
                <td><c:out value="${Description}"/></td>
            </tr>
            <tr>
                <td>Product price </td>
                <td><c:out value="${Price}"/></td>
            </tr>
        </table>
        <form action="<c:url value="/deleteProduct"/>" method="post">
            <input type='hidden' name='productCode' value=${Code}>
            <input type='hidden' size ='100' name='productDesc' value=${Description}>
            <input type='hidden' name='productPrice' value=${Price}> 
            <input type="submit" value="Delete product">
        </form>
    </body>
</html>
