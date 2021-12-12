<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>  
<%@ taglib prefix = "c"    uri = "http://java.sun.com/jsp/jstl/core" %>

<html>

<head>

	<style>
		.failed {
			color: red;
		}
	</style>

</head>

<body>

	<h3> My Custom Login Page </h3>

	<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
				method="POST">
				
		<c:if test="${param.error != null}">
			<i class="failed"> You entered invalid username / password ${param.error} </i>
			
			<br> <br>
		</c:if>

		<input type="text" name="username" placeholder="input username ..." />

		<br> <br>

		<input type="password" name="password" placeholder="input password ..." />
		
		<br> <br>
		
		<input type="submit" value="Login">
		
	</form:form>
	
	
</body>

</html>