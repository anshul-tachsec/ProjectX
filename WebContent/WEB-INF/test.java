			if(patientFormBean.getFirstName().toCharArray().length!=0 && patientFormBean.() !=null ){
				cc2=" or first_name = '"+patientFormBean.getFirstName()+"'";
				System.out.println("first"+patientFormBean.getFirstName());
			}
			else{
				cc2="";
			}
			if(patientFormBean.getAge().toCharArray().length!=0 && patientFormBean.() !=null){
				c1=" or  age= '"+patientFormBean.getAge()+"'"; }
			else{
				c1=""; 
				}

			if( patientFormBean.getGender().toCharArray().length!=0 && patientFormBean.() !=null){
				c2=" or  gender= '"+patientFormBean.getGender()+"'";
				} 
			else{ 
					c2="";
				}

			if( patientFormBean.getMaritalStatus().toCharArray().length!=0 && patientFormBean.() !=null){
				
				c3=" or  marital_status= '"+patientFormBean.getMaritalStatus()+"'"; 
				} 
			else{ 
				c3="";
				}

			if( patientFormBean.getEmpStatus().toCharArray().length!=0 && patientFormBean.() !=null){ c4=" or  emp_status= '"+patientFormBean.getEmpStatus()+"'"; } else{ c4=""; }

			if( patientFormBean.getTreatingProvider().toCharArray().length!=0 && patientFormBean.() !=null){ c5=" or  treating_provider= '"+patientFormBean.getTreatingProvider()+"'"; } else{ c5=""; }

			if( patientFormBean.getReferringProvider().toCharArray().length!=0 && patientFormBean.() !=null){ c6=" or  referring_provider= '"+patientFormBean.getReferringProvider()+"'"; } else{ c6=""; }

			if( patientFormBean.getRelationGuarantor().toCharArray().length!=0 && patientFormBean.() !=null){ c7=" or  relation_guarantor= '"+patientFormBean.getRelationGuarantor()+"'"; } else{ c7=""; }

			if( patientFormBean.getPatientDOB().toCharArray().length!=0 && patientFormBean.() !=null){ c8=" or  DOB= '"+patientFormBean.getPatientDOB()+"'"; } else{ c8=""; }

			if( patientFormBean.getPatientRace().toCharArray().length!=0 && patientFormBean.() !=null){ c9=" or  race= '"+patientFormBean.getPatientRace()+"'"; } else{ c9=""; }

			if( patientFormBean.getPatientEthinicity().toCharArray().length!=0 && patientFormBean.() !=null){ c10=" or  ethnicity= '"+patientFormBean.getPatientEthinicity()+"'"; } else{ c10=""; }

			if( patientFormBean.getPatientLanguage().toCharArray().length!=0 && patientFormBean.() !=null){ c11=" or  language= '"+patientFormBean.getPatientLanguage()+"'"; } else{ c11=""; }

			if( patientFormBean.getMothersMaiden().toCharArray().length!=0 && patientFormBean.() !=null){ c12=" or  mothers_maiden= '"+patientFormBean.getMothersMaiden()+"'"; } else{ c12=""; }

			if( patientFormBean.getPatientSSN().toCharArray().length!=0 && patientFormBean.() !=null){ c13=" or  SSN= '"+patientFormBean.getPatientSSN()+"'"; } else{ c13=""; }

			if( patientFormBean.getPatientDOO().toCharArray().length!=0 && patientFormBean.() !=null){ c14=" or  DOO= '"+patientFormBean.getPatientDOO()+"'"; } else{ c14=""; }

			if( patientFormBean.getResidentialStreet().toCharArray().length!=0 && patientFormBean.() !=null){ c15=" or  res_street= '"+patientFormBean.getResidentialStreet()+"'"; } else{ c15=""; }

			if( patientFormBean.getResidentialCity().toCharArray().length!=0 && patientFormBean.() !=null){ c16=" or  res_city= '"+patientFormBean.getResidentialCity()+"'"; } else{ c16=""; }

			if( patientFormBean.getResidentialState().toCharArray().length!=0 && patientFormBean.() !=null){ c17=" or  res_state= '"+patientFormBean.getResidentialState()+"'"; } else{ c17=""; }

			if( patientFormBean.getResidentialZipcode().toCharArray().length!=0 && patientFormBean.() !=null){ c18=" or  res_zip= '"+patientFormBean.getResidentialZipcode()+"'"; } else{ c18=""; }

			if( patientFormBean.getMailStreet().toCharArray().length!=0 && patientFormBean.() !=null){ c19=" or  mail_street= '"+patientFormBean.getMailStreet()+"'"; } else{ c19=""; }

			if( patientFormBean.getMailCity().toCharArray().length!=0 && patientFormBean.() !=null){ c20=" or  mail_city= '"+patientFormBean.getMailCity()+"'"; } else{ c20=""; }

			if( patientFormBean.getMailState().toCharArray().length!=0 && patientFormBean.() !=null){ c21=" or  mail_state= '"+patientFormBean.getMailState()+"'"; } else{ c21=""; }

			if( patientFormBean.getMailZipcode().toCharArray().length!=0 && patientFormBean.() !=null){ c22=" or  mail_zip= '"+patientFormBean.getMailZipcode()+"'"; } else{ c22=""; }

			if( patientFormBean.getLastVisitDate().toCharArray().length!=0 && patientFormBean.() !=null){ c23=" or  last_visit= '"+patientFormBean.getLastVisitDate()+"'"; } else{ c23=""; }

			if( patientFormBean.getHomePhone().toCharArray().length!=0 && patientFormBean.() !=null){ c24=" or  home_ph= '"+patientFormBean.getHomePhone()+"'"; } else{ c24=""; }

			if( patientFormBean.getWorkPhone().toCharArray().length!=0 && patientFormBean.() !=null){ c25=" or  work_ph= '"+patientFormBean.getWorkPhone()+"'"; } else{ c25=""; }

			if( patientFormBean.getCellPhone().toCharArray().length!=0 && patientFormBean.() !=null){ c26=" or  cell_ph= '"+patientFormBean.getCellPhone()+"'"; } else{ c26=""; }

			if( patientFormBean.getPatientEmail().toCharArray().length!=0 && patientFormBean.() !=null){ c27=" or  email= '"+patientFormBean.getPatientEmail()+"'"; } else{ c27=""; }

			if( patientFormBean.getReminderMethod().toCharArray().length!=0 && patientFormBean.() !=null){ c28=" or  recall_method= '"+patientFormBean.getReminderMethod()+"'"; } else{ c28=""; }

			if( patientFormBean.getDemographicsNotes().toCharArray().length!=0 && patientFormBean.() !=null){ c29=" or  free_text_main= '"+patientFormBean.getDemographicsNotes()+"'"; } else{ c29=""; }

			if( patientFormBean.getConfidentialStatus().toCharArray().length!=0 && patientFormBean.() !=null){ c30=" or  conf_status= '"+patientFormBean.getConfidentialStatus()+"'"; } else{ c30=""; }

			if( patientFormBean.getConfidentialSetBy().toCharArray().length!=0 && patientFormBean.() !=null){ c31=" or  conf_set_by= '"+patientFormBean.getConfidentialSetBy()+"'"; } else{ c31=""; }

			if( patientFormBean.getConfidentialDate().toCharArray().length!=0 && patientFormBean.() !=null){ c32=" or  conf_date= '"+patientFormBean.getConfidentialDate()+"'"; } else{ c32=""; }

			if( patientFormBean.getTreatmentDate().toCharArray().length!=0 && patientFormBean.() !=null){ c33=" or  treatment_date= '"+patientFormBean.getTreatmentDate()+"'"; } else{ c33=""; }

			if( patientFormBean.getOnsetDate().toCharArray().length!=0 && patientFormBean.() !=null){ c34=" or  onset_date= '"+patientFormBean.getOnsetDate()+"'"; } else{ c34=""; }

			if( patientFormBean.getDischargeDate().toCharArray().length!=0 && patientFormBean.() !=null){ c35=" or  discharge_date= '"+patientFormBean.getDischargeDate()+"'"; } else{ c35=""; }

			if( patientFormBean.getFacilityName().toCharArray().length!=0 && patientFormBean.() !=null){ c36=" or  facility_name= '"+patientFormBean.getFacilityName()+"'"; } else{ c36=""; }

			if( patientFormBean.getEmailConsent().toCharArray().length!=0 && patientFormBean.() !=null){ c37=" or  email_consent= '"+patientFormBean.getEmailConsent()+"'"; } else{ c37=""; }

			if( patientFormBean.getBodyPart().toCharArray().length!=0 && patientFormBean.() !=null){ c38=" or  body_part= '"+patientFormBean.getBodyPart()+"'"; } else{ c38=""; }

			if( patientFormBean.getAdditionalInformationNotes().toCharArray().length!=0 && patientFormBean.() !=null){ c39=" or  free_text_additional_info= '"+patientFormBean.getAdditionalInformationNotes()+"'"; } else{ c39=""; }

			if( patientFormBean.getPatientConsent().toCharArray().length!=0 && patientFormBean.() !=null){ c40=" or  patient_consent= '"+patientFormBean.getPatientConsent()+"'"; } else{ c40=""; }

			if( patientFormBean.getConsentDateSet().toCharArray().length!=0 && patientFormBean.() !=null){ c41=" or  consent_date_set= '"+patientFormBean.getConsentDateSet()+"'"; } else{ c41=""; }

			if( patientFormBean.getConsentNotes().toCharArray().length!=0 && patientFormBean.() !=null){ c42=" or  consent_notes= '"+patientFormBean.getConsentNotes()+"'"; } else{ c42=""; }

			if( patientFormBean.getPrimaryInsuranceProvider().toCharArray().length!=0 && patientFormBean.() !=null){ c43=" or  insurance_provider= '"+patientFormBean.getPrimaryInsuranceProvider()+"'"; } else{ c43=""; }

			if( patientFormBean.getPrimaryInsuranceIdNumber().toCharArray().length!=0 && patientFormBean.() !=null){ c44=" or  insurance_id_no= '"+patientFormBean.getPrimaryInsuranceIdNumber()+"'"; } else{ c44=""; }

			if( patientFormBean.getPrimaryGroupIdNumber().toCharArray().length!=0 && patientFormBean.() !=null){ c46=" or insurance_group_id_no = '"+patientFormBean.getPrimaryGroupIdNumber()+"'"; } else{ c46=""; }

			if( patientFormBean.getPrimaryPolicyProviderName().toCharArray().length!=0 && patientFormBean.() !=null){ c47=" or  policy_provider_name= '"+patientFormBean.getPrimaryPolicyProviderName()+"'"; } else{ c47=""; }

			if( patientFormBean.getPrimaryProviderDOB().toCharArray().length!=0 && patientFormBean.() !=null){ c48=" or  policy_provider_DOB= '"+patientFormBean.getPrimaryProviderDOB()+"'"; } else{ c48=""; }

			if( patientFormBean.getPatientAilment().toCharArray().length!=0 && patientFormBean.() !=null){ c49=" or  ailment= '"+patientFormBean.getPatientAilment()+"'"; } else{ c49=""; }

			if( patientFormBean.getSecondaryInsurance().toCharArray().length!=0 && patientFormBean.() !=null){ c50=" or  secondary_insurance= '"+patientFormBean.getSecondaryInsuranceIdNumber()+"'"; } else{ c50=""; }

			if( patientFormBean.getSecondaryInsuranceProvider().toCharArray().length!=0 && patientFormBean.() !=null){ c51=" or  secondary_insurance_provider= '"+patientFormBean.getSecondaryInsuranceProvider()+"'"; } else{ c51=""; }

			if( patientFormBean.getSecondaryInsuranceIdNumber().toCharArray().length!=0 && patientFormBean.() !=null){ c52=" or  secondary_insurance_id_no= '"+patientFormBean.getSecondaryInsuranceIdNumber()+"'"; } else{ c52=""; }

			if( patientFormBean.getSecondaryGroupIdNumber().toCharArray().length!=0 && patientFormBean.() !=null){ c53=" or  secondary_insurance_group_id_no= '"+patientFormBean.getSecondaryGroupIdNumber()+"'"; } else{ c53=""; }

			if( patientFormBean.getSecondaryPolicyProviderName().toCharArray().length!=0 && patientFormBean.() !=null){ c54=" or  secondary_policy_provider_name= '"+patientFormBean.getSecondaryPolicyProviderName()+"'"; } else{ c54=""; }

			if( patientFormBean.getSecondaryProviderDOB().toCharArray().length!=0 && patientFormBean.() !=null){ c55=" or  secondary_policy_provider_DOB= '"+patientFormBean.getSecondaryProviderDOB()+"'"; } else{ c55=""; }

			if( patientFormBean.getTertiaryInsurance().toCharArray().length!=0 && patientFormBean.() !=null){ c56=" or  tertiary_insurance= '"+patientFormBean.getTertiaryInsurance()+"'"; } else{ c56=""; }

			if( patientFormBean.getTertiaryInsuranceProvider().toCharArray().length!=0 && patientFormBean.() !=null){ c57=" or  tertiary_insurance_provider= '"+patientFormBean.getTertiaryInsuranceProvider()+"'"; } else{ c57=""; }

			if( patientFormBean.getTertiaryInsuranceIdNumber().toCharArray().length!=0 && patientFormBean.() !=null){ c58=" or  tertiary_insurance_id_no= '"+patientFormBean.getTertiaryInsuranceIdNumber()+"'"; } else{ c58=""; }

			if( patientFormBean.getTertiaryGroupIdNumber().toCharArray().length!=0 && patientFormBean.() !=null){ c59=" or  tertiary_insurance_group_id_no= '"+patientFormBean.getTertiaryGroupIdNumber()+"'"; } else{ c59=""; }

			if( patientFormBean.getTertiaryPolicyProviderName().toCharArray().length!=0 && patientFormBean.() !=null){ c60=" or  tertiary_policy_provider_name= '"+patientFormBean.getTertiaryPolicyProviderName()+"'"; } else{ c60=""; }

			if( patientFormBean.getTertiaryProviderDOB().toCharArray().length!=0 && patientFormBean.() !=null){ c61=" or  tertiary_policy_provider_name= '"+patientFormBean.getTertiaryProviderDOB()+"'"; } else{ c61=""; }

			if( patientFormBean.getInsurancePhoneNumber().toCharArray().length!=0 && patientFormBean.() !=null){ c62=" or  insurance_ph_number= '"+patientFormBean.getInsurancePhoneNumber()+"'"; } else{ c62=""; }

			if( patientFormBean.getAuthorisedVisits().toCharArray().length!=0 && patientFormBean.() !=null){ c63=" or  authorised_visits= '"+patientFormBean.getAuthorisedVisits()+"'"; } else{ c63=""; }

			if( patientFormBean.getValidityDates().toCharArray().length!=0 && patientFormBean.() !=null){ c64=" or  validity_date= '"+patientFormBean.getValidityDates()+"'"; } else{ c64=""; }

			if( patientFormBean.getPatientCoPay().toCharArray().length!=0 && patientFormBean.() !=null){ c65=" or  copay= '"+patientFormBean.getPatientCoPay()+"'"; } else{ c65=""; }

			if( patientFormBean.getPatientCoInsurance().toCharArray().length!=0 && patientFormBean.() !=null){ c66=" or coinsurance = '"+patientFormBean.getPatientCoInsurance()+"'"; } else{ c66=""; }

			if( patientFormBean.getPatientDeductible().toCharArray().length!=0 && patientFormBean.() !=null){ c67=" or  deductible= '"+patientFormBean.getPatientDeductible()+"'"; } else{ c67=""; }

			if( patientFormBean.getThirdPartyPayer().toCharArray().length!=0 && patientFormBean.() !=null){ c68=" or  third_party_payer= '"+patientFormBean.getThirdPartyPayer()+"'"; } else{ c68=""; }

			if( patientFormBean.getScriptRequired().toCharArray().length!=0 && patientFormBean.() !=null){ c69=" or  script_required= '"+patientFormBean.getScriptRequired()+"'"; } else{ c69=""; }
