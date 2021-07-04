package classes;
//Class type Reservation.
public class Reservation {
	//Reservation attributes.
	private String movName;
	private int hallNum, rowNum, chairNum;
	private double ticketPrice;
	
	//Reservation fully constructor.
	public Reservation(String movName, int hallNum, int rowNum, int chairNum, double ticketPrice) {
		this.movName = movName;
		this.hallNum = hallNum;
		this.rowNum = rowNum;
		this.chairNum = chairNum;
		this.ticketPrice = ticketPrice;
	}
	
	//Reservation Getter's & Setter's.
	public String getMovName() {
		return movName;
	}

	public void setMovName(String movName) {
		this.movName = movName;
	}

	public int getHallNum() {
		return hallNum;
	}

	public void setHallNum(int hallNum) {
		this.hallNum = hallNum;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public int getChairNum() {
		return chairNum;
	}

	public void setChairNum(int chairNum) {
		this.chairNum = chairNum;
	}

	public double getTicPrice() {
		return ticketPrice;
	}

	public void setTicPrice(double ticPrice) {
		this.ticketPrice = ticPrice;
	}
	
	/**
	 * @param object
	 * 
	 * @return true if object instanceof Reservation and all Reservation attribute are equals. 
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
		//if other is class type Reservation or extends it.
		if (other instanceof Reservation) {
			Reservation R = (Reservation) other;
			return (R.getMovName().equals(movName) && R.getHallNum() == hallNum && R.getRowNum() == rowNum && R.getChairNum() == chairNum && R.getTicPrice() == ticketPrice);
		}
		return false;
	}

	/**
     * method define print structure to Person class.
     */
	@Override
	public String toString() {
		return "Reservation [movName=" + movName + ", hallNum=" + hallNum + ", rowNum=" + rowNum + ", chairNum="
				+ chairNum + ", ticketPrice=" + ticketPrice + "]";
	}
	
	


	
	
	
	

}
