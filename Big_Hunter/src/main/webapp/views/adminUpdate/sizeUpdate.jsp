<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/updateSize/${size.id}" method="post">
	<span style="color: red;">${sizeEx}</span>
	<input type="number" name="size"   placeholder="enter size"  value="${size.size }" >
			<input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/>
	
	<button>update size</button>
</form>

</body>
</html>