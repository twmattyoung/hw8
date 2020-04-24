package climatechange;

import java.utils.ArrayList;
import java.io.*;

public class WeatherIO implements IWeatherIO {
    public ArrayList<Temperature> readDataFromFile(String fileName) {
        ArrayList<Temperature> temperatures = new ArrayList<>();
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
                        temperatures.add(new Temperature());
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

	public void writeSubjectHeaderInFile(String filename, String subject) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(subject);
        }
    }

	public void writeDataToFile(String filename, String topic, ArrayList<ITemperature> theWeatherList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(subject);
        }
    }
}

