package classes;
import java.time.LocalDate;
import java.time.Period;

import interfaces.iCustomer;
import interfaces.iEmployee;

//Class type of a cinema employee, extends Person class and implements iEmployee interface.
public class Employee extends Person implements iEmployee, iCustomer{
	
	//for now, employee's doesn't get any discount percentage. 
	public static final int EMPLOYEEDISCOUNT = 1;
	
	//Class employee attributes.
	private double workArray[];
	private double hourWage;
	
	//Class employee fully constructor.
	public Employee(String id, String name, String mail, String phone, LocalDate birthDate, double hourWage) {
		super(id, name, mail, phone, birthDate);
		this.workArray = new double[30];
		this.hourWage = hourWage;
	}

	//Employee Getter's & Setter's.
	public double[] getWorkArray() {
		return workArray;
	}

	public void setWorkArray(double[] workArray) {
		this.workArray = workArray;
	}

	public double getHourWage() {
		return hourWage;
	}

	public void setHourWage(double hourWage) {
		this.hourWage = hourWage;
	}
	/**
	 * @param String popcorn size, Customer class object.
	 * 
	 * method calculate discount popcorn price.
	 * 
	 * @return discounted price 
	 */
	public double popcornSale(String popcornSize, Customer A) {
		double discountPrice = 0;
		//return discounted price according to popcorn size and customer discount(if he have discount).
		if(popcornSize.equals("SMALL")) {
			discountPrice = A.discount(CinemaHouse.SMALLPOPCORN);
		}
		else if(popcornSize.equals("MEDIUM")) {
			discountPrice = A.discount(CinemaHouse.MEDIUMPOPCORN);
		}
		else if(popcornSize.equals("LARGE")) {
			discountPrice = A.discount(CinemaHouse.LARGEPOPCORN);
		}
		//return new price.
		return discountPrice;
		
	}
	
	/**
	 * @param Customer object, Movie object, CinemaHall type array.
	 * 
	 *  method search for relevant movie, and the hall that present it with the most available seats.
	 *  when the hall is found send customer object to ticketPurchase method of CinemaHall class.
	 *  
	 *  @return Reservation object.
	 */
	public Reservation ticketSale(Customer customer, Movie movie, CinemaHall hallArray[]) {
		boolean found = false;
		int temp = 0;
		CinemaHall mostAvailableSeatsHall = null;
		Reservation newRes;
		
		//run on cinema hall array 
		for(CinemaHall item : hallArray) {
			if(item.getCurrentMovie() != null) {
				//check hall current movie and number of available seats.
				if(item.getCurrentMovie().equals(movie) && item.getAvailableSeatsCount() > temp) {
					//update current most available seats hall.
					mostAvailableSeatsHall = item;
					//update current available seats number.
					temp = item.getAvailableSeatsCount();
					//a flag defined we found a hall that present the movie. 
					found = true;
				}
			}
		}
		//case movie has found, create new reservation.
		if (found == true) {
			newRes = mostAvailableSeatsHall.ticketPurchase(customer);
		}
		//case movie has not found, print user message.
		else {
			newRes = null;
			System.out.println("Sorry, this movie is not shown at any hall right now");
		}
		return newRes;
	}
	
	/**
	 * @return calculate employee month salary.
	 */
	public double salarycalculation() {
		double workHoursSum = 0;
		//run on employee work array and sum each day work hours. 
		for (int i = 0 ; i < workArray.length ; i++) {
			workHoursSum += workArray[i];
		}
		//return sum work hours * hour wage.
		return workHoursSum * hourWage;
	}

	/**
	 * @param movieArray - an array contains Movie objects.
	 * 
	 * @return random Movie object, custom customer age.
	 */
	@Override
	public Movie customerMovieSelection(Movie[] movieArray) {
		int index;
		//generate random number for Movie array index, until Movie minimum age comfortable with customer age.
		do {
			index = program.randomNum(movieArray.length);
		} while (movieArray[index].getMinAge() > Period.between(birthDate, LocalDate.now()).getYears());
		//return reference for Movie object.
		return movieArray[index];
	}

	/**
	 * @return random popcorn size - SMALL / MEDIUM / LARGE.
	 */
	@Override
	public String randomPopcornSelection() {
		//use static method to get random number from 0 to 2.
		int size = program.randomNum(3);
		String popSize;
		//random number define popcorn size.
		if (size == 0) {
			popSize = "SMALL";
		}
		else if (size == 1) {
			popSize = "MEDIUM";
		}
		else if (size == 2) {
			popSize = "LARGE";
		}
		else {
			return "ERROR";
		}
		//return String value.
		return popSize;
	}
	
	/**
	 * @param movie ticket price
	 * @return price after Employee discount.
	 */
	@Override
	public double discount(double price) {
		return price * EMPLOYEEDISCOUNT;
	}
	
	/**
     * method define print structure to Employee class.
     */
	@Override
	public String toString() {
		return "Employee " + super.toString();
	}
	
}
