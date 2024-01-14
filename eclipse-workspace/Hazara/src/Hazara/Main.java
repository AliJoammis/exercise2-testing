package Hazara;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		System.out.println("Test Started!");
		Integer[] numbers = new Integer[10];
		for(int i=0; i< numbers.length; i++) {
			numbers[i] = i;
		}
		Character[] chars = new Character[10];
		String str = "ABCDEFGHIJKLMN";
		for(int i=0; i< chars.length; i++) {
			
			chars[i] = str.charAt(i);
		}
		
		printGeneric(numbers);
		System.out.println();
		printGeneric(chars);
		System.out.println();
		
		//System.out.println(maximum(1,2,4));
		
		
		Person p1 = new Person("Ali", 26);
		Person p2 = new Person("Omry",24);
		Person p3 = new Person("Mutlack",22);
		System.out.println(maximum(p1,p2,p3));
		
		Person[] person = {p1,p2,p3};
		ArrayList<Person>arr = new ArrayList<Person>();
		arr.add(person[0]);
		arr.add(person[1]);
		arr.add(person[2]);
		test3(arr);
		
		// ------------------ Generic class Test -------------------
		
		Car car = new Car("Kia","Sorento",2023);
		GenericClassTest<Person,Car>gtest = new GenericClassTest<Person, Car>(p1,car);
		System.out.println(gtest.toString());
		
		
	
		List<Person> list = new ArrayList();
		list.add(p1);
		list.add(p3);
		list.add(p2);
		System.out.println(list);
		
		Collections.sort(list, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				System.out.println(o2.compareTo(o1));
				return o2.compareTo(o1);
			}
			
		});
		System.out.println(list);
		
		
		
		IfunctionA isOdd = (x) ->{
			if(x%2==0)return "Even";
			return "Odd";
			
		};
		
		System.out.println(isOdd.isOdd(10));
		
		IfunctionB isPrime = (x) ->{
			int i = 1;
			while(i<x) {
				i++;
				if(x%i==0 && x!=i)
					return "Not prime";
			}
			return "Is prime";
		};
		System.out.println(isPrime.isPrime(101));
		
		
		
	}
	public static <E> void printGeneric(E[] array) {
		for(E element : array) {
			System.out.print(element+"\t");
		}
	}
	
	public static <T extends Comparable<T>>T maximum(T x, T y, T z){
		T max = x;
		if(y.compareTo(max)>0)
			max = y;
		if(z.compareTo(max)>0)
			max = z;
		
		return max;
	}
	ArrayList<Person>l = new ArrayList();
	public static void test3(ArrayList<?>list){
		
		for(Object obj : list.toArray() ) {
			System.out.println(obj);
		}
	}
	
	


	
	

}

