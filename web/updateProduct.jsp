<%-- 
    Document   : updateProduct
    Created on : May 22, 2016, 5:33:03 PM
    Author     : GiangTruong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mma" uri="/WEB-INF/tlds/murach.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update product</title>
    </head>
    <body>
        <h1>Update Product</h1>
        <p><mma:ifEmptyMark color="blue" field=""/>marks required fields</p>

        <form action="<c:url value='updateConfirmed' />" method="Post">
            <mma:ifEmptyMark color="blue" field="Code"/>
            <input type=text name="Code" value=${Code}><br />
            <mma:ifEmptyMark color="blue" field=""/>
            <input type=text  name="Description" value=${Description}><br />
            <mma:ifEmptyMark color="blue" field=""/>
            <input type=text name="Price" value=${Price}><br />
            <input type="submit" value="Update Product">
        </form>
    </body>
</html>
