package Hazara;

import java.util.Objects;

public class Car {
	private String name;
	private String model;
	private int year;
	public Car(String name, String model, int year) {
		super();
		this.name = name;
		this.model = model;
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public int hashCode() {
		return Objects.hash(model, name, year);
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
		return Objects.equals(model, other.model) && Objects.equals(name, other.name) && year == other.year;
	}
	@Override
	public String toString() {
		return "Car [name=" + name + ", model=" + model + ", year=" + year + "]";
	}
}
