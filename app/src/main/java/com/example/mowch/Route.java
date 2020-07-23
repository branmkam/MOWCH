package com.example.mowch;

import java.util.*;

public class Route {

    private ArrayList<Address> addresses;
    private int routeNum;

    public Route(int routeNum) {
        this.routeNum = routeNum;
        addresses = new ArrayList<>();
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }

    public int getRouteNum() {
        return routeNum;
    }

    public void setRouteNum(int routeNum) {
        this.routeNum = routeNum;
    }
}
