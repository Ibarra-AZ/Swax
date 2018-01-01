<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>

   	<!-- INCLUDES <head> -->
	<%@include file="head.jsp" %> 
	
    <body>
    
    	<!-- INCLUDES MAIN NAVIGATION BAR -->
		<%@include file="navbar.jsp" %>
		
		<!-- INCLUDES JS FORM VALIDATION -->
		<script><%@include file="js-validator/login-js-validator.js" %></script>
	
		<!-- CONTENT -->
        <div class="container">
			
			<div>
				<form:form id="login-form" class="well form-horizontal" method="post" modelAttribute="loginModelAttribute" 
					action="loginAction">
					
					<legend>Login</legend>
					
					<fieldset>
					
						<div class="form-group">
							<label class="col-md-4 control-label">Email</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
									<form:input path="email" type="email" class="form-control" id="email" 
										placeholder="yourmail@provider.com" />
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label">Password</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
									<form:input path="password" type="password" class="form-control" id="password" 
										placeholder="Enter your password"/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label"></label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<button type="submit" class="btn btn-primary">Login</button>
								</div>
							</div>
						</div>
					
					</fieldset>
					
				</form:form>
				
			</div>
			 
			<div>
				<p>Not a member yet? <a href="register">Register Now.</a></p>
			</div>
		
		</div>
    
    </body>

</html>