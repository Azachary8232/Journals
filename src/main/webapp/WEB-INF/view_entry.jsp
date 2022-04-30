<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css"> 
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /> 
<script type="text/javascript" src="js/app.js"></script>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script> 
<title>Insert title here</title>
</head>
<body class="viewPage" style="background-image:url(<c:url value="/img/wood_desk.jpg" />)">
	<div>
		<div class="flex flex-end navBar container">
			<a href="/dashboard">Back to Dashboard</a>
		</div>
		<div class="viewContainer" style="background-image:url(<c:url value="/img/blank_book.png" />)">
			<div>
				<fmt:formatDate value="${entry.entryDate }" pattern="MMMM dd, yyyy" var="newDate"/>
				<h2>${newDate }</h2>
			</div>
			<div class="viewEntry lego">
				<p>${entry.entry}</p>
			</div>
			<div class="entryUpdate">
				<a href="/edit/${entry.id}">Update Entry</a>
			</div>
		</div>
	
	
	
	
	
	
	
	
	
	
	</div>
</body>
</html>