package Core;

import java.sql.Date;
import java.util.Objects;

import Utilities.E_CarModel;
import Utilities.E_Color;

public class MiniCar extends Car implements methodsForMiniAndRegular{
	private String is4doors;

	public MiniCar(String licencePlateSerial, E_CarModel carModel, String subModel, E_Color color, java.util.Date manufactureDate,
			String manufactureCountry, int modelYear, double carLength, double carWeight, int maxSeats,
			double wheelsAirVolume, String is4doors) {
		super(licencePlateSerial, carModel, subModel, color, manufactureDate, manufactureCountry, modelYear, carLength,
				carWeight, maxSeats, wheelsAirVolume);
		this.is4doors = is4doors;
	}

	public String getIs4doors() {
		return is4doors;
	}

	public void setIs4doors(String is4doors) {
		this.is4doors = is4doors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(is4doors);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MiniCar other = (MiniCar) obj;
		return super.equals(other);
	}
	///////////////////////////////////////////Methods//////////////////////////////////////////
	@Override
	public double calcCarPrice() throws SpecialException 
	{
		return (super.calcCarPrice()*1.2)+1000;
	}

	/**
	 * This function check if car for trade.
	 */
	public boolean carForTrade()
	{
		return (this!=null && this.modelYear>2020);//check if the mini not null and model year more than 2020

	}
	/**
	 * This function calc price of moving car to store.
	 * @return cost of moving to store.
	 */
	public double calcCarCostForMovingToStore() throws SpecialException
	{
		double cost=0.0;
		if(this!=null)
		{
			cost=this.calcCarPrice()/this.modelYear;
			if(cost>0)
				return cost;
		}
		return cost;
	}

	/**
	 * @return false in all cases.
	 */
	public boolean checkIfTrailerIsAvailiable()
	{
		return false;
	}


}
