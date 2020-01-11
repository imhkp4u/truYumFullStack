<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
			href="ShowMenuItemListAdmin">Menu</a>
	</div>
	<h1>Edit Menu Item</h1>
	<div class="body-content-color">
		<form action="EditMenuItem" onsubmit="return validateMenuItemForm()"
			name="menuItemForm" method="post">
			<div class="form-field-spacing">
				<label for="title">Name</label>
				<div>
					<input type="text" value="${menuItem.title }" class="name-box"
						name="title" id="title">
				</div>
			</div>
			<div>
				<input type="hidden" name="id" value="${menuItem.id }">
			</div>
			<div>
				<div class="form-field-spacing">
					<label for="price">Price(Rs.)</label>
					<div>
						<input type="text" value="${menuItem.price }" class="text-box"
							name="price" id="price">
					</div>
				</div>
				<div class="form-field-spacing">
					<label for="active">Active</label>
					<div>
						<input class="radio" type="radio" name="active" value="Yes"
							<c:if test="${menuItem.active }">checked </c:if>>Yes <input
							class="radio" type="radio" name="active" value="No"
							<c:if test="${!menuItem.active }">checked </c:if>>No
					</div>
				</div>
				<div class="form-field-spacing">
					<label for="dateOfLaunch">Date of Launch</label>
					<div>

						<input type="text" class="text-box" name="dateOfLaunch"
							value="<fmt:formatDate type="date" pattern="dd/MM/yyyy"
                                         value="${menuItem.dateOfLaunch}" />">
					</div>
				</div>
				<div class="form-field-spacing">
					<label for="category">Category</label>
					<div>
						<select name="category" class="dropdown" id="category">
							<option value="${menuItem.category }">${menuItem.category }</option>
							<option value="starters">Starters</option>
							<option value="maincourse">Main Course</option>
							<option value="dessert">Dessert</option>
							<option value="drinks">Drinks</option>
						</select>
					</div>
				</div>
			</div>
			<div>
				<div class="form-field-spacing">
					<c:if test="${menuItem.freeDelivery }">
						<input type="checkbox" name="freeDelivery" checked>
					</c:if>
					<c:if test="${!menuItem.freeDelivery }">
						<input type="checkbox" name="freeDelivery">
					</c:if>
					<label for="freeDelivery">Free Delivery</label>
				</div>
			</div>
			<div>
				<div>
					<input type="hidden" name="id" value="${MenuItem.id }">
				</div>
				<input type="submit" class="success-button" value="Save">
			</div>
			<div class="footer">
				<p>Copyright &copy; 2019</p>
			</div>
		</form>
	</div>
</body>
</html>
