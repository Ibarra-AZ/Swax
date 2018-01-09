<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<form:form id="changePassword-form" class="well form-horizontal" method="post" 
	modelAttribute="importCollectionModelAttribute" action="importDiscogsCollection">
	
	<legend>Import your collection from Discogs</legend>
						
	<fieldset>
	
		<div class="form-group">
			<label class="col-md-4 control-label">Discogs User URL</label>
			<div class="col-md-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
					<form:input path="discogsUserUrl" type="url" class="form-control" id="discogsUserUrl" 
						placeholder="https://www.discogs.com/fr/user/User_Name" />
				</div>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-4 control-label"></label>
			<div class="col-md-4 inputGroupContainer">
				<div class="input-group">
					<button type="submit" class="btn btn-primary">Import</button>
					<a href="/backToMySwax" class="btn btn-warning" role="button">Cancel</a>
				</div>
			</div>
		</div>
	
	</fieldset>
	
</form:form>