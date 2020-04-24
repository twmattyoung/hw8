package climatechange;

public class Temperature implements ITemperature {
    private String country;
    private String iso3116;
    private String month;
    private int year;
    private double tempFah;
    private double tempCen;

    public static final int NUM_RECORDS = 5;

    public Temperature(String country, String iso3116, String month, int year, double temp) {
        this.country = country;
        this.iso3116 = iso3116;
        this.month = month;
        this.year = year;
        this.tempCen = temp;
        this.tempFah = cToF(temp);
    }

    public String getCountry() {
        return country;
    }

    public String getCountry3LetterCode() {
        return iso3116;
    }
    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public double getTemperature(boolean getFahrenheit) {
        return getFahrenheit ? tempFah : tempCen;
    }

    public String toString() {
        return String.format("%.2f(C), %.2f(F), %d, %s, %s, %s", 
                    this.getTemperature(false),
                    this.getTemperature(true),
                    this.getYear(),
                    this.getMonth(),
                    this.getCountry(),
                    this.getCountry3LetterCode()
                    );
    }

    private double cToF(double temp) {
        return (9.0 / 5) * temp + 32;
    }
}
