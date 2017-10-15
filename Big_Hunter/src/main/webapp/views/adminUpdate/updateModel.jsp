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
 	<form action="/updateModel/${currentModel.id }?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
		<span style="color: red;">${modelException }</span>
		<input  name="name" value="${currentModel.name}">
		<input type="file" name="image"/>
		<button>update model</button>
	</form> 
</div>

</body>
</html>