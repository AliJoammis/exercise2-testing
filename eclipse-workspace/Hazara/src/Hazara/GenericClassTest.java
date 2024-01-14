package Hazara;

public class GenericClassTest<T,E> {
	T t;
	E e;
	public GenericClassTest(T t, E e) {
		this.t = t;
		this.e = e;
	}
	@Override
	public String toString() {
		return "GenericClassTest [t=" + t + ", e=" + e + "]";
	}
}
