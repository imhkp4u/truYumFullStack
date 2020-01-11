<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Menu Item</title>
<link rel="stylesheet" href="styles/style.css">
<script src="js/script.js"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images/truyum-logo-light.png"> <a
			href="ShowMenuItemListCustomer">Menu</a> <a href="ShowCart">Cart</a>
	</div>
	<h1>Menu Items</h1>
	<c:if test="${addCartStatus }">
		<h3>Item Added to Cart Successfully</h3>
	</c:if>
	<table class="table">
		<tr>
			<th>Name</th>
			<th>Free Delivery</th>
			<th>Price</th>
			<th>Category</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${menuItemList}" var="menuItem">
			<tr>
				<td><c:out value="${menuItem.title}" /></td>
				<td><c:if test="${menuItem.freeDelivery eq 'true'}">Yes</c:if>
					<c:if test="${menuItem.freeDelivery eq 'false'}">No</c:if></td>
				<td><fmt:setLocale value="en_IN" /> <fmt:formatNumber
						value="${menuItem.price}" type="currency" /></td>
				<td><c:out value="${menuItem.category}" /></td>
				<td><a href="AddToCart?id=${menuItem.id }">Add To Cart</a></td>
			</tr>
		</c:forEach>
	</table>
	<div class="footer">
		<p>Copyright &copy; 2019</p>
	</div>
</body>
</html>