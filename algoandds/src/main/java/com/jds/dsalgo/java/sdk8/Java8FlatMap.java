package com.jds.dsalgo.java.sdk8;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8FlatMap {

	public static void main(String[] args) {
		// array to list
		// list to array
		// map of list value to list
		// toList and toArray function works
		// weak hash-map
		// in build comparator

		System.out.println("array to list");
		String[] array = { "A", "AB" };
		List<String> list = Arrays.asList(array);
		list.stream().forEach(e -> System.out.print(e + ","));

		System.out.println("list to array");
		String[] array1 = list.toArray(new String[list.size()]);
		Arrays.stream(array1).forEach(e -> System.out.print(e + ","));

		System.out.println("stream to list");
		List<Integer> list1 = Stream.of(1, 6, 2, 3, 5).collect(Collectors.toList());

		System.out.println("list sort in reverse order");
		Collections.sort(list1, Comparator.reverseOrder());

		System.out.println("list to int array");
		Integer[] intAr = list1.toArray(new Integer[list1.size()]);
		Arrays.stream(intAr).forEach(e -> System.out.print(e + ","));

		System.out.println("flatmap:map to list");
		Map<Integer, List<Integer>> map = new LinkedHashMap<Integer, List<Integer>>();
		List<Integer> list2 = Stream.of(1, 6).collect(Collectors.toList());
		map.put(1, list1);
		map.put(2, list2);
		List<Integer> listAll = map.entrySet().stream().flatMap(e -> e.getValue().stream())
				.collect(Collectors.toList());
		System.out.println(listAll);

		System.out.println("String replace all using regex");
		String x = list1.toString().replaceAll("\\]|\\[|(, )", "");
		System.out.println(x);

		System.out.println("weak hash map");
		class Key {
		}
		Map<Key, String> weakmap = new WeakHashMap<>();
		Key key1 = new Key();
		Key key2 = new Key();
		weakmap.put(key1, "123");
		weakmap.put(key2, "234");
		System.out.println(weakmap);
		key1 = null;
		System.gc();
		System.out.println(weakmap);
	}

}
