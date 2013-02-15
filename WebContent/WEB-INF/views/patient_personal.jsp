<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<!-- <!doctype html> -->
<html lang="us">
<head>
<%@taglib uri="/struts-tags" prefix="s"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Patient Page</title>

<link href="css/smoothness/jquery-ui-1.10.0.custom.css" rel="stylesheet">
<script src="js/jquery-1.9.0.js"></script>
<script src="js/jquery-ui-1.10.0.custom.js"></script>
<script>
	$(function() {
		$("#patientID").button().click(false);

		$("#billerMode").button();
		$("#logout").button().click(function() {
			window.location.href = "/LogoutAction";
		});
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
	float: left;
	margin: 0 4px;
}

.fakewindowcontain .ui-widget-overlay {
	position: absolute;
}
</style>
</head>
<body>
	<button id="patientID">
		<b>Patient ID: ${patientFormBean.patientID}</b>

	</button>
	<button id="billerMode">Biller Mode</button>
	<button id="logout">LogOut</button>
	<!-- 		<a href="LogoutAction.action" class="logout" button id="logout">Logout</a> -->

	<div id="tabs">
		<ul>
			<li><a href="#patientInfo"><span>Patient Information</span></a></li>
			<li><a href="#scheduleAppointments">Schedule Appointments</a></li>
			<li><a href="#uploadDocuments">Upload Documents</a></li>
			<li><a href="#viewAttachments">View Attachments</a></li>
			<li><a href="#deliveryReports">Delivery Reports</a></li>

		</ul>
		<!-- 		tab for pt schedule -->
		<div id="patientInfo">
			<div id="subtabs">
				<ul>
					<li><a href="#demographics" class="">Demographics</a></li>
					<li><a href="#paymentInfo">Payment Information</a></li>
					<li><a href="#additionalInfo">Additional Information</a></li>
				</ul>
				<div id="demographics">
					<s:form action="PatientFormActionUpdate" method="post">
						<input value="${patientFormBean.patientID }" style="display: none"
							name="patientFormBean.patientID"></input>
						<!-- 				main table -->
						<table cellspacing="0" cellpadding="5">
							<tr>
								<td width="50%">
									<table width="100%" border="0" cellspacing="0" cellpadding="1">
										<tr>
											<td width="15%">Last Name</td>
											<td><input type="text"
												value="${patientFormBean.lastName}"
												name="patientFormBean.lastName" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">First Name</td>
											<td><input type="text"
												value="${patientFormBean.firstName}"
												name="patientFormBean.firstName" tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Age</td>
											<td><input type="text" value="${patientFormBean.age}"
												name="patientFormBean.age" tabindex="2" size="25"></td>
										</tr>
										<!-- 				radio -->
										<tr>
											<td width="15%">Gender</td>
											<td><input type="text" value="${patientFormBean.gender}"
												name="patientFormBean.gender" tabindex="2" size="25"></td>
										</tr>

										<tr>
											<td width="15%">Marital Status</td>
											<td><input type="text"
												value="${patientFormBean.maritalStatus}"
												name="patientFormBean.maritalStatus" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Employment Status</td>
											<td><input type="text"
												value="${patientFormBean.empStatus}"
												name="patientFormBean.empStatus" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Treating Provider</td>
											<td><input type="text"
												value="${patientFormBean.treatingProvider}"
												name="patientFormBean.treatingProvider" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Referring Provider</td>
											<td><input type="text"
												value="${patientFormBean.referringProvider}"
												name="patientFormBean.referringProvider" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Relation Guarantor</td>
											<td><input type="text"
												value="${patientFormBean.relationGuarantor}"
												name="patientFormBean.relationGuarantor" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">D.O.B.</td>
											<td><input type="text"
												value="${patientFormBean.patientDOB}"
												name="patientFormBean.patientDOB" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Race</td>
											<td><input type="text"
												value="${patientFormBean.patientRace}"
												name="patientFormBean.PatientRace" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Ethnicity</td>
											<td><input type="text"
												value="${patientFormBean.patientEthinicity}"
												name="patientFormBean.patientEthinicity" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Language</td>
											<td><input type="text"
												value="${patientFormBean.patientLanguage}"
												name="patientFormBean.patientLanguage" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Mother's Maiden</td>
											<td><input type="text"
												value="${patientFormBean.mothersMaiden}"
												name="patientFormBean.mothersMaiden" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">SSN</td>
											<td><input type="text"
												value="${patientFormBean.patientSSN}"
												name="patientFormBean.patientSSN" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">D.O.O.</td>
											<td><input type="text"
												value="${patientFormBean.patientDOO}"
												name="patientFormBean.patientDOO" tabindex="2" size="25"></td>
										</tr>
									</table>
								<td width="50%">
									<!-- Table on right side -->
									<table width="100%" border="0" cellspacing="0" cellpadding="1"
										align="right">

										<tr>
											<td width="15%">Residential Street</td>
											<td><input type="text"
												value="${patientFormBean.residentialStreet}"
												name="patientFormBean.residentialStreet" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Residential City</td>
											<td><input type="text"
												value="${patientFormBean.residentialCity}"
												name="patientFormBean.residentialCity" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Residential State</td>
											<td><input type="text"
												value="${patientFormBean.residentialState}"
												name="patientFormBean.residentialState" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Residential Zipcode</td>
											<td><input type="text"
												value="${patientFormBean.residentialZipcode}"
												name="patientFormBean.residentialZipcode" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Mail Street</td>
											<td><input type="text"
												value="${patientFormBean.mailStreet}"
												name="patientFormBean.mailStreet" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Mail City</td>
											<td><input type="text"
												value="${patientFormBean.mailCity}"
												name="patientFormBean.mailCity" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Mail State</td>
											<td><input type="text"
												value="${patientFormBean.mailState}"
												name="patientFormBean.mailState" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Mail Zipcode</td>
											<td><input type="text"
												value="${patientFormBean.mailZipcode}"
												name="patientFormBean.mailZipcode" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Last Visit Date</td>
											<td><input type="text"
												value="${patientFormBean.lastVisitDate}"
												name="patientFormBean.lastVisitDate" tabindex="2" size="25"></td>
										</tr>

										<tr>
											<td width="15%">Home Phone</td>
											<td><input type="text"
												value="${patientFormBean.homePhone}"
												name="patientFormBean.homePhone" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Work Phone</td>
											<td><input type="text"
												value="${patientFormBean.workPhone}"
												name="patientFormBean.workPhone" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Cell Phone</td>
											<td><input type="text"
												value="${patientFormBean.cellPhone}"
												name="patientFormBean.cellPhone" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Email</td>
											<td><input type="text"
												value="${patientFormBean.patientEmail}"
												name="patientFormBean.patientEmail" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Reminder Method</td>
											<td><input type="text"
												value="${patientFormBean.reminderMethod}"
												name="patientFormBean.reminderMethod" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Additional Notes</td>
											<td><input type="text"
												value="${patientFormBean.demographicsNotes}"
												name="patientFormBean.demographicsNotes" tabindex="2"
												size="25"></td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<s:submit value="Submit" />
							</tr>

						</table>
					</s:form>
				</div>

				<div id="paymentInfo">

					<s:form action="PatientFormActionUpdate" method="post">
						<input value="${patientFormBean.patientID }" style="display: none"
							name="patientFormBean.patientID"></input>

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
											<!-- 										<td><input type="text" -->
											<!-- 											name="patientFormBean.patientConsent" tabindex="2" size="25"></td> -->
											<td><input type="text"
												value="${patientFormBean.patientConsent}"
												name="patientFormBean.patientConsent" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Date Set</td>
											<td><input type="text"
												value="${patientFormBean.consentDateSet}"
												name="patientFormBean.consentDateSet" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Consent Notes</td>
											<td><input type="text"
												value="${patientFormBean.consentNotes}"
												name="patientFormBean.consentNotes" tabindex="2" size="25"></td>
										</tr>

										<tr>
											<td><span style="color: Red">Payment Information</span></td>
										</tr>
										<tr>
											<td width="15%">Primary Insurance Provider</td>
											<td><input type="text"
												value="${patientFormBean.primaryInsuranceProvider}"
												name="patientFormBean.primaryInsuranceProvider" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Primary Insurance ID No.</td>
											<td><input type="text"
												value="${patientFormBean.primaryInsuranceIdNumber}"
												name="patientFormBean.primaryInsuranceIdNumber" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Primary Group ID No.</td>
											<td><input type="text"
												value="${patientFormBean.primaryGroupIdNumber}"
												name="patientFormBean.primaryGroupIdNumber" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Primary Policy Provider Name</td>
											<td><input type="text"
												value="${patientFormBean.primaryPolicyProviderName}"
												name="patientFormBean.primaryPolicyProviderName"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Primary Provider DOB</td>
											<td><input type="text"
												value="${patientFormBean.primaryProviderDOB}"
												name="patientFormBean.primaryProviderDOB" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Ailment</td>
											<td><input type="text"
												value="${patientFormBean.patientAilment}"
												name="patientFormBean.patientAilment" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Secondary Insurance</td>
											<td><input type="text"
												value="${patientFormBean.secondaryInsurance}"
												name="patientFormBean.secondaryInsurance" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Secondary Insurance Provider</td>
											<td><input type="text"
												value="${patientFormBean.secondaryInsuranceProvider}"
												name="patientFormBean.secondaryInsuranceProvider"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Secondary Insurance ID No.</td>
											<td><input type="text"
												value="${patientFormBean.secondaryInsuranceIdNumber}"
												name="patientFormBean.secondaryInsuranceIdNumber"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Secondary Group ID No.</td>
											<td><input type="text"
												value="${patientFormBean.secondaryGroupIdNumber}"
												name="patientFormBean.secondaryGroupIdNumber" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Secondary Policy Provider Name</td>
											<td><input type="text"
												value="${patientFormBean.secondaryPolicyProviderName}"
												name="patientFormBean.secondaryPolicyProviderName"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Secondary Provider DOB</td>
											<td><input type="text"
												value="${patientFormBean.secondaryProviderDOB}"
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
												value="${patientFormBean.tertiaryInsurance}"
												name="patientFormBean.tertiaryInsurance" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Tertiary Insurance Provider</td>
											<td><input type="text"
												value="${patientFormBean.tertiaryInsuranceProvider}"
												name="patientFormBean.tertiaryInsuranceProvider"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Tertiary Insurance ID No.</td>
											<td><input type="text"
												value="${patientFormBean.tertiaryInsuranceIdNumber}"
												name="patientFormBean.tertiaryInsuranceIdNumber"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Tertiary Group ID No.</td>
											<td><input type="text"
												value="${patientFormBean.tertiaryGroupIdNumber}"
												name="patientFormBean.tertiaryGroupIdNumber" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Tertiary Policy Provider Name</td>
											<td><input type="text"
												value="${patientFormBean.tertiaryPolicyProviderName}"
												name="patientFormBean.tertiaryPolicyProviderName"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Tertiary Provider DOB</td>
											<td><input type="text"
												value="${patientFormBean.tertiaryProviderDOB}"
												name="patientFormBean.tertiaryProviderDOB" tabindex="2"
												size="25"></td>
										</tr>


										<tr>
											<td width="15%">Insurance Phone Number</td>
											<td><input type="text"
												value="${patientFormBean.insurancePhoneNumber}"
												name="patientFormBean.insurancePhoneNumber" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Authorised Visits</td>
											<td><input type="text"
												value="${patientFormBean.authorisedVisits}"
												name="patientFormBean.authorisedVisits" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Validity Dates</td>
											<td><input type="text"
												value="${patientFormBean.validityDates}"
												name="patientFormBean.validityDates" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Co-Pay</td>
											<td><input type="text"
												value="${patientFormBean.patientCoPay}"
												name="patientFormBean.patientCoPay" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Co-Insurance</td>
											<td><input type="text"
												value="${patientFormBean.patientCoInsurance}"
												name="patientFormBean.patientCoInsurance" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Deductible</td>
											<td><input type="text"
												value="${patientFormBean.patientDeductible}"
												name="patientFormBean.patientDeductible" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Third Party Payer</td>
											<td><input type="text"
												value="${patientFormBean.thirdPartyPayer}"
												name="patientFormBean.thirdPartyPayer" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Script Required</td>
											<td><input type="text"
												value="${patientFormBean.scriptRequired}"
												name="patientFormBean.scriptRequired" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Payment Notes</td>
											<td><input type="text"
												value="${patientFormBean.paymentNotes}"
												name="patientFormBean.paymentNotes" tabindex="2" size="25"></td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<s:submit value="Submit" />
							</tr>

						</table>
					</s:form>
				</div>


				<!-- 				Third tab in new record -->
				<div id="additionalInfo">

					<s:form action="PatientFormActionUpdate" method="post">
						<input value="${patientFormBean.patientID }" style="display: none"
							name="patientFormBean.patientID"></input>

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
												value="${patientFormBean.treatmentDate}"
												name="patientFormBean.treatmentDate" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Onset Date</td>
											<td><input type="text"
												value="${patientFormBean.onsetDate}"
												name="patientFormBean.onsetDate" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Discharge Date</td>
											<td><input type="text"
												value="${patientFormBean.dischargeDate}"
												name="patientFormBean.dischargeDate" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Facility Name</td>
											<td><input type="text"
												value="${patientFormBean.facilityName}"
												name="patientFormBean.facilityName" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Email Consent</td>
											<td><input type="text"
												value="${patientFormBean.emailConsent}"
												name="patientFormBean.emailConsent" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Body Part</td>
											<td><input type="text"
												value="${patientFormBean.bodyPart}"
												name="patientFormBean.bodyPart" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="15%">Additional Notes</td>
											<td><input type="text"
												value="${patientFormBean.additionalInformationNotes}"
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
												value="${patientFormBean.confidentialStatus}"
												name="patientFormBean.confidentialStatus" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Set By</td>
											<td><input type="text"
												value="${patientFormBean.confidentialSetBy}"
												name="patientFormBean.confidentialSetBy" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="15%">Date</td>
											<td><input type="text"
												value="${patientFormBean.confidentialDate}"
												name="patientFormBean.confidentialDate" tabindex="2"
												size="25"></td>
										</tr>
									</table>
								</td>
							</tr>

							<tr>
								<s:submit value="Submit" />
							</tr>

						</table>
					</s:form>
				</div>
			</div>



			<!-- tab for open record -->
			<div id="scheduleAppointments"></div>
			<!-- 		tab for create new record -->
			<div id="newRecord"></div>

			<div id="faxOut"></div>
			<div id="checkIn"></div>
			<div id="faxIn"></div>
			<div id="faxOut"></div>

		</div>
	</div>


</body>
</html>
