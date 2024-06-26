package Test4_7;

public class Interval {
    private String[] stops = new String[2];
    private double distance;

    public Interval(String s1, String s2, double d) {
        this.stops[0] = s1;
        this.stops[1] = s2;
        this.distance = d;
    }

    public String[] getStops() {
        return this.stops;
    }

    public void setStops(String[] stops) {
        this.stops = stops;
    }

    public double getDistance() {
        return this.distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
