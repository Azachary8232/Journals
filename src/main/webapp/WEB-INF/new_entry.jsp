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
<body>
	<div class="newEntry" style="background-image:url(<c:url value="/img/desktop.jpg" />)">
		<div class="newEntry" style="background-image:url(<c:url value="/img/blank_book.png" />)">
			<div class="dashboardContainer py-5">
				<div class="flex flex-end navBar">
					<a href="/dashboard">Back to Dashboard</a>
				</div>
				<div class="formContainer">
					<form:form action="/newEntry" method="post" modelAttribute="newEntry">
						<div class="flex">
							<div class="journalEntry p-3 entry">
								<div class="flex spaceBetween">
									<div>
										<h3>Entry</h3>
									</div>
									<div>
									    <form:errors path="entryDate"/>
										<form:input path="entryDate" type="date" ></form:input>
									</div>
								</div>
								<div class="my-3 p-2">
									<div>
									    <form:errors path="entry"/>
									    <form:textarea path="entry" class="form-control" id="" rows="20" placeholder="Begin entry..."></form:textarea>
									</div>
									<div class="flex flex-end my-3">
										<form:hidden path="user" value="${user_id}"/>
										<button type="submit" class="btn btn2 btn-primary">Save</button>
									</div>
								</div>	
							</div>
							<div class="entry2">
								<div class="my-3 p-2">
								    <form:errors path="summary"/>
								    <form:textarea path="summary" placeholder="Include a summary..." class="form-control" id="" rows="3"></form:textarea>
								</div>
								<div class="border2 my-3 p-2">
									<h3>Add Photo "Under Construction"</h3>
								</div>
							</div>
					</div>
					</form:form>
				</div>
			
			
			
			</div>
		</div>
	</div>
</body>
</html>