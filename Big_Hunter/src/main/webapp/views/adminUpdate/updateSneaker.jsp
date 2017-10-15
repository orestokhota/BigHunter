<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/updateSneaker/${sneaker.id }" method="post">
	<span style="color: red;">${priceExc}</span> 
		<input type="text" name="price" placeholder="enter price" value="${sneaker.price }"> 
		 <span style="color: red;"> ${quantityExc}</span> 
		<input type="text" name="quantity" placeholder="enter quantity" value="${sneaker.quantity }">
		<span style="color: red;"> ${brendExc}</span> 
	 	<select name="brend">
			<option value="none">choose brend</option>
			<c:forEach var="brend" items="${sneakerB}">
				<option value="${brend.id }">${brend.name} <option>
			</c:forEach>
		</select> 
		<span style="color: red;"> ${modelExc}</span>
		<select name="model">
			<option value="none">>choose model</option>
			<c:forEach var="model" items="${sneakerM}">
				<option value="${model.id }">${model.name }</option>
			</c:forEach>
		</select> 
		<span style="color: red;"> ${typeExc}</span>
		 <select name="type">
			<option value="none">>choose type</option>
			<c:forEach var="type" items="${sneakerT}">
				<option value="${type.id }">${type.name }</option>
			</c:forEach>
		</select> 
		 <span style="color: red;"> ${sizeExc}</span> 
		 <select name="size">
			<option value="none">>choose size</option>
			<c:forEach var="size" items="${sneakerS}">
				<option value="${size.id }">${size.size }</option>
			</c:forEach>
		</select> 
		
		
		<input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/>
		<button>update sneaker</button>
	
</form>

</body>
</html>