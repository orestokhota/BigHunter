<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Brend</h1>
<div style="color: black;">
	<form action="/brend" method="post" >
	<span style="color: red;">${brendException }</span>
	<input type = "text"name="brendName"  required placeholder="enter brend"/>
	<input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/>
	<button> save brend</button>
	</form>
</div>

<table class="table table-hover">
            <thead>
            <tr>
                <th>name</th>
                <th>update</th>
                <th>delete</th>
            </tr>
            </thead>
            <tbody>
<c:forEach var="brend" items="${brends}">
	<tr>
		<td>
	
	${brend.name}
	</td>
	
<td>
<a href="/deleteBrend/${brend.id}"> delete</a>
</td>
<td>
<a href="/updateBrend/${brend.id}"> update</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>