<%@page import="org.springframework.security.taglibs.TagLibConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
 <link rel="stylesheet" type="text/css" href="/css/signUp.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script> 
<script src="/js/signUp.js"></script>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>

</head>
<body>
 <meta name="viewport" content="width=device-width"> 
<div class="form button group">
  <button type="button" id="one">Register</button>
  <button type="button" id="two">Login</button>
</div>
<!--registration-->
<form action = "/signUp" method="post" id="registration">
	<span style="color: red;">${usernameException}</span>
  <p>
    <input type="text" name="name" id="username" placeholder="Enter your username" >
  </p>
  <p>
    <input type="text" name="email" id="con_password" placeholder="Enter email">
  </p>
  <p>
    <input type="password" name="password" id="password" placeholder="Enter your password">
  </p>
  <input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/>
  <input type="submit" name="submit" id="submit">
</form>
 <form action = "/login" method="post" id="login">
 <span style="color: red">${exception }</span>
  <p>
    <input type="text" name="username" id="username" placeholder="Enter your username" >
  </p>
  <p>
    <input type="password" name="password" id="password" placeholder="Enter your password">
  </p>
  <input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/>
  <input type="submit" name="log_in" id="log_in" value="Login">
</form>  

<script src="/js/signUp.js"></script>



<%--  <form action="/signUp" method="post"  >
   <h1 class="signUpTitle">Sign up to Big Hunter</h1>
   <span style="color: red;">${usernameException}</span>
   <input type="text" name="name" placeholder="Type your username" >
      <span style="color: red;">${emailException}</span>
     <input type="email"  name ="email" placeholder="Type your email" >
     <span style="color: red;">${passwordException}</span>
   <input type="password" name="password"  placeholder="Enter password" >
   <input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/>
   	<button>Sign Up</button>
</form> 

	<form action="/login" method="post">
	<input type="text" name="username" placeholder="enter user name">
	<input type="password" name="password"	placeholder="enter user password">
 	<input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/>
 	<button>Login</button>
	</form>   --%>

	 
	<%-- <div style="text-align: left; color: green;">
	<c:forEach var ="user" items="${users }">
	<li>${user}<a href="/deleteUser/${user.id}">delete</a></li>
	</c:forEach>
	</div>  --%>
</body>
</html>