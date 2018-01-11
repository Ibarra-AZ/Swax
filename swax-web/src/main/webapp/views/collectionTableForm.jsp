<%@ page language="java" contentType="text/html; charset=utf-8"	isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<form:form>
<table id="dataTable" class="table table-hover table-bordered table-condensed">
	<thead>
		<tr class="active">
			<th>Artist/Album info</th>
			<th>Condition Media/Sleeve</th>
			<th>Notes</th>
			<th>Added</th>
			<th>Discogs</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${userCollection}" var="album">
			<tr>
				<td>
					<a href="album?${album.albumId}"><strong><c:out value="${album.artist} - ${album.albumName}" /></strong></a><br/>
					<span class="small"><c:out value="${album.format}" /></span><br/>
					<span class="small"><c:out value="${album.label} - ${album.catalogNumber}" /></span><br/>
					<span class="small"><c:out value="${album.releaseDate}" /></span>
				</td>
				<td>
					<c:out value="${album.mediaGrading} - ${album.sleeveGrading}" />
				</td>
				<td>
					<c:out value="${album.notes}" />
				</td>
				<td>
					<c:out value="${album.dateAdded}" />
				</td>
				<td>
					<a href="https://www.discogs.com/release/${album.discogsId}" target="_blank">
					<i class="glyphicon glyphicon-record"></i></a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</form:form>