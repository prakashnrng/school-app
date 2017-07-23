<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login page</title>
		<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
		<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
		<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
	</head>

	<body ng-app="myApp" class="ng-cloak">
		<div id="mainWrapper">
			<div class="login-container" ng-controller="UserController as us">
				<div class="login-card">
					<div class="login-form">
						<c:url var="loginUrl" value="/login" />
						<form  name="myForm" method="post" class="form-horizontal" ng-submit="us.submit()">
							<c:if test="${param.error != null}">
								<div class="alert alert-danger">
									<p>Invalid username and password.</p>
								</div>
							</c:if>
							<c:if test="${param.logout != null}">
								<div class="alert alert-success">
									<p>You have been logged out successfully.</p>
								</div>
							</c:if>
							<div class="input-group input-sm">
								<label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
								<input type="text" class="form-control" ng-model="us.user.ssoId" id="username" name="ssoId" placeholder="Enter Username" required>
							</div>
							<div class="input-group input-sm">
								<label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
								<input type="password" class="form-control" ng-model="us.user.password" id="password" name="password" placeholder="Enter Password" required>
							</div>
							<div class="input-group input-sm">
                              <div class="checkbox">
                                <label><input type="checkbox"  name="remember-me"> Remember Me</label>  
                              </div>
                            </div>
							<input type="hidden" ng-model="us.user.rememberme" id="rememberme" name="${_csrf.parameterName}"  value="${_csrf.token}" />
								
							<div class="form-actions">
							<button type="submit"  class="btn btn-danger custom-width">submit</button>

								<!-- <input type="submit"
									class="btn btn-block btn-primary btn-default" value="Log in"> -->
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/UserService.js' />"></script>
      <script src="<c:url value='/static/js/controller/User_Controller.js' />"></script>

	</body>
</html>