<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tag"%>
<%@  page import="java.util.*,com.nr.springmvc.model.*"%>

<%
 Set<Marks> setobject=(Set<Marks>)request.getAttribute("SETMARKS");
	Marks	object1[]=setobject.toArray(new Marks[setobject.size()]);
	
Marks mark=(Marks)request.getAttribute("MARKS");
	 
%>
 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>STUDENT INTERNAL MARKS INFORMATION</h1>

	<table>
		<tr>
			<th>STUDENTNAME</th>
			<td>${STUD.studentFirstName}</td>
		</tr>

	</table>

	<!-- <table>
		<tr>
			<th>SUBJECT NAME</th>
			<th>INTERNAL1 MARKS</th>
			<th>InterNAL2 MARKS</th>
			<th>INTERNAL3 MARKS</th>
		</tr>

		<tr>
			<td> -->

				<table background="orange" cellpadding="100" >
					<tr>
			<th colspan="5" >SUBJECT NAME</th>
			<th colspan="5">INTERNAL1 MARKS</th>
			<th colspan="5">InterNAL2 MARKS</th>
			<th colspan="5">INTERNAL3 MARKS</th>
			<th colspan="5">BEST OF 3 MARKS</th>
				</tr>
					<tr >

						<td colspan="5">${MARKS.subjectname1}</td>
						<td colspan="5">
						  <%=object1[2].getMarks1() %> 
					 </td>
					  <td colspan="5">
						  <%=object1[1].getMarks1() %> 
					 </td>
					 <td colspan="5">
						  <%=object1[0].getMarks1() %> 
					 </td>
					 <td colspan="5"><%=mark.getMarks1() %></td>
					</tr>
					  <tr>
						<td colspan="5">${MARKS.subjectname2}</td>
						<td colspan="5"><%=object1[2].getMarks2() %> </td>
						<td colspan="5"><%=object1[1].getMarks2() %> </td>
						<td colspan="5"><%=object1[0].getMarks2() %></td>
						<td colspan="5"><%=mark.getMarks2() %></td>
					</tr>
					<tr>
						<td colspan="5">${MARKS.subjectname3}</td>
						<td colspan="5"><%=object1[2].getMarks3() %> </td>
					 <td colspan="5"><%=object1[1].getMarks3() %> </td>
					 <td colspan="5"><%=object1[0].getMarks3() %> </td>
					 <td colspan="5"><%=mark.getMarks3() %></td>
					</tr>
					<tr>
						<td colspan="5">${MARKS.subjectname4}</td>
						<td colspan="5"><%=object1[2].getMarks4() %> </td>
						<td colspan="5"><%=object1[1].getMarks4() %> </td>
						<td colspan="5"><%=object1[0].getMarks4() %> </td>
						<td colspan="5"><%=mark.getMarks4() %></td>
					</tr>
					<tr>
						<td colspan="5">${MARKS.subjectname5}</td>
						<td colspan="5"><%=object1[2].getMarks5() %> </td>
						<td colspan="5"><%=object1[1].getMarks5() %> </td>
						<td colspan="5"><%=object1[0].getMarks5() %> </td>
						<td colspan="5"><%=mark.getMarks5() %></td>
					</tr>
					<tr>
						<td colspan="5">${MARKS.subjectname6}</td>
						<td colspan="5"><%=object1[2].getMarks6() %> </td>
						<td colspan="5"><%=object1[1].getMarks6() %> </td>
						<td colspan="5"><%=object1[0].getMarks6() %> </td>
						<td colspan="5"><%=mark.getMarks6() %></td>
					</tr>
					<tr>
						<td colspan="5">${MARKS.subjectname7}</td>
						<td colspan="5"><%=object1[2].getMarks7() %> </td>
						<td colspan="5"><%=object1[1].getMarks7() %> </td>
						<td colspan="5"><%=object1[0].getMarks7() %> </td>
						<td colspan="5"><%=mark.getMarks7() %></td>
					</tr>
				</table> 
				 
			 
    
						
					 
					 
						
				<!-- 	 
						
					 </td>
					 </tr></table>
					 
						 -->
				 
					 
						
					 
					 
						
						
						 
 
 
						 

			  
		 
 
  

 





 

</body>
</html>


