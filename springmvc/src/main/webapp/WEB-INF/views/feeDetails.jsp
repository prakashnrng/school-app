<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 
</head>
<body>


<div class="container">

<form:form action="feePaymentD"  method="POST" modelAttribute="student" class="form-horizontal" >


<!--action="/feePaymentD"  -->

 

<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="grade">Grade</label>
					<div class="col-md-7">
					
					<form:select class="form-control input-sm" path="grade">
								<form:option value="default">default</form:option>
								<form:options items="${listofgrade}" />
					</form:select>					
						 
						<div class="has-error">
							<form:errors path="grade" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>



  <div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="section">Section</label>
					<div class="col-md-7">
					<form:select class="form-control input-sm" path="section">
							<form:options items="${section}" />
					</form:select>	
								<div class="has-error">
							<form:errors path="section" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
					
					 <div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="academicYear">Academic Year</label>
					<div class="col-md-7">
					
					<form:select class="form-control input-sm" path="academicYear">
							<form:options items="${academicyor}" />
					</form:select>	
											 
						<div class="has-error">
							<form:errors path="academicYear" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>  
										 
					
					
					 
					
						 <div class="form-group col-md-12">
					<input type="submit" value="submit">
					</div>
					
				


</form:form>

</div>

 

</body>
</html>