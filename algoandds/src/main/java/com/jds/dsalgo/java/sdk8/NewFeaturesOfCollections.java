package com.jds.dsalgo.java.sdk8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NewFeaturesOfCollections {

	public static void main(String[] args) {

		List<Person> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Person person = new Person();
			person.setCountry("India");
			person.setName("Bappa" + i);
			list.add(person);
		}

		long start = Calendar.getInstance().getTimeInMillis();
		PriorityQueue<String> priorityQueue = list.parallelStream().map(Person::getName)
				.collect(Collectors.toCollection(PriorityQueue::new));
		long timetaken = Calendar.getInstance().getTimeInMillis() - start;
		System.out.println(timetaken);

		// long start1 = Calendar.getInstance().getTimeInMillis();
		// PriorityQueue<String> priorityQueue1 = list.stream().map(Person::getName)
		// .collect(Collectors.toCollection(PriorityQueue::new));
		// long timetaken1 = Calendar.getInstance().getTimeInMillis() - start1;
		// System.out.println(timetaken1);
		Map<Person, String> map = list.stream().collect(Collectors.toMap(Function.identity(),Person::getName));
		System.out.println(map);
	}

}

class Person {
	String name;
	String country;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
