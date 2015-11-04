<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invalid Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top"
		style="background-color: #141452">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="HomeFeed">Home</a><li>
			</li></ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="SignUp.html">Sign-up</a></li>
			</ul>
		</div>
	</nav>
	<br><br>	<br><br>	<br><br>
	<div class="container">
		<h1>INVALID LOGIN DETAILS YOU INCOMPETANT BUFOON TRY AGAIN!</h1>
		<div class="form-group">
			<label for="username" style="color: #141452"></label> <input
				type="Text" class="form-control" name="username"
				placeholder="Username">
		</div>
		<br>

		<div class="form-group">
			<label for="password" style="color: #141452"></label> <input
				type="password" class="form-control" name="password"
				placeholder="Password">
		</div>
		<br>
		<!-- Single button -->


		<form action="LoginServlet" method="POST">
			<button class="btn btn-primary btn-sm">Login</button>
			<a href="SignUp.html">
				<button class="btn btn-primary btn-sm">Sign-up</button>
			</a>
		</form>
		<br>
		<br>
	</div>


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"
		integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ=="
		crossorigin="anonymous"></script>

</body>
</html>