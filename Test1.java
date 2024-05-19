package Test1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
        SubwayMap subwayMap = new SubwayMap();


        try (BufferedReader br = new BufferedReader(new FileReader("E:/大作业/subway.txt"))) {
            String line;
            String currentLine = null;
            while ((line = br.readLine()) != null) {
                if (line.contains("号线站点间距")) {
                    currentLine = line.split("号线站点间距")[0];
                    subwayMap.addLine(currentLine);
                } else if (line.contains("---") || line.contains("—")) {
                    String separator = line.contains("---") ? "---" : "—";
                    String[] parts = line.split(separator);
                    String station1 = parts[0].trim();

                    String station2 = parts[1].split("\t")[0].trim();
                    double distance = Double.parseDouble(parts[1].split("\t")[1].trim());
                    subwayMap.addStation(currentLine, station1, distance);
                    subwayMap.addStation(currentLine, station2, distance);
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<String> transferStations = subwayMap.getTransferStations();
        System.out.println("Transfer Stations:");
        for (String station : transferStations) {
            System.out.println(station);
        }

        // Example usage

    }
}