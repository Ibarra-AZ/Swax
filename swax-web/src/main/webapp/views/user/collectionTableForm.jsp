<%@ page language="java" contentType="text/html; charset=utf-8"	isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<form:form id="collectionTable-form" modelAttribute="importCollectionModelAttribute">
<table id="collectionTable" class="table table-hover table-bordered table-condensed">
	<thead>
		<tr class="active">
			<th><spring:message code="collectionTableForm.th.swap"/></th>
			<th><spring:message code="collectionTableForm.th.artist"/></th>
			<th><spring:message code="collectionTableForm.th.condition"/></th>
			<th><spring:message code="collectionTableForm.th.notes"/></th>
			<th><spring:message code="collectionTableForm.th.added"/></th>
			<th><spring:message code="collectionTableForm.th.discogs"/></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${userCollection}" var="album">
			<tr>
				<td class="col-md-1">
					<c:url value="/swapAlbum" var="swapUrl">
					<c:param name="albumId" value="${album.albumId}"/>
					</c:url>
					<spring:message code="collectionTableForm.swapToolTip" var="swapToolTip"/>
					<a href="${swapUrl}" data-placement="auto" data-toggle="tooltip" title="${swapToolTip}">
					<i class="glyphicon glyphicon-retweet"></i></a>
				</td>
				<td class="col-md-3">
					<a href="/swapAlbum?albumId=${album.albumId}">
						<strong><c:out value="${album.artist} - ${album.albumName}" /></strong>
					</a><br/>
					<span class="small"><c:out value="${album.format}" /></span><br/>
					<span class="small"><c:out value="${album.label} - ${album.catalogNumber}" /></span><br/>
					<span class="small"><c:out value="${album.releaseDate}" /></span>
				</td>
				<td class="col-md-2">${album.mediaGrading}<br>${album.sleeveGrading}</td>
				<td class="col-md-3">
					<c:out value="${album.notes}" />
				</td>
				<td class="col-md-2">
					<c:out value="${album.dateAdded}" />
				</td>
				<td class="col-md-1">
					<a href="https://www.discogs.com/release/${album.discogsId}" target="_blank">
					<i class="glyphicon glyphicon-record"></i></a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</form:form>