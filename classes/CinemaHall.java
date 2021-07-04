package classes;
//Class type CinemaHall.
public abstract class CinemaHall {
	
	//CinemaHall attributes.
	//hall number
	protected int hallNum;
	//current shown movie - Movie object
	protected Movie currentMovie;
	//two dimension Seat class array. 
	protected Seat[][] seats;
	//counter of available seats.
	protected int availableSeatsCount;
	//next available seat.
	protected Seat availableSeat;

	
	//CinemaHall fully constructor.
	public CinemaHall(int hallNum, Movie currentMovie, int rows, int cols) {
		this.hallNum = hallNum;
		this.currentMovie = currentMovie;
		this.availableSeatsCount = rows * cols;
		
		this.seats = new Seat[rows][cols];
		for (int i = 0 ; i < rows ; i++) {
			for (int j = cols - 1 ; j >= 0 ; j--) {
				seats[i][j] = new Seat(i + 1, cols - j);
			}
		}
	}
	
	//CinemaHall Getter's & Setter's.
	public int getHallNum() {
		return hallNum;
	}

	public void setHallNum(int hallNum) {
		this.hallNum = hallNum;
	}

	public Movie getCurrentMovie() {
		return currentMovie;
	}

	public void setCurrentMovie(Movie currentMovie) {
		this.currentMovie = currentMovie;
	}

	public Seat[][] getSeats() {
		return seats;
	}

	public void setSeats(Seat[][] seats) {
		this.seats = seats;
	}
	
	public int getAvailableSeatsCount() {
		return availableSeatsCount;
	}

	public void setAvailableSeatsCount(int availableSeatsCount) {
		this.availableSeatsCount = availableSeatsCount;
	}
	
	public Seat getAvailableSeat() {
		return availableSeat;
	}

	public void setAvailableSeat(Seat availableSeat) {
		this.availableSeat = availableSeat;
	}

	/**
	 * @param Customer class object
	 * @return Reservation object.
	 */
	public abstract Reservation ticketPurchase(Customer A);
	
	/**
	 * @param Seat class available Seat reference
	 * @param hall num of seats in one row. (cols)
	 * 
	 * method seat customer from the last row (the higher one) and from the right corner. 
	 * the available seat move left, and when the row ends, get down one row and back to right corner.
	 */
	public void availableSeatUpdate(Seat availableSeat, int cols) {
		availableSeat.setStatus(false);
		if (availableSeat.getChair() == cols) {
			availableSeat.setRow(availableSeat.getRow()-1);
			availableSeat.setChair(1);
		}
		else {
			availableSeat.setChair(availableSeat.getChair() + 1);
		}
		availableSeatsCount -=1;
		
	}
	
	/**
	 * 
	 * @param Movie class object.
	 * method update hall attribute current movie to new Movie object
	 * method set all seats in the hall to status available.
	 */
	public void movieUpdate(Movie A) {
		
		//update current movie attribute
		currentMovie = A;
		
		//run on 2 dimension seats array and update status.
		for (Seat[] arr : seats) {
			for(Seat item : arr) {
				item.status = true;
			}
		}
		//available seats counter reset by the hall rows and columns number.
		availableSeatsCount = seats.length * seats[0].length;
	}

	/**
     * method define print structure to Customer class.
     */
	@Override
	public String toString() {
		return "CinemaHall [hallNum=" + hallNum + ", currentMovie=" + currentMovie
				+ ", availableSeatsCount=" + availableSeatsCount + "]";
	}
	
	
}
