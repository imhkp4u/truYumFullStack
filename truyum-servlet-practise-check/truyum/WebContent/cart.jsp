<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
		<img
			src="https://image.shutterstock.com/image-vector/knife-fork-vector-icon-flat-260nw-764792872.jpg">
		<a href="ShowCart">Cart</a> <a href="ShowMenuItemListCustomer">Menu</a>
	</div>
	<h1>Cart</h1>
	<c:if test="${message }">
		<h3>Item Removed from Cart Successfully</h3>
	</c:if>
	<table id="tableID">
		<tr>
			<th>Name</th>
			<th>Free Delivery</th>
			<th class="currency"><h4>Price</h4></th>
		</tr>
		<c:forEach items="${cart.menuItemList }" var="menuItem">
			<tr>
				<td>${menuItem.title }</td>
				<td><c:if test="${menuItem.freeDelivery}">Yes</c:if> <c:if
						test="${!menuItem.freeDelivery}">No</c:if></td>
				<td class="currency">Rs. <fmt:formatNumber
						value="${menuItem.price}" pattern="#,##,##,##,###.00" />
				</td>
				<td>${menuItem.category}</td>
				<td><a href="RemoveCart?id=${menuItem.id }">Delete</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td></td>
			<td class="total">Total</td>
			<td class="total">Rs. <fmt:formatNumber value="${cart.total }"
					pattern="#,##,##,##,###.00" />
			</td>
			<td></td>
		</tr>
	</table>
	<div class="footer">
		<p>Copyright &copy; 2019</p>
	</div>
</body>
</html>