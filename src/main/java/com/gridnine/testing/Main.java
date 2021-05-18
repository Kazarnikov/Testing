package com.gridnine.testing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Flight> flights = null;
        boolean exit = true;

        System.out.println("Select a filter: 1 - Exclude departing flights of time\n" +
                "                 2 - Exclude flights with arrival date earlier than departure date\n" +
                "                 3 - Exclude transfer times longer than 2 hours\n" +
                "                 0 - Reset");

        HashMap<Integer, Filter> mapFilter = new HashMap<>();
        mapFilter.put(1, new FilterTimeDeparture());
        mapFilter.put(2, new FilterDateArrival());
        mapFilter.put(3, new FilterTotalTimeEarth());

        HashSet<Integer> numberFilter = new HashSet<>();

        while (exit) {
            System.out.print("Select filter: ");
            flights = FlightBuilder.createFlights();
            int selectFilter = scanner.nextInt();
            if (selectFilter == 0) {
                numberFilter.clear();
                continue;
            }

            if (!numberFilter.removeIf(integer -> integer.equals(selectFilter))) {
                numberFilter.add(selectFilter);
            }

            System.out.println("Filter selected: " + numberFilter);

            for (Integer integer : numberFilter) {
                if (mapFilter.containsKey(integer)) {

                    Filter filter = mapFilter.get(integer);
                    flights = filter.hide(flights);
                }
            }
           FlightBuilder.toPrint(flights);
        }
    }
}