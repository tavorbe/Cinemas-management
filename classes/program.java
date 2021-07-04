package classes;

import java.util.ArrayList;
/**
 * 
 * We built the program on the assumption that an employee can be a regular customer,
 * who is not a student / soldier / retire.
 * The employee does not have a discount on prices, but the cinema can set him a percentage discount later.
 * 
*/
//Import Random class for randomNum function.
import java.util.Random;

//Import LocalDate class to create and manage dates.
import java.time.LocalDate;

//Class of main function
public class program {

	/**
	 * 
	 * @param size - Contains the upper limit for the random number(not include).
	 * 
	 * @return random integer between 0 to size - 1.
	 */
	public static int randomNum(int size) {
		Random num = new Random();
		return num.nextInt(size);
	}

	public static void main(String[] args) {
		// create Cinema house called javaPlanet.
		CinemaHouse javaPlanet = new CinemaHouse("javaPlanet");

		// create and insert different types of movies.
		javaPlanet.getMovieArray()[0] = new Movie("aaa", "HERROR", 120);
		javaPlanet.getMovieArray()[1] = new Movie("bbb", "COMEDY", 120);
		javaPlanet.getMovieArray()[2] = new Movie("ccc", "THRILLER", 120);
		javaPlanet.getMovieArray()[3] = new Movie("Charlie and half", "COMEDY", 120);
		javaPlanet.getMovieArray()[4] = new Movie("Zombies", "HERROR", 130);
		javaPlanet.getMovieArray()[5] = new Movie("Kidnap", "THRILLER", 150);
		javaPlanet.getMovieArray()[6] = new Movie("Cars", "COMEDY", 150);
		javaPlanet.getMovieArray()[7] = new Movie("Fighter", "THRILLER", 90);
		javaPlanet.getMovieArray()[8] = new Movie("The gift", "HERROR", 110);
		javaPlanet.getMovieArray()[9] = new Movie("Sababa", "COMEDY", 145);

		// set Current movies in javaPlanet halls.
		javaPlanet.getHallArray()[0].setCurrentMovie(javaPlanet.getMovieArray()[2]);
		javaPlanet.getHallArray()[1].setCurrentMovie(javaPlanet.getMovieArray()[4]);
		javaPlanet.getHallArray()[2].setCurrentMovie(javaPlanet.getMovieArray()[6]);
		javaPlanet.getHallArray()[3].setCurrentMovie(javaPlanet.getMovieArray()[8]);
		javaPlanet.getHallArray()[4].setCurrentMovie(javaPlanet.getMovieArray()[9]);

		// create different types of customer's.
		Customer A = new Customer("123456789", "David", "davidtheking@gmail.com", "05012345566",
				LocalDate.of(1997, 06, 06), "MTA", LocalDate.of(2022, 10, 10));
		Customer B = new Customer("234567891", "Shlomo", "shlomotheking@gmail.com", "05012346677",
				LocalDate.of(2002, 01, 01), LocalDate.of(2023, 11, 18));
		Customer C = new Customer("345678912", "Shaul", "shaultheking@gmail.com", "05012347788",
				LocalDate.of(1950, 05, 15));
		Customer D = new Customer("912345678", "Dani", "danitheking@gmail.com", "05018446788",
				LocalDate.of(1995, 9, 30), "IDC", LocalDate.of(2023, 10, 10));
		Customer E = new Customer("312648520", "Rivka", "rivkathequeen@gmail.com", "05012942388",
				LocalDate.of(1960, 05, 15));

		// insert customer's to javaPlanet customer list.
		javaPlanet.getCustomerList().add(A);
		javaPlanet.getCustomerList().add(B);
		javaPlanet.getCustomerList().add(C);
		javaPlanet.getCustomerList().add(D);
		javaPlanet.getCustomerList().add(E);

		// create different types of employee's.
		Employee F = new Employee("456789123", "Sara", "sarathequeen@gmail.com", "05012348899",
				LocalDate.of(1995, 06, 10), 30.12);
		Employee G = new Employee("567891234", "Rafi", "rafitheking@gmail.com", "05012345678",
				LocalDate.of(2004, 05, 01), 29.3);
		Employee H = new Employee("678912345", "Avi", "avitheking@gmail.com", "05012345687", LocalDate.of(2006, 07, 03),
				29.3);
		Employee I = new Employee("789123456", "Hadas", "hadasthequeen@gmail.com", "05012345421",
				LocalDate.of(2005, 05, 14), 29.3);
		Employee J = new Employee("891234567", "Yariv", "Yarivthekingn@gmail.com", "05012341255",
				LocalDate.of(1990, 04, 11), 35.23);

		// insert employee's to javaPlanet employee list.
		javaPlanet.getEmployeeList().add(F);
		javaPlanet.getEmployeeList().add(G);
		javaPlanet.getEmployeeList().add(H);
		javaPlanet.getEmployeeList().add(I);
		javaPlanet.getEmployeeList().add(J);

		
		System.out.println(javaPlanet);

		for (int i = 0; i < 3; i++) {
			javaPlanet.movieTicketSale();
			System.out.println("\n");
		}

		for (int i = 0; i < 3; i++) {
			javaPlanet.popcornSale();
			System.out.println("\n");
		}

		System.out.println("Before");
		System.out.println(javaPlanet.getMovieArray()[6]);
		System.out.println(javaPlanet.getHallArray()[2]);

		Movie newMovie = new Movie("Men in black", "THRILLER", 120);
		javaPlanet.movieUpdate("Cars", newMovie);

		System.out.println("After");
		System.out.println(javaPlanet.getMovieArray()[6]);
		System.out.println(javaPlanet.getHallArray()[2]);
		
	}

}
