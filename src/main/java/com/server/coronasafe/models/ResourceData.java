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
		builder.append(", getUpvotes()=");
		builder.append(getUpvotes());
		builder.append(", getDescription()=");
		builder.append(getDescription());
		builder.append(", getExternal_id()=");
		builder.append(getExternal_id());
		builder.append(", getIs_duplicate()=");
		builder.append(getIs_duplicate());
		builder.append(", getTitle()=");
		builder.append(getTitle());
		builder.append(", getVerification_status()=");
		builder.append(getVerification_status());
		builder.append(", getAssigned_to()=");
		builder.append(getAssigned_to());
		builder.append(", getData_name()=");
		builder.append(getData_name());
		builder.append(", getData_id()=");
		builder.append(getData_id());
		builder.append(", getPrice()=");
		builder.append(getPrice());
		builder.append(", getState()=");
		builder.append(getState());
		builder.append(", getState_id()=");
		builder.append(getState_id());
		builder.append(", getEmail()=");
		builder.append(getEmail());
		builder.append(", getPhone_2()=");
		builder.append(getPhone_2());
		builder.append(", getPhone_1()=");
		builder.append(getPhone_1());
		builder.append(", getPincode()=");
		builder.append(getPincode());
		builder.append(", getAddress()=");
		builder.append(getAddress());
		builder.append(", getResource_type()=");
		builder.append(getResource_type());
		builder.append(", getDownvotes()=");
		builder.append(getDownvotes());
		builder.append(", getCreated_by()=");
		builder.append(getCreated_by());
		builder.append(", getSource_link()=");
		builder.append(getSource_link());
		builder.append(", getVerified_by()=");
		builder.append(getVerified_by());
		builder.append(", getDeleted()=");
		builder.append(getDeleted());
		builder.append(", getLast_verified_on()=");
		builder.append(getLast_verified_on());
		builder.append(", getCreated_on()=");
		builder.append(getCreated_on());
		builder.append(", getDistrict()=");
		builder.append(getDistrict());
		builder.append(", getCreated_job()=");
		builder.append(getCreated_job());
		builder.append(", getComment()=");
		builder.append(getComment());
		builder.append(", getDistrict_id()=");
		builder.append(getDistrict_id());
		builder.append(", getCategory()=");
		builder.append(getCategory());
		builder.append(", getQuantity_available()=");
		builder.append(getQuantity_available());
		builder.append(", getClass()=");
		builder.append(getClass());
		builder.append(", hashCode()=");
		builder.append(hashCode());
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

    
}
