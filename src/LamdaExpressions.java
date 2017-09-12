import java.util.*;
import java.util.stream.Collectors;

public class LamdaExpressions {
	
	public static void ascending(List<Person> playerList) {
		playerList.sort((p1, p2) -> p1.age.compareTo(p2.age));
		
		System.out.println("Sorting Age (Ascending)");
		System.out.println("Name\tAge\tGrade");
		System.out.println("=====================");
		for ( Person p: playerList )
			System.out.println( p.name+"\t"+p.age+"\t"+p.grade );
	}
	
	public static void descending(List<Person> playerList) {
		playerList.sort((p1, p2) -> p2.age.compareTo(p1.age));
		
		System.out.println("\nSorting Age (Descending)");
		System.out.println("Name\tAge\tGrade");
		System.out.println("=====================");
		for ( Person p: playerList )
			System.out.println( p.name+"\t"+p.age+"\t"+p.grade );
	}
	
	public static void filtering(List<Person> playerList) {
		playerList.stream().filter(p -> p.age > 30 && "D".equals(p.grade)).collect(Collectors.toList());
		
		System.out.println("\nFiltering (Age > 30 and Grade = D)");
		System.out.println("Name\tAge\tGrade");
		System.out.println("=====================");
		for ( Person p: playerList )
			System.out.println( p.name+"\t"+p.age+"\t"+p.grade );
	}
	
	public static void modifying(List<Person> playerList) {
		playerList.forEach(m -> {
			if(m.grade.charAt(0) == 'A' || m.grade.charAt(0) == 'B'){
				m.grade+=" (Pass)";
			} else {
				m.grade+=" (Failed)";
			}
		});
		
		System.out.println("\nModifying (If Grade = A/B then Pass, else Failed)");
		System.out.println("Name\tAge\tGrade");
		System.out.println("=====================");
		for ( Person p: playerList )
			System.out.println( p.name+"\t"+p.age+"\t"+p.grade );
	}
	
	public static void substraction(List<Person> playerList) {
		playerList.forEach(s -> {
			if(s.age < 50){
				s.age+=25;
			} else {
				s.age+=50;
			}
		});
		
		System.out.println("\nSubstraction (Age)");
		System.out.println("Name\tAge\tGrade");
		System.out.println("=====================");
		for ( Person p: playerList )
			System.out.println( p.name+"\t"+p.age+"\t"+p.grade );
	}
	
	public static void main (String[] args) {
		List<Person> playerList = new ArrayList<Person>(Arrays.asList(
				new Person("Foy",19,"A"),new Person("Rov",4,"E"),
				new Person("Zev",55,"B"),new Person("Mor",109,"D"),
				new Person("Kut",82,"C")));

		/* Sorting Age (Ascending) : Using Lambda Expression */
		ascending(playerList);
		
		/* Sorting Age (Descending) : Using Lambda Expression */
		descending(playerList);
		
		/* Filtering (Age > 30 and Grade = D) : Using Lambda Expression */
		filtering(playerList);
		
		/* Modifying (If Grade = A/B then Pass, else Failed) : Using Lambda Expression */
		modifying(playerList);
		
		/* Substraction (Age): Using Lambda Expression */
		substraction(playerList);
		
	}

}
