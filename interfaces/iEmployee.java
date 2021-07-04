package interfaces;
import classes.CinemaHall;
import classes.Customer;
import classes.Movie;
import classes.Reservation;

//Employee interface
public interface iEmployee {

	//employee methods.
	public double popcornSale(String popcornSize, Customer A);
	public Reservation ticketSale(Customer customer, Movie movie, CinemaHall hallArray[]);
	public double salarycalculation();
}
