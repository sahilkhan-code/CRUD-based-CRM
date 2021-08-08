<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!Doctype html>

<html>
<head>

<title>List Customer</title>

<link type="text/css"
    rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/style.css" />


</head>
<body>

 <div id="wrapper">
     <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
      </div>
 </div>
      <div id = "container">
      
      <div id = "content">
      <!--  add button -->
      
      <input type="button" value="Add Customer"
      onclick="window.location.href='showFormForAdd';return false;" 
       class="add-button" />
     
      <!--  add html table here -->
      
      <table>
         <tr>
              <th>First Name </th>
              <th>Last Name </th>
              <th>Email </th>
              <th>Action</th>
         </tr>
      <!-- loop and print data -->
          
      <c:forEach var="tempCustomer" items="${customers }">
      
      <!--  Add Update Link -->
      <c:url var="updateLink" value="/customer/showFormForUpdate">
      <c:param name="customerId" value="${ tempCustomer.id }" />
      </c:url>
      
       <!--  Add Delete Link -->
      <c:url var="deleteLink" value="/customer/delete">
      <c:param name="customerId" value="${ tempCustomer.id }" />
      </c:url>
      
         <tr>
              <td> ${tempCustomer.firstName }</td>
              <td> ${tempCustomer.lastName }</td>
              <td> ${tempCustomer.email }</td>
              <td>
                  <a href="${updateLink}">Update</a>
                  |
                  <a href="${deleteLink}"
                  onclick="if(!(confirm('Are You sure you want to delete this customer?'))) return false">Delete</a>
              </td>
         </tr>
         </c:forEach>
        </table>      
      
    </div>
</div>

</body>

</html> 