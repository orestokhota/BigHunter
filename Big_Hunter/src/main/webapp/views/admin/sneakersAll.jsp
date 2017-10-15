<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/css/search.css">
	
</head>
<body>
<div class="container">
	<div style="display: flex; justify-content: center; margin-left: none">
		<div class="col-md-10 col-xs-10">
			<div class="row">
				<div class="col-md-5 col-xs-10">
					<div class="dropdown">
						<button class="btn btn-primary dropdown-toggle" type="button"
							data-toggle="dropdown">
							Sort <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<custom:sort innerHtml="Low-High $-$$" paramValue="price" />
							<custom:sort innerHtml="High-Low $$-$" paramValue="price,desc" />
						</ul>
					</div>
				</div>

				<div class="col-md-1 col-xs-4">
					<custom:size posibleSizes="1,2,5,10" size="${sneaker.size}" />
				</div>
			</div>

		</div>
	</div>
<br>
<br>
<%-- <div class="search">
<form action="/search" method="post">
<input class="input" type="text" id="search" placeholder="search"  size="50px">
<input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/>
</form>
</div> --%>
<table class="table table-hover">
            <thead>
            <tr>
                <th>price</th>
                <th>quantity</th>
                <th>Model name</th>
                <th>image</th>
                <th>add</th>
                  <th>
                    <div class="form-group; col-lg-10">
                        <input type="text" class="form-control" id="searchIn"
                               placeholder="search" oninput="search()"/>
                    </div>
                </th>
            </tr>
            </thead>
             <body> 
            <tbody id="indexResult">
	<c:forEach var="sneaker" items="${sneaker.content }">
	<tr>
	
 		<td>${sneaker.price }</td>
 		<td>${sneaker.quantity}</td>
 		<c:forEach var="model" items="${sneaker.models }">
 		<td>	${model.name }</td>
 			<td><img alt="${model.pathImage }" src="${model.pathImage }" height="192px" width="150px"> </td>
 		</c:forEach>
 <td>
 <a href="/show/${sneaker.id }">add</a>
 </td>
</tr>
	</c:forEach>
	</tbody>
</body>
</table> 

		 


	 <%--  	<c:forEach var="sneaker" items="${sneaker.content }">
			<c:forEach var="model" items="${sneaker.models }">
	  <figure class="snip1423">
  
  <img src="${model.pathImage }" alt="sample57" />
 
  <figcaption>
    <h3>${brend.name }</h3>

		
    <p>${model.name }</p>
    <div class="price">
    ${sneaker.price } $
    </div>
  </figcaption><i class="ion-android-cart"></i>
  
  <a href="/show/${sneaker.id }"></a>
</figure> 
  </c:forEach> 
	< </c:forEach> --%> 
	<div style="display: flex; justify-content: center" >
		<div class="col-md-10 col-xs-10">
			<div class="row">

				<div class="col-md-4 col-xs-10 text-center" style="text-align: center;">
					<custom:pageable page="${sneaker}" cell="<li></li>"
						container="<ul class='pagination'></ul>" />
				</div>

			</div>

		</div>
	</div>
	</div>
	
	<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>
	
<script src="/js/search.js"></script>

</body>
</html>