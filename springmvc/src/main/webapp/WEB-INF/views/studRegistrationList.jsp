<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="f"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<%-- <%@include file="authheader.jsp" %>	 --%>
		<div class="panel panel-default">
			<!-- Default panel contents -->


			<sec:authorize access="hasRole('ADMIN')">
				<div class="well">
					<a href="<c:url value='/dashboard' />">dashboard</a>
				</div>
			</sec:authorize>

			<div class="panel-heading">
				<span class="lead">List of Users </span>
				<c:if test="${NOTFOUND eq 'no records found'}">
				
				<h1 color="red">${NOTFOUND}</h1>
				</c:if>
			</div>

<table>
			
			 <tr><td colspan="8" align="right"><c:if test="${BEGIN > 0 }">${BEGIN } to ${END} of ${TNOR}</c:if></td></tr>
				<thead>
					<tr>

						<th>AdmNum</th>
						<th>StFName</th>
						<th>FaFName</th>
						<th>MFName</th>
						<th>DOB</th>
						<th>G</th>
						<th>GRDE</th>
						<th>SECN</th>
						<th>AYear</th>


						<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
							<th width="100"></th>
						</sec:authorize>
						<sec:authorize access="hasRole('ADMIN')">
							<th width="100"></th>
						</sec:authorize>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${sessionScope.li}" var="stu">
						<tr>


							<th>${stu.admisstionNubmer}</th>
							<th>${stu.studentFirstName}</th>
							<th>${stu.fatherFirstName}</th>
							<th>${stu.motherFirstName}</th>
							<th>${stu.dateOfBirth}</th>
							<th>${stu.gender}</th>
							<th>${stu.grade}</th>
							<th>${stu.section}</th>
							<th>${stu.academicYear}</th>




							<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
								<td><a href="<c:url value='/edit-user-${stu.studentId}' />"
									class="btn btn-success custom-width">edit</a></td>
							</sec:authorize>
							<sec:authorize access="hasRole('ADMIN')">
								<td><a
									href="<c:url value='/delete-user-${stu.studentId}' />"
									class="btn btn-danger custom-width">delete</a></td>
							</sec:authorize>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- <table class="table table-hover" width="70%" height="70%"> -->
			
			
			<nav aria-label="pagination">
  <ul class="pager">
    <li class="previous disabled">
     <c:if test="${BEGIN > 0}">
    <a href="<c:url value='/listofStudentprev'/>"><span aria-hidden="true">&larr;</span> Older</a>
    </c:if>
    </li>
    <li class="next">
    <c:if test="${BEGIN < TNOR }">
    <a href="/listofStudentnext">Newer <span aria-hidden="true">&rarr;</span></a>
    </c:if>
   <%--  <c:if test="${BEGIN > TNOR }">
			  <h6>end</h6>
			 </c:if> --%>
    </li>
  </ul>
</nav>
			
			
			<%-- 
			<tr><td>
			 
			 <c:if test="${BEGIN < TNOR }">
			 
			  <a href="<c:url value='/listofStudentnext'/>">next</a> 
			 </c:if>
			 
			 <c:if test="${BEGIN > TNOR }">
			  <h6>end</h6>
			 </c:if>
			 
			</td>
			</tr>
			
			<tr><td>
			 <c:if test="${BEGIN > 0}">
			 <a href="<c:url value='/listofStudentprev'/>">prev</a>  
			</c:if>
		    <c:if test="${BEGIN < 0 }">
		    <h6>end</h6>
		    </c:if>
		    </td></tr> --%>
		    
		</div>
		<sec:authorize access="hasRole('ADMIN')">
			<div class="well">
				<a href="<c:url value='/addStudent' />">Add Student</a>
			</div>
		</sec:authorize>
	</div>

</body>
</html>