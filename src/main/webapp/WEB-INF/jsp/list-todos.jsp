<%@ include file="common/header.jspf" %>
<%@ include file="common/nav.jspf" %>
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
				<th scope="col">Actions</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.desc}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${todo.date}" /></td>
					<td>${todo.done}</td>
					<td><a href="/update-todo?id=${todo.id}"
						class="btn btn-success">Update</a></td>
					<td><a href="/delete-todo?id=${todo.id}"
						class="btn btn-warning">Delete</a>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br> <a href="/add-todo" class="btn btn-primary"> Click here
		to add todo</a>
</div>
<!-- Container  -->
<%@ include file="common/footer.jspf" %>
