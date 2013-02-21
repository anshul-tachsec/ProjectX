<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<!-- <!doctype html> -->
<html lang="us">
<head>
<%@taglib uri="/struts-tags" prefix="s"%>

<meta http-equiv="cache-control" content="no-cache">
<!-- tells browser not to cache -->
<meta http-equiv="expires" content="0">
<!-- says that the cache expires 'now' -->
<meta http-equiv="pragma" content="no-cache">
<!-- says not to use cached stuff, if there is any -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Front Office Home Page</title>

<link href="css/smoothness/jquery-ui-1.10.0.custom.css" rel="stylesheet">
<script src="js/jquery-1.9.0.js"></script>
<script src="js/jquery-ui-1.10.0.custom.js"></script>
<script>
	$(function() {

		$("#billerMode").button();
		$("#logout");
		var tabs = $("#tabs, #subtabs").tabs();
		tabs.find(".ui-tabs-nav").sortable({
			axis : "x",
			stop : function() {
				tabs.tabs("refresh");
			}
		});
	});
</script>
<style>
body {
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
	float: right;
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
			<li><a href="#ptSchedule"><span>PT Schedule</span></a></li>
			<li><a href="#openRecord">Open Record</a></li>
			<li><a href="#newRecord">New Record</a></li>
			<li><a href="#checkIn">Check-In</a></li>
			<li><a href="#faxIn">Fax-In</a></li>
			<li><a href="#faxOut">Fax-Out</a></li>

		</ul>
		<!-- 		tab for pt schedule -->
		<div id="ptSchedule"></div>
		<!-- tab for open record -->
		<div id="openRecord">
			<div id="subtabs">
				<ul>
					<li><a href="#simpleSearch" class=""> Simple Search</a></li>
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
											<td width="15%">Last Name</td>
											<td><input type="text" name="patientFormBean.lastName"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">First Name</td>
											<td><input type="text" name="patientFormBean.firstName"
												tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Patient ID</td>
											<td><input type="text" name="patientFormBean.patientID"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">SSN</td>
											<td><input type="text" name="patientFormBean.patientSSN"
												tabindex="2" size="25"></td>
										</tr>
									</table>
								<td width="50%">
									<!-- Table on right side -->
									<table width="100%" border="0" cellspacing="0" cellpadding="1"
										align="right">

										<tr>
											<td width="15%">Last Visit Date</td>
											<td><input type="text"
												name="patientFormBean.lastVisitDate" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Cell Phone</td>
											<td><input type="text" name="patientFormBean.cellPhone"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Email</td>
											<td><input type="text"
												name="patientFormBean.patientEmail" tabindex="2" size="25"></td>
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

				<div id="advancedSearch">
					<div id="subtabs">
						<ul>
							<li><a href="#demographics" class="">Demographics</a></li>
							<li><a href="#paymentInfo">Payment Information</a></li>
							<li><a href="#additionalInfo">Additional Information</a></li>
						</ul>
						<div id="demographics">
							<s:form action="PatientFormActionAdvancedSearch" method="post">
								<!-- 				main table -->
								<table cellspacing="0" cellpadding="5">
									<tr>
										<td width="50%">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="1">
												<tr>
													<td width="15%">Last Name</td>
													<td><input type="text" name="patientFormBean.lastName"
														tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">First Name</td>
													<td><input type="text"
														name="patientFormBean.firstName" tabindex="1" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Age</td>
													<td><input type="text" name="patientFormBean.age"
														tabindex="2" size="25"></td>
												</tr>
												<!-- 				radio -->
												<tr>
													<td width="15%">Gender</td>
													<td><input type="text" name="patientFormBean.gender"
														tabindex="2" size="25"></td>
												</tr>

												<tr>
													<td width="15%">Marital Status</td>
													<td><input type="text"
														name="patientFormBean.maritalStatus" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Employment Status</td>
													<td><input type="text"
														name="patientFormBean.empStatus" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Treating Provider</td>
													<td><input type="text"
														name="patientFormBean.treatingProvider" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Referring Provider</td>
													<td><input type="text"
														name="patientFormBean.referringProvider" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Relation Guarantor</td>
													<td><input type="text"
														name="patientFormBean.relationGuarantor" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">D.O.B.</td>
													<td><input type="text"
														name="patientFormBean.patientDOB" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Race</td>
													<td><input type="text"
														name="patientFormBean.PatientRace" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Ethnicity</td>
													<td><input type="text"
														name="patientFormBean.patientEthinicity" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Language</td>
													<td><input type="text"
														name="patientFormBean.patientLanguage" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Mothers Maiden</td>
													<td><input type="text"
														name="patientFormBean.mothersMaiden" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">SSN</td>
													<td><input type="text"
														name="patientFormBean.patientSSN" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">D.O.O.</td>
													<td><input type="text"
														name="patientFormBean.patientDOO" tabindex="2" size="25"></td>
												</tr>
											</table>
										<td width="50%">
											<!-- Table on right side -->
											<table width="100%" border="0" cellspacing="0"
												cellpadding="1" align="right">

												<tr>
													<td width="15%">Residential Street</td>
													<td><input type="text"
														name="patientFormBean.residentialStreet" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Residential City</td>
													<td><input type="text"
														name="patientFormBean.residentialCity" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Residential State</td>
													<td><input type="text"
														name="patientFormBean.residentialState" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Residential Zipcode</td>
													<td><input type="text"
														name="patientFormBean.residentialZipcode" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Mail Street</td>
													<td><input type="text"
														name="patientFormBean.mailStreet" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Mail City</td>
													<td><input type="text" name="patientFormBean.mailCity"
														tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Mail State</td>
													<td><input type="text"
														name="patientFormBean.mailState" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Mail Zipcode</td>
													<td><input type="text"
														name="patientFormBean.mailZipcode" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Last Visit Date</td>
													<td><input type="text"
														name="patientFormBean.lastVisitDate" tabindex="2"
														size="25"></td>
												</tr>

												<tr>
													<td width="15%">Home Phone</td>
													<td><input type="text"
														name="patientFormBean.homePhone" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Work Phone</td>
													<td><input type="text"
														name="patientFormBean.workPhone" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Cell Phone</td>
													<td><input type="text"
														name="patientFormBean.cellPhone" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Email</td>
													<td><input type="text"
														name="patientFormBean.patientEmail" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Reminder Method</td>
													<td><input type="text"
														name="patientFormBean.reminderMethod" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Additional Notes</td>
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
							<s:form action="PatientFormActionAdvancedSearch" method="post">
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
													<td width="15%">Patient Consent</td>
													<td><input type="text"
														name="patientFormBean.patientConsent" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Date Set</td>
													<td><input type="text"
														name="patientFormBean.consentDateSet" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Consent Notes</td>
													<td><input type="text"
														name="patientFormBean.consentNotes" tabindex="2" size="25"></td>
												</tr>

												<tr>
													<td><span style="color: Red">Payment
															Information</span></td>
												</tr>
												<tr>
													<td width="15%">Primary Insurance Provider</td>
													<td><input type="text"
														name="patientFormBean.primaryInsuranceProvider"
														tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Primary Insurance ID No.</td>
													<td><input type="text"
														name="patientFormBean.primaryInsuranceIdNumber"
														tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Primary Group ID No.</td>
													<td><input type="text"
														name="patientFormBean.primaryGroupIdNumber" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Primary Policy Provider Name</td>
													<td><input type="text"
														name="patientFormBean.primaryPolicyProviderName"
														tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Primary Provider DOB</td>
													<td><input type="text"
														name="patientFormBean.primaryProviderDOB" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Ailment</td>
													<td><input type="text"
														name="patientFormBean.patientAilment" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Secondary Insurance</td>
													<td><input type="text"
														name="patientFormBean.secondaryInsurance" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Secondary Insurance Provider</td>
													<td><input type="text"
														name="patientFormBean.secondaryInsuranceProvider"
														tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Secondary Insurance ID No.</td>
													<td><input type="text"
														name="patientFormBean.secondaryInsuranceIdNumber"
														tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Secondary Group ID No.</td>
													<td><input type="text"
														name="patientFormBean.secondaryGroupIdNumber" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Secondary Policy Provider Name</td>
													<td><input type="text"
														name="patientFormBean.secondaryPolicyProviderName"
														tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Secondary Provider DOB</td>
													<td><input type="text"
														name="patientFormBean.secondaryProviderDOB" tabindex="2"
														size="25"></td>
												</tr>
											</table>
										<td width="50%">
											<!-- Table on right side -->
											<table width="100%" border="0" cellspacing="0"
												cellpadding="1" align="right">

												<tr>
													<td width="15%">Tertiary Provider</td>
													<td><input type="text"
														name="patientFormBean.tertiaryInsurance" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Tertiary Insurance Provider</td>
													<td><input type="text"
														name="patientFormBean.tertiaryInsuranceProvider"
														tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Tertiary Insurance ID No.</td>
													<td><input type="text"
														name="patientFormBean.tertiaryInsuranceIdNumber"
														tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Tertiary Group ID No.</td>
													<td><input type="text"
														name="patientFormBean.tertiaryGroupIdNumber" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Tertiary Policy Provider Name</td>
													<td><input type="text"
														name="patientFormBean.tertiaryPolicyProviderName"
														tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Tertiary Provider DOB</td>
													<td><input type="text"
														name="patientFormBean.tertiaryProviderDOB" tabindex="2"
														size="25"></td>
												</tr>


												<tr>
													<td width="15%">Insurance Phone Number</td>
													<td><input type="text"
														name="patientFormBean.insurancePhoneNumber" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Authorised Visits</td>
													<td><input type="text"
														name="patientFormBean.authorisedVisits" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Validity Dates</td>
													<td><input type="text"
														name="patientFormBean.validityDates" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Co-Pay</td>
													<td><input type="text"
														name="patientFormBean.patientCoPay" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Co-Insurance</td>
													<td><input type="text"
														name="patientFormBean.patientCoInsurance" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Deductible</td>
													<td><input type="text"
														name="patientFormBean.patientDeductible" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Third Party Payer</td>
													<td><input type="text"
														name="patientFormBean.thirdPartyPayer" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Script Required</td>
													<td><input type="text"
														name="patientFormBean.scriptRequired" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Payment Notes</td>
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
							<s:form action="PatientFormActionAdvancedSearch" method="post">
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
													<td width="15%">Treatment Date</td>
													<td><input type="text"
														name="patientFormBean.treatmentDate" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Onset Date</td>
													<td><input type="text"
														name="patientFormBean.onsetDate" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Discharge Date</td>
													<td><input type="text"
														name="patientFormBean.dischargeDate" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Facility Name</td>
													<td><input type="text"
														name="patientFormBean.facilityName" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Email Consent</td>
													<td><input type="text"
														name="patientFormBean.emailConsent" tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Body Part</td>
													<td><input type="text" name="patientFormBean.bodyPart"
														tabindex="2" size="25"></td>
												</tr>
												<tr>
													<td width="15%">Additional Notes</td>
													<td><input type="text"
														name="patientFormBean.additionalInformationNotes"
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
													<td width="15%">Status</td>
													<td><input type="text"
														name="patientFormBean.confidentialStatus" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Set By</td>
													<td><input type="text"
														name="patientFormBean.confidentialSetBy" tabindex="2"
														size="25"></td>
												</tr>
												<tr>
													<td width="15%">Date</td>
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
											<td width="15%">Last Name</td>
											<td><input type="text" name="patientFormBean.lastName"
												tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="15%">First Name</td>
											<td><input type="text" name="patientFormBean.firstName"
												tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Age</td>
											<td><input type="text" name="patientFormBean.age"
												tabindex="2" size="25"></td>
										</tr>
										<!-- 				radio -->
										<tr>
											<td width="15%">Gender</td>
											<td><input type="text" name="patientFormBean.gender"
												tabindex="2" size="25"></td>
										</tr>

										<tr>
											<td width="15%">Marital Status</td>
											<td><input type="text"
												name="patientFormBean.maritalStatus" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Employment Status</td>
											<td><input type="text" name="patientFormBean.empStatus"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Treating Provider</td>
											<td><input type="text"
												name="patientFormBean.treatingProvider" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Referring Provider</td>
											<td><input type="text"
												name="patientFormBean.referringProvider" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Relation Guarantor</td>
											<td><input type="text"
												name="patientFormBean.relationGuarantor" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">D.O.B.</td>
											<td><input type="text" name="patientFormBean.patientDOB"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Race</td>
											<td><input type="text"
												name="patientFormBean.PatientRace" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Ethnicity</td>
											<td><input type="text"
												name="patientFormBean.patientEthinicity" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Language</td>
											<td><input type="text"
												name="patientFormBean.patientLanguage" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Mothers Maiden</td>
											<td><input type="text"
												name="patientFormBean.mothersMaiden" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">SSN</td>
											<td><input type="text" name="patientFormBean.patientSSN"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">D.O.O.</td>
											<td><input type="text" name="patientFormBean.patientDOO"
												tabindex="2" size="25"></td>
										</tr>
									</table>
								<td width="50%">
									<!-- Table on right side -->
									<table width="100%" border="0" cellspacing="0" cellpadding="1"
										align="right">

										<tr>
											<td width="15%">Residential Street</td>
											<td><input type="text"
												name="patientFormBean.residentialStreet" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Residential City</td>
											<td><input type="text"
												name="patientFormBean.residentialCity" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Residential State</td>
											<td><input type="text"
												name="patientFormBean.residentialState" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Residential Zipcode</td>
											<td><input type="text"
												name="patientFormBean.residentialZipcode" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Mail Street</td>
											<td><input type="text" name="patientFormBean.mailStreet"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Mail City</td>
											<td><input type="text" name="patientFormBean.mailCity"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Mail State</td>
											<td><input type="text" name="patientFormBean.mailState"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Mail Zipcode</td>
											<td><input type="text"
												name="patientFormBean.mailZipcode" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Last Visit Date</td>
											<td><input type="text"
												name="patientFormBean.lastVisitDate" tabindex="2" size="25"></td>
										</tr>

										<tr>
											<td width="15%">Home Phone</td>
											<td><input type="text" name="patientFormBean.homePhone"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Work Phone</td>
											<td><input type="text" name="patientFormBean.workPhone"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Cell Phone</td>
											<td><input type="text" name="patientFormBean.cellPhone"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Email</td>
											<td><input type="text"
												name="patientFormBean.patientEmail" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Reminder Method</td>
											<td><input type="text"
												name="patientFormBean.reminderMethod" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Additional Notes</td>
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
											<td width="15%">Patient Consent</td>
											<td><input type="text"
												name="patientFormBean.patientConsent" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Date Set</td>
											<td><input type="text"
												name="patientFormBean.consentDateSet" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Consent Notes</td>
											<td><input type="text"
												name="patientFormBean.consentNotes" tabindex="2" size="25"></td>
										</tr>

										<tr>
											<td><span style="color: Red">Payment Information</span></td>
										</tr>
										<tr>
											<td width="15%">Primary Insurance Provider</td>
											<td><input type="text"
												name="patientFormBean.primaryInsuranceProvider" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Primary Insurance ID No.</td>
											<td><input type="text"
												name="patientFormBean.primaryInsuranceIdNumber" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Primary Group ID No.</td>
											<td><input type="text"
												name="patientFormBean.primaryGroupIdNumber" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Primary Policy Provider Name</td>
											<td><input type="text"
												name="patientFormBean.primaryPolicyProviderName"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Primary Provider DOB</td>
											<td><input type="text"
												name="patientFormBean.primaryProviderDOB" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Ailment</td>
											<td><input type="text"
												name="patientFormBean.patientAilment" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Secondary Insurance</td>
											<td><input type="text"
												name="patientFormBean.secondaryInsurance" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Secondary Insurance Provider</td>
											<td><input type="text"
												name="patientFormBean.secondaryInsuranceProvider"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Secondary Insurance ID No.</td>
											<td><input type="text"
												name="patientFormBean.secondaryInsuranceIdNumber"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Secondary Group ID No.</td>
											<td><input type="text"
												name="patientFormBean.secondaryGroupIdNumber" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Secondary Policy Provider Name</td>
											<td><input type="text"
												name="patientFormBean.secondaryPolicyProviderName"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Secondary Provider DOB</td>
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
											<td width="15%">Tertiary Provider</td>
											<td><input type="text"
												name="patientFormBean.tertiaryInsurance" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Tertiary Insurance Provider</td>
											<td><input type="text"
												name="patientFormBean.tertiaryInsuranceProvider"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Tertiary Insurance ID No.</td>
											<td><input type="text"
												name="patientFormBean.tertiaryInsuranceIdNumber"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Tertiary Group ID No.</td>
											<td><input type="text"
												name="patientFormBean.tertiaryGroupIdNumber" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Tertiary Policy Provider Name</td>
											<td><input type="text"
												name="patientFormBean.tertiaryPolicyProviderName"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Tertiary Provider DOB</td>
											<td><input type="text"
												name="patientFormBean.tertiaryProviderDOB" tabindex="2"
												size="25"></td>
										</tr>


										<tr>
											<td width="15%">Insurance Phone Number</td>
											<td><input type="text"
												name="patientFormBean.insurancePhoneNumber" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Authorised Visits</td>
											<td><input type="text"
												name="patientFormBean.authorisedVisits" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Validity Dates</td>
											<td><input type="text"
												name="patientFormBean.validityDates" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Co-Pay</td>
											<td><input type="text"
												name="patientFormBean.patientCoPay" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Co-Insurance</td>
											<td><input type="text"
												name="patientFormBean.patientCoInsurance" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Deductible</td>
											<td><input type="text"
												name="patientFormBean.patientDeductible" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Third Party Payer</td>
											<td><input type="text"
												name="patientFormBean.thirdPartyPayer" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Script Required</td>
											<td><input type="text"
												name="patientFormBean.scriptRequired" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Payment Notes</td>
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
											<td width="15%">Treatment Date</td>
											<td><input type="text"
												name="patientFormBean.treatmentDate" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Onset Date</td>
											<td><input type="text" name="patientFormBean.onsetDate"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Discharge Date</td>
											<td><input type="text"
												name="patientFormBean.dischargeDate" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Facility Name</td>
											<td><input type="text"
												name="patientFormBean.facilityName" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Email Consent</td>
											<td><input type="text"
												name="patientFormBean.emailConsent" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Body Part</td>
											<td><input type="text" name="patientFormBean.bodyPart"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Additional Notes</td>
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
											<td width="15%">Status</td>
											<td><input type="text"
												name="patientFormBean.confidentialStatus" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Set By</td>
											<td><input type="text"
												name="patientFormBean.confidentialSetBy" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Date</td>
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
