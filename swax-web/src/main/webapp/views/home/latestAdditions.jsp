<%@ page language="java" contentType="text/html; charset=utf-8"	isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="row text-center">
	<span class="text-muted text-uppercase">Check out the latest additions</span>
</div>

<div class="row">
		<c:forEach items="${latestAdditions}" var="album">
		<div class="col-md-2">
			<div class="img-thumbnail">
				<img src="img/swapAlbums/${album.imgName}" alt="Album Cover" style="width:100%">
				<div class="caption text-center">
					<p>${album.albumCollected.album.artist}<br>
					${album.albumCollected.album.albumName}</p>
					<p>Proposed by <strong>${album.user.userName}</strong></p>
				</div>
			</div>
		</div>
		</c:forEach>
</div>
