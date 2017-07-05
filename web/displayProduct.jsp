<%-- 
    Document   : displayProduct
    Created on : May 22, 2016, 3:22:47 PM
    Author     : GiangTruong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Products</title>
    </head>
    <body>
        <h1>View Products</h1>
        <table cellpadding="5" border="1">

            <c:out value="${test}"/>
            <tr valign="bottom">
                <td><b>Code</b></td>
                <td><b>Description</b></td>
                <td><b>Price</b></td>
                <td><b>Update product</b></td>
                <td><b>Remove product</b></td>
            </tr>

            <p>Product is: ${productList["0"].code}</p>

            <c:forEach var="item" items="${productList}">
                <tr>
                    <td>${item.code}</td>
                    <td>${item.description}</td>
                    <td>${item.price}</td>
                    <td align="left">
                        <form action="<c:url value='updateProduct'/>" method="post">
                            <input class="button" type="submit" name="Edit" value="Edit">
                            <input type='hidden' name='productCode' value=${item.code}>
                            <input type='hidden' size ='100' name='productDesc' value=${item.description}>
                            <input type='hidden' name='productPrice' value=${item.price}>
                        </form>
                    </td>
                    <td align="left">
                        <form action="<c:url value='confirmDelete'/>" method="post">
                            <input class="button" type="submit" name="Remove" value="Remove">
                            <input type='hidden' name='productCode' value=${item.code}>
                            <input type='hidden' size ='100' name='productDesc' value=${item.description}>
                            <input type='hidden' name='productPrice' value=${item.price}>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="<c:url value='addProduct.jsp'/>" method="post">
            <input type="submit" value="Add product">
        </form>

    </body>
</html>
