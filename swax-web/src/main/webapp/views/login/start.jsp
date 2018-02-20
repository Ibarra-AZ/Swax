<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>

<style>
	.row {
		margin-left: 0 !important;
		margin-right: 0 !important;
	}
</style>

   	<!-- INCLUDES <head> -->
	<%@include file="../head.jsp" %> 
	
    <body>
    
    	<!-- INCLUDES MAIN NAVIGATION BAR -->
		<%@include file="../nav/navbar.jsp" %>
			
		<!-- CONTENT -->
			
			<div class="row" style="margin-top: 50px;">
				<div class="col-md-12">
					<h2 class="" style="display: table; margin: 0 auto; margin-top: 15px;">what to do with swax</h2>
				<p class="text-center" style="margin-top: 0px;">"swap your wax", </p>
				<p class="text-center text-danger" style="margin: 0px;">
					<small><i class="glyphicon glyphicon-user"></i> ${countUsers} users to trade with. 
					<i class="glyphicon glhicon-record"></i> ${countSwaps} vinyls to swap.</small>
				</p>
				<c:if test="${countUsers >= maximumUsers}">
					<p class="text-center text-primary" style="margin-top: 0px;">
					Sorry, this app is in a beta test phase and we can't have more users for now. Please, come back soon.
					</p>
				</c:if>
				</div>
			</div>
			
			<div class="row" style="display: table; margin: 0 auto; margin-top: 5px;">
			
			<div class="col-md-12" style="display: table; margin: 0 auto; margin-top: 5px;">
			
			<div class="col-md-3">
				<div class="thumbnail">
					<img src="img/swax-retriever-grey256.jpg" alt="retrieve-img" style="width:100%">
					<div class="caption text-center">
						<div class="text-info"><strong>retrieve</strong></div>
						<div><small>Sign up to swax and automatically <strong class="text-info">retrieve</strong> your collection and wantlist from discogs with your discogs user name. 
							Browse your collection and pick up the albums you want to swap.</small>
						</div>
					</div>	
				</div>
			</div>
			
			<div class="col-md-3">
				<div class="thumbnail">
					<img src="img/swax-matches-grey256.jpg" alt="matches-img" style="width:100%">
					<div class="caption text-center">
						<div class="text-danger"><strong>match</strong></div>
						<div><small>Browse your wantlist and discover who proposes to swap albums you're searching for. 
							Swax also finds perfect <strong class="text-danger">matches</strong> when you can also provide albums to users who have albums you seek.</small>
						</div>
					</div>	
				</div>
			</div>
			
			<div class="col-md-3">
				<div class="thumbnail">
					<img src="img/swax-explorer-grey256.jpg" alt="explorer-img" style="width:100%">
					<div class="caption text-center">
						<div class="text-success"><strong>explore</strong></div>
						<div><small><strong class="text-success">Explore</strong> the latest additions to swax or the other users albums proposed for swapping. 
							Send propositions and invite users to check your albums too. Discuss, trade and swap !</small>
						</div>
					</div>		
				</div>
			</div>
			
			<div class="col-md-3">
				<div class="thumbnail">
					<img src="img/swax-deal-grey256.jpg" alt="deal-img" style="width:100%">
					<div class="caption text-center">
						<div class="text-warning"><strong>deal</strong></div>
						<div><small>Manage your propositions and make a <strong class="text-warning">deal</strong> when all is fair for everyone. 
							The two users involved in a swap have always the choice to modify a proposition until it's fair.</small>
						</div>
					</div>	
				</div>
			</div>

			</div>
		</div>
			
	</body>

</html>