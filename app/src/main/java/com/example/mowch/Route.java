package com.example.mowch;

import java.util.*;

public class Route {

    private ArrayList<String> addresses;
    private int routeNum;

    public Route(int routeNum) {
        this.routeNum = routeNum;
        addresses = new ArrayList<>();
    }

    public ArrayList<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<String> addresses) {
        this.addresses = addresses;
    }

    public int getRouteNum() {
        return routeNum;
    }

    public void setRouteNum(int routeNum) {
        this.routeNum = routeNum;
    }
}
