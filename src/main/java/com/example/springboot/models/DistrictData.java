package com.example.springboot.models;
public class DistrictData
{
    private String doctor;

    private String hospitals;

    private String helpline;

    private String contact;

    private String district;

    private String medicine;

    private String ambulance;

    private String id;

    private String state;

    private String oxygen;

    public String getDoctor ()
    {
        return doctor;
    }

    public void setDoctor (String doctor)
    {
        this.doctor = doctor;
    }

    public String getHospitals ()
    {
        return hospitals;
    }

    public void setHospitals (String hospitals)
    {
        this.hospitals = hospitals;
    }

    public String getHelpline ()
    {
        return helpline;
    }

    public void setHelpline (String helpline)
    {
        this.helpline = helpline;
    }

    public String getContact ()
    {
        return contact;
    }

    public void setContact (String contact)
    {
        this.contact = contact;
    }

    public String getDistrict ()
    {
        return district;
    }

    public void setDistrict (String district)
    {
        this.district = district;
    }

    public String getMedicine ()
    {
        return medicine;
    }

    public void setMedicine (String medicine)
    {
        this.medicine = medicine;
    }

    public String getAmbulance ()
    {
        return ambulance;
    }

    public void setAmbulance (String ambulance)
    {
        this.ambulance = ambulance;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getState ()
    {
        return state;
    }

    public void setState (String state)
    {
        this.state = state;
    }

    public String getOxygen ()
    {
        return oxygen;
    }

    public void setOxygen (String oxygen)
    {
        this.oxygen = oxygen;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [doctor = "+doctor+", hospitals = "+hospitals+", helpline = "+helpline+", contact = "+contact+", district = "+district+", medicine = "+medicine+", ambulance = "+ambulance+", id = "+id+", state = "+state+", oxygen = "+oxygen+"]";
    }
}