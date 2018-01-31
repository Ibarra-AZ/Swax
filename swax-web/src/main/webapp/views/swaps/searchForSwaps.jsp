<%@ page language="java" contentType="text/html; charset=utf-8"	isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>

<!-- INCLUDES <head> -->
<%@include file="../head.jsp"%>

<body>

	<!-- INCLUDES MAIN NAVIGATION BAR -->
	<%@include file="../nav/navbar-logged.jsp"%>

	<!-- CONTENT -->

	<div class="col-md-1"></div>
	
	<div class="col-md-10">

		<div class="row text-center">
			<h2 class="text-center">search for swaps</h2>
		</div>

		<div class="row top15 col-md-12">
		
		<table id="swapAlbumsTable" class="table table-hover table-bordered table-condensed">
		
		<thead>
			<tr class="active">
				<th class="col-md-3">Cover</th>
				<th>Artist</th>
				<th>Album</th>
				<th>Release Date</th>
				<th>Grading (media / sleeve)</th>
				<th>Proposed by</th>
				<th>Discogs</th>
			</tr>
		</thead>
		
		<tbody>
		
		<c:forEach items="${swapAlbums}" var="album">
		<tr>
			<td class="col-md-1" style="vertical-align: top;">
					<img src="img/swapAlbums/${album.imgName}" alt="Album Cover" style="width:100%">
			</td>
			<td class="" style="vertical-align: top;">${album.album.artist}</td>
			<td class="" style="vertical-align: top;">${album.album.albumName}</td>
			<td class="" style="vertical-align: top;">${album.dateAdded}</td>
			<td class="" style="vertical-align: top;">${album.mediaGrading} / ${album.sleeveGrading}</td>
			<td class="" style="vertical-align: top;">${album.user.userName}</td>
			<td>
				<a href="https://www.discogs.com/release/${album.album.discogsId}" target="_blank">
				<i class="glyphicon glyphicon-record"></i></a>
			</td>
		</tr>
		</c:forEach>
		
		</tbody>

		</table>
		
		</div>
		
		</div>

</body>
</html>