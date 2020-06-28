package com.jds.dsalgo.algoandds.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StartToEndPath {

	public static void main(String[] args) {
		Map<Integer, List<Integer>> startToEndPaths = new HashMap<>();
		// Start state next state
		// 1 2,3
		// 2 4,5,6
		// 3 7,8
		// 4 9
		// 5 9
		// 7 10
		// 8 10
		startToEndPaths.put(1, Stream.of(2, 3).collect(Collectors.toList()));
		startToEndPaths.put(2, Stream.of(4, 5, 6).collect(Collectors.toList()));
		startToEndPaths.put(3, Stream.of(7, 8).collect(Collectors.toList()));
		startToEndPaths.put(4, Stream.of(9).collect(Collectors.toList()));
		startToEndPaths.put(5, Stream.of(9).collect(Collectors.toList()));
		startToEndPaths.put(7, Stream.of(10).collect(Collectors.toList()));
		startToEndPaths.put(8, Stream.of(10).collect(Collectors.toList()));

		int start = 2, end = 9;

		List<List<Integer>> outputList = new ArrayList<>();

		List<Integer> currentPaths = new ArrayList<>();
		currentPaths.add(start);

		findPaths(startToEndPaths, currentPaths, outputList, start, end);
		if (!outputList.isEmpty()) {
			StringBuffer out = new StringBuffer("YES:path:");
			outputList.stream().forEach(e -> {
				out.append(e.toString().replaceAll(", ", "->").replace("[", "").replace("]", ""));
				out.append(" or ");
			});
			System.out.println(out.toString());
		}
	}

	private static void findPaths(Map<Integer, List<Integer>> startToEndPaths, List<Integer> currentPaths,
			List<List<Integer>> outputList, int start, int end) {
		if (start == end) {
			outputList.add(new ArrayList<>(currentPaths));
			return;
		}
		List<Integer> endPaths = startToEndPaths.get(start);
		if (endPaths != null) {
			for (Integer e : endPaths) {
				currentPaths.add(e);
				findPaths(startToEndPaths, currentPaths, outputList, e, end);
				currentPaths.remove(e);
			}
		} else {
			currentPaths.remove(new Integer(start));
		}
	}

}
