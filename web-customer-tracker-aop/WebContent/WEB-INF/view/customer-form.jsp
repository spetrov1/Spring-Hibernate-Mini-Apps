<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<html>

<head>
	<title> Add Customer Form </title>

	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">

</head>

<body>
	
	<div id="wrapper">

		<div id="header">
			<h2> CRM - Customer Relationship Manager </h2>
		</div>
			
	</div>
			
	<div id="container">

		<form:form action="saveCustomer" method="POST"
				modelAttribute="customer" >
				
			<form:hidden path="id" />
		
			<h3> Save Customer </h3>
			
			<table>
									
				<tbody>
				
					<tr> 
						<td> <label > First Name: </label> </td>
						<td> <form:input path="firstName" /> </td>
					 </tr>
					 
					 <tr> 
						<td> <label > Last Name: </label> </td>
						<td> <form:input path="lastName" /> </td>
					 </tr>
					 
					 <tr> 
						<td> <label > Email: </label> </td>
						<td> <form:input path="email" /> </td>
					 </tr>
					 
					 <tr> 
						<td> <label > </label> </td>
						<td> <input type="submit" value="Save" /> </td>
					 </tr>
				
				</tbody>
			
			</table>
		
		</form:form>
		
		<p>
			<a href="${pageContext.request.contextPath}/customer/list"> Back to List </a>
		</p>
		
	</div>

</div>
	
	
</body>

</html>