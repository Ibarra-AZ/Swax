<%@ page language="java" contentType="text/html; charset=utf-8"
	isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>

<html>

<!-- INCLUDES <head> -->
<%@include file="../head.jsp"%>

<body>

	<!-- INCLUDES MAIN NAVIGATION BAR -->
	<%@include file="../nav/navbar-logged.jsp"%>

	<!-- CONTENT -->

	<div class="col-md-1"></div>

	<div class="col-md-10">

		<img class="loader" src="/img/loading.gif" alt="loader" width="40" height="40" />
		
		<div class="form-group row">
			<div class="text-center col-md-12 well-sm">
				<span class="text-uppercase lead">${album.artist}</span><br>
				<span class="text-info">${album.albumName}, ${album.releaseDate}</span><br>
				<span class="small"><strong>LABEL:</strong> ${album.label}. <strong>CAT#:</strong> ${album.catalogNumber}</span><br>
				<hr style="width: 100%"/>				
			</div>
		</div>
		
 		<form:form id="swapAlbum-form" class="well row" method="post" 
			modelAttribute="swapAlbumModelAttribute" action="swapAlbum"	enctype="multipart/form-data">
	
		<fieldset>
			<div class="row">
			<div class="form-group col-md-8">
				<label class="col-md-12 control-label">Describe your wax</label>
				<div class="col-md-12 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon">
						<i class="glyphicon glyphicon-pencil"></i></span>
						<form:textarea rows="5" path="discogsURL" type="url"
							class="form-control" id="discogsURL"
							placeholder="Your edition, sleeve & media grading, why you want to swap it and what you're searching for..." />
					</div>
				</div>
			</div>
			
			<div class="form-group col-md-4">
				<label class="col-md-12 control-label">Upload a picture</label>
				<div class="inputGroupContainer col-md-12">
					<div class="input-group">
	                	<label class="input-group-addon btn btn-primary">
	                    	<form:input type="file" style="display: none;" path="discogsFilePath" 
	                    	onchange="$('#upload-file-info').html(this.files[0].name)"
	                    	placeholder="Upload a picture !"/>
	                    	<i class="glyphicon glyphicon-upload"></i>
	                    </label>
	                	<span id="upload-file-info" class="form-control col-md-12"></span>
					</div>
				</div>
			</div>
			</div>
	
			<div class="form-group row">
				<!-- <label class="col-md-4 control-label"></label> -->
				<div class="inputGroupContainer">
					<div class="input-group col-md-4 col-md-offset-5">
						<button type="submit" class="btn btn-primary">Propose to swap!</button>
						<a href="/backToMySwax" class="btn btn-warning" role="button">Cancel</a>
					</div>
				</div>
			</div>
	
		</fieldset>
	</form:form>

	</div>
	<div class="col-md-1"></div>

</body>

</html>