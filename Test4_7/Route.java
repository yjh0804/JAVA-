package Test4_7;

import java.util.ArrayList;

public class Route {
    private String name;
    private ArrayList<Interval> intevals = new ArrayList();

    public Route() {
    }

    public ArrayList<Interval> getIntevals() {
        return this.intevals;
    }

    public void setIntevals(ArrayList<Interval> intevals) {
        this.intevals = intevals;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
