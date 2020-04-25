package climatechange;

import java.util.*;
import java.io.*;

public class WeatherIO implements IWeatherIO {
    public static final Map<Integer, String> monthTab;

    static {
        Map<Integer, String> months = new HashMap<Integer, String>();
        months.put(1, "Jan");
        months.put(2, "Feb");
        months.put(3, "Mar");
        months.put(4, "Apr");
        months.put(5, "May");
        months.put(6, "Jun");
        months.put(7, "Jul");
        months.put(8, "Aug");
        months.put(9, "Sep");
        months.put(10, "Oct");
        months.put(11, "Nov");
        months.put(12, "Dec");
        monthTab = Collections.unmodifiableMap(months);
    }

    public ArrayList<ITemperature> readDataFromFile(String fileName) throws Exception {
        ArrayList<ITemperature> temperatures = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine(); // Skip first line for header
            line = br.readLine();
            while (line != null) {
                String[] records = line.split("\\s*,\\s*");
                if (records.length != Temperature.NUM_RECORDS) {
                    System.err.println("Error record number " + line);
                } 
                else {
                    try {
                        double temp = Double.valueOf(records[0]);
                        int year = Integer.valueOf(records[1]);
                        // Temperature, Year, Month_Avg, Country, Country_Code
                        // Temperature(String country, String iso3116, String month, int year, double temp) {
                        temperatures.add(new Temperature(records[3], records[4], records[2], year, temp));
                    }
                    catch(Exception e) {
                        System.err.println("Error record format: " + line);
                    }
                }

                line = br.readLine();
            }
        }

        return temperatures;
    }

	public void writeSubjectHeaderInFile(String fileName, String subject) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(subject);
        }
    }

	public void writeDataToFile(String fileName, String topic, ArrayList<ITemperature> theWeatherList) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(topic);
        }
    }
}


