<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/addToCart/${sneaker.id }" method="post">
		<input type="text" name="oQua"> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
		<button>add To Cart</button>
	</form>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Price</th>
				<th>Quantity</th>
				<th>Brend Name</th>
				<th>Model Name</th>
				<th>Image</th>
				<th>Size</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${sneaker.price} $</td>
				<td>${sneaker.quantity }#</td>
				<c:forEach var="brend" items="${sneaker.brends }">
				<td>${brend.name }</td>
				</c:forEach>
				<c:forEach var="model" items="${sneaker.models }">
					<td>${model.name }</td>
					<td><img alt="${model.pathImage}" src="${model.pathImage }"height="192px" width="150px">
				</c:forEach>
					<td>${sneaker.size.size }</td>
			</tr>
		</tbody>
	</table>
	



</body>
</html>