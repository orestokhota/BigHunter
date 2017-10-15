<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--  <link rel="stylesheet" href="/css/header.css" type="text/css"> -->
<link rel="stylesheet" href="/css/lang.css" type="text/css">
</head>
<body>


	<!--  <header>
	<h1>Big Hunter</h1>
	<nav>  
	<a href="/">Home</a>
	<a href="/signUp">sign Up</a>
		<a href="/sneaker">new Sneaker</a>
		 <a href="/size">new Size</a>
		<a href="/brend">new Brend</a>
		<a href="/model">new Model</a>
		<a href="/type">new Type</a>
	
	 </nav>
</header>
 -->
 
 <header class="header">
  <h1 class="logo">Big Hunter</h1>
  <ul class="nav">
    <li><a href="/"><span><spring:message code="label.home"/></</span></a></li>
			<sec:authorize access="!isAuthenticated()">
				<li><a href="/signUp"><span><spring:message code="label.sign_up"/></span></a></li>
			</sec:authorize>
			<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
				<li><a href="/sneaker"><span><spring:message code="label.sneakers"/></</span></a></li>
				<li><a href="/brend"><span><spring:message code="label.brend"/></</span></a></li>
				<li><a href="/model"><span><spring:message code="label.model"/></</span></a></li>
				<li><a href="/type"><span><spring:message code="label.type"/></</span></a></li>
				<li><a href="/size"><span><spring:message code="label.size"/></</span></a></li>

			</sec:authorize>

			
				<sec:authorize access="hasRole('ROLE_USER')">
				<li><a href="/profile"><span><spring:message code="label.profile"/></</span></a></li>
				<li><a href="/history"><span><spring:message code="label.history"/></</span></a></li>
				<li><a href="/sneakersAll"><span><spring:message code="label.sneakers_all"/></</span></a>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
				<li><form action="/logout" method="post">
				<input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/>
						<button><span><spring:message code="label.logout"/></<span></button>
					</form></li>
	
</sec:authorize>
<div class="dropdown">
  <div class="dropbtn"> UA</div>
  <div class="dropdown-content">
    <a href="?lang=ua"> UA</a>
    <a href="?lang=en"> EN</a>
  </div>
</div>

  </ul>
  
  
  
</header>

	<%-- <div id="header">
		<a href="/" id="logo">Big Hunter</a>
		<ul id="menu">
			<li><a href="/"><span>Home</span></a></li>
			<sec:authorize access="!isAuthenticated()">
				<li><a href="/signUp"><span>Sign Up</span></a></li>
			</sec:authorize>
			<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
				<li><a href="/sneaker"><span>Sneaker</span></a></li>
				<li><a href="/brend"><span>Brend</span></a></li>
				<li><a href="/model"><span>Model</span></a></li>
				<li><a href="/type"><span>Type</span></a></li>
				<li><a href="/size"><span>Size</span></a></li>

			</sec:authorize>
			
			<sec:authorize access="isAuthenticated()">
				<li><a href="/profile"><span>Profile</span></a></li>
				<li><a href="/sneakersAll"><span>All Sneakers</span></a>
				<li><form action="/logout" method="post">
				<input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/>
						<button><span>Log out<span></button>
					</form></li>
			</sec:authorize>
		</ul>
	</div>
 --%>	
	





</body>
</html>