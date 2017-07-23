<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="t" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to dashboard</h1>

<div>
<div>
<a href='<c:url value="feePaymentDetails"></c:url>'>FeePaymentDetails</a><br/></div>
<div><a href='<c:url value="studentSearch"/>'>Student Search</a><br/></div>
<div><a href='<c:url value="feepaymentRecipts"/>'>FeePymentReceipt</a></div>
</div>


</body>
</html>