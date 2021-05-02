package com.server.coronasafe.models;

import java.util.List;

public class Data
{
    private List<Object> data;

    public List<Object> getData ()
    {
        return data;
    }

    public void setData (List<Object> data)
    {
        this.data = data;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Data [data=");
		builder.append(data);
		builder.append(", getData()=");
		builder.append(getData());
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
