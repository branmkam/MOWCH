package com.example.mowch;

import java.util.*;

public class Admin extends Account implements AdminInterface  {

    ArrayList<Driver> drivers;

    public Admin(String name, int number, String username, String email, String password) {
        super(name, number, username, email, password);
    }

    public Admin(String name, int number, String username, String email, String password, ArrayList<Driver> drivers) {
        super(name, number, username, email, password);
        this.drivers = drivers;
    }

    //methods
    @Override
    public boolean assignRoute(Driver d, Route r) {
        d.setRoute(r);
        String s = "Your route has been updated to Route " + r.getRouteNum();
        notifyDriver(d, s);
        return true;
    }

    @Override
    public boolean removeRoute(Driver d, Route r) {
        d.setRoute(null);
        String s = "Your route has been removed.";
        notifyDriver(d, s);
        return true;
    }

    @Override
    public boolean notifyDriver(Driver d, String s) {
        return false;
        //find a way to send message to driver
    }

    @Override
    public boolean notifyDrivers(String s) {
        for (Driver d : drivers) {
            notifyDriver(d, s);
        }
        return true;
    }

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(ArrayList<Driver> drivers) {
        this.drivers = drivers;
    }
}
