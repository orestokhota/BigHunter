<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<h1 style="color: white;">Sizes</h1>
<form action="/size" method="post">
	<span style="color: red;">${sizeEx}</span>
	 <input type="text"
		name="size" placeholder="enter size" style="margin-left: 20px"/> <input type="hidden"
		name="${_csrf.parameterName}" value="${_csrf.token}" />
	<button>save size</button>
</form>
<br>
<table class="table table-hover">
	<thead>
		<tr>
			<th>Size</th>
			<th>update</th>
			<th>delete</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="size" items="${ sizes}">
			<tr>
				<td>
				${size.size}
				</td>
				<td>
				<a href="/delete/${size.id }">delete</a>
				</td>
				<td>
				<a href="/updateSize/${size.id}">update</a>
				</td>

			</tr>
		</c:forEach>
	</tbody>
</table>


<body>

</body>
</html>