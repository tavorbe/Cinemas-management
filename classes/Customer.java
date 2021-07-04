package classes;

//import LocalDate & Period classes for dates usage.
import java.time.LocalDate;
import java.time.Period;

import interfaces.iCustomer; 

//Class type of a cinema customer, extends Person class and implements iCustomer interface.
public class Customer extends Person implements iCustomer {
	//Customer attributes.
	private String academicIns;
	private LocalDate discountExpiredDate;
	private String customerType;
    
	//Student customer fully constructor.
	public Customer(String id, String name, String mail, String phone, LocalDate birthDate, String academicIns, LocalDate gradDate) {
		super(id, name, mail, phone, birthDate);
		this.academicIns = academicIns;
		this.discountExpiredDate = gradDate;
		this.customerType = "Student";
	}
	
	//Soldier customer fully constructor.
	public Customer(String id, String name, String mail, String phone, LocalDate birthDate, LocalDate servEndDate) {
		super(id, name, mail, phone, birthDate);
		this.discountExpiredDate = servEndDate;
		this.customerType = "Soldier";
	}
	
	//Pension customer fully constructor.
	public Customer(String id, String name, String mail, String phone, LocalDate birthDate) {
		super(id, name, mail, phone, birthDate);
		this.discountExpiredDate = null;
		this.customerType = "Pension";
	}
	
	//default constructor - "fast buy" customer.
	public Customer() {
		super();
		this.customerType = "temp";
	}

	//Customer Getter's & Setter's.
	public String getAcademicIns() {
		return academicIns;
	}

	public void setAcademicIns(String academicIns) {
		this.academicIns = academicIns;
	}

	public LocalDate getDiscountExpiredDate() {
		return discountExpiredDate;
	}

	public void setDiscountExpiredDate(LocalDate discountExpiredDate) {
		this.discountExpiredDate = discountExpiredDate;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	
	/**
	 * @param movieArray - an array contains Movie objects.
	 * 
	 * @return random Movie object, custom customer age.
	 */
	@Override
	public Movie customerMovieSelection(Movie movieArray[]) {
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
	 * @param price - double type cost of movie ticket reservation.
	 * 
	 * @return price after discount. method calculate price according to customer type.
	 */
    @Override
    public double discount(double price) {
    	//case customer is a Student and his graduate date not passed.
    	if(customerType.equals("Student") && discountExpiredDate.isAfter(LocalDate.now())) {
    		price = price * STUCOST;
    	}
    	//case customer is a soldier and not finish his service.
    	else if(customerType.equals("Soldier") && discountExpiredDate.isAfter(LocalDate.now())) {
    		price = price * SOLCOST;
    	}
    	//case customer is a pensioner and his age is above or equal to 65.
    	else if(customerType.equals("Pension") && Period.between(getBirthDate(), LocalDate.now()).getYears() >= 65) {
    		price = price * PENSCOST;
    	}
    	else if(customerType.equals("temp")) {
    		return price;
    	}
    	//else return regular price.
    	return price;
	}

    /**
     * method define print structure to Customer class.
     */
	@Override
	public String toString() {
		return "Customer " + super.toString();
	}    

}
