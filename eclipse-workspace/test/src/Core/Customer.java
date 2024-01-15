package Core;

import java.util.ArrayList;
import java.util.Objects;

public class Customer {
	
	private ArrayList<Car> CarsBought;
	private String idNumber;
	private String fName;
	private String lName;
	private String city;
	private String email;
	//////////////////////////////Constructors and Getters And Setters/////////////////////////
	public Customer(String idNumber, String fName, String lName, String city, String email) {
		CarsBought = new ArrayList<Car>();
		this.idNumber = idNumber;
		this.fName = fName;
		this.lName = lName;
		this.city = city;
		this.email = email;
	}
	public Customer(String idNumber) {
		CarsBought = new ArrayList<Car>();
		this.idNumber = idNumber;
	}
	public ArrayList<Car> getCarsBought() {
		return CarsBought;
	}
	public void setCars(ArrayList<Car> cars) {
		this.CarsBought = cars;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		return Objects.hash(CarsBought, city, email, fName, idNumber, lName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return this.idNumber==other.idNumber ;
	}
	@Override
	public String toString() {
		return "Customer : " + idNumber + "\nName : " + fName +" "+ lName + "\nE-mail : " + email ;
	}
	/////////////////////////////////Methods/////////////////////////////////////////
	/**
	 * This function add car to customer
	 * @param c a car
	 * @return true if success to add car else return fasle.
	 */
	public boolean addCarToCustomer(Car c)
	{
		if(c!=null)//check if the car is null.
		{
			if(!CarsBought.contains(c))//check if the car is here.
			{
				return CarsBought.add(c);//add the car to the array.
			}
		}
		return false;//if the car is null, or if the car is already there
	}
	/**
	 * This function remove car from customer's car.
	 * @param c a car
	 * @return true if success to remove it else false.
	 */
	public boolean removeCarFromCustmer(Car c)
	{
		if(c!=null)//if the car is null.
		{
			if(CarsBought.contains(c))//check if the car in the array.
				return CarsBought.remove(c);//remove the car.
		}
		return false;//if the car is null or if the car is not contained.
	}
	
	

}
