<%@page import="org.springframework.web.context.annotation.SessionScope"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="f"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="com.nr.springmvc.model.Question,java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>


<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%
Object obj=session.getAttribute("li");
Question q=(Question)obj;

  Object oquest=session.getAttribute("QUES");
  String question=(String)oquest;
  String chaptername=(String)request.getAttribute("CHAPTERNAME");
  
 %>

<style type="text/css">

div.page{

padding-left:10px; 

}


div.q {
	padding-top: 10px;
	padding-right: 30px;
	padding-bottom: 500px;
	padding-left: 80px;
}
</style>

<script type="text/javascript">

var curtime=new Date().getTime();

var noofhours=Math.floor(cutime%(1000*60*60*24));
var minutes=Math.floor(cutime%(1000*60*60))/((1000*60));
var seconds=Math.floor((cutime%(1000*60))/1000);

var question=q.getQuestion();
document.getElementById("ques")=question;

</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<p id="time">
		<%

%>



		<%-- <%=q.toString() %>  --%>
	<div class="container">



		<sec:authorize access="hasRole('ADMIN')">
			<div class="well">
				<a href="<c:url value='/dashboard' />">dashboard</a>
			</div>
		</sec:authorize>

		<sec:authorize access="hasRole('STUDENT')">
			<div class="panel-heading">
				<span class="lead">Take Test </span>
				<c:if test="${NOTFOUND eq 'no records found'}">

					<h1 color="red">${NOTFOUND}</h1>
				</c:if>
			</div>

			<table>

				<tr>
					<td colspan="8" align="right"><c:if test="${(BEGIN >=0)}">${BEGIN } to ${END} of ${TNOR}</c:if></td>
				</tr>
				<thead>
					<tr>
				<thead>
					<tr>





						<table>

							<form:form action="/checksol" commandName="QUEST">
								<tr>
									<form:hidden path="qidnum" value="<%=q.getQidnum() %>" />
									<form:hidden path="chaptername" value="<%=chaptername %>"/>	

									<td><%=q.getQidnum() %></td>


								</tr>
								<tr>
									<td><form:hidden path="question"
											value="<%=q.getQuestion()%>" /> <%-- 	<form:hidden path="chaptername" value="${QUEST.chaptername}"/> --%>


										<div>
											<pre>
									  &nbsp;<%=question %>
										 <%--  <%=q.getQuestion()%>   --%>
										       
										 </pre>
										</div></td>
								</tr>

								<tr>
									<c:if test="${COUNT >1}">
										<tr>
										<td><form:checkbox path="enteredsolution"
												value="<%=q.getQoption().getQoption1()%>" /> <%=q.getQoption().getQoption1()%>

										</td></tr>
										 
										<tr>	
										<td><form:checkbox path="enteredsolution"
												value="<%=q.getQoption().getQoption2()%>" /> <%=q.getQoption().getQoption2()%>
										</td></tr>
										 


										<tr>
										<td><form:checkbox path="enteredsolution"
												value="<%=q.getQoption().getQoption3()%>" /> <%=q.getQoption().getQoption3()%>
										</td>
										</tr>

										 


										<tr>
										<td><form:checkbox path="enteredsolution"
												value="<%=q.getQoption().getQoption4()%>" /> <%=q.getQoption().getQoption4()%>

										</td></tr>
										 


									</c:if>
									<c:if test="${COUNT <=1}">
											<tr>
										<td><form:radiobutton path="enteredsolution"
												value="<%=q.getQoption().getQoption1()%>" /> <%=q.getQoption().getQoption1()%>

										</td>
										</tr>
										<tr>

										<td><form:radiobutton path="enteredsolution"
												value="<%=q.getQoption().getQoption2()%>" /> <%=q.getQoption().getQoption2()%>
										</td>
											</tr>

										<tr>
										<td><form:radiobutton path="enteredsolution"
												value="<%=q.getQoption().getQoption3()%>" /> <%=q.getQoption().getQoption3()%>
										</td>
													</tr>



													<tr>
										<td><form:radiobutton path="enteredsolution"
												value="<%=q.getQoption().getQoption4()%>" /> <%=q.getQoption().getQoption4()%>

										</td>
										</tr>





										<tr>
											<td><input type="submit" value="review"></td>
										</tr>
									</c:if>

								</tr>

								<c:if test="${(BEGIN==TNOR)}">
									<tr>
										<td><input type="submit" value="Submit"></td>
									</tr>
								</c:if>
							</form:form>

						</table>



					


 


			<c:if test="${SOL ne null}">
								${SOL}
								</c:if>
			<c:if test="${WSOL ne null}">
								${WSOL}
								</c:if>

			<c:if test="${ANS}!=null}">
								     ${ANS}
								     </c:if>
								     
								     </tr>
				</thead>
			</table>
  

  <div style="display: inline;">
			<nav aria-label="pagination">
			<ul class="pager" >
				<li class="previous disabled">
				
				<c:if test="${BEGIN > 0}">
				<div style="float: left;">
				<form:form action="/listQuestionPrev" commandName="QUEST"
							method="get">

							<form:hidden path="chaptername" value="${CHAPTERNAME}" />

							<input type="submit" style="margin-right:1000px; " class="btn btn-info" value="older" />

						</form:form>
				</div>
							 
					</c:if></li>
				<li class="next"><c:if test="${BEGIN < TNOR }">
				 <div style="float: right;">
						<form:form action="/listQuestionNext" commandName="QUEST"
							method="get">

							<form:hidden path="chaptername" value="${CHAPTERNAME}" />

							<input type="submit"  style="margin-left:1000px; "    class="btn btn-info" value="next" />

						</form:form>
						</div>
						 
					</c:if> <c:if test="${BEGIN > TNOR }">
						<h6>end</h6>
					</c:if></li>
			</ul>
			</nav>
			 </div>
			 
			</sec:authorize>
			
			</div>








 


 

</body>
</html>