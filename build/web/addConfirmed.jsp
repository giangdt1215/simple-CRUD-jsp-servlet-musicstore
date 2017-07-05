<%-- 
    Document   : addConfirmed
    Created on : May 22, 2016, 5:24:46 PM
    Author     : GiangTruong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmed Add Product</title>
    </head>
    <body>
        <h1>Confirm add product</h1>

        <table>
            <tr>
                <td>Product code:</td>
                <td><c:out value='${Code}'/></td>
            </tr>
            <tr>
                <td>Product description:</td>
                <td><c:out value='${Description}'/></td>
            </tr>
            <tr>
                <td>Product price:</td>
                <td><c:out value='${Price}'/></td>
            </tr>
        </table>

        <form action="<c:url value='displayProduct'/>" method="post">
            <input type="submit" value="View Product">
        </form>
    </body>
</html>
