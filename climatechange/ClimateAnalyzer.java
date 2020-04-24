package climatechange;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

class MaxAndMin {
    public double maxTemp;
    public double minTemp;
    public MaxAndMin() {
        this.maxTemp = Double.MIN_VALUE;
        this.minTemp = Double.MAX_VALUE;
    }
}

public class ClimateAnalyzer implements IClimateAnalyzer {
    private WeatherIO weatherIO = null;
    private ArrayList<ITemperature> records = new ArrayList<ITemperature>();

    public ClimateAnalyzer() throws Exception {
        weatherIO = new WeatherIO();
        records = weatherIO.readDataFromFile("world_temp_2000-2016.csv");
    }

    public WeatherIO getIO() {
        return weatherIO;
    }

	public ITemperature getLowestTempByMonth(String country, int month) {
        for (ITemperature record : records) {
        }
        return null;
    }

	public ITemperature getHighestTempByMonth(String country, int month) {
        return null;
    }

	public ITemperature getLowestTempByYear(String country, int year){
        return null;
    }

	public ITemperature getHighestTempByYear(String country, int year){
        return null;
    }

	public TreeSet<ITemperature> getTempWithinRange(String country, double rangeLowTemp, double rangeHighTemp){
        return null;
    }

	public ITemperature getLowestTempYearByCountry(String country){
        return null;
    }

	public ITemperature getHighestTempYearByCountry(String country){
        return null;
    }

	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp(int month){
        return null;
    }

	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp(int month){
        return null;
    }

	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp(){
        return null;
    }

	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp(){
        return null;
    }

	public ArrayList<ITemperature> allCountriesGetAllDataWithinTempRange(double lowRangeTemp,double highRangeTemp){
        return null;
    }

	public ArrayList<ITemperature> allCountriesTop10TempDelta(int month, int year1, int year2){
        return null;
    }

	public void runClimateAnalyzer(){}

    public static void main(String[] args) throws Exception {
        ClimateAnalyzer analyzer = new ClimateAnalyzer();
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<ITemperature> A1 = new ArrayList<ITemperature>();
            System.out.print("Enter Country : ");
            String country = scanner.nextLine();
            System.out.print("Enter Month : ");
            String month = scanner.nextLine();
            A1.add(analyzer.getLowestTempByMonth(country, Integer.valueOf(month)));
        }
    }
}
