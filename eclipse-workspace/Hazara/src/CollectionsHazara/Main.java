package CollectionsHazara;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import Hazara.Person;

public class Main {

	public static <A, N> void main(String[] args) {
		
		ArrayList<Person> persons = new ArrayList();
		Person p1 = new Person("Ali", 26);
		//Person p4 = new Person("Mutlack",22); Duplicate 
		Person p2 = new Person("Omry",24);
		Person p3 = new Person("Mutlack",22);
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		
		//System.out.println(f1(persons));
		
		Character[] chars = {'A','Z','Y','D','R'};
		Integer[] numbers = {4,6,2,1,3};
		Map<Character,Integer>map = new HashMap<Character,Integer>();
		map.put(chars[0], numbers[0]);
		map.put(chars[1], numbers[1]);
		map.put(chars[2], numbers[2]);
		map.put(chars[3], numbers[3]);
		map.put(chars[4], numbers[4]);
		printSet(map);
		
		
		Map<Character,Integer>tree = new TreeMap<Character,Integer>();
		tree.put(chars[0], numbers[0]);
		tree.put(chars[1], numbers[1]);
		tree.put(chars[2], numbers[2]);
		tree.put(chars[3], numbers[3]);
		tree.put(chars[4], numbers[4]);
		printSet(tree);
		
		Set<Character> keys = tree.keySet();
		TreeSet<Character> treeset = new TreeSet<Character>(keys);
		for(int i=0;i<tree.size();i++) {
			treeset.addAll(tree.keySet());
		}
		printTree(treeset);
		
		Comp c = new Comp("Ali",26,100);
		System.out.println(c.compare(p2, p3));
		
	}
	
	public static <A,N>void printSet(Map<A,N> map) {
		System.out.println(map);
		//System.out.println(map.values());
		
	}
	
	public static<T> void printTree(Set<T> tree) {
		for(T key : tree) {
			System.out.println(key);
		}
	}
	
	

}
