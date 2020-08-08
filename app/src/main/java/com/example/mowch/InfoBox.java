package com.example.mowch;

public class InfoBox {
    private int imageResource;
    private String driverName;
    private boolean isExpanded;
    private boolean assigned;
    private boolean read;

    public InfoBox(int imageResource, String driverName) {
        this.imageResource = imageResource;
        this.driverName = driverName;
        read = false;
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

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
