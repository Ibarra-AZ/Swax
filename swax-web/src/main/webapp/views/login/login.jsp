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
		<script><%@include file="../js-validator/login-js-validator.js" %></script>
	
		<!-- CONTENT -->
        <div class="container" style="margin-top: 100px;">
			
			<div>
				<form:form id="login-form" class="well form-horizontal" method="post" modelAttribute="loginModelAttribute" 
					action="loginAction">
					
					<legend>Login</legend>
					
					<c:if test="${!loginModelAttribute.errorMsg.equals('')}">
						<div class="alert alert-danger">
							${loginModelAttribute.errorMsg}
						</div>
					</c:if>
										
					<fieldset>
					
						<div class="form-group">
							<label class="col-md-4 control-label"><spring:message code="login.email"/></label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
									<form:input path="email" type="email" class="form-control" id="email" 
										placeholder="yourmail@provider.com" />
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label"><spring:message code="login.password"/></label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
									<spring:message code="login.password.placeholder" var="passwordPlaceholder"/>
									<form:input path="password" type="password" class="form-control" id="password" 
										placeholder="${passwordPlaceholder}" />
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
				<p><spring:message code="login.register1"/><a href="register">
					<spring:message code="login.register2"/></a>
				<spring:message code="login.member1"/><a href="changePassword"><spring:message code="login.member2"/></a>
				</p>
			</div>
		
		</div>
    
    </body>

</html>