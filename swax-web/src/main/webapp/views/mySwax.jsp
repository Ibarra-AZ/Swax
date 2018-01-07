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

		<img class="loader" src="/img/loading.gif" alt="loader" width="40" height="40" />

		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#home">Home</a></li>
			<li><a data-toggle="tab" href="#collection">Collection</a></li>
			<li><a data-toggle="tab" href="#wantlist">Wantlist</a></li>
			<li><a data-toggle="tab" href="#propositions">Propositions</a></li>
		</ul>


		<div class="tab-content">
			<div id="home" class="tab-pane fade in active">
				<h3>HOME</h3>
				<p>Welcome to Swax!</p>
			</div>
			<div id="collection" class="tab-pane fade">
				<h3>Collection</h3>
				<p>Browse your collection</p>
			</div>
			<div id="wantlist" class="tab-pane fade">
				<h3>Wantlist</h3>
				<p>Browse your wantlist</p>
			</div>
			<div id="propositions" class="tab-pane fade">
				<h3>Wantlist</h3>
				<p>See your swaps</p>
			</div>
		</div>
	</div>

	<div class="col-md-1"></div>


</body>

</html>