<!doctype html>
<html lang="us">
<head>
	<meta charset="utf-8">
	<title>jQuery UI Example Page</title>
	<link href="css/smoothness/jquery-ui-1.10.0.custom.css" rel="stylesheet">
	<script src="js/jquery-1.9.0.js"></script>
	<script src="js/jquery-ui-1.10.0.custom.js"></script>
	<script>
	$(function() {
		
		$( "#button" ).button();
		
		$( "#tabs" ).tabs();
	});
	</script>
	<style>
	body{
		font: 62.5% "Trebuchet MS", sans-serif;
		margin: 50px;
	}
	.demoHeaders {
		margin-top: 2em;
	}
	#dialog-link {
		padding: .4em 1em .4em 20px;
		text-decoration: none;
		position: relative;
	}
	#dialog-link span.ui-icon {
		margin: 0 5px 0 0;
		position: absolute;
		left: .2em;
		top: 50%;
		margin-top: -8px;
	}
	#icons {
		margin: 0;
		padding: 0;
	}
	#icons li {
		margin: 2px;
		position: relative;
		padding: 4px 0;
		cursor: pointer;
		float: left;
		list-style: none;
	}
	#icons span.ui-icon {
		float: left;
		margin: 0 4px;
	}
	.fakewindowcontain .ui-widget-overlay {
		position: absolute;
	}
	</style>
</head>
<body>
<button id="billerMode">Biller Mode</button>
<button id="logout">LogOut</button>

<div id="tabs">
	<ul>
		<li><a href="#tabs-1">PT Schedule</a></li>
		<li><a href="#tabs-2">Open Record</a></li>
		<li><a href="#tabs-3">New Record</a></li>
		<li><a href="#tabs-4">Check-In</a></li>
		<li><a href="#tabs-5">Fax-In</a></li>
		<li><a href="#tabs-6">Fax-Out</a></li>

	</ul>
	<div id="tabs-1">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</div>
	<div id="tabs-2">Phasellus mattis tincidunt nibh. Cras orci urna, blandit id, pretium vel, aliquet ornare, felis. Maecenas scelerisque sem non nisl. Fusce sed lorem in enim dictum bibendum.</div>
	<div id="tabs-3">Nam dui erat, auctor a, dignissim quis, sollicitudin eu, felis. Pellentesque nisi urna, interdum eget, sagittis et, consequat vestibulum, lacus. Mauris porttitor ullamcorper augue.</div>
</div>

</body>
</html>
