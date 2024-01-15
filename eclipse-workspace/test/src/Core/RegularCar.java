package Core;
import java.util.Date;
import java.time.Year;

import Utilities.E_CarModel;
import Utilities.E_Color;

public class RegularCar extends Car implements methodsForMiniAndRegular{

	
	public RegularCar(String licencePlateSerial, E_CarModel carModel, String subModel, E_Color color,
			Date manufactureDate, String manufactureCountry, int modelYear, double carLength, double carWeight,
			int maxSeats, double wheelsAirVolume) {
		super(licencePlateSerial, carModel, subModel, color, manufactureDate, manufactureCountry, modelYear, carLength, carWeight, maxSeats, wheelsAirVolume);
		// TODO Auto-generated constructor stub
	}
	//////////////////////////////////////////Methods////////////////////////////////////////////////
	@Override
	public double calcCarPrice() throws SpecialException 
	{
		return (super.calcCarPrice()*1.2)+1000;
	}
	/**
	 * This function check if we can add trailer to the car
	 * @return true if it is available else return false
	 */
	public boolean checkIfTrailerIsAvailiable()
	{
		return this!=null && this.carWeight>4;//check if the weight more than 4kg;
			
	}
	/**
	 * This function check if car are trade.
	 * @return true if success else false.
	 */
	public boolean carForTrade()
	{
		int year = Year.now().getValue();//calculate the current year;
	    return year-this.modelYear<2;//return true if the diff less than 2,else return false.
	}
	
	
	public double calcCarCostForMovingToStore() throws SpecialException
	{
		double cost=0.0;
		if(this!=null )//check if the object is not null
		{
			cost=this.calcCarPrice()/1000;//save the value of in the cost
		if( cost>0)//check if it more than 0
			return cost;//return cost
		}
		return cost;
	}

}


