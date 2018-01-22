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
		<%@include file="../nav/navbar.jsp" %>
		
		<!-- INCLUDES JS FORM VALIDATION -->
		<script><%@include file="../js-validator/register-js-validator.js" %></script>
	
		<!-- CONTENT -->
        <div class="container">
			
			<div>
				<form:form id="register-form" class="well form-horizontal" method="post" modelAttribute="registerModelAttribute" 
					action="registerAction">
					
					
					<legend><spring:message code="register.legend" /></legend>
					
					<c:if test="${!registerModelAttribute.errorMsg.equals('')}">
						<div class="alert alert-danger">
							${registerModelAttribute.errorMsg}
						</div>
					</c:if>
					
					<fieldset>
					
						<div class="form-group">
							<label class="col-md-4 control-label"><spring:message code="register.label.user" /></label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group ">
									<spring:message code="register.input.placeholder.user" var="userPlaceholder"/>
									<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
									<form:input path="userName" type="text" class="form-control" id="userName" 
										placeholder="${userPlaceholder}" />
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label">Email</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
									<form:input path="email" type="email" class="form-control" id="email" 
										placeholder="yourmail@provider.com"/>
								</div>
							</div>
						</div>
						
						<div class="form-group"> 
						  <label class="col-md-4 control-label"><spring:message code="register.label.country" /></label>
						    <div class="col-md-4 selectContainer">
						    <div class="input-group">
						        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
						    <select name="country" class="form-control selectpicker" data-live-search="true">
						      <option value=" " ><spring:message code="register.label.country.message" /></option>
						      <%@include file="../utils/countries.jsp" %>
						    </select>
						  </div>
						</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label"><spring:message code="register.label.password" /></label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<spring:message code="register.input.placeholder.password" var="passwordPlaceholder"/>
									<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
									<form:input path="password" type="password" class="form-control" id="password" 
										placeholder="${passwordPlaceholder}"/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label"><spring:message code="register.label.confirmPassword" /></label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<spring:message code="register.input.placeholder.confirmPassword" var="confirmPasswordPlaceholder"/>
									<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
									<form:input path="password2" type="password" class="form-control" id="password2" 
										placeholder="${confirmPasswordPlaceholder}"/>
								</div>
							</div>
						</div>

					<div class="form-group">
						<label class="col-md-4 control-label"><spring:message code="register.label.discogsName" /></label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<spring:message code="register.input.placeholder.discogsName" var="discogsNamePlaceholder"/>
								<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
								<form:input path="discogsName" type="text"	class="form-control" id="discogsName" 
								placeholder="${discogsNamePlaceholder}" />
							</div>
						</div>
					</div>

					<div class="form-group">
							<label class="col-md-4 control-label"></label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<button type="submit" class="btn btn-primary"><spring:message code="register.button.register" /></button>
									<a href="/logout" class="btn btn-warning" role="button"><spring:message code="register.button.cancel" /></a>
								</div>
							</div>
						</div>
					
					</fieldset>
					
				</form:form>
				
			</div>
	
		</div>
    
    </body>

</html>