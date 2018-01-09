<%@ page language="java" contentType="text/html; charset=utf-8"
	isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>

<html>

<!-- INCLUDES <head> -->
<%@include file="head.jsp"%>

<body>

	<!-- INCLUDES MAIN NAVIGATION BAR -->
	<%@include file="navbar-logged.jsp"%>

	<!-- CONTENT -->

	<div class="col-md-1"></div>

	<div class="col-md-10">

		<img class="loader" src="/img/loading.gif" alt="loader" width="40"
			height="40" />

		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#home">Home</a></li>
			<li><a data-toggle="tab" href="#collection">Collection</a></li>
			<li><a data-toggle="tab" href="#wantlist">Wantlist</a></li>
			<li><a data-toggle="tab" href="#propositions">Propositions</a></li>
		</ul>


		<div class="tab-content">
			<div id="home" class="tab-pane fade in active">
				<p>Welcome to Swax!</p>
				<p>${infoMsg}</p>
			</div>
			<div id="collection" class="tab-pane fade">
				<c:if test="${hasCollection==true}">
				<p>Browse your collection and start to swap your wax ;-)</p>
				<table id="dataTable" class="table table-hover table-bordered table-condensed">
					<thead>
						<tr class="active">
							<th>Artist/Album info</th>
							<th>Condition Media/Sleeve</th>
							<th>Notes</th>
							<th>Added</th>
							<th>Discogs</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${userCollection}" var="album">
							<tr>
								<td>
									<a href="album?${album.albumId}"><strong><c:out value="${album.artist} - ${album.albumName}" /></strong></a><br/>
									<span class="small"><c:out value="${album.format}" /></span><br/>
									<span class="small"><c:out value="${album.label} - ${album.catalogNumber}" /></span><br/>
									<span class="small"><c:out value="${album.releaseDate}" /></span>
								</td>
								<td>
									<c:out value="${album.mediaGrading} - ${album.sleeveGrading}" />
								</td>
								<td>
									<c:out value="${album.notes}" />
								</td>
								<td>
									<c:out value="${album.dateAdded}" />
								</td>
								<td>
									<a href="https://www.discogs.com/release/${album.discogsId}" target="_blank">
									<i class="glyphicon glyphicon-record"></i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</c:if>
				<c:if test="${hasCollection==false}">
					<p>It seems that you don't have any collection. Do you want to import your collection from Discogs now ?</p>
				</c:if>
			</div>
			<div id="wantlist" class="tab-pane fade">
				<p>Browse your wantlist</p>
			</div>
			<div id="propositions" class="tab-pane fade">
				<p>See your swaps</p>
			</div>
		</div>
	</div>

	<div class="col-md-1"></div>


</body>

</html>