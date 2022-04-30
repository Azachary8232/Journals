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
<body style="background-color: black">
	<div class="dashboardContainer py-5" style="background-image:url(<c:url value="/img/Bookshelf.jpg" />)">
		<div class="flex flex-end">
			<div class="hyperLink a">
				<a class="mx-3" href="/newEntry">New Entry</a>
				<a href="/logout">Logout</a>
			</div>
		</div>
		<div class="bookshelf">
			<div class="flex spaceBetween">
			</div>
			<form action="/entries" method= "get">
				<div class="yearSelect flex ">
					<h5 class="mx-2 selectYear">Select Year</h5>
					<select name="year" class="select">
						<option value="2021">2021</option>
						<option value="2022">2022</option>
					</select>
				</div>
				<div class="journalsDisplay flex spaceBetween">
					<div class="journals"  style="background-image:url(<c:url value="/img/brown_marble.jpg" />)">
						<button class="journalButton" type="submit" value="01" name="month">Jan</button>					
					</div>
					<div class="journals"  style="background-image:url(<c:url value="/img/brown_marble.jpg" />)" >
						<button class="journalButton" type="submit" value="02" name="month">Feb</button>
					</div>
					<div class="journals"  style="background-image:url(<c:url value="/img/brown_marble.jpg" />)">
						<button class="journalButton" type="submit" value="03" name="month">Mar</button>
					</div>
					<div class="journals"  style="background-image:url(<c:url value="/img/brown_marble.jpg" />)">
						<button class="journalButton" type="submit" value="04" name="month">Apr</button>
					</div>
					<div class="journals"  style="background-image:url(<c:url value="/img/brown_marble.jpg" />)">
						<button class="journalButton" type="submit" value="05" name="month">May</button>
					</div>
					<div class="journals"  style="background-image:url(<c:url value="/img/brown_marble.jpg" />)">
						<button class="journalButton" type="submit" value="06" name="month">Jun</button>
					</div>
					<div class="journals"  style="background-image:url(<c:url value="/img/brown_marble.jpg" />)">
						<button class="journalButton" type="submit" value="07" name="month">Jul</button>
					</div>
					<div class="journals"  style="background-image:url(<c:url value="/img/brown_marble.jpg" />)">
						<button class="journalButton" type="submit" value="08" name="month">Aug</button>
					</div>
					<div class="journals"  style="background-image:url(<c:url value="/img/brown_marble.jpg" />)">
						<button class="journalButton" type="submit" value="09" name="month">Sep</button>
					</div>
					<div class="journals"  style="background-image:url(<c:url value="/img/brown_marble.jpg" />)">
						<button class="journalButton" type="submit" value="10" name="month">Oct</button>
					</div>
					<div class="journals"  style="background-image:url(<c:url value="/img/brown_marble.jpg" />)">
						<button class="journalButton" type="submit" value="11" name="month">Nov</button>
					</div>
					<div class="journals"  style="background-image:url(<c:url value="/img/brown_marble.jpg" />)">
						<button class="journalButton" type="submit" value="12" name="month">Dec</button>
					</div>
				</div>
			</form>
			<form action="/keyword" method="get">
				<div class="journalSearch p-2">
					<div>
						<h2 class="mx-3">Search All Journals</h2>
						<input class="searchInput" placeholder="Under Construction">
					</div>
					<div class="my-2 flex flex-end">
						<button type="submit" class="btn btn-primary">Search</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>