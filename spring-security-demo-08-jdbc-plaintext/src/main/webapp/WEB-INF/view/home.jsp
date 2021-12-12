<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<body>

	Hello world from Spring Security Demo
	
	
	
	<br>
	
	<hr>
	
	 <br>
	
	<security:authentication property="principal.username"/>
	<security:authentication property="principal.authorities"/>
	
	<hr>
	
	
	<br>
	
	
	<form:form action="${pageContext.request.contextPath}/logout"
				method="POST">
		<input type="submit" value="Logout">
	</form:form>
		
	<hr>
	
	<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${pageContext.request.contextPath}/leaders"> Leaders meeting </a>
		</p>
	</security:authorize>
	

</body>

</html>