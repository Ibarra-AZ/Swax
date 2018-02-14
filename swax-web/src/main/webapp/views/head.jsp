<head>
<title>SWAX, swap your wax!</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="shortcut icon" type="image/x-icon" href="http://swax.fr/favicon.png">

<!-- BOOTSTRAP3 LINKS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- END OF BOOTSTRAP3 LINKS -->

<!-- BOOTSTRAP VALIDATOR LINK -->
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js">
</script>
<!-- END OF BOOTSTRAP VALIDATOR LINK -->

<!-- JQuery Form Validator -- A TESTER +
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>
 -->

<!-- DATATABLES LINKS -->
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css"/>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
<!-- END OF DATATABLES LINKS -->

<!-- GIF LOADER MANAGER -->
<script type="text/javascript">
	addEventListener("load", function(event) {
		$(".loader").hide();
	});
</script>

<!-- ENABLING DATATABLE & BOOTSTRAP TOOLTIP PLUGIN -->
<script type="text/javascript">
	$(document).ready(function(){
	    $('#collectionTable').DataTable({
	    	"aaSorting": [[ 4, "desc" ]]
	    } );
	    $('#wantlistTable').DataTable( {
	    	"aaSorting": [[ 4, "desc" ]]
	    } );
	    $('#swapAlbumsTable').DataTable( {
	    	"aaSorting": [[ 2, "desc" ]]
	    } );
	    $('[data-toggle="tooltip"]').tooltip();
	});
</script>

<!-- SWAX CSS STYLES -->
<link rel="stylesheet" type="text/css" href="../css/head.css"/>

</head>