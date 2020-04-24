package climatechange;

import java.util.ArrayList;

interface IWeatherIO {
	public ArrayList<ITemperature> readDataFromFile(String fileName) throws Exception;
	public void writeSubjectHeaderInFile(String filename, String subject) throws Exception;
	public void writeDataToFile(String filename, String topic, ArrayList<ITemperature> theWeatherList) throws Exception;
}
