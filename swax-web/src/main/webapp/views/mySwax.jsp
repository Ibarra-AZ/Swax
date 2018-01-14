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
			<li class="active"><a data-toggle="tab" href="#home">Home </a></li>
			<li><a data-toggle="tab" href="#collection">Collection 
					<span class="badge badge-info">${userCollection.size()}</span></a>
			</li>
			<li><a data-toggle="tab" href="#wantlist">Wantlist 
				<span class="badge badge-warning">${userWantlist.size()}</span></a></li>
			<li><a data-toggle="tab" href="#propositions">Propositions </a></li>
		</ul>

		<div class="tab-content">
			<br/>
			<div id="home" class="tab-pane fade in active">
				<h2 class="text-center">welcome to swax</h2>
				<c:if test="${hasCollection==false}">
					<p>It seems that you have no collection yet. Do you want to import your 
					collection from Discogs?</p>
					<%@include file="importCollectionForm.jsp"%>
				</c:if>
				<c:if test="${hasCollection==true}">
					<%@include file="latestAdditions.jsp"%>
				</c:if>
			</div>
			<div id="collection" class="tab-pane fade">
				<c:if test="${hasCollection==true}">
					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-4 text-center">
							<a href="#"><i class="glyphicon glyphicon-refresh"></i>
								<span class="text-primary"> Synchronize with discogs</span>
							</a>
							
						</div>
						<div class="col-md-4"></div>
					</div>
					
					<div><%@include file="collectionTableForm.jsp"%></div>	
					
				</c:if>
				<c:if test="${hasCollection==false}">
					You have no collection to display. Import your collection from Discogs.
				</c:if>
			</div>
			<div id="wantlist" class="tab-pane fade">
				<c:if test="${hasWantlist==true}">
					<p>Browse your wantlist and start to swap your wax ;-)</p>
					<%@include file="wantlistTableForm.jsp"%>
				</c:if>
				<c:if test="${hasWantlist==false}">
					You have no wantlist to display. Import your wantlist from Discogs.
					<%@include file="importWantlistForm.jsp"%>
				</c:if>
			</div>
			<div id="propositions" class="tab-pane fade">
				<p>See your swaps</p>
			</div>
		</div>
	</div>

	<div class="col-md-1"></div>

</body>

</html>