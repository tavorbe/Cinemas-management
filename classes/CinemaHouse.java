package classes;

import java.util.ArrayList;

public class CinemaHouse {

	// Popcorn prices (fixed and known for all).
	public static final int SMALLPOPCORN = 20;
	public static final int MEDIUMPOPCORN = 30;
	public static final int LARGEPOPCORN = 40;

	// Cinema house characteristics.
	// Cinema name.
	private String cinameName;
	// ArrayList contains Customer objects.
	private ArrayList<Customer> customerList;
	// ArrayList contains Employee objects.
	private ArrayList<Employee> employeeList;
	// Array contains Movie objects.
	private Movie movieArray[];
	// ArrayList contains CinemaHall objects.
	private CinemaHall hallArray[];

	// CinemaHouse fully constructor
	public CinemaHouse(String cinameName) {

		this.cinameName = cinameName;
		this.customerList = new ArrayList<Customer>();
		this.employeeList = new ArrayList<Employee>();
		this.movieArray = new Movie[10];
		this.hallArray = new CinemaHall[5];

		// create halls according to task instructions.
		hallArray[0] = new SmallHall(1, null);
		hallArray[1] = new SmallHall(2, null);
		hallArray[2] = new BigHall(3, null);
		hallArray[3] = new BigHall(4, null);
		hallArray[4] = new VipHall(5, null);

	}

	// CinemaHouse Getter's & Setter's.
	public String getCinameName() {
		return cinameName;
	}

	public void setCinameName(String cinameName) {
		this.cinameName = cinameName;
	}

	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}

	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public Movie[] getMovieArray() {
		return movieArray;
	}

	public void setMovieArray(Movie[] movieArray) {
		this.movieArray = movieArray;
	}

	public CinemaHall[] getHallArray() {
		return hallArray;
	}

	public void setHallArray(CinemaHall[] hallArray) {
		this.hallArray = hallArray;
	}

	/**
	 * help method
	 * 
	 * @return the first empty cell index in the movie array.
	 */
	public int movieArraySearch() {
		int i = 0;
		for (i = 0; i < movieArray.length; i++) {
			if (movieArray[i] == null) {
				return i;
			}
		}
		return i;
	}

	/**
	 * help method
	 * 
	 * @return the first empty cell index in the halls array.
	 */
	public int hallArraySearch() {
		int i = 0;
		for (i = 0; i < hallArray.length; i++) {
			if (hallArray[i].getCurrentMovie() == null) {
				return i;
			}
		}
		return i;
	}

	/**
	 * 
	 * @param newMovie - movie Object
	 * 
	 *                 method gets new Movie object, add it to the movie array and
	 *                 update maximum (movie array length / hall array length) halls
	 *                 to show the movie, if: 1. movie array is not full. 2. there
	 *                 are halls in the array that doesnt have current movie.
	 */
	public void addNewMovie(Movie newMovie) {
		// get index from help method
		int res1 = hallArraySearch();
		// get index from help method
		int res2 = movieArraySearch();
		// case conditions 1 & 2 met.
		if (res1 != hallArray.length && res2 != movieArray.length) {
			// update movie array with new movie.
			movieArray[res2] = newMovie;
			// round up calculate of movie array length / hall array length.
			double index = Math.ceil(res2 / res1);
			// update halls current movie.
			while (hallArraySearch() != hallArray.length && index > 0) {
				hallArray[hallArraySearch()].setCurrentMovie(newMovie);
				index = index - 1;
			}
		}
		// case movie array is full / all halls show movies.
		else {
			System.out.println(
					"ERROR. we cant add the new movie right now. please check the capacity of the movies and halls lists.");
		}
	}

	/**
	 * 
	 * @param oldMovieName - String movie name
	 * @param newMovie     - Class Movie object
	 * 
	 *                     method update movie array with new movie instead of old
	 *                     movie, and all the hall that present it.
	 */
	public void movieUpdate(String oldMovieName, Movie newMovie) {
		boolean index = false;
		// run on movie array to find old movie by his name.
		for (int i = 0; i < movieArray.length; i++) {
			if (movieArray[i].getMovieName().equals(oldMovieName)) {
				movieArray[i] = newMovie;
				index = true;
			}
		}
		// case we found the movie
		if (index == true) {
			// run on halls array and update current movie.
			for (CinemaHall item : hallArray) {
				if (item.getCurrentMovie().getMovieName().equals(oldMovieName)) {
					item.setCurrentMovie(newMovie);
				}
			}
		}
		// case movie has not found.
		else {
			System.out.println("ERROR. movie name not found.");
		}
	}

	/**
	 * help method - find employee in employee list by his id number.
	 * 
	 * @param String employee id number
	 * @return employee array index
	 */
	public int findEmployee(String id) {
		// run on employee's list
		for (int i = 0; i < employeeList.size(); i++) {
			if (employeeList.get(i).getId() == id) {
				// return index
				return i;
			}
		}
		// return list size (no such index)
		return employeeList.size();
	}

	/**
	 * 
	 * @param newEmployee - employee object method check if employee already in the
	 *                    list by his id number, else add it to the list.
	 */
	public void addEmployee(Employee newEmployee) {
		if (findEmployee(newEmployee.getId()) == employeeList.size()) {
			employeeList.add(newEmployee);
			System.out.println("Employee added successfully");
		} else {
			System.out.println("This employee is already exist in the system.");
		}
	}

	/**
	 * 
	 * @param String employee id number method search employee in the list by his id
	 *               number and delete it. case employee is not found, print user
	 *               message.
	 */
	public void deleteEmployee(String id) {
		if (findEmployee(id) != employeeList.size()) {
			employeeList.remove(findEmployee(id));
			System.out.println("Employee has deleted");
		} else {
			System.out.println("Employee id has not found");
		}
	}

	/**
	 * help method
	 * 
	 * @return method return true if Movie is currently shown at any hall.
	 */
	public boolean isShown(Movie movie) {
		for (CinemaHall item : hallArray) {
			// case hall is shown a movie.
			if (item.getCurrentMovie() != null) {
				if (item.getCurrentMovie().getMovieName().equals(movie.getMovieName())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * method generate random customer and employee from the lists, and create a new
	 * reservation with there methods.
	 */
	public void movieTicketSale() {
		// generates random indexes
		int randomCustomerIndex = program.randomNum(customerList.size());
		int randomEmployeeIndex = program.randomNum(employeeList.size());
		// create new Reservation object.
		Movie randomMovie;
		do {
			randomMovie = customerList.get(randomCustomerIndex).customerMovieSelection(movieArray);
		} while (isShown(randomMovie) == false);

		Reservation newRes = employeeList.get(randomEmployeeIndex).ticketSale(customerList.get(randomCustomerIndex),
				randomMovie, hallArray);
		// print employee, customer and reservation details.
		System.out.println(employeeList.get(randomEmployeeIndex));
		System.out.println(customerList.get(randomCustomerIndex));
		System.out.println(newRes);

	}

	/**
	 * method generate random customer and employee from the lists, and make a
	 * popcorn sale action (by employee method).
	 */
	public void popcornSale() {
		// generates random indexes
		int randomCustomerIndex = program.randomNum(customerList.size());
		int randomEmployeeIndex = program.randomNum(employeeList.size());

		// print employee, customer and reservation details.
		System.out.println(employeeList.get(randomEmployeeIndex));
		System.out.println(customerList.get(randomCustomerIndex));
		System.out.println(employeeList.get(randomEmployeeIndex).popcornSale(
				customerList.get(randomCustomerIndex).randomPopcornSelection(), customerList.get(randomCustomerIndex)));

	}

	/**
	 * @param object
	 * 
	 * @return true if object instanceof CinemaHouse and Cinema name attribute
	 *         equals.
	 */
	@Override
	public boolean equals(Object other) {
		// true if it is the same reference
		if (this == other) {
			return true;
		}
		// false if other reference null.
		if (other == null) {
			return false;
		}
		// if other is class type CinemaHouse or extends it.
		if (other instanceof CinemaHouse) {
			CinemaHouse C = (CinemaHouse) other;
			return (C.getCinameName().equals(cinameName));
		}
		return false;
	}

	/**
	 * help method
	 * 
	 * @return count currently shown movies.
	 */
	public int countShownMovies() {
		int count = 0;
		for (CinemaHall item : hallArray) {
			if (item.getCurrentMovie() != null) {
				count++;
			}
		}
		return count;
	}

	/**
	 * method define print structure to Person class.
	 */
	@Override
	public String toString() {
		return "CinemaHouse [cinameName=" + cinameName + " , number of shown movies: " + countShownMovies()
				+ " , number of halls: " + hallArray.length + " ]";
	}
}
