package com.server.coronasafe.models.io.quicktype;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.*;

public class Data {
    private List<ResourceData> data;

    @JsonProperty("data")
    public List<ResourceData> getData() { return data; }
    @JsonProperty("data")
    public void setData(List<ResourceData> value) { this.data = value; }
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
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
		Data other = (Data) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Data [data=");
		builder.append(data);
		builder.append("]");
		return builder.toString();
	}
	
}

// Datum.java

