package com.jds.dsalgo.test;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CountOccurances {

	public static void main(String[] args) {
		String str = "occurances";
		Map<String, Long> strCount = Stream.of(str, str, "hello", "welcome", "hello")
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(strCount);

		char[] strAr = str.toCharArray();
		IntStream.range(1, 16).forEach(i -> {
			if (i % 15 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println("Fizz");
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		});
	}
}
