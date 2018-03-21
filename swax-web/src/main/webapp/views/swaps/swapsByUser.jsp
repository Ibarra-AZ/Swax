<%@ page language="java" contentType="text/html; charset=utf-8"	isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>

<style>

p.text-info {
	border-left: solid;
	border-radius: 5px; 
	border-right: solid;
	padding: 10px;
	margin-bottom: 15px;
}

</style>


<!-- INCLUDES <head> -->
<%@include file="../head.jsp"%>

<script>
function check() {
    var swapAlbums = document.forms[0];
    var numberBoxChecked = 0;
    for (i = 0; i < swapAlbums.length; i++) {
    	  if (swapAlbums[i].checked) {
		  	numberBoxChecked = numberBoxChecked + 1;
    	  }
    	}
    if (numberBoxChecked == 0) {
    	document.getElementById("submitButton").disabled = true;
        }
    else {
    	document.getElementById("submitButton").disabled = false;
    }
}
</script>

<body>

	<!-- INCLUDES MAIN NAVIGATION BAR -->
	<%@include file="../nav/navbar-logged.jsp"%>

	<!-- CONTENT -->
	
	<div class="container col-md-12" style="margin-top:50px">

	<div class="col-md-1"></div>

	<div class="col-md-10">

		<div class="row col-md-12 text-center" style="display: table; margin: 0 auto; padding: 0;">
			<h2 class="">${userToSee.userName}<spring:message code="swapsByUser.h2.title"/></h2>
			<p class="text-info text-justify"><spring:message code="swapsByUser.info"/></p>
		</div>
	
		<form:form id="seeSwapsByUser-form" method="POST" modelAttribute="selectSwapsModelAttribute" action="sendProposition">
		
		<table id="swapAlbumsTable" class="table table-hover table-bordered table-condensed">
		
		<thead>
			<tr class="active">
				<th><spring:message code="swapsByUser.th.cover"/></th>
				<th><spring:message code="swapsByUser.th.artist"/></th>
				<th><spring:message code="swapsByUser.th.condition"/></th>
				<th><spring:message code="swapsByUser.th.description"/></th>
				<th><spring:message code="swapsByUser.th.discogs"/></th>
				<th><spring:message code="swapsByUser.th.select"/></th>
			</tr>
		</thead>
		
		<tbody>
		
			<c:forEach items="${albumsToSwap}" var="album">
				<tr>
					<td class="col-md-1">
						<img src="img/swapAlbums/${album.imgName}" alt="Album Cover" style="width:100%">
					</td>
					<td class="col-md-4">
						<strong><c:out value="${album.album.artist} - ${album.album.albumName}" /></strong>
						<br/>
						<span class="small"><c:out value="${album.album.format}" /></span><br/>
						<span class="small"><c:out value="${album.album.label} - ${album.album.catalogNumber}" /></span><br/>
						<span class="small"><c:out value="${album.album.releaseDate}" /></span>
					</td>
					<td class="col-md-2">${album.mediaGrading}<br>${album.sleeveGrading}</td>
					<td class="col-md-2">${album.description}</td>
					<td class="col-md-1">
						<a href="https://www.discogs.com/release/${album.album.discogsId}" target="_blank">
						<i class="glyphicon glyphicon-record"></i></a>
					</td>
					<td><form:checkbox onclick="check()" path="albumsSelected" name="swapAlbums" value="${album.swapAlbumId}" /></td>
				</tr>
			</c:forEach>
	
		</tbody>

		</table>
		
		<div class="form-group">
			<div class="inputGroupContainer">
				<div class="input-group col-md-12">
					<div style="display: table; margin: 0 auto;">
					<button id="submitButton" type="submit" class="btn btn-success" disabled><spring:message code="swapsByUser.button.submit"/></button>
					<a href="/backToMySwax" class="btn btn-warning" role="button"><spring:message code="swapsByUser.button.cancel"/></a>
					</div>
				</div>
			</div>
		</div>
		
		</form:form>
	
	</div>
		
	<div class="col-md-1"></div>
	
	</div>
		
</body>

</html>