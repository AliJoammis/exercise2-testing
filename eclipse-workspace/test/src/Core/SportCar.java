package Core;
import java.sql.Date;
import java.util.Objects;
import Utilities.E_CarModel;
import Utilities.E_Color;
public class SportCar extends Car {
	private boolean isFastCar;
	private boolean isConvertible;
	private boolean is4doors;
	public SportCar(String licencePlateSerial, E_CarModel carModel, String subModel, E_Color color,
			java.util.Date manufactureDate, String manufactureCountry, int modelYear, double carLength, double carWeight,
			int maxSeats, double wheelsAirVolume,boolean isFastCar, boolean isConvertible, boolean is4doors) {
		super(licencePlateSerial, carModel, subModel, color, manufactureDate, manufactureCountry, modelYear, carLength,
				carWeight, maxSeats, wheelsAirVolume);
		this.isFastCar = isFastCar;
		this.isConvertible = isConvertible;
		this.is4doors = is4doors;
	}
	public boolean isFastCar() {
		return isFastCar;
	}
	public void setFastCar(boolean isFastCar) {
		this.isFastCar = isFastCar;
	}
	public boolean isConvertible() {
		return isConvertible;
	}
	public void setConvertible(boolean isConvertible) {
		this.isConvertible = isConvertible;
	}
	public boolean isIs4doors() {
		return is4doors;
	}
	public void setIs4doors(boolean is4doors) {
		this.is4doors = is4doors;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(is4doors, isConvertible, isFastCar);
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
		SportCar other = (SportCar) obj;
		return super.equals(other);
	}
	@Override
	public double calcCarPrice() throws SpecialException 
	{
		if(this.isConvertible)//check if the car is convertible
		 return (super.calcCarPrice()*2.5)+60000;
			return (super.calcCarPrice()*2.5)+50000;
	}
	
	
	

}
