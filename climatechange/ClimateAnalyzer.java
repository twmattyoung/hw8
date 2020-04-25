package climatechange;

import java.util.*;

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
		ITemperature lowest = records.get(0);
		for (ITemperature record : records) {
			if (record.getCountry().equals(country) && record.getMonth().equals(WeatherIO.monthTab.get(month))) {
				if (record.getTemperature(true) <= lowest.getTemperature(true)) {
					lowest = record;
				}
        	}
        }
        return lowest;
    }

	public ITemperature getHighestTempByMonth(String country, int month) {
		ITemperature highest = records.get(0);
		for (ITemperature record : records) {
			if (record.getCountry().equals(country) && record.getMonth().equals(WeatherIO.monthTab.get(month))) {
				if (record.getTemperature(true) >= highest.getTemperature(true)) {
					highest = record;
				}
        	}
        }
        return highest;
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
            System.out.print("Enter Month(1-12) : ");
            String month = scanner.nextLine();
            System.out.println(analyzer.getLowestTempByMonth(country, Integer.valueOf(month)));
            A1.add(analyzer.getLowestTempByMonth(country, Integer.valueOf(month))); 
            System.out.println(analyzer.getHighestTempByMonth(country, Integer.valueOf(month)));
            A1.add(analyzer.getHighestTempByMonth(country, Integer.valueOf(month))); 
            
        } 
    }
}
