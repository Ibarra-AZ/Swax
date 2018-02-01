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
	.Gold {
		background-color: e5b73b /* #FFDF00 */;
	}
	.Silver {
		background-color: #C0C0C0;
	}
	.Bronze {
		background-color: #cd7f32;
	}
	
</style>

<html>

<!-- INCLUDES <head> -->
<%@include file="../head.jsp"%>

<body>

	<!-- INCLUDES MAIN NAVIGATION BAR -->
	<%@include file="../nav/navbar-logged.jsp"%>

	<!-- CONTENT -->

	<div class="col-md-1"></div>
	
	<form:form id="seePossibleSwaps-form" modelAttribute="seePossibleSwapsModelAttribute">
	
	<div class="col-md-10">

		<div class="row text-center">
			<h2 class="text-center">possible swaps</h2>
		</div>

		<div class="form-group">
			<div class="inputGroupContainer">
				<div class="input-group col-md-12">
					<div style="display: table; margin: 0 auto;">
					<!-- <button type="submit" class="btn btn-primary">Change Profile</button> -->
					<a href="/userProfile?userId=${userToSwapWith.userId}" class="btn btn-danger" role="button">
						All ${userToSwapWith.userName}'s albums</a>
					<a href="/sendProposition" class="btn btn-success" role="button">Send a proposition</a>
					<a href="/backToMySwax" class="btn btn-warning" role="button">Cancel</a>
					</div>
				</div>
			</div>
		</div>

		<div class="row top15 col-md-12">
		
		<table>
		<tr>
		<td class="col-md-6" style="border-right-style: solid; vertical-align: top;">
		<div id="userConnected" class="" style="" >
			<div class="text-center text-info">Your albums</div>
			<c:if test="${albumsUserToSwapWithWants.size()==0 || albumsUserToSwapWithWants==null}">
				<div class="row top15 col-md-12 text-justify">You don't have any albums to propose to ${userToSwapWith.userName}. However, you 
					can send an invitation for him to check out the albums you swap.
				</div>
			</c:if>
			<c:if test="${albumsUserToSwapWithWants.size() != 0}">
			<div style="display: table; margin: 0 auto; margin-top: 15px;">
				<c:forEach items="${albumsUserToSwapWithWants}" var="album">
					<div class="col-md-4" style="padding: 5px;">
						<div class="thumbnail">
							<img src="img/swapAlbums/${album.imgName}" alt="Album Cover" style="width:100%">
							<div class="caption text-center ${album.waxValue}">
								<div><strong>${album.album.artist}</strong></div>
								<div><small>${album.album.albumName}</small></div>
								<div><small>${album.album.releaseDate}</small></div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			</c:if>
		</div>
		</td>
		
		<td class="col-md-6" style="border-left-style: solid; vertical-align: top;">
		<div id="userToSwapWith" class="" style="">
		<div class="text-center text-danger">${userToSwapWith.userName}'s albums</div>
			<div style="display: table; margin: 0 auto; margin-top: 15px;">
				<c:forEach items="${albumsUserConnectedWants}" var="album">
					<div class="col-md-4" style="padding: 5px;">
						<div class="thumbnail">
							<img src="img/swapAlbums/${album.imgName}" alt="Album Cover" style="width:100%">
						<%-- <a href="viewSwap?albumId=${album.swapAlbumId}"> --%>
						<div class="caption text-center a-btn ${album.waxValue}"
							data-placement="auto" data-toggle="tooltip" title="Sleeve is ${album.sleeveGrading},  
							Media is ${album.mediaGrading}. ${album.description}">
							<div><strong>${album.album.artist}</strong></div>
							<div><small>${album.album.albumName}</small></div>
							<div><small>${album.album.releaseDate}</small></div>
							<div><form:checkbox path="albumsSelected" value="${album.swapAlbumId}"></form:checkbox></div>
						</div>
						<!-- </a> -->
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		</td>
		
		</tr>
		</table>
		
		</div>
		
		</div>
		
		</form:form>

</body>
</html>