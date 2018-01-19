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
 </style>
 
<div class="row text-center">
	<span class="text-muted text-uppercase">Check out the latest additions</span>
</div>

<div class="row top15">
	<div style="display: table; margin: 0 auto;">
		<c:forEach items="${latestAdditions}" var="album">
		<div class="col-md-2">
			<div class="thumbnail">
				<img src="img/swapAlbums/${album.imgName}" alt="Album Cover" style="width:100%">
				<a href="viewSwap?albumId=${album.swapAlbumId}">
				<div class="caption text-center a-btn">
					<p>
						<strong>${album.albumCollected.album.artist}</strong><br>
						<small>${album.albumCollected.album.albumName}<br>
						${album.albumCollected.album.releaseDate}</small>
					</p>
				</div>
				</a>
				
			</div>
		</div>
		</c:forEach>
	</div>
</div>

<div class="row top15">
	<div style="display: table; margin: 0 auto;">
		<button type="button" class="btn btn-default btn-lg" data-placement="auto" data-toggle="tooltip" title="View more">
			<span><i class="glyphicon glyphicon-plus"></i></span>
		</button>
		<button type="button" class="btn btn-default btn-lg" data-placement="auto" data-toggle="tooltip" title="Search for swaps">
			<span><i class="glyphicon glyphicon-search"></i></span>
		</button>
	</div>
</div>
