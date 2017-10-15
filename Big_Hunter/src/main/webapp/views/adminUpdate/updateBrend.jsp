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
	<div>
		<div style="color: black;">
			<form action="/safeUpdatesBrend/${brend.id }" method="post">
				<span style="color: red;">${brendException }</span> <input
					name="brendName" type="text" value="${brend.name}">

				<%-- <select name="mods">
					<option>choose model</option>
					<c:forEach var="m" items=" ${brend.models}">
						<option>${m}</option>
					</c:forEach> --%>
				</select> <input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<button>update brend</button>
			</form>
		</div>
</body>
</html>