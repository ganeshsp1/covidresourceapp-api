package com.server.coronasafe.models;

import java.util.List;

public class User
{
	private boolean active;
	private Timestamp lastlogin;
	private String token;	
    private List<ResourceQuery> queries;
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
	 * @return the lastlogin
	 */
	public Timestamp getLastlogin() {
		return lastlogin;
	}
	/**
	 * @param lastlogin the lastlogin to set
	 */
	public void setLastlogin(Timestamp lastlogin) {
		this.lastlogin = lastlogin;
	}
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @return the queries
	 */
	public List<ResourceQuery> getQueries() {
		return queries;
	}
	/**
	 * @param queries the queries to set
	 */
	public void setQueries(List<ResourceQuery> queries) {
		this.queries = queries;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((lastlogin == null) ? 0 : lastlogin.hashCode());
		result = prime * result + ((queries == null) ? 0 : queries.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
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
		User other = (User) obj;
		if (active != other.active)
			return false;
		if (lastlogin == null) {
			if (other.lastlogin != null)
				return false;
		} else if (!lastlogin.equals(other.lastlogin))
			return false;
		if (queries == null) {
			if (other.queries != null)
				return false;
		} else if (!queries.equals(other.queries))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [active=");
		builder.append(active);
		builder.append(", lastlogin=");
		builder.append(lastlogin);
		builder.append(", token=");
		builder.append(token);
		builder.append(", queries=");
		builder.append(queries);
		builder.append("]");
		return builder.toString();
	}   
}
