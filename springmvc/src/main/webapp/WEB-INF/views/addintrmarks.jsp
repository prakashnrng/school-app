<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Student Internal marks</h1>
<form:form action="/addStudmarks" commandName="MRKS">
<table>
 

<tr>
<th>SubjectName</th>
 
<th>Subject marks</th>
 
</tr>

<tr><td>
<form:hidden path="student.studentId" value="${STUD.studentId}"/>
</td>
</tr>

<%-- <c:forEach var="marks" items="${STUD.marks}"> --%>
<tr><td>
<form:input path="subjectname1"/>
</td>


  <td>
<form:input path="marks1"/>
</td>

</tr>

<tr><td>
<form:input path="subjectname2"/>
</td>
<td><form:input path="marks2"/></td>
</tr>

<tr><td>
<form:input path="subjectname3"/>
</td>
 <td><form:input path="marks3"/></td>
</tr>

<tr><td>
<form:input path="subjectname4"/>

</td>
<td><form:input path="marks4"/></td>
</tr>

<tr><td>
<form:input path="subjectname5"/>
</td>
<td><form:input path="marks5"/></td>
</tr>

<tr><td>
<form:input path="subjectname6"/>
</td>
<td><form:input path="marks6"/></td>
</tr>


<tr><td>
<form:input path="subjectname7"/>
</td>
<td><form:input path="marks7"/></td>
</tr>


<tr>
<td>
Internal Name
</td>
<td><form:input path="internalsname"/></td>
</tr>  
 
 
<tr><td>
<input type="submit" value="submit">
</td></tr>

 
</table>

 

</form:form>


</body>
</html>