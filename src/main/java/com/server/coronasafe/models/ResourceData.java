package com.server.coronasafe.models;

public class ResourceData
{
	private String upvotes;

	private String description;

	private String external_id;

	private String is_duplicate;

	private String title;

	private String verification_status;

	private String Assigned_to;

	private String data_name;

	private String data_id;

	private String price;

	private String state;

	private String state_id;

	private String email;

	private String phone_2;

	private String phone_1;

	private String pincode;

	private String address;

	private String resource_type;

	private String downvotes;

	private String created_by;

	private String source_link;

	private String verified_by;

	private String deleted;

	private String last_verified_on;

	private String created_on;

	private String district;

	private String created_job;

	private String comment;

	private String district_id;

	private String category;

	private String quantity_available;

	public String getUpvotes ()
	{
		return upvotes;
	}

	public void setUpvotes (String upvotes)
	{
		this.upvotes = upvotes;
	}

	public String getDescription ()
	{
		return description;
	}

	public void setDescription (String description)
	{
		this.description = description;
	}

	public String getExternal_id ()
	{
		return external_id;
	}

	public void setExternal_id (String external_id)
	{
		this.external_id = external_id;
	}

	public String getIs_duplicate ()
	{
		return is_duplicate;
	}

	public void setIs_duplicate (String is_duplicate)
	{
		this.is_duplicate = is_duplicate;
	}

	public String getTitle ()
	{
		return title;
	}

	public void setTitle (String title)
	{
		this.title = title;
	}

	public String getVerification_status ()
	{
		return verification_status;
	}

	public void setVerification_status (String verification_status)
	{
		this.verification_status = verification_status;
	}

	public String getAssigned_to ()
	{
		return Assigned_to;
	}

	public void setAssigned_to (String Assigned_to)
	{
		this.Assigned_to = Assigned_to;
	}

	public String getData_name ()
	{
		return data_name;
	}

	public void setData_name (String data_name)
	{
		this.data_name = data_name;
	}

	public String getData_id ()
	{
		return data_id;
	}

	public void setData_id (String data_id)
	{
		this.data_id = data_id;
	}

	public String getPrice ()
	{
		return price;
	}

	public void setPrice (String price)
	{
		this.price = price;
	}

	public String getState ()
	{
		return state;
	}

	public void setState (String state)
	{
		this.state = state;
	}

	public String getState_id ()
	{
		return state_id;
	}

	public void setState_id (String state_id)
	{
		this.state_id = state_id;
	}

	public String getEmail ()
	{
		return email;
	}

	public void setEmail (String email)
	{
		this.email = email;
	}

	public String getPhone_2 ()
	{
		return phone_2;
	}

	public void setPhone_2 (String phone_2)
	{
		this.phone_2 = phone_2;
	}

	public String getPhone_1 ()
	{
		return phone_1;
	}

	public void setPhone_1 (String phone_1)
	{
		this.phone_1 = phone_1;
	}

	public String getPincode ()
	{
		return pincode;
	}

	public void setPincode (String pincode)
	{
		this.pincode = pincode;
	}

	public String getAddress ()
	{
		return address;
	}

	public void setAddress (String address)
	{
		this.address = address;
	}

	public String getResource_type ()
	{
		return resource_type;
	}

	public void setResource_type (String resource_type)
	{
		this.resource_type = resource_type;
	}

	public String getDownvotes ()
	{
		return downvotes;
	}

	public void setDownvotes (String downvotes)
	{
		this.downvotes = downvotes;
	}

	public String getCreated_by ()
	{
		return created_by;
	}

	public void setCreated_by (String created_by)
	{
		this.created_by = created_by;
	}

	public String getSource_link ()
	{
		return source_link;
	}

	public void setSource_link (String source_link)
	{
		this.source_link = source_link;
	}

	public String getVerified_by ()
	{
		return verified_by;
	}

	public void setVerified_by (String verified_by)
	{
		this.verified_by = verified_by;
	}

	public String getDeleted ()
	{
		return deleted;
	}

	public void setDeleted (String deleted)
	{
		this.deleted = deleted;
	}

	public String getLast_verified_on ()
	{
		return last_verified_on;
	}

	public void setLast_verified_on (String last_verified_on)
	{
		this.last_verified_on = last_verified_on;
	}

	public String getCreated_on ()
	{
		return created_on;
	}

	public void setCreated_on (String created_on)
	{
		this.created_on = created_on;
	}

	public String getDistrict ()
	{
		return district;
	}

	public void setDistrict (String district)
	{
		this.district = district;
	}

	public String getCreated_job ()
	{
		return created_job;
	}

	public void setCreated_job (String created_job)
	{
		this.created_job = created_job;
	}

	public String getComment ()
	{
		return comment;
	}

	public void setComment (String comment)
	{
		this.comment = comment;
	}

	public String getDistrict_id ()
	{
		return district_id;
	}

	public void setDistrict_id (String district_id)
	{
		this.district_id = district_id;
	}

	public String getCategory ()
	{
		return category;
	}

	public void setCategory (String category)
	{
		this.category = category;
	}

	public String getQuantity_available ()
	{
		return quantity_available;
	}

	public void setQuantity_available (String quantity_available)
	{
		this.quantity_available = quantity_available;
	}


	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Assigned_to == null) ? 0 : Assigned_to.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((created_by == null) ? 0 : created_by.hashCode());
		result = prime * result + ((created_job == null) ? 0 : created_job.hashCode());
		result = prime * result + ((created_on == null) ? 0 : created_on.hashCode());
		result = prime * result + ((data_id == null) ? 0 : data_id.hashCode());
		result = prime * result + ((data_name == null) ? 0 : data_name.hashCode());
		result = prime * result + ((deleted == null) ? 0 : deleted.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((district == null) ? 0 : district.hashCode());
		result = prime * result + ((district_id == null) ? 0 : district_id.hashCode());
		result = prime * result + ((downvotes == null) ? 0 : downvotes.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((external_id == null) ? 0 : external_id.hashCode());
		result = prime * result + ((is_duplicate == null) ? 0 : is_duplicate.hashCode());
		result = prime * result + ((last_verified_on == null) ? 0 : last_verified_on.hashCode());
		result = prime * result + ((phone_1 == null) ? 0 : phone_1.hashCode());
		result = prime * result + ((phone_2 == null) ? 0 : phone_2.hashCode());
		result = prime * result + ((pincode == null) ? 0 : pincode.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((quantity_available == null) ? 0 : quantity_available.hashCode());
		result = prime * result + ((resource_type == null) ? 0 : resource_type.hashCode());
		result = prime * result + ((source_link == null) ? 0 : source_link.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((state_id == null) ? 0 : state_id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((upvotes == null) ? 0 : upvotes.hashCode());
		result = prime * result + ((verification_status == null) ? 0 : verification_status.hashCode());
		result = prime * result + ((verified_by == null) ? 0 : verified_by.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResourceData other = (ResourceData) obj;
		if (Assigned_to == null) {
			if (other.Assigned_to != null)
				return false;
		} else if (!Assigned_to.equals(other.Assigned_to))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (created_by == null) {
			if (other.created_by != null)
				return false;
		} else if (!created_by.equals(other.created_by))
			return false;
		if (created_job == null) {
			if (other.created_job != null)
				return false;
		} else if (!created_job.equals(other.created_job))
			return false;
		if (created_on == null) {
			if (other.created_on != null)
				return false;
		} else if (!created_on.equals(other.created_on))
			return false;
		if (data_id == null) {
			if (other.data_id != null)
				return false;
		} else if (!data_id.equals(other.data_id))
			return false;
		if (data_name == null) {
			if (other.data_name != null)
				return false;
		} else if (!data_name.equals(other.data_name))
			return false;
		if (deleted == null) {
			if (other.deleted != null)
				return false;
		} else if (!deleted.equals(other.deleted))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (district_id == null) {
			if (other.district_id != null)
				return false;
		} else if (!district_id.equals(other.district_id))
			return false;
		if (downvotes == null) {
			if (other.downvotes != null)
				return false;
		} else if (!downvotes.equals(other.downvotes))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (external_id == null) {
			if (other.external_id != null)
				return false;
		} else if (!external_id.equals(other.external_id))
			return false;
		if (is_duplicate == null) {
			if (other.is_duplicate != null)
				return false;
		} else if (!is_duplicate.equals(other.is_duplicate))
			return false;
		if (last_verified_on == null) {
			if (other.last_verified_on != null)
				return false;
		} else if (!last_verified_on.equals(other.last_verified_on))
			return false;
		if (phone_1 == null) {
			if (other.phone_1 != null)
				return false;
		} else if (!phone_1.equals(other.phone_1))
			return false;
		if (phone_2 == null) {
			if (other.phone_2 != null)
				return false;
		} else if (!phone_2.equals(other.phone_2))
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
		if (quantity_available == null) {
			if (other.quantity_available != null)
				return false;
		} else if (!quantity_available.equals(other.quantity_available))
			return false;
		if (resource_type == null) {
			if (other.resource_type != null)
				return false;
		} else if (!resource_type.equals(other.resource_type))
			return false;
		if (source_link == null) {
			if (other.source_link != null)
				return false;
		} else if (!source_link.equals(other.source_link))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (state_id == null) {
			if (other.state_id != null)
				return false;
		} else if (!state_id.equals(other.state_id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (upvotes == null) {
			if (other.upvotes != null)
				return false;
		} else if (!upvotes.equals(other.upvotes))
			return false;
		if (verification_status == null) {
			if (other.verification_status != null)
				return false;
		} else if (!verification_status.equals(other.verification_status))
			return false;
		if (verified_by == null) {
			if (other.verified_by != null)
				return false;
		} else if (!verified_by.equals(other.verified_by))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResourceData [upvotes=");
		builder.append(upvotes);
		builder.append(", description=");
		builder.append(description);
		builder.append(", external_id=");
		builder.append(external_id);
		builder.append(", is_duplicate=");
		builder.append(is_duplicate);
		builder.append(", title=");
		builder.append(title);
		builder.append(", verification_status=");
		builder.append(verification_status);
		builder.append(", Assigned_to=");
		builder.append(Assigned_to);
		builder.append(", data_name=");
		builder.append(data_name);
		builder.append(", data_id=");
		builder.append(data_id);
		builder.append(", price=");
		builder.append(price);
		builder.append(", state=");
		builder.append(state);
		builder.append(", state_id=");
		builder.append(state_id);
		builder.append(", email=");
		builder.append(email);
		builder.append(", phone_2=");
		builder.append(phone_2);
		builder.append(", phone_1=");
		builder.append(phone_1);
		builder.append(", pincode=");
		builder.append(pincode);
		builder.append(", address=");
		builder.append(address);
		builder.append(", resource_type=");
		builder.append(resource_type);
		builder.append(", downvotes=");
		builder.append(downvotes);
		builder.append(", created_by=");
		builder.append(created_by);
		builder.append(", source_link=");
		builder.append(source_link);
		builder.append(", verified_by=");
		builder.append(verified_by);
		builder.append(", deleted=");
		builder.append(deleted);
		builder.append(", last_verified_on=");
		builder.append(last_verified_on);
		builder.append(", created_on=");
		builder.append(created_on);
		builder.append(", district=");
		builder.append(district);
		builder.append(", created_job=");
		builder.append(created_job);
		builder.append(", comment=");
		builder.append(comment);
		builder.append(", district_id=");
		builder.append(district_id);
		builder.append(", category=");
		builder.append(category);
		builder.append(", quantity_available=");
		builder.append(quantity_available);
		builder.append("]");
		return builder.toString();
	}


}
