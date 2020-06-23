package com.example.mowch;

public class Address {

    private String first;
    private String last;
    private String addressLine;
    private String city;
    private boolean skipped;
    private boolean delivered;
    private String extraInfo;

    public Address(String first, String last, String addressLine, String city, boolean skipped, String extraInfo) {
        this.first = first;
        this.last = last;
        this.addressLine = addressLine;
        this.city = city;
        this.skipped = skipped;
        this.extraInfo = extraInfo;
        delivered = false;
    }

    public Address(String first, String last, String addressLine, String city, String extraInfo) {
        this.first = first;
        this.last = last;
        this.addressLine = addressLine;
        this.city = city;
        skipped = false;
        this.extraInfo = extraInfo;
        delivered = false;
    }

    public boolean isSkipped() {
        return skipped;
    }

    public void setSkipped(boolean skipped) {
        this.skipped = skipped;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }
}
