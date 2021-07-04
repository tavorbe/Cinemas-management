package classes;
import java.time.LocalDate;
import java.time.Period;

//Class abstract type Person.
public class Person {
		
	//Person attributes.
	protected String id, name, mail, phone;
	protected LocalDate birthDate;
	
	//Person fully constructor
	public Person(String id, String name, String mail, String phone, LocalDate birthDate) {
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.phone = phone;
		this.birthDate = birthDate;
	}
	
	public Person() {
		this.id = "0";
		this.name = "temp customer";
		this.mail = "null";
		this.birthDate = null;
	}
	
	//Person Getter's & Setter's.
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	/**
	 * @param object
	 * 
	 * @return true if object instanceof Person and id attribute equals. 
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
		//if other is class type Person or extends it.
		if (other instanceof Person) {
			Person C = (Person) other;
			return (C.getId().equals(id));
		}
		return false;
	}
	
	/**
     * method define print structure to Person class.
     */
	@Override
	public String toString() {
		return " [name=" + name + ", phone=" + phone + ", age=" + Period.between(birthDate, LocalDate.now()).getYears() + "]";
	}
}
