<%@ page language="java" contentType="text/html; charset=utf-8"	isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>

<!-- INCLUDES <head> -->
<%@include file="../head.jsp"%>

<style>

</style>

<body>

	<!-- INCLUDES MAIN NAVIGATION BAR -->
	<%@include file="../nav/navbar-logged.jsp"%>

	<!-- CONTENT -->

	<div class="col-md-1"></div>

	<div class="col-md-10">

		<div class="row text-center">
			<h2 class="text-center">search for swaps</h2>
		</div>
	
		<%-- <form:form id="searchForSwaps-form"> --%>
		
		<table id="swapAlbumsTable" class="table table-hover table-bordered table-condensed">
		
		<thead>
			<tr class="active">
				<th>Cover</th>
				<th>Artist/Album info</th>
				<th>Added</th>
				<th>Condition Media/Sleeve</th>
				<th>Proposed by</th>
				<th>Discogs</th>
			</tr>
		</thead>
		
		<tbody>
		
			<c:forEach items="${swapAlbums}" var="album">
				<tr>
					<td class="col-md-1">
							<img src="img/swapAlbums/${album.imgName}" alt="Album Cover" style="width:100%">
					</td>
					<td class="col-md-3">
						<a href="/swapAlbum?albumId=${album.swapAlbumId}">
							<strong><c:out value="${album.album.artist} - ${album.album.albumName}" /></strong>
						</a><br/>
						<span class="small"><c:out value="${album.album.format}" /></span><br/>
						<span class="small"><c:out value="${album.album.label} - ${album.album.catalogNumber}" /></span><br/>
						<span class="small"><c:out value="${album.album.releaseDate}" /></span>
					</td>
					<td class="col-md-2">${album.dateAdded}</td>
					<td class="col-md-3">${album.mediaGrading}<br>${album.sleeveGrading}</td>
					<td class="col-md-2">${album.user.userName}</td>
					<td class="col-md-1">
						<a href="https://www.discogs.com/release/${album.album.discogsId}" target="_blank">
						<i class="glyphicon glyphicon-record"></i></a>
					</td>
				</tr>
			</c:forEach>
	
		</tbody>

		</table>
		
		<%-- </form:form> --%>
	
	</div>
		
	<div class="col-md-1"></div>
		
</body>

</html>