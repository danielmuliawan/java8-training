import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


class AllMethod {
	
	/* 1.Predicate <T> */
	public static boolean verifyScore(int score) {
		return score > 50;
	}
	
	public static List<Integer> findNumbers(
	  List<Integer> l, Predicate<Integer> p) {
		List<Integer> newList = new ArrayList<>();
			for(Integer i : l) {
				if(p.test(i)) {
					newList.add(i);
				}
			}
		return newList;
	}
	
	/* 2.Function <T,R> */
	public static String createString(int score) {
		return score+ ",";
	}
	
	public static String concatNumber(
	  List<Integer> l, Function<Integer, String> p) {
		String output = "";
		for(Integer i : l) {
			output += p.apply(i);	
		}
		return output;
	}
	
}

public class main {
	
	private static AllMethod m = new AllMethod();

	
	public static void predicate(List<Integer> list) {
		// Using a lambda expression
		List<Integer> result = m.findNumbers(list, a -> AllMethod.verifyScore(a));
	
		// Using a method reference
		//List<Integer> result = m.findNumbers(list, AllMethod::verifyScore);
		
		System.out.print("1.Predicate\nScore > 50 : ");
		result.stream().forEach(e->{
			System.out.print(e+" ");
		});
	}
	
	public static void function(List<Integer> list) {
		// Using a lambda expression
		String result = m.concatNumber(list, a -> AllMethod.createString(a));
	
		// Using a method reference
		//String result = m.concatNumber(list, AllMethod::createString);
		
		System.out.print("\n\n2.Function\nConcat Score : ");
		System.out.print(result.substring(0,result.length()-1));
		
	}
	
	public static void binaryOperator() {
		BinaryOperator<String> operator = (a, b) -> a + b;
		System.out.print("\n\n3.BinaryOperator\nResult : ");
		System.out.println(operator.apply("Daniel", "Denny"));
	}
	
	public static void consumer() {
		Consumer<String> consumer1=s->{
			System.out.println(s+"Functional Interfaces");
		};
		
		Consumer<String> consumer2=s->{
			System.out.println(s+"Consumer");
		};
		
		Consumer<String> consumer4=s->{
			System.out.println(s+"PBI 3&4");
		};
		
		System.out.print("\n4.Consumer\nResult : ");
		consumer1.andThen(consumer2).andThen(consumer4).accept("This is ");
	}
	
	public static void supplier() {
		Supplier<Integer> supplier1=()->{
			return 50;
		};
		
		Supplier<Integer> supplier2=()->{
			return 100;
		};
		
		System.out.print("\n5.Supplier\nResult : ");
		System.out.println(supplier1.get()+supplier2.get());
	}

	public static void main(String[] args) {
		/* 1.Predicate <T> */
		List<Integer> predicate = Arrays.asList(82,5,75,18,33,94,60);
		predicate(predicate);
		
		/* 2.Function <T,R> */
		List<Integer> function = Arrays.asList(5,2,9,3,1);
		function(function);
		
		/* 3.BinaryOperator <T> */
		binaryOperator();
		
		/* 4.Consumer */
		consumer();
		
		/* 5.Supplier <T> */
		supplier();
	}

}
