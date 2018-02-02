<nav class="navbar navbar-inverse navbar-fixed-top">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-refresh"></span> SWAX</a>
	    </div>
	    <div class="collapse navbar-collapse" id="myNavbar">
	      <ul class="nav navbar-nav">
	        <li><a href="/backToMySwax"><i class="glyphicon glyphicon-home"></i></a></li>
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
	        <li><a href="/loadUserProfilePage" data-placement="auto" data-toggle="tooltip" 
	        	title="<spring:message code="navbarLogged.tooltip.profile"/>">
	        	<span class="glyphicon glyphicon-user"></span> ${user.userName}</a></li>
	        <li><a href="/logout" data-placement="auto" data-toggle="tooltip" 
	        	title="<spring:message code="navbarLogged.tooltip.logout"/>">
	        	<span class="glyphicon glyphicon-log-out"></span></a></li>
	      </ul>
	    </div>
	  </div>
</nav>