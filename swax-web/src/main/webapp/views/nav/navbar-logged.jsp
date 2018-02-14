<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><span	class="glyphicon glyphicon-refresh"></span> SWAX</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="/backToMySwaxRefresh" data-placement="auto" data-toggle="tooltip" title="Refresh datas and go back home">
					<i class="glyphicon glyphicon-home"></i></a>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">
						<span class="glyphicon glyphicon-user"></span> ${user.userName}
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="/loadUserProfilePage">
							<i class="glyphicon glyphicon-user"></i>
							<span>Change Profile</span></a></li>
						<li><a href="/synchronizeWithDiscogs">
							<i class="glyphicon glyphicon-refresh"></i>
							<span>Synchronize with discogs</span></a></li>
						<li><a href="/logout">
							<i class="glyphicon glyphicon-log-out"></i>
							<span>Log out</span></a></li>
						<li><a href="/deleteAccount">
							<i class="glyphicon glyphicon-volume-off"></i>
							<span>Delete account</span></a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>