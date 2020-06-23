package com.example.mowch;

public interface AdminInterface {

    public boolean assignRoute(Driver d, Route r);
    public boolean removeRoute(Driver d, Route r);
    public boolean notifyDrivers(String s);
    public boolean notifyDriver(Driver d, String s);
}
