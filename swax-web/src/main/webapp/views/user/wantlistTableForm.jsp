<%@ page language="java" contentType="text/html; charset=utf-8"	isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<form:form>
<table id="wantlistTable" class="table table-hover table-bordered table-condensed">
	<thead>
		<tr class="active">
			<th><spring:message code="wantlistTableForm.th.artist"/></th>
			<th><spring:message code="wantlistTableForm.th.notes"/></th>
			<th><spring:message code="wantlistTableForm.th.added"/></th>
			<th><spring:message code="wantlistTableForm.th.foundOnSwax"/></th>
			<th><spring:message code="wantlistTableForm.th.proposed"/></th>
			<th><spring:message code="wantlistTableForm.th.discogs"/></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${userWantlist}" var="album">
			<tr>
				<td class="col-md-3">
					<a href="album?${album.albumId}"><strong><c:out value="${album.artist} - ${album.albumName}" /></strong></a><br/>
					<span class="small"><c:out value="${album.format}" /></span><br/>
					<span class="small"><c:out value="${album.label} - ${album.catalogNumber}" /></span><br/>
					<span class="small"><c:out value="${album.releaseDate}" /></span>
				</td>
				<td class="col-md-2">
					<c:out value="${album.notes}" />
				</td>
				<td class="col-md-2">
					<c:out value="${album.dateAdded}" />
				</td>
				<td class="col-md-2">
					<c:if test="${album.possibleSwaps.size() != 0}">
						${album.possibleSwaps.size()}
					</c:if>
				</td>
				<td class="col-md-2">
					<c:if test="${album.possibleSwaps.size() != 0}">
						<c:forEach items="${album.possibleSwaps}" var="swapAlbum">
								<c:if test="${perfectMatchesMap.get(swapAlbum.user.userId)!=null}">
									<a href="seePossibleSwapsWith?userId=${swapAlbum.user.userId}">
									<i class="glyphicon glyphicon-user text-danger"></i>
									<span class="text-danger" data-placement="auto" data-toggle="tooltip" 
										title="You have ${perfectMatchesMap.get(swapAlbum.user.userId).size()} album(s) 
										${swapAlbum.user.userName} wants">${swapAlbum.user.userName}
									</span>
									</a>
								</c:if>
								<c:if test="${perfectMatchesMap.get(swapAlbum.user.userId)==null}">
									<a href="seePossibleSwapsWith?userId=${swapAlbum.user.userId}">
									<i class="glyphicon glyphicon-user"></i>
									<span class="text-info">${swapAlbum.user.userName}</span>
									</a>
								</c:if>							
							<br>
						</c:forEach>
					</c:if>
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