<%-- 
    Document   : addProduct
    Created on : May 22, 2016, 4:50:09 PM
    Author     : GiangTruong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mma" uri="/WEB-INF/tlds/murach.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add products</title>
    </head>
    <body>
        <h1>Add product</h1>
        <div class="error"><c:out value="${messeage}"/></div>
        <p><mma:ifEmptyMark color="blue" field="" /> marks required fields</p>

        <form action="<c:url value='addProduct'/>" method="post">
            <mma:ifEmptyMark color="blue" field="Code"/>
            <input type="text" name="Code" value="Please enter a code"> <br/>
            <mma:ifEmptyMark color="blue" field=""/>
            <input type="text" name="Description" value="Please enter a desription"> <br/>
            <mma:ifEmptyMark color="blue" field=""/>
            <input type="text" name="Price" value="Please enter a price"> <br/>
            <input type="submit" value="Add Product"/>
        </form>
    </body>
</html>
