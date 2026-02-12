package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCity() {
        City city = new City("Yellowknife", "Northwest Territories");
        CityList cityList = mockCityList();
        cityList.add(city);
        City fakeCity = new City("Regina", "Saskatchewan");
        assertTrue(cityList.hasCity(city));
        assertFalse(cityList.hasCity(fakeCity));
    }

    @Test
    public void testDelete() {
        CityList cityList = mockCityList();
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        cityList.deleteCity(city);
        assertEquals(1, cityList.getCities().size());
    }

    @Test
    public void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Vancouver", "British Columbia");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.deleteCity(city);
        });
    }

    @Test
    public void testCountCities() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());
        City city = new City("Yellowknife", "Northwest Territories");
        City blank = mockCity();
        cityList.add(city);
        assertEquals(1, cityList.countCities());
        cityList.deleteCity(city);
        assertEquals(0, cityList.countCities());
        cityList.add(blank);
        cityList.add(city);
        assertEquals(2, cityList.countCities());
        cityList.deleteCity(blank);
        assertEquals(1, cityList.countCities());
    }
}