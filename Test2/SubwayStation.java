package Test2;


public class SubwayStation {
    private final String name;
    private final String line;
    private final double distance;

    public SubwayStation(String name, String line, double distance) {
        this.name = name;
        this.line = line;
        this.distance = distance;
    }
    public String getName() {
        return name;
    }
    public double getDistance() {
        return distance;
    }
    @Override
    public String toString() {
        return String.format("<%s，%s号线，%.3f>", name, line, distance);
    }
}
