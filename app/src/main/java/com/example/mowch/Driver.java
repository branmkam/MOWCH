package com.example.mowch;

public class Driver extends Account {

    private Route route;
    private AdminInterface admin;

    public Driver(String name, String email, String password,
                  Route route, AdminInterface admin) {
        super(name, email, password);
        this.route = route;
        this.admin = admin;
    }

    public Driver(String name, String email, String password) {
        super(name, email, password);
        this.route = null;
        this.admin = null;
    }

    public Driver(String name, String email, String password, Route route) {
        super(name, email, password);
        this.route = route;
        this.admin = null;
    }

    public Driver(String name, String email, String password, AdminInterface admin) {
        super(name, email, password);
        this.route = null;
        this.admin = admin;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public AdminInterface getAdmin() {
        return admin;
    }

    public void setAdmin(AdminInterface admin) {
        this.admin = admin;
    }

    //methods
    public boolean reportEmergency()
    {
        //call respective admin number
        return false;
    }

    public boolean updateDeliveryStatus(Address a)
    {
        if(a != null) {
            a.setDelivered(true);
            return true;
        }
        else
        {
            return false;
        }
    }



}
