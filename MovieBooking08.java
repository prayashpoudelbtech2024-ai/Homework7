class SeatNotAvailableException extends Exception {
    public SeatNotAvailableException(String msg) {
        super(msg);
    }
}

class Movie {
    String name = "Avengers";
    int availableSeats = 4;

    void bookTicket(int seats) throws SeatNotAvailableException {
        if (seats > availableSeats) {
            throw new SeatNotAvailableException("Not enough seats available!");
        } else {
            availableSeats -= seats;
            System.out.println(seats + " ticket(s) booked for " + name);
            System.out.println("Remaining seats: " + availableSeats);
        }
    }
}

public class MovieBooking08 {
    public static void main(String[] args) {
        Movie m = new Movie();

        try {
            m.bookTicket(2);
            m.bookTicket(3); // will throw exception
        } catch (SeatNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}