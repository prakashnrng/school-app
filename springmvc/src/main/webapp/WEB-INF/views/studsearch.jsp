<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <body>

 <form:form action="/studentsearch" commandName="STUD">
 <table>
 <tr>
 <td>
 Grade
 </td>
 <td><form:input path="grade"/>
 </td>
 </tr>
 
 <tr>
 <td>Section</td>
 <td>
 <form:select class="form-control input-sm" path="section">
								<form:option value="default">default</form:option>
								<form:options items="${section}" />

							</form:select>
							</td>
 </tr>
 
 <tr>
 <td>
  AcademicYear
 </td>
 <td>
 <form:input path="academicYear"/>
 </td>
 </tr>
 
 <tr>
 <td><input type="submit" value="submit">
 </td></tr>
 </table>
  
 </form:form>


</body>
</html>