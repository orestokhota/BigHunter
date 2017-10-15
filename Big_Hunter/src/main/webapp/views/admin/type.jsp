<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Type</h1>
	<div>
		<%-- <sf:form modelAttribute="type1" method="post">
<span style="color: red;">${typeException }</span>
	<sf:input path="name" placeholder="enter type"/>
	<sf:button> save type</sf:button>
	</sf:form> --%>

		<form action="/type?${_csrf.parameterName}=${_csrf.token}"
			method="post" enctype="multipart/form-data">
			<span style="color: red;">${typeException }</span> <input type="text"
				name="typeName" placeholder="enter type name"> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

			<button>save type</button>
		</form>
	</div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Type name</th>
				<th>update</th>
				<th>delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="type" items="${types}">
				<tr>
					<td>
					${type.name}
					</td>

					<td>
					<a href="/deleteType/${type.id}"> delete</a>
					</td>
					<td>
					<a href="/updateType/${type.id}"> update</a>
					</td>
					</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>