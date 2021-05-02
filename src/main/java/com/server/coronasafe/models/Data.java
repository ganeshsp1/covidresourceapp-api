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
    public String toString()
    {
        return "ClassPojo [data = "+data+"]";
    }
}
