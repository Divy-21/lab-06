package com.example.listycity;
/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City>{
    private String city;
    private String province;
    /**
     * Constructor for city,
     * @param city
     *      This is name of the city
     * @param province
     *      This is the province of the city
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }
    /**
     * This returns the city name
     * @return The name of the city
     */
    String getCityName(){
        return this.city;
    }
    /**
     * This returns the province name
     * @return The name of the province
     */
    String getProvinceName(){
        return this.province;
    }
    /**
     * This compares the city to another city based on their name
     * @param o
     *      This is the city to compare against
     * @return
     *      Return the result of the comparison between cities
     *
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());

    }
}
