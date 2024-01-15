package Core;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Formatter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Store implements Serializable{

	private String storeName;

	private int storeId;

	private ArrayList<Car> cars;

	private Customer[] customers;

	private ArrayList<ItemPart> items;


	public Store(String storeName, int storeId) {
		this.storeName = storeName;
		this.storeId = storeId;
		this.cars = new ArrayList<Car>();
		this.customers = new Customer[100];
		this.items=new ArrayList<ItemPart>();

	}

	public String getStoreName() {
		return storeName;
	}


	public ArrayList<ItemPart> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemPart> items) {
		this.items = items;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public ArrayList<Car> getCars() {
		return cars;
	}

	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}

	public Customer[] getCustomers() {
		return customers;
	}

	public void setCustomers(Customer[] customers) {
		this.customers = customers;
	}




	/*---------------------------------------------------Methods----------------------------------------------------*/

	/**
	 * this function add new customer to store.
	 * @param c an customer
	 * @return true if success to add, else return false.
	 */
	public boolean addCustomerToStore(Customer c) {
		int emptyIndex=-1;
		if(c!=null)//check if the c not null
		{
			for(int i=0;i<customers.length;i++)//run over the array 
			{
				if(customers[i]!=null && customers[i].equals(c))//check if the customer is already here.
				{
					
					return false;// false if the customer is here
				}
				if(customers[i]==null)//check if we find an empty place
					emptyIndex=i;//save the index into a variable.
			}
			if(emptyIndex==-1)
				return false;//there is no  capacity in the array.
			customers[emptyIndex]=c;//add the customer into an empty place.
			return true;
		}return false;
	}

	public boolean addCarToStore(Car c) throws SpecialException {
		if(c!=null) {
			boolean b = checkIfCarIsReady(c);
			if(!b) {

				throw new SpecialException("Car : "+c.licencePlateSerial +" Isn't Ready , Some Parts Are Missing");
			}
			if(!this.cars.contains(c)) {
				{
					return this.cars.add(c);
				}
			}
			return false;
		}
		return false;
	}

	/**
	 * This function removed car from store.
	 * @param c an car
	 * @return true if success to remove else return false.
	 */
	public boolean removeCarFromStore(Car c) {
		if(c!=null)//check if car is not null
		{
			if(cars.contains(c))//check if the array contain the car
				return cars.remove(c);//remove it from the array list ,if remove process success return true else return false
		}
		return false;//return false if the car is null or does not exist.

	}

	public boolean removeCustomerFromStore(Customer c) {
		if(c!=null) {
			for(Customer cust : this.customers) {
				if(cust!=null && cust.equals(c)) {
					if(cust.getCarsBought().size()<=0) {
						cust=null;
						return true;
					}
					else
						return false;
				}
			}
			return false;
		}
		return false;
	}

	/**
	 * This function check if the car is ready to add to the store.
	 * @param c an car.
	 * @return true if car is ready else false.
	 */
	public boolean checkIfCarIsReady(Car c)  {
		if(c!=null)//check if c not null
		{
			if(checkAllParts(c))//if the car have all the parts.
				return true;
		}
		return false;//if the c is null.
	}

	/**
	 * This function check if all parts are complete in the car.
	 * @param c an car
	 * @return true if all part is here,else false.
	 */
	private boolean checkAllParts(Car c)
	{
		int numOfParts=0;
		for(ItemPart ip:c.carPart)//run over the array of the parts of the car
		{
			if(ip!=null)//if ip is not null
			{
				numOfParts++;//count number of the part.
			}
		}
		return numOfParts==7;//if number of all parts are 7 thats mean that the car is ready.
	}

	/**
	 * This function add item into store.
	 * @param i item
	 * @return true if success to add else false.
	 */
	public boolean addItemToStore(ItemPart i) {
		if(i!=null)//item not null
		{
			if(!items.contains(i))//check if the item isn't here.
				return items.add(i);//add the item 
		}
		return false;
	}

	/**
	 * This function takes all the customer from the file by using tokenizer
	 * @param fileName
	 */
	public void getCustomersFromTextFile(String fileName) {
		try {
			FileReader reader=new FileReader(fileName);//open Stream
			Scanner input=new Scanner(reader);//point to the file
			Customer customer=null;//define a customer as null.
			while(input.hasNextLine())//check if there another input in the file.
			{
				String line=input.nextLine();//save the first token
				StringTokenizer token=new StringTokenizer(line);//second token
				String id=token.nextToken();//third token
				String firstName=token.nextToken();//4th token
				String lastname=token.nextToken();//5th token
				String city=token.nextToken();//6th token
				String email=token.nextToken();//7th token
				customer=new Customer(id,firstName,lastname,city,email);//create an object with the feature.
				if(customer!=null) //check if the customer not null
				{
					addCustomerToStore(customer);//add customer to the list.
					customer=null;//reset the customer to null.
				}

			}
			reader.close();//close the stream.
			input.close();//close the file.
		}

		catch ( IOException f ) {
			f.getMessage();//if the file not exit.
		}
	}


	/**
	 * This function add car to Customer.
	 * @param licencePlateSerial number of the car.
	 * @param customerId number of the customer.
	 * @return true if success to add car to the customer else return false.
	 */
	public boolean addCarToCustomer(String licencePlateSerial,String customerId) {
		Car tempCar=null;
		int IndexOfCust=0;
		for(Car car:cars)//run over the cars list.
		{
			//car is here.
			if(car!=null && car.getLicencePlateSerial().equals(licencePlateSerial))//check if the car already in the store.
			{
				for(int i=0;i<customers.length;i++)//run over the all customers.
				{
					if(customers[i]!=null && customers[i].getIdNumber().equals(customerId))//check if the customer already there.
					{
						if(customers[i].addCarToCustomer(car))//check if success to add the car to the customer.
						{

							return removeCarFromStore(car);//return true if success to remove else return false
						}
						return false;//if failed to add the car to the customer.
					}
				}
				//customer does not exist
				Customer tempCst=new Customer(customerId);//create new customer
				if(addCustomerToStore(tempCst))//check if the customer was added successfully.
				{
					IndexOfCust=findIndexForCustomer(tempCst);//index of the customer.
					if(customers[IndexOfCust].addCarToCustomer(tempCar))//check if the car was added successfully for customer
					{
						return removeCarFromStore(car);//return true if success to add else return false.
					}
					return false;//if the car failed to add
				}
				return false;//if failed to add into the store.
			}
		}return false;//car is not here at all.
	}

	//this function return the index of an customer
	private int findIndexForCustomer(Customer tempCst) {
		int indexOfCustomer=-1;
		for(int i=0;i<customers.length;i++)//run over the customers
		{
			if(customers[i]!=null && customers[i].equals(tempCst))//if the customer in not null and is the one we want.
				indexOfCustomer=i;//save the index of the customer.
		}
		return indexOfCustomer;//return the index of the element.
	}

	/*-----------------------------------------------Queries----------------------------------------------------*/

	/**
	 * This function sorted all cars by price. and save them into file.
	 * @return sorted array list.
	 */
	public ArrayList<Car> sortAllCarsByPricesAsc(){
		Collections.sort(cars);//sort the cars according to the compare to.
		int i=0;
		try {
			Formatter output=new Formatter("qrt.txt");//create new file
			output.format("Car list\n");//print into the file
			for(Car c:cars)//run over the car list
			{
				i++;//increase index i for printing
				if(c!=null)//check if car not null
				{
					output.format("("+i+") "+c+"\n");//print the car details into the file
				}
			}
			output.close();//close the file.
		}
		catch (Exception e) {
			e.getMessage();
		}
		return cars;//return the sorted list.
	}
	/**
	 * This function save all the cars that was produced in the specific month
	 * @param month of production
	 */
	public void saveCarsToCSFileByMonthOfProduction(int month) {
		try {
			FileOutputStream fos=new FileOutputStream("save.bin");//open stream
			ObjectOutputStream out=new ObjectOutputStream(fos);//point to the file
			for(Car car:cars)//run over the cars 
			{
				//check if the car is not null and date production is the same month.
				if(car!=null && car.getManufactureDate().getMonth()==month)
				{
					out.writeObject(car.toString());//save the object into file
				}
			}
			out.close();//close file.
			fos.close();//close stream
		}
		catch (Exception e) {
			e.getStackTrace();
		}

	}
	/**
	 * This function return the customer that payed with most money
	 * @return details of the customer.
	 * @throws SpecialException if the car isn't ready
	 */
	public String getCustomerPayedMostMoney() throws SpecialException {
		double totalPrice=0,maxPrice=0;//save to variable 1 for total price,2 for the max price
		int numOfcars=0,counter=0;//save number of the cars for the most payed customer.
		String st="";
		Customer expensiveCust=null;
		for(Customer cust:customers)//run over the customers.
		{
			if(cust!=null)//check if the cust is null
			{
				for(Car car:cust.getCarsBought())//if the cust is here run over car's customer
				{
					if(car!=null)//if there cars
					{
						counter++;//increase number of the cars.
						totalPrice+=car.calcCarPrice();//sum the total pric of the cars.
					}
				}
				if(totalPrice>maxPrice)//check if this is the customer 
				{
					//update the variable.
					maxPrice=totalPrice;
					expensiveCust=cust;
					numOfcars=counter;
					//save the details of the customer.
					st=expensiveCust.toString()+"\nNumber Of Cars : "+numOfcars+"\nCars Price: "+maxPrice;
				}
				totalPrice=0;//set up the total price.
				numOfcars=0;//set up number if the cars.
				counter=0;
			}
		}
		return st;//return the details of the customer that have most expansive cars.
	}
}
