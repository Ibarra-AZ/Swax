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

<c:if test="${userSwapPropositions.size()==null}">

	<div class="row text-center">
		<span class="text-muted text-uppercase"><spring:message code="myAlbumsToSwap.cannotDisplay"/></span>
	</div>
	
</c:if>
 
<c:if test="${userSwapPropositions.size() != null}">

	<div class="row text-center">
		<span class="text-muted text-uppercase"><spring:message code="myAlbumsToSwap.checkout"/></span>
	</div>
	
	<div class="row top15">
		<div style="display: table; margin: 0 auto; width: 100%;">
			<c:forEach items="${userSwapPropositions}" var="album">
			<div class="col-md-2">
				<div class="thumbnail">
					<img src="img/swapAlbums/${album.imgName}" alt="Album Cover" style="width:100%">
					<a href="/swapAlbum?albumId=${album.albumCollected.albumCollectedId}">
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

</c:if>
