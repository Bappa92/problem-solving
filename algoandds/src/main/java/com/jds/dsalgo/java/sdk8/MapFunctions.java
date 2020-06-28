package com.jds.dsalgo.java.sdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapFunctions {

	public static void main(String[] args) {
//		List<Integer> list=Stream.of(1,2,5,8,3,4,6,9).map(e->e*2).collect(Collectors.toList())	;
//		Integer[] ar= list.toArray(new Integer[list.size()]);
//	   Arrays.stream(ar).forEach(e->System.out.print(e+",55"));
//	   System.out.println();
//	   System.out.println("list:"+Arrays.asList(ar));
//		System.out.println(list);
//		List<Integer> number = Arrays.asList(2,3,4,5);
//		List<List<Integer>> listf=Arrays.asList(list,number);
//		//ans is the first element, ans passed to each loop
//		int even = number.stream().filter(x->x%2==0).reduce(0,(ans,i)->ans+i);
//		System.out.println(even);
//	  listf.stream().flatMap(e->e.stream()).forEach(e->System.out.print(e+","));
		
		List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );
        

        System.out.println(result);
	}
}
