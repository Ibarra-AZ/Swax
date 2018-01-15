<%@ page language="java" contentType="text/html; charset=utf-8"	isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<form:form id="importWantlist-form" class="well form-horizontal" 	method="post" 
	modelAttribute="importWantlistModelAttribute" action="importDiscogsWantlist"
	enctype="multipart/form-data">

	<legend>Import your Wantlist from Discogs</legend>

	<fieldset>

		<div class="form-group">
			<label class="col-md-4 control-label">Discogs User URL</label>
			<div class="col-md-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon">
					<i class="glyphicon glyphicon-download-alt"></i></span>
					<form:input path="wantlistURL" type="url"
						class="form-control" id="wantlistURL"
						placeholder="https://www.discogs.com/fr/user/User_Name" />
				</div>
			</div>
		</div>
		
		<div style="text-align: center;">OR<br/></div>
		
		<div class="form-group">
			<label class="col-md-4 control-label">Upload discogs CSV file</label>
			<div class="inputGroupContainer col-md-4">
				<div class="input-group">
                	<label class="input-group-addon btn btn-primary">
                    	<form:input type="file" style="display: none;" path="wantlistFilePath" 
                    	onchange="$('#upload-wantlist-info').html(this.files[0].name)"/>
                    	<i class="glyphicon glyphicon-upload"></i>
                    </label>
                	<span id="upload-wantlist-info" class="form-control col-md-8"></span>
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