<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/ratings.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Date Of Order</th>

					<th>Sneaker Quantity</th>

				</tr>
			</thead>
			<tbody>

				<c:forEach var="order" items="${user.orders }">
					<tr>
						<td>${order.date }</td>

						<c:forEach var="sneaker" items="${order.sneakers }">

							<td>${sneaker.quantity }штук</td>

						</c:forEach>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>





</body>
</html>