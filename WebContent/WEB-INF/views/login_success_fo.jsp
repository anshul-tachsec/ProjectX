<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<!-- <!doctype html> -->
<html lang="us">
<head>
<%@taglib uri="/struts-tags" prefix="s"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<title>Front Office Home Page</title>
</head>
<link href="css/smoothness/jquery-ui-1.10.0.custom.css" rel="stylesheet">
<script src="js/jquery-1.9.0.js"></script>
<script src="js/jquery-ui-1.10.0.custom.js"></script>
<link rel='stylesheet' type='text/css' href='fc/fullcalendar.css' />
<link rel='stylesheet' type='text/css' href='fc/fullcalendar.print.css'
	media='print' />
<script type='text/javascript' src='fc/fullcalendar.min.js'></script>

<style>
body {
	font: 62.5% "Trebuchet MS", sans-serif;
	margin: 0px;
	padding: 0px;
	height: 100%;
	overflow: hidden;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
}

#calendar {
	width: 72%;
	margin: 0 auto;
}
</style>
<script type="text/javascript" charset="utf-8">
	$(document)
			.ready(
					function() {
						var calendar = $('#calendar');
						calendar
								.fullCalendar({
									slotMinutes : 15,
									defaultView : "agendaDay",
									defaultEventMinutes : 15,
									header : {
										left : 'prev,next today',
										center : 'title',
										right : 'agendaDay,agendaWeek,month'
									},
									editable : true,
									theme : true,
									selectable : true,
									selectHelper : true,
									events : "fc/json-events.php",

									loading : function(bool) {
										if (bool)
											$('#loading').show();
										else
											$('#loading').hide();
									},
									select : function(start, end, allDay) {
										$('#eventStart').datepicker("setDate",
												new Date(start));
										$('#eventEnd').datepicker("setDate",
												new Date(end));
										$('#calEventDialog').dialog('open');
									},
									eventClick : function(calEvent, jsEvent,
											view) {
										$('#eventStart').datepicker("setDate",
												new Date(calEvent.start));
										$('#eventEnd').datepicker("setDate",
												new Date(calEvent.end));
										$('#calEventDialog #eventTitle').val(
												calEvent.title);
										$('#calEventDialog #allday')
												.val(
														[ calEvent.className == "gbcs-halfday-event" ? "1"
																: "2" ]).prop(
														'checked', true);
										$("#calEventDialog")
												.dialog(
														"option",
														"buttons",
														[
																{
																	text : "Save",
																	click : function() {
																		$(this)
																				.dialog(
																						"close");
																	}
																},
																{
																	text : "Delete",
																	click : function() {
																		$(this)
																				.dialog(
																						"close");
																	}
																},
																{
																	text : "Cancel",
																	click : function() {
																		$(this)
																				.dialog(
																						"close");
																	}
																} ]);
										$("#calEventDialog").dialog("option",
												"title", "Edit Event");
										$('#calEventDialog').dialog('open');
									}
								});

						var title = $('#eventTitle');
						var start = $('#eventStart');
						var end = $('#eventEnd');
						var eventClass, color;
						$('#calEventDialog')
								.dialog(
										{
											resizable : false,
											autoOpen : false,
											title : 'Schedule Appointment',
											width : 400,
											buttons : {
												Save : function() {
													if ($(
															'input:radio[name=allday]:checked')
															.val() == "1") {
														eventClass = "gbcs-halfday-event";
														color = "#9E6320";
														end.val(start.val());
													} else {
														eventClass = "gbcs-allday-event";
														color = "#875DA8";
													}
													if (title.val() !== '') {
														$calendar
																.fullCalendar(
																		'renderEvent',
																		{
																			title : title
																					.val(),
																			start : start
																					.val(),
																			end : end
																					.val(),
																			allDay : true,
																			className : eventClass,
																			color : color
																		}, true // make the event "stick"
																);
													}
													$calendar
															.fullCalendar('unselect');
													$(this).dialog('close');
												},
												Cancel : function() {
													$(this).dialog('close');
												}
											}
										});

						$("#billerMode").button();
						$("#logout").button();
						var tabs = $("#tabs, #subtabs").tabs({
							show : function(event, ui) {
								$('#calendar').fullCalendar('render');
							}
						});
						tabs.find(".ui-tabs-nav").sortable({
							axis : "x",
							stop : function() {
								tabs.tabs("refresh");
							}
						});
					});
</script>
<body>
	<button id="billerMode">Biller Mode</button>
	<button id="logout">LogOut</button>
	<div id="tabs">
		<ul>
			<li><a href="#calendar">Schedule</a></li>
			<li><a href="#openRecord">Open Record</a></li>
			<li><a href="#newRecord">New Record</a></li>
			<li><a href="#checkIn">Check-In</a></li>
			<li><a href="#faxIn">Fax-In</a></li>
			<li><a href="#faxOut">Fax-Out</a></li>

		</ul>
		<!-- 		tab for pt schedule -->
		<div id='calendar'></div>
		<div id="calEventDialog">
			<form>
				<fieldset>
					<table>
						<tr>
							<td width="100%"><label for="eventTitle">Patient
									Name</label></td>
							<td><input type="text" name="eventTitle" id="eventTitle" /><br>
							</td>
						</tr>
						<tr>
							<td width="100%"><label for="eventTitle">PT</label></td>
							<td><input type="text" name="eventTitle" id="eventTitle" /></td>
						</tr>
						<tr>
							<td width="100%"><label for="eventTitle">Provider</label></td>
							<td><input type="text" name="eventTitle" id="eventTitle" /></td>
						</tr>
						<tr>
							<td width="100%"><label for="eventTitle">Co-Pay</label></td>
							<td><input type="text" name="eventTitle" id="eventTitle" /></td>
						</tr>
						<tr>
							<td width="100%"><label for="eventTitle">Visits</label></td>
							<td><input type="text" name="eventTitle" id="eventTitle"
								size="2" />/<input type="text" name="eventTitle"
								id="eventTitle" size="2" /></td>

						</tr>
						<tr>
							<td width="100%"><label for="eventStart">Start Time</label></td>
							<td><input type="text" name="eventStart" id="eventStart" /></td>
						</tr>
						<tr>
							<td width="100%"><label for="eventEnd">End Time</label></td>
							<td><input type="text" name="eventEnd" id="eventEnd" /></td>
						</tr>
						<tr>
							<td width=100%>Visit Type</td>
							<td><select name="visitType">
									<option value="I">Initial Eval</option>
									<option value="P/N">Progress Note</option>
									<option value="D/N">Discharge Note</option>
									<option value="R">Regular Visit</option>

							</select></td>
						</tr>
					</table>
				</fieldset>
			</form>
		</div>
		<!-- tab for open record -->
		<div id="openRecord">
			<div id="subtabs">
				<ul>
					<li><a href="#simpleSearch" class="">Simple Search</a></li>
					<li><a href="#advancedSearch">Advanced Search</a></li>
				</ul>
				<div id="simpleSearch">
					<s:form action="PatientFormActionSimpleSearch" method="post">
						<!-- 				main table -->
						<table cellspacing="0" cellpadding="5">
							<tr>
								<td width="50%">
									<table width="100%" border="0" cellspacing="0" cellpadding="1">
										<tr>
											<td width="25%">Patient ID</td>
											<td><input type="text"
												name="patientFormSearch.patientID" tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Last Name</td>
											<td><input type="text" name="patientFormSearch.lastName"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">First Name</td>
											<td><input type="text"
												name="patientFormSearch.firstName" tabindex="2" size="25"></td>
										</tr>


									</table>
								<td width="50%">
									<!-- Table on right side -->
									<table width="100%" border="0" cellspacing="0" cellpadding="1"
										align="right">
										<tr>
											<td width="25%">Cell Phone</td>
											<td><input type="text"
												name="patientFormSearch.cellPhone" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">D.O.B</td>
											<td><input type="text"
												name="patientFormSearch.patientDOB" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Email</td>
											<td><input type="text"
												name="patientFormSearch.patientEmail" tabindex="2" size="25"></td>
										</tr>

									</table>
								</td>
							</tr>
							<tr>
								<s:submit value="Search" />
							</tr>
						</table>
					</s:form>

					<table width="100%" border="0" cellspacing="0" cellpadding="1">

						<tr>
							<td width="25%"><b>Patient ID</b></td>
							<td width="25%"><b>Last Name</b></td>
							<td width="25%"><b>First Name</b></td>
							<td width="25%"><b>Cellphone</b></td>
							<td width="25%"><b>D.O.B</b></td>
							<td width="25%"><b>Email</b></td>

							<s:iterator value="al" status="alStatus">
								<tr>
									<td width="25%"><a
										href="<s:url action="PatientFormActionSearchHyperlink">
											<s:param name="patientFormBean.patientID" value="%{patientID}" />
										</s:url>">${patientID}</a></td>
									<td width="25%"><s:property value="%{lastName}" /></td>
									<td width="25%"><s:property value="%{firstName}" /></td>
									<td width="25%"><s:property value="%{cellPhone}" /></td>
									<td width="25%"><s:property value="%{patientDOB}" /></td>
									<td width="25%"><s:property value="%{patientEmail}" /></td>
								</tr>
							</s:iterator>
					</table>
				</div>

				<div id="advancedSearch">
					<div id="subtabs">
						<ul>
							<li><a href="#demographics" class="">Demographics</a></li>
							<li><a href="#paymentInfo">Payment Information</a></li>
							<li><a href="#additionalInfo">Additional Information</a></li>
						</ul>
						<div id="demographics">
							<s:form action="PatientFormActionAdvancedSearchDemographicsTab"
								method="post">
								<!-- 				main table -->
								<table cellspacing="0" cellpadding="5">
									<tr>
										<td width="50%">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="1">
												<tr>
													<td width="25%">Last Name</td>
													<td><input type="text"
														name="patientFormSearch.lastName" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="25%">First Name</td>
													<td><input type="text"
														name="patientFormSearch.firstName" tabindex="1" size="25"></td>
												</tr>
												<tr>
													<td width="25%">Age</td>
													<td><input type="text" name="patientFormSearch.age"
														tabindex="2" size="25"></td>
												</tr>
												<!-- 				radio -->
												<tr>
													<td width="25%">Gender</td>
													<td><input type="text" name="patientFormSearch.gender"
														tabindex="2" size="25"></td>
												</tr>

												<tr>
													<td width="25%">Marital Status</td>
													<td><input type="text"
														name="patientFormSearch.maritalStatus" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Employment Status</td>
													<td><input type="text"
														name="patientFormSearch.empStatus" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="25%">Treating Provider</td>
													<td><input type="text"
														name="patientFormSearch.treatingProvider" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Referring Provider</td>
													<td><input type="text"
														name="patientFormSearch.referringProvider" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Relation Guarantor</td>
													<td><input type="text"
														name="patientFormSearch.relationGuarantor" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">D.O.B.</td>
													<td><input type="text"
														name="patientFormSearch.patientDOB" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="25%">Race</td>
													<td><input type="text"
														name="patientFormSearch.PatientRace" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Ethnicity</td>
													<td><input type="text"
														name="patientFormSearch.patientEthinicity" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Language</td>
													<td><input type="text"
														name="patientFormSearch.patientLanguage" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Mothers Maiden</td>
													<td><input type="text"
														name="patientFormSearch.mothersMaiden" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">SSN</td>
													<td><input type="text"
														name="patientFormSearch.patientSSN" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="25%">D.O.O.</td>
													<td><input type="text"
														name="patientFormSearch.patientDOO" tabindex="2" size="25"></td>
												</tr>
											</table>
										<td width="50%">
											<!-- Table on right side -->
											<table width="100%" border="0" cellspacing="0"
												cellpadding="1" align="right">

												<tr>
													<td width="25%">Residential Street</td>
													<td><input type="text"
														name="patientFormSearch.residentialStreet" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Residential City</td>
													<td><input type="text"
														name="patientFormSearch.residentialCity" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Residential State</td>
													<td><input type="text"
														name="patientFormSearch.residentialState" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Residential Zipcode</td>
													<td><input type="text"
														name="patientFormSearch.residentialZipcode" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Mail Street</td>
													<td><input type="text"
														name="patientFormSearch.mailStreet" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="25%">Mail City</td>
													<td><input type="text"
														name="patientFormSearch.mailCity" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="25%">Mail State</td>
													<td><input type="text"
														name="patientFormSearch.mailState" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="25%">Mail Zipcode</td>
													<td><input type="text"
														name="patientFormSearch.mailZipcode" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Last Visit Date</td>
													<td><input type="text"
														name="patientFormSearch.lastVisitDate" tabindex="2"
														size="25"></td>
												</tr>

												<tr>
													<td width="25%">Home Phone</td>
													<td><input type="text"
														name="patientFormSearch.homePhone" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="25%">Work Phone</td>
													<td><input type="text"
														name="patientFormSearch.workPhone" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="25%">Cell Phone</td>
													<td><input type="text"
														name="patientFormSearch.cellPhone" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="25%">Email</td>
													<td><input type="text"
														name="patientFormSearch.patientEmail" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Reminder Method</td>
													<td><input type="text"
														name="patientFormSearch.reminderMethod" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Additional Notes</td>
													<td><input type="text"
														name="patientFormSearch.demographicsNotes" tabindex="2"
														size="25"></td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<s:submit value="Search" />
									</tr>

								</table>
							</s:form>
						</div>

						<div id="paymentInfo">
							<s:form action="PatientFormActionAdvancedSearchPaymentTab"
								method="post">
								<!-- 				main table -->
								<table cellspacing="0" cellpadding="5">
									<tr>
										<td width="50%">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="1">

												<tr>
													<td><span style="color: Red">Consent</span></td>
												</tr>
												<tr>
													<td width="25%">Patient Consent</td>
													<td><input type="text"
														name="patientFormSearch.patientConsent" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Date Set</td>
													<td><input type="text"
														name="patientFormSearch.consentDateSet" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Consent Notes</td>
													<td><input type="text"
														name="patientFormSearch.consentNotes" tabindex="2"
														size="25"></td>
												</tr>

												<tr>
													<td><span style="color: Red">Payment
															Information</span></td>
												</tr>
												<tr>
													<td width="25%">Primary Insurance Provider</td>
													<td><input type="text"
														name="patientFormSearch.primaryInsuranceProvider"
														tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="25%">Primary Insurance ID No.</td>
													<td><input type="text"
														name="patientFormSearch.primaryInsuranceIdNumber"
														tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="25%">Primary Group ID No.</td>
													<td><input type="text"
														name="patientFormSearch.primaryGroupIdNumber" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Primary Policy Provider Name</td>
													<td><input type="text"
														name="patientFormSearch.primaryPolicyProviderName"
														tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="25%">Primary Provider DOB</td>
													<td><input type="text"
														name="patientFormSearch.primaryProviderDOB" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Ailment</td>
													<td><input type="text"
														name="patientFormSearch.patientAilment" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Secondary Insurance</td>
													<td><input type="text"
														name="patientFormSearch.secondaryInsurance" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Secondary Insurance Provider</td>
													<td><input type="text"
														name="patientFormSearch.secondaryInsuranceProvider"
														tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="25%">Secondary Insurance ID No.</td>
													<td><input type="text"
														name="patientFormSearch.secondaryInsuranceIdNumber"
														tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="25%">Secondary Group ID No.</td>
													<td><input type="text"
														name="patientFormSearch.secondaryGroupIdNumber"
														tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="25%">Secondary Policy Provider Name</td>
													<td><input type="text"
														name="patientFormSearch.secondaryPolicyProviderName"
														tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="25%">Secondary Provider DOB</td>
													<td><input type="text"
														name="patientFormSearch.secondaryProviderDOB" tabindex="2"
														size="25"></td>
												</tr>
											</table>
										<td width="50%">
											<!-- Table on right side -->
											<table width="100%" border="0" cellspacing="0"
												cellpadding="1" align="right">

												<tr>
													<td width="25%">Tertiary Provider</td>
													<td><input type="text"
														name="patientFormSearch.tertiaryInsurance" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Tertiary Insurance Provider</td>
													<td><input type="text"
														name="patientFormSearch.tertiaryInsuranceProvider"
														tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="25%">Tertiary Insurance ID No.</td>
													<td><input type="text"
														name="patientFormSearch.tertiaryInsuranceIdNumber"
														tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="25%">Tertiary Group ID No.</td>
													<td><input type="text"
														name="patientFormSearch.tertiaryGroupIdNumber"
														tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="25%">Tertiary Policy Provider Name</td>
													<td><input type="text"
														name="patientFormSearch.tertiaryPolicyProviderName"
														tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="25%">Tertiary Provider DOB</td>
													<td><input type="text"
														name="patientFormSearch.tertiaryProviderDOB" tabindex="2"
														size="25"></td>
												</tr>


												<tr>
													<td width="25%">Insurance Phone Number</td>
													<td><input type="text"
														name="patientFormSearch.insurancePhoneNumber" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Authorised Visits</td>
													<td><input type="text"
														name="patientFormSearch.authorisedVisits" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Validity Dates</td>
													<td><input type="text"
														name="patientFormSearch.validityDates" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Co-Pay</td>
													<td><input type="text"
														name="patientFormSearch.patientCoPay" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Co-Insurance</td>
													<td><input type="text"
														name="patientFormSearch.patientCoInsurance" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Deductible</td>
													<td><input type="text"
														name="patientFormSearch.patientDeductible" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Third Party Payer</td>
													<td><input type="text"
														name="patientFormSearch.thirdPartyPayer" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Script Required</td>
													<td><input type="text"
														name="patientFormSearch.scriptRequired" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Payment Notes</td>
													<td><input type="text"
														name="patientFormSearch.paymentNotes" tabindex="2"
														size="25"></td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<s:submit value="Search" />
									</tr>

								</table>
							</s:form>
						</div>


						<!-- 				Third tab in new record -->
						<div id="additionalInfo">
							<s:form action="PatientFormActionAdvancedSearchAdditionalTab"
								method="post">
								<!-- 				main table -->
								<table cellspacing="0" cellpadding="5">
									<tr>
										<td width="50%">
											<table cellspacing="0" cellpadding="1" align="left">
												<tr>
												<tr>
													<td><span style="color: Red">Additional
															Information</span></td>
												</tr>
												<tr>
													<td width="25%">Treatment Date</td>
													<td><input type="text"
														name="patientFormSearch.treatmentDate" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Onset Date</td>
													<td><input type="text"
														name="patientFormSearch.onsetDate" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="25%">Discharge Date</td>
													<td><input type="text"
														name="patientFormSearch.dischargeDate" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Facility Name</td>
													<td><input type="text"
														name="patientFormSearch.facilityName" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Email Consent</td>
													<td><input type="text"
														name="patientFormSearch.emailConsent" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Body Part</td>
													<td><input type="text"
														name="patientFormSearch.bodyPart" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="25%">Additional Notes</td>
													<td><input type="text"
														name="patientFormSearch.additionalInformationNotes"
														tabindex="2" size="25"></td>
												</tr>
											</table>
										<td width="50%">
											<!-- Table on right side -->
											<table cellspacing="0" cellpadding="1" align="right">

												<tr>
													<td><span style="color: Red">Confidential
															Status</span></td>
												</tr>
												<tr>
													<td width="25%">Status</td>
													<td><input type="text"
														name="patientFormSearch.confidentialStatus" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Set By</td>
													<td><input type="text"
														name="patientFormSearch.confidentialSetBy" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="25%">Date</td>
													<td><input type="text"
														name="patientFormSearch.confidentialDate" tabindex="2"
														size="25"></td>
												</tr>
											</table>
										</td>
									</tr>

									<tr>
										<s:submit value="Search" />
									</tr>

								</table>
							</s:form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 		tab for create new record -->
		<div id="newRecord">
			<div id="subtabs">
				<ul>
					<li><a href="#demographics" class="">Demographics</a></li>
					<li><a href="#paymentInfo">Payment Information</a></li>
					<li><a href="#additionalInfo">Additional Information</a></li>
				</ul>
				<div id="demographics">
					<s:form action="PatientFormActionDemographicsTab" method="post">
						<!-- 				main table -->
						<table cellspacing="0" cellpadding="5">
							<tr>
								<td width="50%">
									<table width="100%" border="0" cellspacing="0" cellpadding="1">
										<tr>
											<td width="25%">Last Name</td>
											<td><input type="text" name="patientFormBean.lastName"
												tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="25%">First Name</td>
											<td><input type="text" name="patientFormBean.firstName"
												tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Age</td>
											<td><input type="text" name="patientFormBean.age"
												tabindex="2" size="25"></td>
										</tr>
										<!-- 				radio -->
										<tr>
											<td width="25%">Gender</td>
											<td><input type="text" name="patientFormBean.gender"
												tabindex="2" size="25"></td>
										</tr>

										<tr>
											<td width="25%">Marital Status</td>
											<td><input type="text"
												name="patientFormBean.maritalStatus" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Employment Status</td>
											<td><input type="text" name="patientFormBean.empStatus"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Treating Provider</td>
											<td><input type="text"
												name="patientFormBean.treatingProvider" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Referring Provider</td>
											<td><input type="text"
												name="patientFormBean.referringProvider" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Relation Guarantor</td>
											<td><input type="text"
												name="patientFormBean.relationGuarantor" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">D.O.B.</td>
											<td><input type="text" name="patientFormBean.patientDOB"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Race</td>
											<td><input type="text"
												name="patientFormBean.PatientRace" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Ethnicity</td>
											<td><input type="text"
												name="patientFormBean.patientEthinicity" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Language</td>
											<td><input type="text"
												name="patientFormBean.patientLanguage" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Mothers Maiden</td>
											<td><input type="text"
												name="patientFormBean.mothersMaiden" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">SSN</td>
											<td><input type="text" name="patientFormBean.patientSSN"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">D.O.O.</td>
											<td><input type="text" name="patientFormBean.patientDOO"
												tabindex="2" size="25"></td>
										</tr>
									</table>
								<td width="50%">
									<!-- Table on right side -->
									<table width="100%" border="0" cellspacing="0" cellpadding="1"
										align="right">

										<tr>
											<td width="25%">Residential Street</td>
											<td><input type="text"
												name="patientFormBean.residentialStreet" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Residential City</td>
											<td><input type="text"
												name="patientFormBean.residentialCity" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Residential State</td>
											<td><input type="text"
												name="patientFormBean.residentialState" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Residential Zipcode</td>
											<td><input type="text"
												name="patientFormBean.residentialZipcode" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Mail Street</td>
											<td><input type="text" name="patientFormBean.mailStreet"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Mail City</td>
											<td><input type="text" name="patientFormBean.mailCity"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Mail State</td>
											<td><input type="text" name="patientFormBean.mailState"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Mail Zipcode</td>
											<td><input type="text"
												name="patientFormBean.mailZipcode" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Last Visit Date</td>
											<td><input type="text"
												name="patientFormBean.lastVisitDate" tabindex="2" size="25"></td>
										</tr>

										<tr>
											<td width="25%">Home Phone</td>
											<td><input type="text" name="patientFormBean.homePhone"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Work Phone</td>
											<td><input type="text" name="patientFormBean.workPhone"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Cell Phone</td>
											<td><input type="text" name="patientFormBean.cellPhone"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Email</td>
											<td><input type="text"
												name="patientFormBean.patientEmail" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Reminder Method</td>
											<td><input type="text"
												name="patientFormBean.reminderMethod" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Additional Notes</td>
											<td><input type="text"
												name="patientFormBean.demographicsNotes" tabindex="2"
												size="25"></td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<s:submit value="Save" />
							</tr>

						</table>
					</s:form>
				</div>

				<div id="paymentInfo">
					<s:form action="PatientFormActionPaymentTab" method="post">
						<!-- 				main table -->
						<table cellspacing="0" cellpadding="5">
							<tr>
								<td width="50%">
									<table width="100%" border="0" cellspacing="0" cellpadding="1">

										<tr>
											<td><span style="color: Red">Consent</span></td>
										</tr>
										<tr>
											<td width="25%">Patient Consent</td>
											<td><input type="text"
												name="patientFormBean.patientConsent" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Date Set</td>
											<td><input type="text"
												name="patientFormBean.consentDateSet" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Consent Notes</td>
											<td><input type="text"
												name="patientFormBean.consentNotes" tabindex="2" size="25"></td>
										</tr>

										<tr>
											<td><span style="color: Red">Payment Information</span></td>
										</tr>
										<tr>
											<td width="25%">Primary Insurance Provider</td>
											<td><input type="text"
												name="patientFormBean.primaryInsuranceProvider" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Primary Insurance ID No.</td>
											<td><input type="text"
												name="patientFormBean.primaryInsuranceIdNumber" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Primary Group ID No.</td>
											<td><input type="text"
												name="patientFormBean.primaryGroupIdNumber" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Primary Policy Provider Name</td>
											<td><input type="text"
												name="patientFormBean.primaryPolicyProviderName"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Primary Provider DOB</td>
											<td><input type="text"
												name="patientFormBean.primaryProviderDOB" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Ailment</td>
											<td><input type="text"
												name="patientFormBean.patientAilment" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Secondary Insurance</td>
											<td><input type="text"
												name="patientFormBean.secondaryInsurance" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Secondary Insurance Provider</td>
											<td><input type="text"
												name="patientFormBean.secondaryInsuranceProvider"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Secondary Insurance ID No.</td>
											<td><input type="text"
												name="patientFormBean.secondaryInsuranceIdNumber"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Secondary Group ID No.</td>
											<td><input type="text"
												name="patientFormBean.secondaryGroupIdNumber" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Secondary Policy Provider Name</td>
											<td><input type="text"
												name="patientFormBean.secondaryPolicyProviderName"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Secondary Provider DOB</td>
											<td><input type="text"
												name="patientFormBean.secondaryProviderDOB" tabindex="2"
												size="25"></td>
										</tr>
									</table>
								<td width="50%">
									<!-- Table on right side -->
									<table width="100%" border="0" cellspacing="0" cellpadding="1"
										align="right">

										<tr>
											<td width="25%">Tertiary Provider</td>
											<td><input type="text"
												name="patientFormBean.tertiaryInsurance" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Tertiary Insurance Provider</td>
											<td><input type="text"
												name="patientFormBean.tertiaryInsuranceProvider"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Tertiary Insurance ID No.</td>
											<td><input type="text"
												name="patientFormBean.tertiaryInsuranceIdNumber"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Tertiary Group ID No.</td>
											<td><input type="text"
												name="patientFormBean.tertiaryGroupIdNumber" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Tertiary Policy Provider Name</td>
											<td><input type="text"
												name="patientFormBean.tertiaryPolicyProviderName"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Tertiary Provider DOB</td>
											<td><input type="text"
												name="patientFormBean.tertiaryProviderDOB" tabindex="2"
												size="25"></td>
										</tr>


										<tr>
											<td width="25%">Insurance Phone Number</td>
											<td><input type="text"
												name="patientFormBean.insurancePhoneNumber" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Authorised Visits</td>
											<td><input type="text"
												name="patientFormBean.authorisedVisits" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Validity Dates</td>
											<td><input type="text"
												name="patientFormBean.validityDates" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Co-Pay</td>
											<td><input type="text"
												name="patientFormBean.patientCoPay" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Co-Insurance</td>
											<td><input type="text"
												name="patientFormBean.patientCoInsurance" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Deductible</td>
											<td><input type="text"
												name="patientFormBean.patientDeductible" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Third Party Payer</td>
											<td><input type="text"
												name="patientFormBean.thirdPartyPayer" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Script Required</td>
											<td><input type="text"
												name="patientFormBean.scriptRequired" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Payment Notes</td>
											<td><input type="text"
												name="patientFormBean.paymentNotes" tabindex="2" size="25"></td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<s:submit value="Save" />
							</tr>

						</table>
					</s:form>
				</div>


				<!-- 				Third tab in new record -->
				<div id="additionalInfo">
					<s:form action="PatientFormActionAdditionalTab" method="post">
						<!-- 				main table -->
						<table cellspacing="0" cellpadding="5">
							<tr>
								<td width="50%">
									<table cellspacing="0" cellpadding="1" align="left">
										<tr>
										<tr>
											<td><span style="color: Red">Additional
													Information</span></td>
										</tr>
										<tr>
											<td width="25%">Treatment Date</td>
											<td><input type="text"
												name="patientFormBean.treatmentDate" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Onset Date</td>
											<td><input type="text" name="patientFormBean.onsetDate"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Discharge Date</td>
											<td><input type="text"
												name="patientFormBean.dischargeDate" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Facility Name</td>
											<td><input type="text"
												name="patientFormBean.facilityName" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Email Consent</td>
											<td><input type="text"
												name="patientFormBean.emailConsent" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Body Part</td>
											<td><input type="text" name="patientFormBean.bodyPart"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Additional Notes</td>
											<td><input type="text"
												name="patientFormBean.additionalInformationNotes"
												tabindex="2" size="25"></td>
										</tr>
									</table>
								<td width="50%">
									<!-- Table on right side -->
									<table cellspacing="0" cellpadding="1" align="right">

										<tr>
											<td><span style="color: Red">Confidential Status</span></td>
										</tr>
										<tr>
											<td width="25%">Status</td>
											<td><input type="text"
												name="patientFormBean.confidentialStatus" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Set By</td>
											<td><input type="text"
												name="patientFormBean.confidentialSetBy" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Date</td>
											<td><input type="text"
												name="patientFormBean.confidentialDate" tabindex="2"
												size="25"></td>
										</tr>
									</table>
								</td>
							</tr>

							<tr>
								<s:submit value="Save" />
							</tr>

						</table>
					</s:form>
				</div>
			</div>
		</div>
		<div id="faxOut"></div>
		<div id="checkIn"></div>
		<div id="faxIn"></div>
		<div id="faxOut"></div>
	</div>
</body>
</html>
