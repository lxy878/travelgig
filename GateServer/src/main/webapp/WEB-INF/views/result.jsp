<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Result</title>
    </head>
    <body>
        <h3 style='color: red;'>${error}</h3>
        <%-- <div th:unless='${error}'>
            <h3 style='color: green;'>Success!</h3>
            <div>Id.: <span th:text='${id}' /></div>
            <div>Status: <span th:text='${status}' /></div>
            <div>Charge id.: <span th:text='${chargeId}' /></div>
            <div>Balance transaction id.: <span th:text='${balance_transaction}' /></div>
        </div> --%>
        <a href='/checkout'>Checkout again</a>
    </body>
</html>