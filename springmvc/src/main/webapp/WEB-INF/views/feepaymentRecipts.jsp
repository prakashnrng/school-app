<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>FeePaymentRecipts page</h1>

<table>
<%-- <tr><td>
total fee bee</td>
<td>${TFEEBAL}</td>
</tr>
<tr>  LISTSTUD
<td>
 totfeePaid</td>
 <td>${TFEEPAID}</td>
 </tr>
 --%>
</table>

<div class="panel panel-default">

<div class="panel-heading"><span class="lead">List Of Student</span></div>
		  	
			<table class="table table-hover" width="70%" height="70%">
	    		<thead>
		      		<tr>
		      		<th>StudentId</th>
				        <th>Firstname</th>
				        <th>Lastname</th>
				        <th>Grade</th>
				        <th>Section</th>
				        <th>AcademicYear</th>
				        <th>TotalAmount</th>
				        <th>FeePaid</th>
				        <th>DueFee</th>
				         
				        
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${LISTSTUD}" var="stud">
					<tr>
					<td>${stud.studentId}</td>
						<td>${stud.studentFirstName}</td>
						<td>${stud.studentLastName}</td>
						<td>${stud.grade}</td>
						<td>${stud.section}</td>
						<td>${stud.academicYear}</td>
						<%-- <td>${stud.fee.feeId }</td> --%>
					  <td>${stud.fee.totalFeeAmount}</td>
						<td>${stud.fee.feePaid}</td>
						<td style="color: red">${stud.fee.feeBal}</td> 
						 
						
					    <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
							<td><a href="<c:url value='/download-stud-${stud.studentId}' />" class="btn btn-success custom-width">Generate Receipt</a></td>
				        </sec:authorize>
				        <sec:authorize access="hasRole('ADMIN')">
							<td><a href="<c:url value='/delete-user-${user.ssoId}' />" class="btn btn-danger custom-width">delete</a></td>
        				</sec:authorize>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
		<sec:authorize access="hasRole('ADMIN')">
		 	<div class="well">
		 		<a href="<c:url value='/newuser' />">Add New User</a>
		 	</div>
	 	</sec:authorize>
  


</body>
</html>