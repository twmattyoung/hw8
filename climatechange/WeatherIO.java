package climatechange;

import java.util.*;
import java.io.*;

public class WeatherIO implements IWeatherIO {
    public static final Map<String, Integer> monthTab;

    static {
        Map<String, Integer> months = new HashMap<String, Integer>();
        months.put("Jan", 0);
        months.put("Feb", 1);
        months.put("Mar", 2);
        months.put("Apr", 3);
        months.put("May", 4);
        months.put("Jun", 5);
        months.put("Jul", 6);
        months.put("Aug", 7);
        months.put("Sep", 8);
        months.put("Oct", 9);
        months.put("Nov", 10);
        months.put("Dec", 11);
        monthTab = Collections.unmodifiableMap(months);
    }

    public ArrayList<ITemperature> readDataFromFile(String fileName) throws Exception {
        ArrayList<ITemperature> temperatures = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine(); // Skip first line for header
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
                        temperatures.add(new Temperature(records[3], records[4], records[2],
                                        Integer.valueOf(records[1]), Double.valueOf(records[0])));
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

