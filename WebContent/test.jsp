<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
                    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Using JQuery Tabs</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<link rel="stylesheet" href="flora.tabs.css" type="text/css"
	media="screen" title="Flora Tabs">
<script type="text/javascript" src="jquery-1.2.6.js"></script>
<script type="text/javascript" src="ui.core.js"></script>
<script type="text/javascript" src="ui.tabs.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#example > ul").tabs();

		// if tab is pressed from these fields, show the next tab
		$("input#zipCode,input#notificationDate").bind("keydown", function(e) {
			var keynum;
			var keychar;
			var numcheck;

			if (window.event) // IE
			{
				keynum = e.keyCode;
			} else if (e.which) // Netscape/Firefox/Opera
			{
				keynum = e.which;
			}
			keychar = String.fromCharCode(keynum);
			numcheck = /\t/;
			if (numcheck.test(keychar)) { //it's a tab
				selectNextTab();
				setFocus();
			}
		});

	});

	function selectNextTab() {
		var $tabs = $('#example > ul').tabs();
		var selected = $tabs.data('selected.tabs');

		switch (selected) {
		case 0:
			$('#example > ul').tabs('select', 1);
			break;

		case 1:
			$('#example > ul').tabs('select', 2);
			break;

		case 2:
			$('#example > ul').tabs('select', 3);
			break;

		}
	}

	function setFocus() {
		var $tabs = $('#example > ul').tabs();
		var selected = $tabs.data('selected.tabs');

		switch (selected) {
		case 1:
			$('input#notificationtype').select();
			break;

		case 2:
			$('input#householdIncome').select();
			break;

		case 3:
			$('input#testInput').select();
			break;
		}

	}
</script>
</head>
<body>

	<div id="example" class="flora">
		<ul>

			<li><a href="#fragment-1"><span>The first thing</span> </a></li>
			<li><a href="#fragment-2"><span>Second Thing</span> </a></li>
			<li><a href="#fragment-3"><span>Thing Three</span> </a></li>
		</ul>
		<div id="fragment-1">
			<table width="98%" align="center">
				<tr>
					<td width="10%">Address 1</td>
					<td><input type="text" id="address1" name="address1"
						tabindex="1" size="45"></td>
				</tr>
				<tr>
					<td>Address 2</td>
					<td><input type="text" name="address2" tabindex="2" size="45">
					</td>
				</tr>
				<tr>
					<td>City</td>
					<td><input type="text" name="city" tabindex="3"></td>
					<td>State</td>
					<td><select tabindex="2">
							<option>Florida</option>
							<option>New York</option>
					</select></td>
					<td>Zip Code</td>
					<td><input type="text" id="zipCode" name="zipCode"
						tabindex="5"></td>
				</tr>
			</table>


		</div>
		<div id="fragment-2">
			<table width="98%" align="center">
				<tr>
					<td width="20%"><span
						style="text-decoration: none; color: black;"> Notification
							Type</span></td>
					<td colspan="2"><input type="text" id="notificationtype"
						tabindex="6"></td>
					<td><span style="color: black">Notificaton Date</span></td>
					<td colspan="1"><input type="text" id="notificationDate"
						name="notificationDate" tabindex="7"></td>
				</tr>
			</table>

		</div>
		<div id="fragment-3">
			<table width="98%" align="center">
				<tr>
					<td width="20%"><span
						style="text-decoration: none; color: black;">Test Select</span></td>
					<td colspan="2"><select id="testSelect" tabindex="8">
							<option>One thing</option>
							<option>The other Thing</option>
					</select></td>
					<td><span style="color: black">Test Input</span></td>
					<td colspan="1"><input type="text" id="testInput"
						name="testInput" tabindex="9"></td>
				</tr>
			</table>
		</div>
	</div>


</body>
</html>
