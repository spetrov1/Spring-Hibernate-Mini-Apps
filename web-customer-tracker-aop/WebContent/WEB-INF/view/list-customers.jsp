<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>

<html>

<head>
	<title> List Customers </title>
		<link 	type="text/css" 
				rel="stylesheet" 
				href="${pageContext.request.contextPath}/resources/css/style.css" />
				
</head>

<body>

	<div id="wrapper">
	
		<div id="header">
			<h2> CRM - Customer Relationship Manager </h2>
		</div>
		
		
		<div id="container">
		
			<div id="content">
		
				<input type="button" value="Add Customer" class="add-button"
					onclick="window.location.href='showFormForAdd'; return false;" />
				
				<table>
				
					<tr>
						<th> First Name </th>
						<th> Last Name </th>
						<th> Email </th>
						<th> Action </th>
					</tr>
					
					<!--  For each customer ... display row with data -->
					<c:forEach var="currentCustomer" items="${customers}">
					
						<c:url var="tempUpdateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${currentCustomer.id}" />
						</c:url>
						
						<c:url var="tempDeleteLink" value="/customer/deleteCustomer">
							<c:param name="customerId" value="${currentCustomer.id}" />
						</c:url>

						<tr>
							<td> ${currentCustomer.firstName} </td>
							<td> ${currentCustomer.lastName} </td>
							<td> ${currentCustomer.email} </td>
							<td> 	<a href="${tempUpdateLink}"> Update </a> 
									|
								  	<a href="${tempDeleteLink}"
								  		onclick="if (!confirm('Are you sure you want to delete the customer')) return false"
								  	  > Delete </a> 
							</td>
						</tr>
					</c:forEach>
					
				</table>
				
				<p> contextPath: ${pageContext.request.contextPath} </p>
				<p> pathInfo: ${pageContext.request.pathInfo} heeh </p>
				<p> servletPath: ${pageContext.request.servletPath} </p>
				
			</div>
		</div>
	
	</div>

</body>

</html>