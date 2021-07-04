package interfaces;
import classes.Movie;

//Customer interface
public interface iCustomer {	
	//customer percentage prices according to his status.
	double STUCOST = 0.5;
	double SOLCOST = 0;
	double PENSCOST = (1/3.0);
	//customer methods.
	public Movie customerMovieSelection(Movie movieArray[]);
	public String randomPopcornSelection();
	public double discount(double price);
}
