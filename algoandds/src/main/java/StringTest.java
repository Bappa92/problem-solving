import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

public class StringTest {
	String a = "ass";
	boolean is = a.equals("equals");
	// create a list of String
	List<String> names = Arrays.asList("Reflection", "Collection", "Stream");

	// demonstration of filter method
	List<String> result = names.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());
}
