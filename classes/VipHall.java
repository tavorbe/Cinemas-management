package classes;

//Class VipHall extends CinemaHall.
public class VipHall extends CinemaHall{

	//Vip Hall rows and columns number.
	public static final int ROWS = 8;
	public static final int COLS = 12;
	//Vip Hall movie ticket price.
	public static final int PRICE = 67;
	
	//Vip Hall fully constructor.
	public VipHall(int hallNum, Movie currentMovie) {
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
