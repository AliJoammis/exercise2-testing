package CollectionsHazara;

import java.util.Comparator;
import java.util.Objects;

import Hazara.Person;

public class Comp implements Comparator<Person> {
	private String name;
	private int age;
	private int wheight;
	public Comp(String name, int age, int wheight) {
		super();
		this.name = name;
		this.age = age;
		this.wheight = wheight;
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, name, wheight);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comp other = (Comp) obj;
		return age == other.age && Objects.equals(name, other.name) && wheight == other.wheight;
	}
	@Override
	public String toString() {
		return "Comp [name=" + name + ", age=" + age + ", wheight=" + wheight + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWheight() {
		return wheight;
	}
	public void setWheight(int wheight) {
		this.wheight = wheight;
	}

	@Override
	public int compare(Person o1, Person o2) {
		return o1.getAge() - o2.getAge();
	}
	
}
