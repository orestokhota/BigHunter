<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile</title>
</head>
<body>
<br>
<br>
<h1 style="text-align: center;color: blue;">Your Order</h1>
<div class="container">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Brend</th>
				<th>Model Name</th>
				<th>Image</th>
				<th>Quntity In Stock</th>
				<th>Price</th>
				<th>Ordered Quantity</th>
				<th>Size</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="sneaker" items="${userBasket.sneakers }">
				<tr>
					<c:forEach var="brend" items="${sneaker.brends }">
						<td>${brend.name }</td>
					</c:forEach>

					<c:forEach items="${sneaker.models }" var="model">

						<td>${model.name }</td>
						<td><img alt="${model.pathImage }" src="${model.pathImage}"
							height="192px" width="150px"></td>

					</c:forEach>
					<td>${sneaker.quantity } #</td>

					<td>${sneaker.price } $ </td>
					<c:forEach items="${sneaker.orderSneakers }" var="orderSneaker">
						<td>${orderSneaker.quantityForBuy}
					</c:forEach>
					<td>${sneaker.size.size }</td>

					<td><a href="/delete/${userBasket.id}/${sneaker.id}">
							delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form:form action="/buy/${userBasket.id }" method="post">
		<button>buy</button>
	</form:form>
	</div>


</body>
</html>