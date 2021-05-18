package com.gridnine.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FilterTest {

    List<Flight> flights = null;

    @Before
    public void setUp() throws Exception {
        flights = FlightBuilder.createFlights();
    }

    @Test
    public void testHideFilterDateArrival() {
        List<Flight> actual = new FilterDateArrival().hide(flights);
        List<Flight> expected = List.of(
                flights.get(0),
                flights.get(1),
                flights.get(2),
                flights.get(4),
                flights.get(5));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testHideFilterTimeDeparture() {
        List<Flight> actual = new FilterTimeDeparture().hide(flights);
        List<Flight> expected = List.of(
                flights.get(0),
                flights.get(1),
                flights.get(3),
                flights.get(4),
                flights.get(5));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testHideFilterTotalTimeEarth() {
        List<Flight> actual = new FilterTotalTimeEarth().hide(flights);
        List<Flight> expected = List.of(
                flights.get(0),
                flights.get(1),
                flights.get(2),
                flights.get(3));
        Assert.assertEquals(expected, actual);
    }
}