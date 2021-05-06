package com.server.coronasafe.models;

public class ResourceQuery
{
	private boolean active;
	private String state;
	private String district;
	private Timestamp lastmodified;	
    private String resource;
	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}
	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	/**
	 * @return the lastmodified
	 */
	public Timestamp getLastmodified() {
		return lastmodified;
	}
	/**
	 * @param lastmodified the lastmodified to set
	 */
	public void setLastmodified(Timestamp lastmodified) {
		this.lastmodified = lastmodified;
	}
	/**
	 * @return the resources
	 */
	public String getResource() {
		return resource;
	}
	/**
	 * @param resources the resources to set
	 */
	public void setResources(String resource) {
		this.resource = resource;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((district == null) ? 0 : district.hashCode());
		result = prime * result + ((lastmodified == null) ? 0 : lastmodified.hashCode());
		result = prime * result + ((resource == null) ? 0 : resource.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		ResourceQuery other = (ResourceQuery) obj;
		if (active != other.active)
			return false;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (lastmodified == null) {
			if (other.lastmodified != null)
				return false;
		} else if (!lastmodified.equals(other.lastmodified))
			return false;
		if (resource == null) {
			if (other.resource != null)
				return false;
		} else if (!resource.equals(other.resource))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResourceQuery [active=");
		builder.append(active);
		builder.append(", state=");
		builder.append(state);
		builder.append(", district=");
		builder.append(district);
		builder.append(", lastmodified=");
		builder.append(lastmodified);
		builder.append(", resources=");
		builder.append(resource);
		builder.append("]");
		return builder.toString();
	}
}
