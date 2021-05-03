package com.server.coronasafe.models;

import java.util.List;


public class ResourceQuery
{
	private boolean active;
	private String state;
	private String district;
	private Timestamp lastmodified;	
    private List<String> resources;
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
	public List<String> getResources() {
		return resources;
	}
	/**
	 * @param resources the resources to set
	 */
	public void setResources(List<String> resources) {
		this.resources = resources;
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
		result = prime * result + ((resources == null) ? 0 : resources.hashCode());
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
		if (resources == null) {
			if (other.resources != null)
				return false;
		} else if (!resources.equals(other.resources))
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
		builder.append(resources);
		builder.append("]");
		return builder.toString();
	}
}
