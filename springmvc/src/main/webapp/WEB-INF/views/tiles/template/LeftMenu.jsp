<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
 <head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<title>Insert title here</title>
</head>
<body>
<div> 
<div>
<%-- <a href='<c:url value="/feePaymentDetails"></c:url>'>FeePaymentDetails</a><br/></div> --%>

<ul class="dropdown-menu">
<li class="dropdown-header">StudentInformation</li>

<li><a href='<c:url value="/studentSearch"/>'>search Student</a></li>


</ul>
<div><a href='<c:url value="/studentSearch"/>'>Student Search</a><br/></div>
<div class="dropdown">

 <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Fee
<span class="caret"></span></button>
<ul class="dropdown-menu">
      <li class="dropdown-header">Student Fee Info</li>
      <li><a href='<c:url value="/feePaymentDetails"/>'>FeePaymentDetails</a></li>
      <li><a href="/feePaymentDetailsForm">Fee Payment Receipt</a></li>
      <li><a href="#">Dumy</a></li>
           
    </ul>
</div>


<%-- <div><a href='<c:url value="/feepaymentRecipts"/>'>FeePymentReceipt</a></div> --%>
<div>
<a href="<c:url value='/listofStudent' />">Users List</a>
 </div>
<%-- <sec:authorize access="hasRole('ADMIN')"> --%>
<div class="dropdown">
<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Student
<span class="caret"></span></button>
<ul class="dropdown-menu">
<li class="dropdown-header">Student Info</li>
<li><a href='<c:url value="/addStudent"/>'>AddNewStudent </a></li>
<li><a href="<c:url value='/listofStudent'/>">Student List</a></li>

</ul>
</div>
<%-- <div><a href='<c:url value="/addStudent"/>'>AddNewStudent </a></div> --%>
<%-- </sec:authorize> --%>
</div>

</div>
</body>
</html>