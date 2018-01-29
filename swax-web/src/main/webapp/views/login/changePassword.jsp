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
		<script><%@include file="../js-validator/changePassword-js-validator.js" %></script>
	
		<!-- CONTENT -->
        <div class="container">
			
			<div>
				<form:form id="changePassword-form" class="well form-horizontal" method="post" 
					modelAttribute="changePasswordModelAttribute" action="changePasswordAction">
					
					<legend><spring:message code="changePassword.legend"/></legend>
					
					<c:if test="${!changePasswordModelAttribute.errorMsg.equals('')}">
						<div class="alert alert-danger">
							${changePasswordModelAttribute.errorMsg}
						</div>
					</c:if>
										
					<fieldset>
					
						<div class="form-group">
							<label class="col-md-4 control-label"><spring:message code="changePassword.email"/></label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
									<form:input path="email" type="email" class="form-control" id="email" 
										placeholder="yourmail@provider.com" />
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label"></label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<button type="submit" class="btn btn-primary">
										<spring:message code="changePassword.btn.send"/></button>
									<a href="/logout" class="btn btn-warning" role="button">
										<spring:message code="changePassword.btn.cancel"/></a>
								</div>
							</div>
						</div>
					
					</fieldset>
					
				</form:form>
				
			</div>
			 
			<div>
				<p><spring:message code="changePassword.member1"/>
				<a href="register"><spring:message code="changePassword.btn.member2"/></a></p>
			</div>
		
		</div>
    
    </body>

</html>