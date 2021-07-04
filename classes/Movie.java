package classes;
import java.time.LocalDate;
import java.time.Period;
//Class type Movie.
public class Movie {
	
	//Movie static final attributes.
	public static final int HERRORMINAGE = 18;
	public static final int THRILLERMINAGE = 16;
	public static final int COMEDYMINAGE = 0;

	//Movie attributes.
	private String movieName, movieType;
	private int minAge, movieLength;
	
	//Movie fully constructor.
	public Movie(String movieName, String movieType, int movieLength) {
		
		this.movieName = movieName;
		this.movieType = movieType;
		this.movieLength = movieLength;
		if(movieType.equals("HERROR")) {
			this.minAge = HERRORMINAGE;
		}
		else if(movieType.equals("THRILLER")) {
			this.minAge = THRILLERMINAGE;
		}
		else if(movieType.equals("COMEDY")) {
			this.minAge = COMEDYMINAGE;
		}
	}

	//Movie Getter's & Setter's.
	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieType() {
		return movieType;
	}

	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public int getMovieLength() {
		return movieLength;
	}

	public void setMovieLength(int movieLength) {
		this.movieLength = movieLength;
	}

	public static int getHerrorminage() {
		return HERRORMINAGE;
	}

	public static int getThrillerminage() {
		return THRILLERMINAGE;
	}
	
	public static int getComedyminage() {
		return COMEDYMINAGE;
	}

	/**
	 * 
	 * @param Customer class object
	 * method check if customer age is above movie minimum age.
	 * @return print user message. 
	 */
	public void ageCheck(Customer A) {
		
		if (Period.between(A.getBirthDate(), LocalDate.now()).getYears() >= minAge) {
    		System.out.println("The customer allowed to watch the movie");
    	}
    	else {
    		System.out.println("The customer is not allowed to watch the movie");
    	}
	}

	/**
	 * @param object
	 * 
	 * @return true if object instanceof Movie and movie name attribute equals. 
	 */
	@Override
	public boolean equals(Object other) {
		//true if it is the same reference
		if (this == other) {
			return true;
		}
		//false if other reference null.
		if (other == null) {
			return false;
		}
		//if other is class type Movie or extends it.
		if (other instanceof Movie) {
			Movie M = (Movie) other;
			return (M.getMovieName().equals(movieName));
		}
		return false;
	}

	/**
     * method define print structure to Person class.
     */
	@Override
	public String toString() {
		return "Movie [movieName=" + movieName + ", movieType=" + movieType + ", minAge=" + minAge + ", movieLength="
				+ movieLength + "]";
	}

}
