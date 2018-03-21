<%@ page language="java" contentType="text/html; charset=utf-8"	isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- SWAX CSS STYLES -->
<link rel="stylesheet" type="text/css" href="../../css/seePossibleSwapsWith.css"/>

<html>

<!-- INCLUDES <head> -->
<%@include file="../head.jsp"%>

<body>

	<!-- INCLUDES MAIN NAVIGATION BAR -->
	<%@include file="../nav/navbar-logged.jsp"%>

	<!-- CONTENT -->
	
	<div class="container col-md-12" style="margin-top:50px">

	<div class="col-md-1"></div>
	
	<form:form id="seePossibleSwaps-form" modelAttribute="selectSwapsModelAttribute">
	
	<div class="col-md-10">

		<div class="row col-md-12 text-center" style="display: table; margin: 0 auto; padding: 0;">
			<h2><spring:message code="seePossibleSwax.h2.title"/></h2>
			<p class="text-info text-justify"><spring:message code="seePossibleSwax.info"/></p>
		</div>
		
		<div id="userToSwapWith" class="row top5 col-md-12" style="">
			<div class="text-center text-danger">${userToSwapWith.userName}'s albums</div>
			<c:if test="${albumsUserToSwapWithWants.size()==0 || albumsUserToSwapWithWants==null}">
				<p class="col-md-12 text-center"><spring:message code="seePossibleSwax.info.noMatch"/> ${userToSwapWith.userName}.</p>
			</c:if>
			<c:if test="${albumsUserToSwapWithWants.size() != 0 && albumsUserToSwapWithWants != null}">
				<p class="col-md-12 text-center">${albumsUserToSwapWithWants.size()} <spring:message code="seePossibleSwax.info.match"/> ${userToSwapWith.userName}.</p>
			</c:if>
			
			<div style="display: table; margin: 0 auto; margin-top: 15px; width: 100%;">
				<c:forEach items="${albumsUserConnectedWants}" var="album">
					<div class="col-md-2" style="padding: 5px;">
						<div class="thumbnail">
							<img src="img/swapAlbums/${album.imgName}" alt="Album Cover" style="width:100%">
						<%-- <a href="viewSwap?albumId=${album.swapAlbumId}"> --%>
						<div role="button" class="caption text-center a-btn ${album.waxValue}" 
							data-target="#infoModal${album.swapAlbumId}" data-toggle="modal"
							data-placement="auto" data-toggle="tooltip" title="Click for info">
							<div><strong>${album.album.artist}</strong></div>
							<div><small>${album.album.albumName}</small></div>
							<div><small>${album.album.releaseDate}</small></div>
						</div>
						<div class="text-center" style="margin: 0; padding: 0;"><form:checkbox path="albumsSelected" value="${album.swapAlbumId}"></form:checkbox></div>
						<!-- </a> -->
						</div>
					</div>
					<!-- Modal -->
					<div id="infoModal${album.swapAlbumId}" class="modal fade" role="dialog" style="top: 100px;">
					  <div class="modal-dialog">
					    <!-- Modal content-->
					    <div class="modal-content panel panel-default">
					      <div class="modal-header panel-heading">
					        <button type="button" class="close" data-dismiss="modal">&times;</button>
					        <h4 class="modal-title text-center">${album.album.artist}<br><small>${album.album.albumName}</small></h4>
					      </div>
					      <div class="modal-body panel-body">
					        <p>Media grading: ${album.mediaGrading}.<br>
					        	Sleeve grading: ${album.sleeveGrading}<br>
					        	<br>${album.description}</p>
					      </div>
					    </div>
					  </div>
					</div>
				</c:forEach>
			</div>
		</div>
		
		<div class="form-group">
			<div class="inputGroupContainer">
				<div class="input-group col-md-12">
					<div style="display: table; margin: 0 auto;">
					<!-- <button type="submit" class="btn btn-primary">Change Profile</button> -->
					<a href="/seeUserSwaps?userId=${userToSwapWith.userId}" class="btn btn-danger" role="button">
						All ${userToSwapWith.userName}'s albums</a>
					<a href="/sendProposition" class="btn btn-success" role="button">Send a proposition</a>
					<a href="/backToMySwax" class="btn btn-warning" role="button">Cancel</a>
					</div>
				</div>
			</div>
		</div>
		
		</div>
		
		</form:form>
		
		<div class="col-md-1"></div>
		
		</div>
		
		
		
		
		
<!-- 		</div> -->

</body>
</html>