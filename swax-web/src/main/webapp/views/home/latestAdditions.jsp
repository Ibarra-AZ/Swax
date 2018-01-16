<%@ page language="java" contentType="text/html; charset=utf-8"	isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="row text-center">
	<span class="text-muted text-uppercase">Check out the latest
		additions</span>
</div>
<div class="row">
	<c:forEach items="${latestAdditions}" var="album">
		<div class="col-md-2">
		<img src="img/swapAlbums/${album.imgName}" class="img-thumbnail"
			alt="Album Cover" width="300" height="300">
	</div>
	</c:forEach>
	<!-- <div class="col-md-2">
		<img src="img/swapAlbums/cover1.jpg" class="img-thumbnail"
			alt="Album Cover" width="300" height="300">
	</div>
	<div class="col-md-2">
		<img src="img/swapAlbums/cover2.jpg" class="img-thumbnail"
			alt="Album Cover" width="300" height="300">
	</div>
	<div class="col-md-2">
		<img src="img/swapAlbums/cover3.jpg" class="img-thumbnail"
			alt="Album Cover" width="300" height="300">
	</div>
	<div class="col-md-2">
		<img src="img/swapAlbums/cover4.jpg" class="img-thumbnail"
			alt="Album Cover" width="300" height="300">
	</div>
	<div class="col-md-2">
		<img src="img/swapAlbums/cover5.jpg" class="img-thumbnail"
			alt="Album Cover" width="300" height="300">
	</div>
	<div class="col-md-2">
		<img src="img/swapAlbums/cover6.jpg" class="img-thumbnail"
			alt="Album Cover" width="300" height="300">
	</div>
 --></div>
