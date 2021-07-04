package classes;

//Class BigHall extends CinemaHall.
public class BigHall extends CinemaHall{
	
	//Big Hall rows and columns number.
	public static final int ROWS = 16;
	public static final int COLS = 20;
	//Big Hall movie ticket price.
	public static final int PRICE = 42;
		
	//Big Hall fully constructor.
	public BigHall(int hallNum, Movie currentMovie) {
		super(hallNum, currentMovie, ROWS, COLS);
		this.availableSeat = new Seat(ROWS, 1);
	}
	
	/**
	 * @param Customer class object
	 * method create new Reservation object with this hall details, current movie and available seat attribute, and customer discount method. 
	 * @return Reservation object.
	 */
	public Reservation ticketPurchase(Customer A) {
		Reservation newReservation = new Reservation(this.getCurrentMovie().getMovieName(),this.getHallNum(), availableSeat.getRow(), availableSeat.getChair(), A.discount(PRICE));
		super.availableSeatUpdate(availableSeat, COLS);
		return newReservation;
		
	}
}
