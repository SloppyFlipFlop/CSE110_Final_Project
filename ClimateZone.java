
/*
 * In a file named ClimateZone.java, implement the class described below.

The ClimateZone class must have the following private instance variables:

a variable named cityList that will store a reference to an ArrayList<City>
The ClimateZone class must have the following public constructor methods:

a default constructor
an overloaded constructor that takes one argument. This argument will be a String.
The ClimateZone class must have the following public methods:

a method named addCity. This method will take four arguments. The first argument will be a String (city name). The second argument will be a String (state name). The third (high temp.) and fourth (low temp.) arguments will be type double.
a method named getCityCount. This method will take no arguments. This method will return an int.
a method named getCityByName. This method will take two String arguments. This method will return a City reference.
a method named printHottestCities. This method will take no arguments. This method will not return anything.
a method named printColdestCities. This method will take no arguments. This method will not return anything.
a method named printAllCities. This method will take no arguments. This method will not return anything.
Other Details

The default constructor should instantiate a new ArrayList object, and store a reference to this object in the ClimateZone's cityList instance variable.
The overloaded constructor should instantiate a new ArrayList object, and store a reference to this object in the ClimateZone's cityList instance variable. It should then open the climate zone data file named in the parameter variable. It should then read in the data from this file and, for each line in the file, it should create (instantiate) a new City object with the name, state, high temp., and low temp. on that line, and add this City to the ArrayList cityList.
The addCity method should instantiate a new City object with the name, state, high temp., and low temp. provided in the argument values, and then add this City to the ClimateZone's ArrayList<City> object.
The getCityCount method should return the number of cities currently stored in the ClimateZone's ArrayList<City> object.
The getCityByName method should iterate through the ClimateZone's ArrayList<City> object and search for a City with a name and state that are equal to the argument values. If such a City is found, then this method should return a reference to that City object, otherwise this method should return null.
The printHottestCities method should determine the two Cities objects with the highest high temps. (in descending order). It should then call the printInfo method on these City objects.
The printColdestCities method should determine the two City objects with the lowest low temps. (in ascending order). It should then call the printInfo method on these City objects.
The printAllCities method should iterate through the ClimateZone's ArrayList<City> object and call the printInfo method on each of these City objects.
 */
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ClimateZone {

  private ArrayList<City> cityList;

  public ClimateZone() {
    cityList = new ArrayList<City>();
  }

  public ClimateZone(ArrayList<City> newCityArray) {
    cityList = newCityArray;
  }

  public ClimateZone(String fileName) throws IOException {
    FileInputStream myFile = new FileInputStream(fileName);
    Scanner myFileReader = new Scanner(myFile);

    ArrayList<City> newCityList = new ArrayList<City>();

    String currentLine;

    String cityName;
    String cityState;
    double highTemp;
    double lowTemp;

    int spaceOneIndex;
    int spaceTwoIndex = 0;
    int spaceThreeIndex;

    while (myFileReader.hasNextLine()) {
      currentLine = myFileReader.nextLine();
      spaceOneIndex = currentLine.indexOf(" ");
      spaceThreeIndex = currentLine.lastIndexOf(" ");
      for (int i = 0; i < currentLine.length(); i++) {
        // finds the second space
        if (currentLine.charAt(i) == ' ' && i > spaceOneIndex && i < spaceThreeIndex) {
          spaceTwoIndex = i;
        }
      }
      cityName = currentLine.substring(0, spaceOneIndex);
      cityState = currentLine.substring(spaceOneIndex + 1, spaceTwoIndex);
      highTemp = Double.parseDouble(currentLine.substring(spaceTwoIndex + 1, spaceThreeIndex));
      lowTemp = Double.parseDouble(currentLine.substring(spaceThreeIndex + 1, currentLine.length()));
      City currentCity = new City(cityName, cityState, highTemp, lowTemp);
      newCityList.add(currentCity);
    }
    myFileReader.close();
    // outputs an array of player objects
    cityList = newCityList;
  }

  // getters
  public int getCityCount() {
    int count = 0;
    for (int i = 0; i < cityList.size(); i++) {
      ++count;
    }
    return count;
  }

  public City getCityByName(String cityName, String state) {
    for (City city : this.cityList) {
      if (city.getName().equals(cityName) && city.getName().equals(cityName)) {
        return city;
      }
    }
    return null;
  }

  private void sortHottestCities() {
    for (int i = 0; i < cityList.size() - 1; i++) {
      for (int x = i + 1; x < cityList.size(); x++) {
        if (cityList.get(i).getHighTemp() < cityList.get(x).getHighTemp()) {
          City city = cityList.get(i);
          cityList.set(i, cityList.get(x));
          cityList.set(x, city);
        }
      }
    }
  }

  private void sortColdestCities() {
    for (int i = 0; i < cityList.size() - 1; i++) {
      for (int x = i + 1; x < cityList.size(); x++) {
        if (cityList.get(i).getLowTemp() > cityList.get(x).getLowTemp()) {
          City city = cityList.get(i);
          cityList.set(i, cityList.get(x));
          cityList.set(x, city);
        }
      }
    }
  }

  // setters

  public void addCity(String cityName, String stateName, double cityHighTemp, double cityLowTemp) {
    City newCity = new City(cityName, stateName, cityHighTemp, cityLowTemp);
    cityList.add(newCity);
  }

  // displayers

  public void printHottestCities() {
    sortHottestCities();
    cityList.get(0).printInfo();
    cityList.get(1).printInfo();
  }

  public void printColdestCities() {
    sortColdestCities();
    cityList.get(0).printInfo();
    cityList.get(1).printInfo();
  }

  public void printAllCities() {

    // for each loop that goes through each item in the loop and prints the info of
    // each object
    for (City city : this.cityList) {
      city.printInfo();
    }
  }

}