<%@ page language="java" contentType="text/html; charset=utf-8"	isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>



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

<body>

<script type="text/javascript">
var numberBoxChecked = 0;

function isChecked(input) {
	if (input.checked) {
		numberBoxChecked = numberBoxChecked + 1;
	}
	else {
		numberBoxChecked = numberBoxChecked - 1;
	}
    console.log(numberBoxChecked);
    if (numberBoxChecked == 0) {
    	document.getElementById("submitButton").disabled = true;
        }
    else {
    	document.getElementById("submitButton").disabled = false;
    }  
}
</script>

<c:if test="${userNotifications.size()==null}">

	<div class="row text-center">
		<span class="text-muted text-uppercase"><spring:message code="myNotifications.cannotDisplay"/></span>
	</div>
	
</c:if>
 
<c:if test="${userNotifications.size() != null}">

	<form:form id="myNotifications-form" method="POST" modelAttribute="selectNotificationsModelAttribute" action="deleteNotifications">
		
		<table id="notificationsTable" class="table table-hover table-bordered table-condensed">
		
		<thead>
			<tr class="active">
				<th><spring:message code="myNotifications.th.select"/></th>
				<th><spring:message code="myNotifications.th.date"/></th>
				<th><spring:message code="myNotifications.th.subject"/></th>
				<th><spring:message code="myNotifications.th.message"/></th>
			</tr>
		</thead>
		
		<tbody>
		
			<c:forEach items="${userNotifications}" var="notification">
				<tr>
					<td class="col-md-1"><form:checkbox onclick="isChecked(this);" path="notificationsSelected" name="notifications" value="${notification.notificationId}" /></td>
					<td class="col-md-2"><c:out value="${notification.dateAdded}" /></td>
					<td class="col-md-2"><c:out value="${notification.subject}" /></td>
					<td class="col-md-7"><c:out value="${notification.message}" /></td>
				</tr>
			</c:forEach>
	
		</tbody>

		</table>
		
		<div class="form-group">
			<div class="inputGroupContainer">
				<div class="input-group col-md-12">
					<div style="display: table; margin: 0 auto;">
					<button id="submitButton" type="submit" class="btn btn-success" disabled><spring:message code="myNotifications.button.submit"/></button>
					</div>
				</div>
			</div>
		</div>
		
		</form:form>

</c:if>

</body>

</html>
