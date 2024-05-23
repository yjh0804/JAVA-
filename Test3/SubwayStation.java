package Test3;

public class SubwayStation {
    String name;

    SubwayStation(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SubwayStation subwayStation = (SubwayStation) obj;
        return name.equals(subwayStation.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}
