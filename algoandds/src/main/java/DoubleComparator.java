import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DoubleComparator {

	public static void main(String[] args) {

		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("Jobs", 2);
		map.put("songs", 2);
		map.put("cats", 1);
		map.put("videos", 3);
		map.put("movies", 1);
		map.put("dogs", 1);
		System.out.println(map);
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if (o1.getValue() == o2.getValue()) {
					return o1.getKey().compareTo(o2.getKey());
				}  else {
					return o2.getValue()-o1.getValue();
				}
			}
		});
		list.stream().forEach(e->System.out.print(e.getKey()+" "));
	}

}
