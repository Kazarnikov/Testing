package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

public class FilterDateArrival implements Filter{
    @Override
    public List<Flight> hide(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isBefore(segment.getArrivalDate())))
                .collect(Collectors.toList());
    }
}
