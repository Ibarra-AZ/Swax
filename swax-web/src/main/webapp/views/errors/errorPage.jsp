<%@ page language="java" contentType="text/html; charset=utf-8"	isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>

<html>

<!-- INCLUDES <head> -->
<%@include file="../head.jsp"%>

<body>

	<!-- INCLUDES MAIN NAVIGATION BAR -->
	<%@include file="../nav/navbar-logged.jsp"%>
	
	<div class="container">
	
	<div class="row text-center" style="margin-top:50px">
		<h2 class="text-center"><spring:message code="errorPage.h2.title"/></h2>
		<span class=""><spring:message code="errorPage.info"/></span>
	</div>
	
	<div class="row top20">
		<div class="col-md-12">
			<div class="col-md-4" style=""></div>
			<div class="col-md-4" style="">
				<img src="img/broken-rec-grey256.jpg" alt="Broken page" style="width:100%;" />
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	
	</div>
 
</body>

</html>