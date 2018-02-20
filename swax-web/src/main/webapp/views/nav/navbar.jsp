<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/"> <i
				class="glyphicon glyphicon-refresh"></i> SWAX
			</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
<!-- 			<ul class="nav navbar-nav">
				<li class="active"><a href="#"><i class="glyphicon glyphicon-home"></i></a></li>
			</ul> -->
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/signin"><i class="glyphicon glyphicon-log-in"></i>
					<span>sign in</span></a>
				</li>
				<c:if test="${countUsers < maximumUsers}">
				<li><a href="/register"><i class="glyphicon glyphicon-user"></i>
					<span>sign up</span></a>
				</li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>