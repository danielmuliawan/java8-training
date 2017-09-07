package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.IntSummaryStatistics;

public class Stream {

	public static void main(String[] args) {
		List<User> emp = new ArrayList <User>();
		List<String> ageCollection = new ArrayList <String>();
		emp.add(new User("Deny",26));
		emp.add(new User("Daniel",20));
		emp.add(new User("Yuliawan",22));
		emp.add(new User("Sofyan",21));
		emp.add(new User("Ibnu",22));
		emp.add(new User("Taufik",24));
		emp.add(new User("Wisesa",28));
		emp.add(new User("Wimba",27));
		emp.add(new User("Billy",24));
		emp.add(new User("Inez",24));
		
		int count=(int)emp.stream().count();
		emp.stream()
			.forEach(e -> System.out.println("Name : "+e.getName()+", Age : "+e.getAge()));
		System.out.println("Total employees : "+count+"\n\n");
		
		int filtered=(int)emp.stream().filter(e -> e.getAge()>23).count();
		List<User> filteredUser = emp.stream()
										.filter(e -> e.getAge()>23)
										.collect(Collectors.toList());
		filteredUser.stream()
					.forEach(e -> System.out.println("Name : "+e.getName()+", Age : "+e.getAge()));
		System.out.println("Total employees that have age > 23 : "+filtered);
		
		System.out.println("\nEmployee sorted by age (ASC) : ");
		emp.stream()
			.sorted((e1,e2) -> e1.getAge()-e2.getAge())
			.forEach(e -> System.out.println("Name : "+e.getName()+", Age : "+e.getAge()));
		
		System.out.println("\nEmployee sorted by age (DESC) : ");
		emp.stream()
			.sorted((e1,e2) -> e2.getAge()-e1.getAge())
			.forEach(e -> System.out.println("Name : "+e.getName()+", Age : "+e.getAge()));
		
		emp.stream()
			.sorted((e1,e2) -> e1.getAge()-e2.getAge())
			.forEach(e -> ageCollection.add(String.valueOf(e.getAge())));
		String mergedAge = ageCollection.stream().distinct().collect(Collectors.joining(", "));
		System.out.println("\nEmployee age collection : "+mergedAge);
		
		System.out.println("\nEdited Employee Name : ");
		emp.stream()
			.map(e -> new User(e.getName()+" Edited Name",e.getAge()))
			.forEach(e -> System.out.println("Name : "+e.getName()+", Age : "+e.getAge()));
		
		IntSummaryStatistics stats = emp.stream().mapToInt((x) -> x.getAge()).summaryStatistics();
		System.out.println("\nHighest Age : " + stats.getMax());
		System.out.println("Lowest Age : " + stats.getMin());
		System.out.println("Sum of all Ages : " + stats.getSum());
		System.out.println("Average of all Ages : " + stats.getAverage());
	}

}
