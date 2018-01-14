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
		<div class="form-group">
		<h3><span class="text-center col-md-12 well-sm label label-success">
			${album.artist} - ${album.albumName}</span></h3><br/>
		</div>
		<span class="well">${album.format}</span><br/>
		<span class="well">${album.label} - ${album.catalogNumber}</span><br/>
		<span class="well">${album.releaseDate}</span><br/>
		
		<form:form id="swapAlbum-form" class="well form-horizontal" method="post" 
			modelAttribute="swapAlbumModelAttribute" action="swapAlbum"	enctype="multipart/form-data">
	
		<fieldset>
	
			<div class="form-group">
				<label class="col-md-4 control-label">Discogs User URL</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon">
						<i class="glyphicon glyphicon-download-alt"></i></span>
<%-- 						<form:input path="discogsURL" type="url"
							class="form-control" id="discogsURL"
							placeholder="https://www.discogs.com/fr/user/User_Name" />
 --%>					</div>
				</div>
			</div>
			<div style="text-align: center;">OR<br/></div>
			<div class="form-group">
				<label class="col-md-4 control-label">Upload discogs CSV file</label>
				<div class="inputGroupContainer col-md-4">
					<div class="input-group">
	                	<label class="input-group-addon btn btn-primary">
<%-- 	                    	<form:input type="file" style="display: none;" path="discogsFilePath" 
	                    	onchange="$('#upload-file-info').html(this.files[0].name)"/>
 --%>	                    	<i class="glyphicon glyphicon-upload"></i>
	                    </label>
	                	<span id="upload-file-info" class="form-control col-md-8"></span>
					</div>
				</div>
			</div>
	
			<div class="form-group">
				<label class="col-md-4 control-label"></label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<button type="submit" class="btn btn-primary">Import</button>
					</div>
				</div>
			</div>
	
		</fieldset>
	</form:form>

	</div>
	<div class="col-md-1"></div>

</body>

</html>