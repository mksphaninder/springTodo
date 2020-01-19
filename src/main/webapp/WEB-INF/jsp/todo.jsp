<%@ include file="common/header.jspf" %>
<%@ include file="common/nav.jspf" %>
	<div class="container">
		<div class="row">

			<div>
				<form:form method="POST" modelAttribute="todo">
					<form:hidden path="id"/>
						<fieldset class="form-group">
							<form:label path="desc" >Description</form:label> 
							<form:input type="text" path="desc" class="form-control" required="required"/> 
							<form:errors path="desc" cssClass="text-warning"/>
						</fieldset><!-- form-group -->
						
						<fieldset class="form-group">
							<form:label path="date" >Date</form:label> 
							<form:input type="text" path="date" class="form-control" required="required" /> 
							<form:errors path="date" cssClass="text-warning"/>
						</fieldset><!-- form-group -->
						<input type="submit" class="btn btn-primary">
				</form:form>
			</div>
		</div><!-- row -->
	</div><!-- container -->
<%@ include file="common/footer.jspf" %>
	