package com.jds.dsalgo.algoandds;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FrequencyInVector {

	public static void main(String[] args) {
		List<Integer> vector=Stream.of(1,1,3,32,1,2,10).collect(Collectors.toList());
		int x=1;
		System.out.println(vector.stream().filter(i->i==x).count());
		}
	
}
