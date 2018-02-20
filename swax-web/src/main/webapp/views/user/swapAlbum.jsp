<%@ page language="java" contentType="text/html; charset=utf-8"
	isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE html>

<html lang="en" xmlns:th="http://www.thymeleaf.org">

<style>

p.text-info {
	border-left: solid;
	border-radius: 5px; 
	border-right: solid;
	padding: 10px;
	margin-bottom: 15px;
}

</style>


<!-- INCLUDES <head> -->
<%@include file="../head.jsp"%>

<body>

	<!-- INCLUDES MAIN NAVIGATION BAR -->
	<%@include file="../nav/navbar-logged.jsp"%>

	<!-- INCLUDES JS FORM VALIDATION -->
	<!-- WARN: INCLUDES PREVIEW IMG JS TOO -->
	<script><%@include file="../js-validator/swapAlbum-js-validator.js" %></script>

	<!-- CONTENT -->
	
	<div class="container col-md-12" style="margin-top:50px">

	<div class="col-md-1"></div>

	<div class="col-md-10">

		<img class="loader" src="/img/loading.gif" alt="loader" width="40" height="40" />
		
		<div class="form-group row">
			<div class="text-center col-md-12 well-sm">
				<span class="text-uppercase lead">${album.artist}</span><br>
				<span class="text-danger">${album.albumName}, ${album.releaseDate}</span><br>
				<span class="small"><strong>LABEL:</strong> ${album.label}. <strong>CAT#:</strong> ${album.catalogNumber}</span><br>
				<hr style="width: 100%; padding:0; margin-bottom: 0;"/>				
			</div>
		</div>
		
		<div class="row" style="margin-top: 0; margin-bottom: 10px;">
			<p class="text-info text-justify"><spring:message code="swapAlbum.info"/></p>
		</div>
		
 		<form:form id="swapAlbum-form" class="well row" method="post" 
			modelAttribute="swapAlbumModelAttribute" action="saveAndSwapAlbum"	enctype="multipart/form-data">
			
		<form:hidden path="albumId" value="${album.albumId}"></form:hidden>
	
		<fieldset>
			<div class="row">
			<div class="form-group col-md-8">
				<div class="col-md-12 inputGroupContainer" style="margin-bottom: 16px">
					<label class="col-md-12 control-label"><spring:message code="swapAlbum.form.grade.media"/></label>
					<div class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-record"></i></span>
						 <form:select path="mediaGrading" class="form-control selectpicker" data-live-search="true">
						      <option selected>${mediaGrading}</option>
						<%@include file="../utils/gradings.jsp" %>
						</form:select>
					</div>
				</div>
			
				<div class="col-md-12 inputGroupContainer" style="margin-bottom: 16px">
					<label class="col-md-12 control-label"><spring:message code="swapAlbum.form.grade.sleeve"/></label>
					<div class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-picture"></i></span>
						<form:select path="sleeveGrading" class="form-control selectpicker" data-live-search="true">
						      <option selected>${sleeveGrading}</option>
						<%@include file="../utils/gradings.jsp" %>
						</form:select>
					</div>	
				</div>
				
				<div class="col-md-12 inputGroupContainer" style="margin-bottom: 16px">
					<label class="col-md-12 control-label"><spring:message code="swapAlbum.form.waxValue"/></label>
					<div class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-piggy-bank"></i></span>
						<select name="waxValue" class="form-control selectpicker" data-live-search="true">
						      <option selected>${waxValue}</option>
						<%@include file="../utils/waxValues.jsp" %>
						</select>
					</div>	
				</div>
			
				<div class="col-md-12 inputGroupContainer">	
					<label class="col-md-12 control-label"><spring:message code="swapAlbum.form.description"/></label>		
					<div class="input-group">
						<span class="input-group-addon">
						<i class="glyphicon glyphicon-pencil"></i></span>
						<textarea form="swapAlbum-form" rows="5" name="description" class="form-control"
							placeholder="Your edition, sleeve & media grading, why you want to swap it and what you're searching for...">${description}</textarea>
					</div>
				</div>
			</div>
			
			<div class="form-group col-md-4">
				<label class="col-md-12 control-label" 
				data-placement="auto" data-toggle="tooltip" title="Upload a picture of the album from your collection. 
				ONLY jpg acccepted"><spring:message code="swapAlbum.form.upload"/></label>

				
				<div class="inputGroupContainer col-md-12" style="margin-bottom: 10px">
					<div class="input-group">
	                	<label class="input-group-addon btn btn-primary">
	                    	<form:input id="uploadImg" type="file" style="display: none;" path="imgFilePath" 
	                    	value="" onchange="$('#uploadFileInfo').html(this.files[0].name)" />
	                    	<i class="glyphicon glyphicon-upload"></i>
	                    </label>
	                	<span id="uploadFileInfo" class="form-control col-md-12"></span>
					</div>
				</div>
				<br>
				<c:if test="${!errorMsg.equals('')}">
					<span class="text-danger col-md-12">${errorMsg}</span>
				</c:if>
				<div class="col-md-12">
					<img src="img/swapAlbums/${imgURL}" id="imgId" class="img-thumbnail" alt="Album Cover" height="400" width="400">
				</div>
			</div>
			</div>
	
			<div class="form-group row">
				<!-- <label class="col-md-4 control-label"></label> -->
				<div class="inputGroupContainer">
					<div class="input-group col-md-12">
						<div style="display: table; margin: 0 auto;">
						<spring:message code="swapAlbum.button.saveSwap.tooltip" var="saveSwapTooltip"/>
						<button type="submit" class="btn btn-primary" name="albumToSwap" value="true"
							data-placement="auto" data-toggle="tooltip" 
							title="${saveSwapTooltip}">
							<spring:message code="swapAlbum.button.saveSwap"/></button>
						<spring:message code="swapAlbum.button.saveRemove.tooltip" var="saveRemoveTooltip"/>	
						<button type="submit" class="btn btn-info" name="albumToSwap" value="false"
							data-placement="auto" data-toggle="tooltip" 
							title="${saveRemoveTooltip}">
							<spring:message code="swapAlbum.button.saveRemove"/></button>
							
						<a href="/backToMySwax" class="btn btn-warning" role="button">
						<spring:message code="swapAlbum.button.cancel"/></a>
						</div>
					</div>
				</div>
			</div>
	
		</fieldset>
	</form:form>

	</div>
	<div class="col-md-1"></div>
	
	</div>

</body>

</html>