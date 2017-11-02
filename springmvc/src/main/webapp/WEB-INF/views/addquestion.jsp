<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="post" action="/addquestionform" commandName="addquestion">
<table>

<tr>
<td>Enter SubjectName</td>
<td><form:input path="subjectname"/>
</td>
</tr>


<tr>
<td>Enter ChapterName</td>
<td><form:input path="chaptername"/>
</td>
</tr>



<tr>
<td>Enter Question</td>
<td>
<form:textarea rows="15" cols="40"  path="question"/>
</td></tr>
<tr>
<td>1st Option</td>
<td>
<form:textarea rows="3" cols="40"  path="qoption.qoption1"/>
</td></tr>
<tr>
<td>2nd Option</td>
<td>
<form:textarea rows="3" cols="40" path="qoption.qoption2"/></td></tr>

<tr>
<td>3rd option</td>
<td><form:textarea rows="3" cols="40" path="qoption.qoption3"/></td>
</tr>

<tr>
<td>4th option</td>
<td><form:textarea rows="3" cols="40" path="qoption.qoption4"/></td>
</tr>
 
 
<tr>
<td>right option 1</td>
<td><form:textarea rows="3" cols="40" path="qrightoption.qroption1"/></td>
</tr>

<tr>
<td>right option 2</td>
<td><form:textarea rows="3" cols="40" path="qrightoption.qroption2"/></td>
</tr>

<tr>
<td><input type="submit" value="ADDQUESTION"/>
</td></tr>

 
 
 </table>
 </form:form>
 </body>
 </html>