package classes;
//Class Seat halp the system the manage halls seats.
public class Seat {
	
	//Seat attributes.
	private int row, chair;
	//seat available = true /not available = false.
	boolean status;

	//Seat fully constructor.
	public Seat(int row, int chair) {
		this.row = row;
		this.chair = chair;
		this.status = true;
	}

	//Seat Getter's & Setter's.
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getChair() {
		return chair;
	}

	public void setChair(int chair) {
		this.chair = chair;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
