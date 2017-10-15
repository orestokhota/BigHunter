<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
        <%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>




<div class="container">
	<form action="/model?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
	<span style="color: red;">${modelException }</span>
		<input type="text" name="modelName" placeholder="enter model name">
		<input type="file" name="image" required="required"/>
				<input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/>
		
		<button>save model</button>
	</form> 
	</div>
<div class="container">
<table class="table table-hover">
            <thead>
            <tr>
                <th>name</th>
                <th>images</th>
                <th>update</th>
                <th>delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="model" items="${models.content}">
                <tr>
                    <td>
                            ${model.name}
                    </td>
                    
                        <td>
                            <img src="${model.pathImage}" alt="${model.pathImage}" height="192px" width="150px">
                        </td>
                  
                    <td>
                        <a href="/updateModel/${model.id}">update</a>
                    </td>
                    <td>
                        <a href="deleteModel/${model.id}">delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div style="display: flex; justify-content: center; margin-left: 10%">
        <div class="col-md-10 col-xs-10">
                <div class="row">
                    <div class="col-md-5 col-xs-10">
                        <div class="dropdown">
                            <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort <span
                                    class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <custom:sort innerHtml="Name asc" paramValue="name"/>
                                <custom:sort innerHtml="Name desc" paramValue="name,desc"/>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-4 col-xs-10 text-center">
                        <custom:pageable page="${models}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
                    </div>
                    <div class="col-md-1 col-xs-4">
                        <custom:size posibleSizes="1,2,5,10" size="${models.size}"/>
                    </div>
                </div>
           
     </div>
     </div>
     </div>
       

<%-- <a href="/model?page=${models.number}&size=${models.size}">previous</a>
<a href="/model?page=${models.number+ 2}&size=${models.size}">next</a> --%>
</body>
</html>