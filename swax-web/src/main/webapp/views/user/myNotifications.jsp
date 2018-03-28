<%@ page language="java" contentType="text/html; charset=utf-8"	isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<style>
	.a-btn {
	    transition: .2s;
	}
	.a-btn:hover, .btn:focus {
	    background-color: #f1f1f1;
	    text-decoration: none;
	}
	a:hover {
	    text-decoration: none;
	}
	.caption div {
		width: 100%; 
		height: 18px; 
		overflow: hidden;
	}
</style>

<c:if test="${userNotifications.size()==null}">

	<div class="row text-center">
		<span class="text-muted text-uppercase"><spring:message code="myNotifications.cannotDisplay"/></span>
	</div>
	
</c:if>
 
<c:if test="${userNotifications.size() != null}">

<%-- 	<div class="row text-center">
		<span class="text-muted text-uppercase"><spring:message code="myNotifications.checkout"/></span>
	</div> --%>
	
	<div class="row top15">

	</div>

</c:if>
