<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>First Web Application</title>
<link href="webjars/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1>Todos</h1>
		<br>
		<table class="table">
			<caption>Your Todos</caption>
			<thead>
				<tr>
					<th scope="col">Description</th>
					<th scope="col">Target Date</th>
					<th scope="col">Is Done</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.desc}</td>
						<td>${todo.date}</td>
						<td>${todo.done}</td>
						<td><a href="/delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br> <a href="/add-todo" class="btn btn-primary"> Click here to add todo</a>
	</div><!-- Container  -->
	<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</body>
</html>