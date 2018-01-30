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
</style>

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
			<span class="text-muted text-uppercase">Possible Swaps !</span>
		</div>

		<div class="row top15 col-md-12">
		
		<div id="userConnected" class="col-md-6" style="background-color: #F8F8F8; border-right-style: solid;">
			<div class="text-muted text-center text-info">I HAVE, ${userToSwapWith.userName} WANTS</div>
			<div style="display: table; margin: 0 auto;">
				<c:forEach items="${albumsUserToSwapWithWants}" var="album">
					<div class="col-md-4">
						<div class="thumbnail">
							<img src="img/swapAlbums/${album.imgName}" alt="Album Cover" style="width:100%">
							<div class="caption text-center">
								<div><strong>${album.album.artist}</strong></div>
								<div><small>${album.album.albumName}</small></div>
								<div><small>${album.album.releaseDate}</small></div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		
		<div id="userToSwapWith" class="col-md-6"  style="border-left-style: solid;">
		<div class="text-muted text-center text-danger">${userToSwapWith.userName} HAS, I WANT</div>
			<div style="display: table; margin: 0 auto;">
				<c:forEach items="${albumsUserConnectedWants}" var="album">
					<div class="col-md-4">
						<div class="thumbnail">
							<img src="img/swapAlbums/${album.imgName}" alt="Album Cover" style="width:100%">
						<a href="viewSwap?albumId=${album.swapAlbumId}">
						<div class="caption text-center a-btn">
							<div><strong>${album.album.artist}</strong></div>
							<div><small>${album.album.albumName}</small></div>
							<div><small>${album.album.releaseDate}</small></div>
							</div>
							</a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		
		</div>
		
		</div>

</body>
</html>