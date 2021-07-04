package classes;

public class Popcorn {
	
	private String size;
	private double price;
	
	public Popcorn(String size, double price) {
		this.size = size;
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
