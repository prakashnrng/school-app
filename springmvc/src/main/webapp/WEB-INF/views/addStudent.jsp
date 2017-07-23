<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="css/base/jquery-ui-1.9.2.custom.css" rel="stylesheet">
<script src="js/jquery-1.8.3.js"></script>
<script src="js/jquery-ui-1.9.2.custom.js"></script>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<script>

$(document).ready(function(){
	$('#student').click(function(e){
		e.preventDefault();
		$('#student').addClass("active");
		$('#StudentId').fadeIn(500);
		$('#Fee').hide();
		$('#fee').removeClass("active");
			});
	
	$('#fee').click(function(e){
		e.preventDefault();
		$('#fee').addClass("active");
		$('#Fee').fadeIn(500);
		$('#StudentId').hide();
		$('#student').removeClass("active");
			});
	
	
});



</script>


<script>
function myFunction(){
	var totamount=document.getElementById("fee.totalFeeAmount").value;
	var feepaid=document.getElementById("fee.feePaid").value;
	var balamount=parseInt(totamount)-parseInt(feepaid);	document.getElementById("fee.feeBal").innerHTML=balamount;
if(!isNaN(balamount)){
document.getElementById('fee.feeBal').value=balamount;
}

}

</script>


<!-- <script>
 $(document).ready(function(){
	
	 $('fee.feeBal').click(function(e){
		
		function myFunction(){
		var totamount=document.getElementById("fee.totalFeeAmount").value;
		var feepaid=document.getElementById("fee.feePaid").value;
		var balamount=totamount-feepaid;
		document.getElementById("fee.feeBal").innerHTML=balamount;
	}
	
	
 });

</script>
  -->




<script type="text/javascript">
	$(document).ready(function(){
	$('#dateOfBirth').datepicker({
		inline:true
		minDate:0
	});
	
	</script>





</head>
<body>

<div class="container">
<ul class="nav nav-tabs">
			<li id="student"><a href="#StudentId">StudentInformation</a></li>
			<li id="fee"><a href="#Fee">Fee Pay</a></li>
			<li><a href="#">Menu 3</a></li>
		</ul>

	<div class="tabcontent">

		

		<form:form method="POST" modelAttribute="stu" class="form-horizontal">
			<div id="StudentId">
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="admisstionNubmer">AdmissionNumber</label>

						<div class="col-md-7">

							<span class="input-group-addon" id="sizing-addon1"><span
								class="glyphicon glyphicon-user"></span></span>

							<form:input type="text" path="admisstionNubmer"
								id="admisstionNubmer" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="admisstionNubmer" class="help-inline" />
							</div>
						</div>

					</div>
				</div>



				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="studentFirstName">StudentFirstName</label>
						<div class="col-md-7">
							<span class="glyphicons glyphicons-user"></span>
							<form:input type="text" path="studentFirstName"
								id="studentFirstName" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="studentFirstName" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<span class="glyphicons glyphicons-user"></span> <label
							class="col-md-3 control-lable">StudentLastName</label>
						<div class="col-md-7">
							<form:input type="text" path="studentLastName"
								id="studentLastName" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="studentLastName" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<span class="glyphicons glyphicons-user-add"></span> <label
							class="col-md-3 control-lable">FatherFirstName</label>
						<div class="col-md-7">
							<form:input type="text" path="fatherFirstName"
								id="fatherFirstName" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="fatherFirstName" class="help-inline" />
							</div>
						</div>
					</div>
				</div>


				<div class="row">
					<div class="form-group col-md-12">
						<span class="glyphicons glyphicons-user-add"></span> <label
							class="col-md-3 control-lable">FatherLastName</label>
						<div class="col-md-7">
							<form:input type="text" class="form-control input-sm"
								path="fatherLastName" id="fatherLastName" />
							<div class="has-error">
								<form:errors path="fatherLastName" class="help-inline" />
							</div>
						</div>
					</div>
				</div>


				<div class="row">
					<div class="form-group col-md-12">
						<span class="glyphicons glyphicons-woman"></span> <label
							class="col-md-3 control-lable">MotherFirstName</label>
						<div class="col-md-7">
							<form:input type="text" class="form-control input-sm"
								path="motherFirstName" id="motherFirstName" />
							<div class="has-error">
								<form:errors path="motherFirstName" class="help-inline" />
							</div>
						</div>
					</div>
				</div>



				<div class="row">
					<div class="form-group col-md-12">
						<span class="glyphicons glyphicons-woman"></span> <label
							class="col-md-3 control-lable">MotherLastName</label>
						<div class="col-md-7">
							<form:input type="text" class="form-control input-sm"
								path="motherLastName" id="motherLastName" />
							<div class="has-error">
								<form:errors path="motherLastName" class="help-inline" />
							</div>
						</div>
					</div>
				</div>



				<div class="row">
					<div class="form-group col-md-12">

						<!-- <div class='input-group date' id='datetimepicker1'> -->
						<span class="glyphicons glyphicons-clock"></span> <label
							class="col-md-3 control-lable">DateOfBirth</label>
						<div class="col-md-7">
							<form:input type="date" data-date-format="mm/dd/yyyy"
								path="dateOfBirth" id="dateOfBirth" />
							<div class="has-error">
								<form:errors path="dateOfBirth" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">

						<!-- <div class='input-group date' id='datetimepicker1'> -->
						<span class="glyphicons glyphicons-clock"></span> <label
							class="col-md-3 control-lable">Grade</label>
						<div class="col-md-7">
							<form:input type="text" class="form-control input-sm"
								path="grade" id="grade" />
							<div class="has-error">
								<form:errors path="grade" class="help-inline" />
							</div>
						</div>
					</div>
				</div>



				<div class="row">
					<div class="form-group col-md-12">

						<label class="col-md-3 control-label">Gender</label> <label
							class="col-md-3 control-lable">Male</label>
						<div class="col-md-1">
							<form:radiobutton class="radio-inline" path="gender" value="Male" />
						</div>
						<label class="col-md-3 control-lable">FeMale</label>
						<div class="col-md-1">
							<form:radiobutton class="radio-inline" path="gender"
								value="Female" />
						</div>
						<div class="has-error">
							<form:errors path="gender" class="help-inline" />
						</div>
					</div>


				</div>


				<div class="row">
					<div class="form-group col-md-12">
						<!-- <div class="input-group"> -->
						<label class="col-md-3 control-label">Section</label>
						<div class="col-md-7">
							<form:select class="form-control input-sm" path="section">
								<form:option value="default">default</form:option>
								<form:options items="${section}" />

							</form:select>
							<!-- </div> -->
						</div>
					</div>
				</div>


				<div class="row">
					<div class="form-group col-md-12">
						<!-- 	<div class="input-group"> -->
						<!-- <div class='input-group date' id='datetimepicker1'> -->
						<label class="col-md-3 control-lable">AcademicYear</label>
						<div class="col-md-7">
							<form:input type="text" path="academicYear" id="academicYear" />
							<!-- 	</div> -->
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<!-- <div class="input-group"> -->
						<label class="col-md-3 control-lable">Address</label>
						<div class="col-md-7">
							<form:textarea class="form-control input-sm" rows="5"
								path="studentAddress"></form:textarea>
							<!-- </div> -->
						</div>
					</div>
				</div>
</div>


				<div id="Fee">
				
				
				
				<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable">Total Fee</label>
							<div class="col-md-7">
								<form:input class="form-control input-sm"  name="totalFeeAmount" path="fee.totalFeeAmount"
									id="fee.totalFeeAmount" type="text" onkeyup="myFunction();"  />
							</div>
						</div>
					</div>
				
				
				
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable">Fee Paid</label>
							<div class="col-md-7">
								<form:input  class="form-control input-sm" name="feePaid" path="fee.feePaid"
									id="fee.feePaid" type="text"  onkeyup="myFunction();" />
							</div>
						</div>
					</div>


					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable">Fee Bal</label>
							<div class="col-md-7">
								<form:input   class="form-control input-sm" name="feeBal" path="fee.feeBal"
									id="fee.feeBal" type="text" />
							</div>
						</div>
					</div>
				
				
				
				
				<%-- <div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable">Total Fee</label>
							<div class="col-md-7">
								<form:input path="fee.totalFeeAmount" class="form-control input-sm" name="totalFeeAmount"
									id="totalFeeAmount" type="text" />
							</div>
						</div>
					</div>
				
				
				
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable">Fee Paid</label>
							<div class="col-md-7">
								<form:input path="fee.feePaid" class="form-control input-sm" name="fee.feePaid"
									id="fee.feePaid" type="text" />
							</div>
						</div>
					</div>


					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable">Fee Bal</label>
							<div class="col-md-7">
								<form:input path="fee.feeBal" class="form-control input-sm"
									id="fee.feeBal" type="text" onclick="myFunction()" />
							</div>
						</div>
					</div> --%>



					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable">Pay Date</label>
							<div class="col-md-7">
								<form:input path="fee.feePayDate" class="form-control input-sm"
									id="fee.feePayDate" type="date" />
							</div>
						</div>
					</div>
					
				 
					
					

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable">No Of Installment</label>
							<div class="col-md-7">
							<form:select path="fee.noOfInstallments"
									class="form-control input-sm" >
									 <form:options items="${numberofinstallments}"/>
									
									</form:select>
							</div>
						</div>
					</div>

				 <div class="form-group col-md-12">
					<input type="submit" class="btn btn-info" value="SubmitButton">
				</div>


</div>





				



		 
		</form:form>

</div>
	</div>











</body>
</html>