/*
 * In a file named City.java, implement the class described below.

The City class must have the following private instance variables:

a variable named name that will store a String
a variable named state that will store a String
a variable named highTemp that will store a double
a variable named lowTemp that will store a double
The City class must have the following public constructor method:

an overloaded constructor that takes four arguments. The first argument will be a String (city name). The second argument will be a String (state name). The third (high temp.) and fourth (low temp.) arguments will be type double.
The City class must have the following public methods:

a method named getName. This accessor method will take no arguments. This method will return a String.
a method named getState. This accessor method will take no arguments. This method will return a String.
a method named getHighTemp. This accessor method will take no arguments. This method will return a double.
a method named setHighTemp. This mutator method will take one double argument. This method will not return anything.
a method named getLowTemp. This accessor method will take no arguments. This method will return a double.
a method named setLowTemp. This mutator method will take one double argument. This method will not return anything.
a method named printInfo. This method will take no arguments. This method will not return anything.
Other Details

The overloaded constructor should initialize the object's name, state, highTemp and lowTemp variables with the values passed in to the parameter variables.
The getName accessor method should simply return the value stored in the object's name variable.
The getState accessor method should simply return the value stored in the object's state variable.
The getHighTemp accessor method should simply return the value currently stored in the object's highTemp variable.
The setHighTemp mutator method should store the value passed in as an argument in the object's highTemp variable.
The getLowTemp accessor method should simply return the value currently stored in the object's lowTemp variable.
The setLowTemp mutator method should store the value passed in as an argument in the object's lowTemp variable.
The printInfo method should print out to the console, the name, state, high temp., and low temp. The printout should look like this:
Denver, Colorado (High = 31.00, Low = -6.00)
Note that the temperature values always have 2 decimal places of precision.
 */

public class City {
  private String name;
  private String state;
  private double highTemp;
  private double lowTemp;

  public City(String initName, String initState, double initHighTemp, double initLowtemp) {
    name = initName;
    state = initState;
    highTemp = initHighTemp;
    lowTemp = initLowtemp;
  }

  // getters
  public String getName() {
    return name;
  }

  public String getState() {
    return state;
  }

  public double getHighTemp() {
    return highTemp;
  }

  public double getLowTemp() {
    return lowTemp;
  }

  // setters
  public void setHighTemp(double newHighTemp) {
    highTemp = newHighTemp;
  }

  public void setLowTemp(double newLowTemp) {
    lowTemp = newLowTemp;
  }

  // displayers
  public void printInfo() {
    System.out.printf("%s, %s (High = %.2f, Low = %.2f)\n", getName(), getState(), getHighTemp(), getLowTemp());
  }
}