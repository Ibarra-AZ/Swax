<%@ page language="java" contentType="text/html; charset=utf-8"
	isELIgnored="false" pageEncoding="utf-8"%>
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

	<!-- CONTENT -->
	<div class="container col-md-12" style="margin-top:50px">
	
	<div class="col-md-1"></div>

	<div class="col-md-10">

		
		<!-- gif loader -->
		<img class="loader" src="/img/loading.gif" alt="loader" width="40" height="40" />


		<!-- Menu -->
		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#home">
				<i class="glyphicon glyphicon-home"></i></a>
			</li>
			<li><a data-toggle="tab" href="#collection">
				<spring:message code="userNav.menu.collection"/>
					<span class="badge badge-info">${userCollection.size()}</span></a>
			</li>
			<li><a data-toggle="tab" href="#wantlist">
				<spring:message code="userNav.menu.wantlist"/>
				<span class="badge badge-warning">${userWantlist.size()}</span></a>
			</li>
			<li><a data-toggle="tab" href="#propositions">
				<spring:message code="userNav.menu.albumsISwap"/>
				<span class="badge badge-success">${userSwapPropositions.size()}</span></a>
			</li>
		</ul>

		
		<!-- Tabs Content -->
		<div class="tab-content">
			<br/>


			<!-- ERROR MESSAGE -->
			<c:if test="${!errorMsg.equals('') && errorMsg != null}">
				<div class="alert alert-danger">
					${errorMsg}
				</div>
			</c:if>

			
			<!-- HOME -->
			<div id="home" class="tab-pane fade in active">
				<h2 class="text-center">welcome to swax</h2>
				<c:if test="${hasCollection==false}">
					<p>It seems that you have no collection yet. Do you want to import your 
					collection from Discogs?</p>
					<%@include file="importCollectionForm.jsp"%>
				</c:if>
				<c:if test="${hasCollection==true}">
					<%@include file="../home/latestAdditions.jsp"%>
				</c:if>
			</div>

			
			<!-- COLLECTION -->
			<div id="collection" class="tab-pane fade">
				<h2 class="text-center">your collection</h2>
				<c:if test="${hasCollection==true}">
					<div class="row text-center">
						<a href="#"><i class="glyphicon glyphicon-refresh"></i>
							<span class="text-primary"> Synchronize with discogs</span>
						</a>
					</div>
					<div><%@include file="collectionTableForm.jsp"%></div>	
				</c:if>
				<c:if test="${hasCollection==false}">
					You have no collection to display. Import your collection from Discogs.
				</c:if>
			</div>
			
			
			<!-- WANTLIST -->
			<div id="wantlist" class="tab-pane fade">
				<h2 class="text-center">your wantlist</h2>
				<c:if test="${hasWantlist==true}">
					<p>Browse your wantlist and start to swap your wax ;-)</p>
					<%@include file="wantlistTableForm.jsp"%>
				</c:if>
				<c:if test="${hasWantlist==false}">
					You have no wantlist to display. Import your wantlist from Discogs.
					<%@include file="importWantlistForm.jsp"%>
				</c:if>
			</div>

			
			<!-- ALBUMS USER SWAPS -->
			<div id="propositions" class="tab-pane fade">
				<h2 class="text-center">albums you swap</h2>
				<c:if test="${userSwapPropositions.size()!=0}">
				<%@include file="myAlbumsToSwap.jsp"%>
				</c:if>
			</div>

			
		<!-- End of Tab Content -->	
		</div>
		
	</div>

	<div class="col-md-1"></div>
	
	</div>

</body>

</html>