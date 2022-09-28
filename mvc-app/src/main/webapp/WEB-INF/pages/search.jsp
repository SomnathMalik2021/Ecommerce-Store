<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/payment/search/byId" method="POST">
	<label>Enter Payment Id</label>
	<input type="number" name="paymentId" id="paymentId" />
	<input type="submit" value="search"/>
	</form>
	<br>
	<form action="/payment/search/byCustomerName" method="POST">
	<label>Enter Customer Name</label>
	<input type="text" name="customerName" id="customerName" />
	<input type="submit" value="search"/>
	</form>
	${payment}
	${payments}
	${plans}
</body>
</html>