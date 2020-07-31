package com.example.mowch;

public class ExampleRoute {

    private int imageResource;
    private Route route;
    private boolean isExpanded;
    private boolean assigned;

    public ExampleRoute(int imageResource, Route route) {
        this.imageResource = imageResource;
        this.route = route;
        this.assigned = route.getDriverAssigned() != null;

    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }
}
