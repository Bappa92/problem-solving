package com.jds.dsalgo.java.sdk8;


public class MultipleInheritance {
	public static void main(String[] args) {
		// A b = new D();
		// b.a();
	}

}

 interface A {
	default void display() { // code goes here }
	}
}

 interface B extends A {
}

 interface C extends A {
}

 class D implements B, C {
}
