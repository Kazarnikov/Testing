package com.gridnine.testing;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class exclude transfer times longer than 2 hours
 */
public class FilterTotalTimeEarth implements Filter {
    @Override
    public List<Flight> hide(List<Flight> flights) {

        int timeLimit = 2;
        return flights.stream()
                .filter(flight -> {
                    List<Segment> segments = flight.getSegments();
                    int transfers = segments.size();
                    if (transfers > 1) {
                        int totalTimeEarth = 0;
                        for (int i = 0; i < transfers - 1; i++) {
                            totalTimeEarth += ChronoUnit.HOURS.between(segments.get(i).getArrivalDate(),
                                    segments.get(i + 1).getDepartureDate());
                            if (totalTimeEarth >= timeLimit) {
                                return false;
                            }
                        }
                    }
                    return true;
                })
                .collect(Collectors.toList());
    }
}
