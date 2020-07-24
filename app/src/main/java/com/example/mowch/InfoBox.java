package com.example.mowch;

public class InfoBox {
    private int imageResource;
    private String driverName;
    private boolean isExpanded;

    public InfoBox(int imageResource, String driverName) {
        this.imageResource = imageResource;
        this.driverName = driverName;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getDriverName() {
        return driverName;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public void setDriverName(String driverName) { this.driverName = driverName; }
}
