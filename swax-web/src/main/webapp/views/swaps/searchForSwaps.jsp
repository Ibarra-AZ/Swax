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

<style>

</style>

<body>

	<!-- INCLUDES MAIN NAVIGATION BAR -->
	<%@include file="../nav/navbar-logged.jsp"%>

	<!-- CONTENT -->
	
	<div class="container col-md-12" style="margin-top:50px">

	<div class="col-md-1"></div>

	<div class="col-md-10">

		<div class="row col-md-12 text-center" style="display: table; margin: 0 auto; padding: 0;">
			<h2 class=""><spring:message code="searchForSwaps.h2.title"/></h2>
			<p class="text-info text-justify"><spring:message code="searchForSwaps.info"/></p>
		</div>
	
		<%-- <form:form id="searchForSwaps-form"> --%>
		
		<div class="form-group">
			<div class="inputGroupContainer">
				<div class="input-group col-md-12">
					<div style="display: table; margin: 0 auto;">
					<a href="/backToMySwax" class="btn btn-warning" role="button"><spring:message code="searchForSwaps.button.cancel"/></a>
					</div>
				</div>
			</div>
		</div>
		
		<table id="swapAlbumsTable" class="table table-hover table-bordered table-condensed">
		
		<thead>
			<tr class="active">
				<th><spring:message code="searchForSwaps.th.cover"/></th>
				<th><spring:message code="searchForSwaps.th.artist"/></th>
				<th><spring:message code="searchForSwaps.th.added"/></th>
				<th><spring:message code="searchForSwaps.th.condition"/></th>
				<th><spring:message code="searchForSwaps.th.proposed"/></th>
				<th><spring:message code="searchForSwaps.th.discogs"/></th>
			</tr>
		</thead>
		
		<tbody>
		
			<c:forEach items="${swapAlbums}" var="album">
				<c:if test="${album.user.userId != user.userId}">
				<tr>
					<td class="col-md-1">
						<img src="img/swapAlbums/${album.imgName}" alt="Album Cover" style="width:100%">
					</td>
					<td class="col-md-4">
						<a href="/swapAlbum?albumId=${album.swapAlbumId}">
							<strong><c:out value="${album.album.artist} - ${album.album.albumName}" /></strong>
						</a><br/>
						<span class="small"><c:out value="${album.album.format}" /></span><br/>
						<span class="small"><c:out value="${album.album.label} - ${album.album.catalogNumber}" /></span><br/>
						<span class="small"><c:out value="${album.album.releaseDate}" /></span>
					</td>
					<td class="col-md-2">${album.dateAdded}</td>
					<td class="col-md-2">${album.mediaGrading}<br>${album.sleeveGrading}</td>
					<td class="col-md-2"><a href="/swapsByUser?userId=${album.user.userId}">
						<i class="glyphicon glyphicon-user"></i> ${album.user.userName}</a>
					</td>
					<td class="col-md-1">
						<a href="https://www.discogs.com/release/${album.album.discogsId}" target="_blank">
						<i class="glyphicon glyphicon-record"></i></a>
					</td>
				</tr>
				</c:if>
			</c:forEach>
	
		</tbody>

		</table>
		
		<%-- </form:form> --%>
	
	</div>
		
	<div class="col-md-1"></div>
	
	</div>
		
</body>

</html>