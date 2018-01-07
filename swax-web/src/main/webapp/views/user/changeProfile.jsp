<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
    
   	<!-- INCLUDES <head> -->
	<%@include file="../head.jsp" %> 
    
    <body>
    
    	<!-- INCLUDES MAIN NAVIGATION BAR -->
		<%@include file="../navbar.jsp" %>
		
		<!-- INCLUDES JS FORM VALIDATION -->
		<script><%@include file="../js-validator/changeProfile-js-validator.js" %></script>
	
		<!-- CONTENT -->
        <div class="container">
			
			<div>
				<form:form id="changeProfile-form" class="well form-horizontal" method="post" modelAttribute="registerModelAttribute" 
					action="changeProfileAction">
					
					<legend>Change your profile</legend>
					
					<c:if test="${!registerModelAttribute.errorMsg.equals('')}">
						<div class="alert alert-danger">
							${registerModelAttribute.errorMsg}
						</div>
					</c:if>
					
					<fieldset>
					
						<div class="form-group">
							<label class="col-md-4 control-label">User Name</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group ">
									<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
									<form:input path="userName" type="text" class="form-control" id="userName" 
										value="${registerModelAttribute.userName}" />
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label">Email</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
									<form:input path="email" type="email" class="form-control" id="email" 
										value="${registerModelAttribute.email}"/>
								</div>
							</div>
						</div>
						
						<div class="form-group"> 
						  <label class="col-md-4 control-label">Country</label>
						    <div class="col-md-4 selectContainer">
						    <div class="input-group">
						        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
						    <select name="country" class="form-control selectpicker" data-live-search="true">
						      <option value="" >Please select your country</option>
						      <%@include file="../login/countries.jsp" %>
						    </select>
						  </div>
						</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label">Password</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
									<form:input path="password" type="password" class="form-control" id="password" 
										placeholder="Create your password"/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label">Confirm password</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
									<form:input path="password2" type="password" class="form-control" id="password2" 
										placeholder="Confirm your password"/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label"></label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<button type="submit" class="btn btn-primary">Change Profile</button>
									<a href="/backToMySwax" class="btn btn-warning" role="button">Cancel</a>
								</div>
							</div>
						</div>
					
					</fieldset>
					
				</form:form>
				
			</div>
	
		</div>
    
    </body>

</html>