class NoSeatsAvailableException extends Exception {
    public NoSeatsAvailableException(String msg) {
        super(msg);
    }
}

class Flight {
    int availableSeats = 5;

    void bookSeat(int seats) throws NoSeatsAvailableException {
        if (seats > availableSeats) {
            throw new NoSeatsAvailableException("No seats available!");
        } else {
            availableSeats -= seats;
            System.out.println(seats + " seat(s) booked. Remaining: " + availableSeats);
        }
    }
}

public class FlightBooking08 {
    public static void main(String[] args) {
        Flight f = new Flight();

        try {
            f.bookSeat(3);
            f.bookSeat(3); // will throw exception
        } catch (NoSeatsAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}