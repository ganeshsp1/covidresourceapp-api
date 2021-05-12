package com.server.coronasafe.models.io.quicktype;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ResourceData {
    private String state;
    private String district;
    private String stateID;
    private String districtID;
    private String dataName;
    private UUID externalID;
    private String dataID;
    private String category;
    private String phone1;
    private boolean isDuplicate;
    private long downvotes;
    private long upvotes;
    private long createdJob;
    private String title;
    private String status;
    private String address;
    private String comment;
    private boolean deleted;
    private String phone2;
    private String sourceLink;
    private String lastVerifiedOn;
    private String quantityAvailable;
    private String verificationStatus;
    private String email;
    private String price;
    private String pincode;
    private String createdBy;
    private String createdOn;
    private String description;
    private String verifiedBy;
    private String resourceType;
    private String lastVerified;
    private String city;
    private String pinCode;
    private String hospitalAvailableIcuBeds;
    private String hospitalAvailableNormalBeds;
    private String hospitalAvailableOxygenBeds;
    private String hospitalAvailableVentilatorBeds;
    private String details;
    private String otherComments;
    private String resourceType2;
    private String salesRentaCharity;
    private String oxygenSupplierWillingToJoinWhatsAppBot;
    private String latitude;
    private String longitude;
    private String assignedTo;
    private String datumResourceType;
    private String selectedByUser;

    @JsonProperty("state")
    public String getState() { return state; }
    @JsonProperty("state")
    public void setState(String value) { this.state = value; }

    @JsonProperty("district")
    public String getDistrict() { return district; }
    @JsonProperty("district")
    public void setDistrict(String value) { this.district = value; }

    @JsonProperty("state_id")
    public String getStateID() { return stateID; }
    @JsonProperty("state_id")
    public void setStateID(String value) { this.stateID = value; }

    @JsonProperty("district_id")
    public String getDistrictID() { return districtID; }
    @JsonProperty("district_id")
    public void setDistrictID(String value) { this.districtID = value; }

    @JsonProperty("data_name")
    public String getDataName() { return dataName; }
    @JsonProperty("data_name")
    public void setDataName(String value) { this.dataName = value; }

    @JsonProperty("external_id")
    public UUID getExternalID() { return externalID; }
    @JsonProperty("external_id")
    public void setExternalID(UUID value) { this.externalID = value; }

    @JsonProperty("data_id")
    public String getDataID() { return dataID; }
    @JsonProperty("data_id")
    public void setDataID(String value) { this.dataID = value; }

    @JsonProperty("category")
    public String getCategory() { return category; }
    @JsonProperty("category")
    public void setCategory(String value) { this.category = value; }

    @JsonProperty("phone_1")
    public String getPhone1() { return phone1; }
    @JsonProperty("phone_1")
    public void setPhone1(String value) { this.phone1 = value; }

    @JsonProperty("is_duplicate")
    public boolean getIsDuplicate() { return isDuplicate; }
    @JsonProperty("is_duplicate")
    public void setIsDuplicate(boolean value) { this.isDuplicate = value; }

    @JsonProperty("downvotes")
    public long getDownvotes() { return downvotes; }
    @JsonProperty("downvotes")
    public void setDownvotes(long value) { this.downvotes = value; }

    @JsonProperty("upvotes")
    public long getUpvotes() { return upvotes; }
    @JsonProperty("upvotes")
    public void setUpvotes(long value) { this.upvotes = value; }

    @JsonProperty("created_job")
    public long getCreatedJob() { return createdJob; }
    @JsonProperty("created_job")
    public void setCreatedJob(long value) { this.createdJob = value; }

    @JsonProperty("title")
    public String getTitle() { return title; }
    @JsonProperty("title")
    public void setTitle(String value) { this.title = value; }

    @JsonProperty("Status")
    public String getStatus() { return status; }
    @JsonProperty("Status")
    public void setStatus(String value) { this.status = value; }

    @JsonProperty("address")
    public String getAddress() { return address; }
    @JsonProperty("address")
    public void setAddress(String value) { this.address = value; }

    @JsonProperty("comment")
    public String getComment() { return comment; }
    @JsonProperty("comment")
    public void setComment(String value) { this.comment = value; }

    @JsonProperty("deleted")
    public boolean getDeleted() { return deleted; }
    @JsonProperty("deleted")
    public void setDeleted(boolean value) { this.deleted = value; }

    @JsonProperty("phone_2")
    public String getPhone2() { return phone2; }
    @JsonProperty("phone_2")
    public void setPhone2(String value) { this.phone2 = value; }

    @JsonProperty("source_link")
    public String getSourceLink() { return sourceLink; }
    @JsonProperty("source_link")
    public void setSourceLink(String value) { this.sourceLink = value; }

    @JsonProperty("last_verified_on")
    public String getLastVerifiedOn() { return lastVerifiedOn; }
    @JsonProperty("last_verified_on")
    public void setLastVerifiedOn(String value) { this.lastVerifiedOn = value; }

    @JsonProperty("quantity_available")
    public String getQuantityAvailable() { return quantityAvailable; }
    @JsonProperty("quantity_available")
    public void setQuantityAvailable(String value) { this.quantityAvailable = value; }

    @JsonProperty("verification_status")
    public String getVerificationStatus() { return verificationStatus; }
    @JsonProperty("verification_status")
    public void setVerificationStatus(String value) { this.verificationStatus = value; }

    @JsonProperty("email")
    public String getEmail() { return email; }
    @JsonProperty("email")
    public void setEmail(String value) { this.email = value; }

    @JsonProperty("price")
    public String getPrice() { return price; }
    @JsonProperty("price")
    public void setPrice(String value) { this.price = value; }

    @JsonProperty("pincode")
    public String getPincode() { return pincode; }
    @JsonProperty("pincode")
    public void setPincode(String value) { this.pincode = value; }

    @JsonProperty("created_by")
    public String getCreatedBy() { return createdBy; }
    @JsonProperty("created_by")
    public void setCreatedBy(String value) { this.createdBy = value; }

    @JsonProperty("created_on")
    public String getCreatedOn() { return createdOn; }
    @JsonProperty("created_on")
    public void setCreatedOn(String value) { this.createdOn = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("verified_by")
    public String getVerifiedBy() { return verifiedBy; }
    @JsonProperty("verified_by")
    public void setVerifiedBy(String value) { this.verifiedBy = value; }

    @JsonProperty("resource type")
    public String getResourceType() { return resourceType; }
    @JsonProperty("resource type")
    public void setResourceType(String value) { this.resourceType = value; }

    @JsonProperty("last verified")
    public String getLastVerified() { return lastVerified; }
    @JsonProperty("last verified")
    public void setLastVerified(String value) { this.lastVerified = value; }

    @JsonProperty("city")
    public String getCity() { return city; }
    @JsonProperty("city")
    public void setCity(String value) { this.city = value; }

    @JsonProperty("pin_code")
    public String getPinCode() { return pinCode; }
    @JsonProperty("pin_code")
    public void setPinCode(String value) { this.pinCode = value; }

    @JsonProperty("hospital_available_icu_beds")
    public String getHospitalAvailableIcuBeds() { return hospitalAvailableIcuBeds; }
    @JsonProperty("hospital_available_icu_beds")
    public void setHospitalAvailableIcuBeds(String value) { this.hospitalAvailableIcuBeds = value; }

    @JsonProperty("hospital_available_normal_beds")
    public String getHospitalAvailableNormalBeds() { return hospitalAvailableNormalBeds; }
    @JsonProperty("hospital_available_normal_beds")
    public void setHospitalAvailableNormalBeds(String value) { this.hospitalAvailableNormalBeds = value; }

    @JsonProperty("hospital_available_oxygen_beds")
    public String getHospitalAvailableOxygenBeds() { return hospitalAvailableOxygenBeds; }
    @JsonProperty("hospital_available_oxygen_beds")
    public void setHospitalAvailableOxygenBeds(String value) { this.hospitalAvailableOxygenBeds = value; }

    @JsonProperty("hospital_available_ventilator_beds")
    public String getHospitalAvailableVentilatorBeds() { return hospitalAvailableVentilatorBeds; }
    @JsonProperty("hospital_available_ventilator_beds")
    public void setHospitalAvailableVentilatorBeds(String value) { this.hospitalAvailableVentilatorBeds = value; }

    @JsonProperty("Details")
    public String getDetails() { return details; }
    @JsonProperty("Details")
    public void setDetails(String value) { this.details = value; }

    @JsonProperty("Other comments")
    public String getOtherComments() { return otherComments; }
    @JsonProperty("Other comments")
    public void setOtherComments(String value) { this.otherComments = value; }

    @JsonProperty("resource type_2")
    public String getResourceType2() { return resourceType2; }
    @JsonProperty("resource type_2")
    public void setResourceType2(String value) { this.resourceType2 = value; }

    @JsonProperty("Sales/Renta/Charity")
    public String getSalesRentaCharity() { return salesRentaCharity; }
    @JsonProperty("Sales/Renta/Charity")
    public void setSalesRentaCharity(String value) { this.salesRentaCharity = value; }

    @JsonProperty("oxygen supplier willing to join WhatsAppBot")
    public String getOxygenSupplierWillingToJoinWhatsAppBot() { return oxygenSupplierWillingToJoinWhatsAppBot; }
    @JsonProperty("oxygen supplier willing to join WhatsAppBot")
    public void setOxygenSupplierWillingToJoinWhatsAppBot(String value) { this.oxygenSupplierWillingToJoinWhatsAppBot = value; }

    @JsonProperty("latitude")
    public String getLatitude() { return latitude; }
    @JsonProperty("latitude")
    public void setLatitude(String value) { this.latitude = value; }

    @JsonProperty("longitude")
    public String getLongitude() { return longitude; }
    @JsonProperty("longitude")
    public void setLongitude(String value) { this.longitude = value; }

    @JsonProperty("Assigned_to")
    public String getAssignedTo() { return assignedTo; }
    @JsonProperty("Assigned_to")
    public void setAssignedTo(String value) { this.assignedTo = value; }

    @JsonProperty("resource_type")
    public String getDatumResourceType() { return datumResourceType; }
    @JsonProperty("resource_type")
    public void setDatumResourceType(String value) { this.datumResourceType = value; }

    @JsonProperty("Selected By User")
    public String getSelectedByUser() { return selectedByUser; }
    @JsonProperty("Selected By User")
    public void setSelectedByUser(String value) { this.selectedByUser = value; }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((assignedTo == null) ? 0 : assignedTo.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + (int) (createdJob ^ (createdJob >>> 32));
		result = prime * result + ((createdOn == null) ? 0 : createdOn.hashCode());
		result = prime * result + ((dataID == null) ? 0 : dataID.hashCode());
		result = prime * result + ((dataName == null) ? 0 : dataName.hashCode());
		result = prime * result + ((datumResourceType == null) ? 0 : datumResourceType.hashCode());
		result = prime * result + (deleted ? 1231 : 1237);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((district == null) ? 0 : district.hashCode());
		result = prime * result + ((districtID == null) ? 0 : districtID.hashCode());
		result = prime * result + (int) (downvotes ^ (downvotes >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((externalID == null) ? 0 : externalID.hashCode());
		result = prime * result + ((hospitalAvailableIcuBeds == null) ? 0 : hospitalAvailableIcuBeds.hashCode());
		result = prime * result + ((hospitalAvailableNormalBeds == null) ? 0 : hospitalAvailableNormalBeds.hashCode());
		result = prime * result + ((hospitalAvailableOxygenBeds == null) ? 0 : hospitalAvailableOxygenBeds.hashCode());
		result = prime * result
				+ ((hospitalAvailableVentilatorBeds == null) ? 0 : hospitalAvailableVentilatorBeds.hashCode());
		result = prime * result + (isDuplicate ? 1231 : 1237);
		result = prime * result + ((lastVerified == null) ? 0 : lastVerified.hashCode());
		result = prime * result + ((lastVerifiedOn == null) ? 0 : lastVerifiedOn.hashCode());
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((otherComments == null) ? 0 : otherComments.hashCode());
		result = prime * result + ((oxygenSupplierWillingToJoinWhatsAppBot == null) ? 0
				: oxygenSupplierWillingToJoinWhatsAppBot.hashCode());
		result = prime * result + ((phone1 == null) ? 0 : phone1.hashCode());
		result = prime * result + ((phone2 == null) ? 0 : phone2.hashCode());
		result = prime * result + ((pinCode == null) ? 0 : pinCode.hashCode());
		result = prime * result + ((pincode == null) ? 0 : pincode.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((quantityAvailable == null) ? 0 : quantityAvailable.hashCode());
		result = prime * result + ((resourceType == null) ? 0 : resourceType.hashCode());
		result = prime * result + ((resourceType2 == null) ? 0 : resourceType2.hashCode());
		result = prime * result + ((salesRentaCharity == null) ? 0 : salesRentaCharity.hashCode());
		result = prime * result + ((selectedByUser == null) ? 0 : selectedByUser.hashCode());
		result = prime * result + ((sourceLink == null) ? 0 : sourceLink.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((stateID == null) ? 0 : stateID.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + (int) (upvotes ^ (upvotes >>> 32));
		result = prime * result + ((verificationStatus == null) ? 0 : verificationStatus.hashCode());
		result = prime * result + ((verifiedBy == null) ? 0 : verifiedBy.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResourceData other = (ResourceData) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (assignedTo == null) {
			if (other.assignedTo != null)
				return false;
		} else if (!assignedTo.equals(other.assignedTo))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (createdJob != other.createdJob)
			return false;
		if (createdOn == null) {
			if (other.createdOn != null)
				return false;
		} else if (!createdOn.equals(other.createdOn))
			return false;
		if (dataID == null) {
			if (other.dataID != null)
				return false;
		} else if (!dataID.equals(other.dataID))
			return false;
		if (dataName == null) {
			if (other.dataName != null)
				return false;
		} else if (!dataName.equals(other.dataName))
			return false;
		if (datumResourceType == null) {
			if (other.datumResourceType != null)
				return false;
		} else if (!datumResourceType.equals(other.datumResourceType))
			return false;
		if (deleted != other.deleted)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (districtID == null) {
			if (other.districtID != null)
				return false;
		} else if (!districtID.equals(other.districtID))
			return false;
		if (downvotes != other.downvotes)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (externalID == null) {
			if (other.externalID != null)
				return false;
		} else if (!externalID.equals(other.externalID))
			return false;
		if (hospitalAvailableIcuBeds == null) {
			if (other.hospitalAvailableIcuBeds != null)
				return false;
		} else if (!hospitalAvailableIcuBeds.equals(other.hospitalAvailableIcuBeds))
			return false;
		if (hospitalAvailableNormalBeds == null) {
			if (other.hospitalAvailableNormalBeds != null)
				return false;
		} else if (!hospitalAvailableNormalBeds.equals(other.hospitalAvailableNormalBeds))
			return false;
		if (hospitalAvailableOxygenBeds == null) {
			if (other.hospitalAvailableOxygenBeds != null)
				return false;
		} else if (!hospitalAvailableOxygenBeds.equals(other.hospitalAvailableOxygenBeds))
			return false;
		if (hospitalAvailableVentilatorBeds == null) {
			if (other.hospitalAvailableVentilatorBeds != null)
				return false;
		} else if (!hospitalAvailableVentilatorBeds.equals(other.hospitalAvailableVentilatorBeds))
			return false;
		if (isDuplicate != other.isDuplicate)
			return false;
		if (lastVerified == null) {
			if (other.lastVerified != null)
				return false;
		} else if (!lastVerified.equals(other.lastVerified))
			return false;
		if (lastVerifiedOn == null) {
			if (other.lastVerifiedOn != null)
				return false;
		} else if (!lastVerifiedOn.equals(other.lastVerifiedOn))
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (otherComments == null) {
			if (other.otherComments != null)
				return false;
		} else if (!otherComments.equals(other.otherComments))
			return false;
		if (oxygenSupplierWillingToJoinWhatsAppBot == null) {
			if (other.oxygenSupplierWillingToJoinWhatsAppBot != null)
				return false;
		} else if (!oxygenSupplierWillingToJoinWhatsAppBot.equals(other.oxygenSupplierWillingToJoinWhatsAppBot))
			return false;
		if (phone1 == null) {
			if (other.phone1 != null)
				return false;
		} else if (!phone1.equals(other.phone1))
			return false;
		if (phone2 == null) {
			if (other.phone2 != null)
				return false;
		} else if (!phone2.equals(other.phone2))
			return false;
		if (pinCode == null) {
			if (other.pinCode != null)
				return false;
		} else if (!pinCode.equals(other.pinCode))
			return false;
		if (pincode == null) {
			if (other.pincode != null)
				return false;
		} else if (!pincode.equals(other.pincode))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantityAvailable == null) {
			if (other.quantityAvailable != null)
				return false;
		} else if (!quantityAvailable.equals(other.quantityAvailable))
			return false;
		if (resourceType == null) {
			if (other.resourceType != null)
				return false;
		} else if (!resourceType.equals(other.resourceType))
			return false;
		if (resourceType2 == null) {
			if (other.resourceType2 != null)
				return false;
		} else if (!resourceType2.equals(other.resourceType2))
			return false;if (salesRentaCharity == null) {
			if (other.salesRentaCharity != null)
				return false;
		} else if (!salesRentaCharity.equals(other.salesRentaCharity))
			return false;
		if (selectedByUser == null) {
			if (other.selectedByUser != null)
				return false;
		} else if (!selectedByUser.equals(other.selectedByUser))
			return false;
		if (sourceLink == null) {
			if (other.sourceLink != null)
				return false;
		} else if (!sourceLink.equals(other.sourceLink))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (stateID == null) {
			if (other.stateID != null)
				return false;
		} else if (!stateID.equals(other.stateID))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (upvotes != other.upvotes)
			return false;
		if (verificationStatus == null) {
			if (other.verificationStatus != null)
				return false;
		} else if (!verificationStatus.equals(other.verificationStatus))
			return false;
		if (verifiedBy == null) {
			if (other.verifiedBy != null)
				return false;
		} else if (!verifiedBy.equals(other.verifiedBy))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResourceData [state=");
		builder.append(state);
		builder.append(", district=");
		builder.append(district);
		builder.append(", stateID=");
		builder.append(stateID);
		builder.append(", districtID=");
		builder.append(districtID);
		builder.append(", dataName=");
		builder.append(dataName);
		builder.append(", externalID=");
		builder.append(externalID);
		builder.append(", dataID=");
		builder.append(dataID);
		builder.append(", category=");
		builder.append(category);
		builder.append(", phone1=");
		builder.append(phone1);
		builder.append(", isDuplicate=");
		builder.append(isDuplicate);
		builder.append(", downvotes=");
		builder.append(downvotes);
		builder.append(", upvotes=");
		builder.append(upvotes);
		builder.append(", createdJob=");
		builder.append(createdJob);
		builder.append(", title=");
		builder.append(title);
		builder.append(", status=");
		builder.append(status);
		builder.append(", address=");
		builder.append(address);
		builder.append(", comment=");
		builder.append(comment);
		builder.append(", deleted=");
		builder.append(deleted);
		builder.append(", phone2=");
		builder.append(phone2);
		builder.append(", sourceLink=");
		builder.append(sourceLink);
		builder.append(", lastVerifiedOn=");
		builder.append(lastVerifiedOn);
		builder.append(", quantityAvailable=");
		builder.append(quantityAvailable);
		builder.append(", verificationStatus=");
		builder.append(verificationStatus);
		builder.append(", email=");
		builder.append(email);
		builder.append(", price=");
		builder.append(price);
		builder.append(", pincode=");
		builder.append(pincode);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", createdOn=");
		builder.append(createdOn);
		builder.append(", description=");
		builder.append(description);
		builder.append(", verifiedBy=");
		builder.append(verifiedBy);
		builder.append(", resourceType=");
		builder.append(resourceType);
		builder.append(", lastVerified=");
		builder.append(lastVerified);
		builder.append(", city=");
		builder.append(city);
		builder.append(", pinCode=");
		builder.append(pinCode);
		builder.append(", hospitalAvailableIcuBeds=");
		builder.append(hospitalAvailableIcuBeds);
		builder.append(", hospitalAvailableNormalBeds=");
		builder.append(hospitalAvailableNormalBeds);
		builder.append(", hospitalAvailableOxygenBeds=");
		builder.append(hospitalAvailableOxygenBeds);
		builder.append(", hospitalAvailableVentilatorBeds=");
		builder.append(hospitalAvailableVentilatorBeds);
		builder.append(", details=");
		builder.append(details);
		builder.append(", otherComments=");
		builder.append(otherComments);
		builder.append(", resourceType2=");
		builder.append(resourceType2);
		builder.append(", salesRentaCharity=");
		builder.append(salesRentaCharity);
		builder.append(", oxygenSupplierWillingToJoinWhatsAppBot=");
		builder.append(oxygenSupplierWillingToJoinWhatsAppBot);
		builder.append(", latitude=");
		builder.append(latitude);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append(", assignedTo=");
		builder.append(assignedTo);
		builder.append(", datumResourceType=");
		builder.append(datumResourceType);
		builder.append(", selectedByUser=");
		builder.append(selectedByUser);
		builder.append("]");
		return builder.toString();
	}
        
}

// Category.java

