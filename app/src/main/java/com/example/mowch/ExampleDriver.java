package com.example.mowch;

public class ExampleDriver {

    private int imageResource;
    private Driver driver;
    private boolean isExpanded;

    public ExampleDriver(int imageResource, Driver driver) {
        this.imageResource = imageResource;
        this.driver = driver;
    }

    public int getImageResource() {
        return imageResource;
    }

    public Driver getDriver() {
        return driver;
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

    public void setDriver(Driver driver) { this.driver = driver; }

    public String getDriverName()
    {
        return driver.getName();
    }
}
