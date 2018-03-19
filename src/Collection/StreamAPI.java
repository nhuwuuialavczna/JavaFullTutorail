package Collection;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import objects.Person;
import objects.Student;

public class StreamAPI {
	public String covertListToString() {
		String re =	"";
		Person p1 = new Student("A", 15, "15130052");
		Person p2 = new Student("B", 16, "15130136");
		Person p3 = new Student("C", 17, "15130174");
		List<Person> ds = Arrays.asList(p1,p2,p3);
		int i =0;
//		ds.stream().peek(System.out::println).forEach(System.out::println);// ham peek giong ham foreach nhung cho phep xu ly them

		return re;
	}
	public static void main(String[] args) {
		// dropWhile,flatMapToDouble, isParallel
		StreamAPI s = new StreamAPI();
		System.out.println(s.covertListToString());
	}
}
