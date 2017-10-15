<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sneakers</title>
</head>
<body>
	<h1 style="text-align: center; color: black;">Sneakers</h1>

	<%-- <sf:form modelAttribute="sneaker" method="post">
		<sf:errors path="*"/>
		
		
		

		<sf:select element="div" path="brends" items="${brends}"
			itemLabel="name" itemValue="id" /> 
			 <sf:select path="models" items="${models}" itemLabel="name" itemValue="id"/>
			<sf:select path="types" items="${ types}" itemLabel="name" itemValue="id"/> 
		<button>save sneaker</button>

	</sf:form> --%>

<div class="container">
	<form action="/sneaker" method="post">
		 <span style="color: red;">${priceExc}</span> 
		<input type="text" name="price"  placeholder="enter price" required="required"> 
		 <span style="color: red;"> ${quantityExc}</span> 
		<input type="text" name="quantity" placeholder="enter quantity" required="required">
		 <span style="color: red;"> ${sizeExc}</span> 
		<select name="size">
			<option value="none">choose size</option>
			<c:forEach var="size" items="${sizes}">
				<option value="${size.id }">${size.size }</option>
			</c:forEach>
		</select> 
		 <span style="color: red;"> ${brendExc}</span> 
		<select name="brend">
			<option value="none">choose brend</option>
			<c:forEach var="brend" items="${brends}">
				<option value="${brend.id }">${brend.name}</option>
			</c:forEach>
		</select> 
		 <span style="color: red;"> ${modelExc}</span> 
		 <select name="model">
			<option value="none">choose model</option>
			<c:forEach var="model" items="${models }">
				<option value="${model.id}">${model.name}</option>
			</c:forEach>
		</select>   
		 <span style="color: red;"> ${typeExc}</span> 
		<select name="type">
			<option value="none">choose type</option>
			<c:forEach var="type" items="${types}">
				<option value="${type.id }">${type.name }</option>
			</c:forEach>
		</select>
		<input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/>
		<button>save sneaker</button>
	</form>
	<table class="table table-hover">
            <thead>
            <tr>
                <th>price</th>
                <th>quantity</th>
                <th>Type Name</th>
                <th>images</th>
                <th>update</th>
                <th>delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="sneaker" items="${sneakers}">
                <tr>
                    <td>
                            ${sneaker.price} $
                    </td>
                    <td>
                            ${sneaker.quantity} #
                    </td>
                    	
                    	<c:forEach var="model" items="${sneaker.models }">
                    	
                    	 <td>
                            ${model.name} 
                   	 	</td>
                   	 	 
                    	<td>
                            <img src="${model.pathImage}" alt="${model.pathImage}" height="192px" width="150px">
                        </td>
                    	
                    	</c:forEach>
                    
                        
                  
                    <td>
                        <a href="/updateSneaker/${sneaker.id}">update</a>
                    </td>
                    <td>
                        <a href="/deleteSneaker/${sneaker.id}">delete</a>
                    </td>
                    <td>
                        <a href="/show/${sneaker.id}">show</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>


</div>
</body>
</html>