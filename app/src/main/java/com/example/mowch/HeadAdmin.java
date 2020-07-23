package com.example.mowch;

import java.util.*;

public class HeadAdmin extends Account implements AdminInterface {

    private ArrayList<Account> accounts;
    private ArrayList<Driver> drivers;
    private ArrayList<Account> pending;

    public HeadAdmin(String name, int number, String username, String email, String password) {
        super(name, number, username, email, password);
        this.accounts = new ArrayList<>();
        this.pending = new ArrayList<>();
    }

    public HeadAdmin(String name, int number, String username, String email, String password, ArrayList<Account> accounts) {
            super(name, number, username, email, password);
        this.accounts = accounts;
        this.pending = new ArrayList<>();
    }

    public HeadAdmin(String name, int number, String username, String email, String password,
                     ArrayList<Account> accounts, ArrayList<Account> pending) {
        super(name, number, username, email, password);
        this.accounts = accounts;
        this.pending = pending;
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

    public boolean driverToAdmin(Driver d)
    {
        if(accounts.contains(d))
        {
            Admin ad = new Admin(d.getName(), d.getNumber(), d.getUsername(),
                    d.getEmail(), d.getPassword(), drivers);
            accounts.remove(d);
            accounts.add(ad);
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean adminToDriver(Account ad)
    {
        if(accounts.contains(ad) &&
                ad.getClass().toString().equals("Admin") ||
                ad.getClass().toString().equals("HeadAdmin")) {
            Driver d = new Driver(ad.getName(), ad.getNumber(), ad.getUsername(),
                    ad.getEmail(), ad.getPassword());
            accounts.remove(ad);
            accounts.add(d);
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean acceptAccountRequest(Account acc)
    {
        if(pending.contains(acc))
        {
            Driver d = new Driver(acc.getName(), acc.getNumber(), acc.getUsername(),
                    acc.getEmail(), acc.getPassword());
            accounts.add(d);
            pending.remove(acc);
            return true;
        }
        else
        {
            return false;
        }
    }

}
