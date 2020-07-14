package com.example.mowch;

public class ExampleDriver {

    private int imageResource;
    private String driverName;

    public ExampleDriver(int imageResource, String driverName) {
        this.imageResource = imageResource;
        this.driverName = driverName;

    }

    public int getImageResource() {
        return imageResource;
    }

    public String getDriverName() {
        return driverName;
    }
}
