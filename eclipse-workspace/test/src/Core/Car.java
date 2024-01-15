package Core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import Utilities.E_CarModel;
import Utilities.E_Color;

public abstract class Car implements Comparable<Car> {
	protected String licencePlateSerial;
	protected E_CarModel carModel;
	protected String subModel;
	protected E_Color color;
	protected Date manufactureDate;
	protected String manufactureCountry;
	protected int modelYear;
	protected double carLength;
	protected double carWeight;
	protected int maxSeats;
	protected double wheelsAirVolume;
	protected ArrayList<ItemPart> carPart;
	
	///////////////////////////////////Constructor ,Getters And Setters //////////////////////////////////////////
	public Car(String licencePlateSerial, E_CarModel carModel, String subModel, E_Color color,Date manufactureDate,
			String manufactureCountry, int modelYear, double carLength, double carWeight, int maxSeats,
			double wheelsAirVolume) {
		this.licencePlateSerial = licencePlateSerial;
		this.carModel = carModel;
		this.subModel = subModel;
		this.color = color;
		this.manufactureDate = (Date) manufactureDate;
		this.manufactureCountry = manufactureCountry;
		this.modelYear = modelYear;
		this.carLength = carLength;
		this.carWeight = carWeight;
		this.maxSeats = maxSeats;
		this.wheelsAirVolume = wheelsAirVolume;
		carPart=new ArrayList<ItemPart>();
		
	}
	public String getLicencePlateSerial() {
		return licencePlateSerial;
	}
	public void setLicencePlateSerial(String licencePlateSerial) {
		this.licencePlateSerial = licencePlateSerial;
	}
	public E_CarModel getCarModel() {
		return carModel;
	}
	public void setCarModel(E_CarModel carModel) {
		this.carModel = carModel;
	}
	public String getSubModel() {
		return subModel;
	}
	public void setSubModel(String subModel) {
		this.subModel = subModel;
	}
	public E_Color getColor() {
		return color;
	}
	public void setColor(E_Color color) {
		this.color = color;
	}
	public Date getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	public String getManufactureCountry() {
		return manufactureCountry;
	}
	public void setManufactureCountry(String manufactureCountry) {
		this.manufactureCountry = manufactureCountry;
	}
	public int getModelYear() {
		return modelYear;
	}
	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}
	public double getCarLength() {
		return carLength;
	}
	public void setCarLength(double carLength) {
		this.carLength = carLength;
	}
	public double getCarWeight() {
		return carWeight;
	}
	public void setCarWeight(double carWeight) {
		this.carWeight = carWeight;
	}
	public int getMaxSeats() {
		return maxSeats;
	}
	public void setMaxSeats(int maxSeats) {
		this.maxSeats = maxSeats;
	}
	public double getWheelsAirVolume() {
		return wheelsAirVolume;
	}
	public void setWheelsAirVolume(double wheelsAirVolume) {
		this.wheelsAirVolume = wheelsAirVolume;
	}
	@Override
	public int hashCode() {
		return Objects.hash(carLength, carModel, carWeight, color,licencePlateSerial, manufactureCountry,
				manufactureDate, maxSeats, modelYear,subModel,wheelsAirVolume);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(licencePlateSerial, other.licencePlateSerial);
				
	}
	@Override
	public String toString() {
		return "licencePlateSerial : " + licencePlateSerial + "\n"+"carModel : " + carModel + "\nsubModel : " + subModel
				+ "\ncolor : " + color + "\nmanufactureCountry : " + manufactureCountry + "\nmodelYear : " + modelYear ;
	}
	
	
	//////////////////////////////////Methods//////////////////////////////////////
	/**
	 * This function calc the cost of the parts of the car.
	 * @return cost.
	 * @throws SpecialException if the is missing part it will throws an exception.
	 */
	public double calcCarPrice() throws SpecialException
	{
		if(carPart.size()<7)//check if all the part are complete
			//if function return False it will throws an exception.
			throw new SpecialException("Car Isn't Ready And Some Parts Are Missing,You need to add the missing parts");
		double cost=0;
		//compute the cost of the car.
		for(ItemPart item:carPart)//run over the items
		{
			if(item!=null)
				cost+=item.price;//sum all the prices
		}
		return cost;//return the total price of the items.
	}
	/**
	 * This function Add new item to the car
	 * @param item
	 * @return true if success to add else return false
	 */
	public boolean addItemToCar(ItemPart item)
	{
		if(item!=null)//check if there item
		{
			//check two logical condition:
			//if the item is wheel and num of the wheels less than 4 then you can add it.
			//if item is not wheel and does not contain into the list you can add it.
			if((item instanceof Wheel && wheelsNum()<4) || 
					(!(item instanceof Wheel) && !carPart.contains(item)))
				return carPart.add(item);//add the item
		}
		return false;	//if the item is null or already there.
	}
	/**
	 * This function count how many wheels in car.
	 * @return Wheel's car number.
	 */
	private int wheelsNum() {
		int cnt=0;
		for(ItemPart ip:carPart)//run over the parts.
			if(ip!=null && ip instanceof Wheel)//if the item is wheel
				cnt++;//increase the counter.
		return cnt;//return the counter of the wheels in the car.
	}
	/**
	 * This function remove a part of car
	 * @param item
	 * @return true if success to remove else return false
	 */
	public boolean removeItemFromCar(ItemPart item)
	{
		if(item!=null)//if the item not null
		{
			if(carPart.contains(item))//check if the part there
			{
				return carPart.remove(item);//delete the item
			}
		}
		return false;//return false if the item null or isn't here
	}
	/**
	 * This function comparing two objects by car price. 
	 */
	public int compareTo(Car car)
	{
		try {
		if(this.calcCarPrice()<car.calcCarPrice())
	          return -1;
	    else if(this.calcCarPrice()>car.calcCarPrice())
	          return 1;
	    return 0;
		}
		catch(Exception e)
		{
			e.fillInStackTrace();
		}
		return 0;
	}
	
}
	
	
	
	
	
	
	
	
	
	
	


