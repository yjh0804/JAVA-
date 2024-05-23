package Test3;


import java.io.*;
import java.util.*;

public class Test3 {
    public static void main(String[] args) {
        SubwayGraph subwayGraph = new SubwayGraph();
        try {
            subwayGraph.loadFromFile("E:/大作业/subway.txt");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter start station:");
            String startStationName = scanner.nextLine();
            System.out.println("Enter end station:");
            String endStationName = scanner.nextLine();

            SubwayStation start = new SubwayStation(startStationName);
            SubwayStation end = new SubwayStation(endStationName);

            List<List<SubwayStation>> paths = subwayGraph.findAllPaths(start, end);

            for (int i = 0; i < paths.size(); i++) {
                System.out.println("Path " + (i + 1) + ": " + paths.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}