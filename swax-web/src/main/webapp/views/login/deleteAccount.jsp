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
		<%@include file="../nav/navbar-logged.jsp" %>
		
		<!-- INCLUDES JS FORM VALIDATION -->
		<script><%@include file="../js-validator/login-js-validator.js" %></script>
	
		<!-- CONTENT -->
        <div class="container" style="margin-top: 100px;">
			
			<div>
				<form:form id="login-form" class="well form-horizontal" method="get" action="deleteAccountConfirm">
					
					<legend>Delete Account</legend>
					<p class="text-danger text justify">
						You are about to delete your account. All your datas are going to be deleted. By confirming this choice, 
						you make an irreversible action.
					</p>
										
					<fieldset>
						
						<div class="form-group">
							<label class="col-md-4 control-label"></label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group" style="display: table; margin: 0 auto;">
									<button type="submit" class="btn btn-danger">Delete account</button>
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