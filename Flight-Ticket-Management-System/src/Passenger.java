class Passenger {
    private String bookingId;
    private String name;
    private int age ;
    private int seatsBooked;

    public Passenger (String bookingId,String name, int age , int seatsBooked) {
        this.bookingId = bookingId;
        this.name = name;
        this.age = age;
        this.seatsBooked = seatsBooked;
    }

    public String getBookingId () {
        return bookingId;
    }

    public int getSeatsBooked () {
        return seatsBooked;
    }

    @Override
    public String toString() {
        return "Passenger { PassengerId = " + bookingId + " ; Name = " + name + " ; Age = " + age + " ; SeatsBooked = " + seatsBooked + " }";
    }
}
