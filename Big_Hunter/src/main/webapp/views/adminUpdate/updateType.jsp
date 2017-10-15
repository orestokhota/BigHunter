<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<form action="/updateType/${currentType.id}" method="post">
		<span style="color: red;">${typeException }</span>
		<input  name="name" value="${currentType.name}" >
					<input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/>
		
		<button>update type</button>
	</form>
</div>

</body>
</html>