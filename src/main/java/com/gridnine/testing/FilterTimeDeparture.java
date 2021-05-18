package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FilterTimeDeparture implements Filter{
    @Override
    public  List<Flight> hide(List<Flight> flights) {
        LocalDateTime time = LocalDateTime.now();

        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isAfter(time)))
                .collect(Collectors.toList());
    }
}
