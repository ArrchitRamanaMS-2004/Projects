import java.util.*;

class Flight {
    private String flightName ;
    private int availableSeats = 50;// each flight has or starts with 50 seats
    private int ticketPrice = 5000;// initial ticket price is 5000
    private Map<String, Passenger> bookings = new java.util.HashMap<String, Passenger>();
    private int bookingCounter = 0;

    public Flight (String flightName) {
        this.flightName = flightName;
    }

    public String bookTickets (String passengerName , int age , int seats)
    {
        if ( seats <= availableSeats ) {
            bookingCounter++;
            String bookingId = "T" + bookingCounter;
            Passenger passenger = new Passenger(bookingId, passengerName, age , seats);
            bookings.put(bookingId,passenger);
            availableSeats = availableSeats - seats;
            ticketPrice = ticketPrice + ( 200 * seats);
            return bookingId;
        }
        else {
            System.out.println("Booking Failed : Not enough seats available");
            return null;
        }
    }

    public boolean cancelBooking (String bookingId) {
        Passenger passenger = bookings.get(bookingId);
        if ( passenger != null ) {
            int seats = passenger.getSeatsBooked();
            availableSeats = availableSeats + seats;
            ticketPrice = ticketPrice + ( 200 * seats);
            bookings.remove(bookingId);
            System.out.println("Booking canceled successfully. Refund issued for " + seats + " seats.");
            return true;
        }
        else
        {
            System.out.println("Cancellation failed : Booking Id not found");
            return false;
        }
    }

    public void displayDetails () {
        System.out.println("Flight : " + flightName);
        System.out.println("Available Seats : " + availableSeats);
        System.out.println("Current Ticket Price : " + ticketPrice);
    }

    public void printDetails () {
        System.out.println("Flight : " + flightName);
        System.out.println("Available Seats : " + availableSeats);
        System.out.println("Current Ticket Price : " + ticketPrice);
        System.out.println("Passengers : ");
        for ( Passenger passenger : bookings.values() ) {
            System.out.println(passenger);
        }
    }
}
