import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HackNumber {

	public static void main(String[] args) {
		System.out.println("We love to hack on hackerearth".indexOf("hack",14));
		//solve("We love to hack on hackerearth", "hack", 'Y',14);
	}

	static void solve(String S1, String S2, char C, int I) {
		int j = 0;
		int output = 0;
		boolean isFound = false;
		while(!isFound) {
			int index=S1.indexOf(S2,I);
			if(index==-1) {
				break;
			}else {
				if(C=='Y') {
					if(index-1>=0 && S1.charAt(index-1)==' ' &&
						index+S2.length()<=S1.length() && S1.charAt(index+S2.length())==' ')
					{
						isFound=true;

					}else {
						
					}
				}else {
					isFound=true;
				}
				I=index+S2.length()-1;
			}
				
		}
		if (isFound) {
			System.out.println(output);
		} else {
			System.out.println("Goodbye Watson");
		}
		
		m1();
		return;
		
		
	}
	
	static void m1()
	{
		String str = "occurrences";
		
		Set<Entry<String, Long>> entrySet = Stream.of(str).filter(f -> !f.isEmpty()).map(m -> m.split("")).flatMap(Arrays::stream).sorted().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet();
		
		entrySet.forEach(System.out::println);
	}
}
