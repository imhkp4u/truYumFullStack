<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles/style.css">
<script src="js/script.js"></script>
<title>edit Menu Item</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img
			src="https://image.shutterstock.com/image-vector/knife-fork-vector-icon-flat-260nw-764792872.jpg">
		<a href="ShowCart">Cart</a> <a href="ShowMenuItemListCustomer">Menu</a>
	</div>
	<div class="cart">
		<h1>Cart</h1>
		<div>
			No Item in Cart. use 'Add to Cart' option in<a
				href="ShowMenuItemListCustomer">"Menu item list"</a>
		</div>
	</div>
	<div class="footer">
		<p>Copyright &copy; 2019</p>
	</div>
</body>
</html>