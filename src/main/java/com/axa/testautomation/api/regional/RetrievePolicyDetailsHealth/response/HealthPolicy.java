package com.axa.testautomation.api.regional.RetrievePolicyDetailsHealth.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HealthPolicy {

	@SerializedName("issuingBranchCode1")
	@Expose
	private String issuingBranchCode1;
	@SerializedName("originalInceptionDate")
	@Expose
	private String originalInceptionDate;
	@SerializedName("policyEffectiveDate")
	@Expose
	private String policyEffectiveDate;
	@SerializedName("policyExpirationDate")
	@Expose
	private String policyExpirationDate;
	@SerializedName("policyNumber")
	@Expose
	private String policyNumber;
	@SerializedName("policyStatusCode")
	@Expose
	private String policyStatusCode;
	@SerializedName("producingAgentCode1")
	@Expose
	private String producingAgentCode1;
	@SerializedName("productCode")
	@Expose
	private String productCode;
	@SerializedName("sourceSystemCode")
	@Expose
	private String sourceSystemCode;
	@SerializedName("certificateNumber")
	@Expose
	private String certificateNumber;
	@SerializedName("policyRenewalDate")
	@Expose
	private String policyRenewalDate;
	@SerializedName("product")
	@Expose
	private Product product;
	@SerializedName("partyRoles")
	@Expose
	private List<PartyRole> partyRoles = null;
	@SerializedName("corePolicyAgents")
	@Expose
	private List<CorePolicyAgent> corePolicyAgents = null;
	@SerializedName("oldPolicyNumber")
	@Expose
	private String oldPolicyNumber;
	@SerializedName("PolicyCoverage")
	@Expose
	private List<PolicyCoverage> policyCoverage = null;
	@SerializedName("PolicyInstallment")
	@Expose
	private PolicyInstallment policyInstallment;
	
	public String getIssuingBranchCode1() {
	return issuingBranchCode1;
	}
	
	public void setIssuingBranchCode1(String issuingBranchCode1) {
	this.issuingBranchCode1 = issuingBranchCode1;
	}
	
	public String getOriginalInceptionDate() {
	return originalInceptionDate;
	}
	
	public void setOriginalInceptionDate(String originalInceptionDate) {
	this.originalInceptionDate = originalInceptionDate;
	}
	
	public String getPolicyEffectiveDate() {
	return policyEffectiveDate;
	}
	
	public void setPolicyEffectiveDate(String policyEffectiveDate) {
	this.policyEffectiveDate = policyEffectiveDate;
	}
	
	public String getPolicyExpirationDate() {
	return policyExpirationDate;
	}
	
	public void setPolicyExpirationDate(String policyExpirationDate) {
	this.policyExpirationDate = policyExpirationDate;
	}
	
	public String getPolicyNumber() {
	return policyNumber;
	}
	
	public void setPolicyNumber(String policyNumber) {
	this.policyNumber = policyNumber;
	}
	
	public String getPolicyStatusCode() {
	return policyStatusCode;
	}
	
	public void setPolicyStatusCode(String policyStatusCode) {
	this.policyStatusCode = policyStatusCode;
	}
	
	public String getProducingAgentCode1() {
	return producingAgentCode1;
	}
	
	public void setProducingAgentCode1(String producingAgentCode1) {
	this.producingAgentCode1 = producingAgentCode1;
	}
	
	public String getProductCode() {
	return productCode;
	}
	
	public void setProductCode(String productCode) {
	this.productCode = productCode;
	}
	
	public String getSourceSystemCode() {
	return sourceSystemCode;
	}
	
	public void setSourceSystemCode(String sourceSystemCode) {
	this.sourceSystemCode = sourceSystemCode;
	}
	
	public String getCertificateNumber() {
	return certificateNumber;
	}
	
	public void setCertificateNumber(String certificateNumber) {
	this.certificateNumber = certificateNumber;
	}
	
	public String getPolicyRenewalDate() {
	return policyRenewalDate;
	}
	
	public void setPolicyRenewalDate(String policyRenewalDate) {
	this.policyRenewalDate = policyRenewalDate;
	}
	
	public Product getProduct() {
	return product;
	}
	
	public void setProduct(Product product) {
	this.product = product;
	}
	
	public List<PartyRole> getPartyRoles() {
	return partyRoles;
	}
	
	public void setPartyRoles(List<PartyRole> partyRoles) {
	this.partyRoles = partyRoles;
	}
	
	public List<CorePolicyAgent> getCorePolicyAgents() {
	return corePolicyAgents;
	}
	
	public void setCorePolicyAgents(List<CorePolicyAgent> corePolicyAgents) {
	this.corePolicyAgents = corePolicyAgents;
	}
	
	public String getOldPolicyNumber() {
	return oldPolicyNumber;
	}
	
	public void setOldPolicyNumber(String oldPolicyNumber) {
	this.oldPolicyNumber = oldPolicyNumber;
	}
	
	public List<PolicyCoverage> getPolicyCoverage() {
	return policyCoverage;
	}
	
	public void setPolicyCoverage(List<PolicyCoverage> policyCoverage) {
	this.policyCoverage = policyCoverage;
	}
	
	public PolicyInstallment getPolicyInstallment() {
	return policyInstallment;
	}
	
	public void setPolicyInstallment(PolicyInstallment policyInstallment) {
	this.policyInstallment = policyInstallment;
	}

}
