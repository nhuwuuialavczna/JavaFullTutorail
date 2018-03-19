package Collection;

import objects.Person;
import objects.Student;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListJavaTest {
    @Test
    public void testList() {
        Person p1 = new Student("A", 15, "15130052");
        Person p2 = new Student("B", 16, "15130136");
        Person p3 = new Student("C", 17, "15130174");
        List<Person> ds = Arrays.asList(p1, p2, p3);
        ds.removeIf(p -> p.getAge() > 15); // removeIf :UnsupportedOperationException (deo hieu)
//        assertEquals(ds.get(0), p2);

        ds.set(0, p2);
        assertEquals(ds.get(0), p2);

        List<Person> ds2 = Arrays.asList(p3, p1, p2);
        ds2.sort(Comparator.comparing(Person::getName));
        assertEquals(ds2.get(0), p1);
    }

    @Test
    public void testAttributeListAndRoleList() {
        // java bean
    }

    @Test
    public void testToArray() {
        Collection<String> collection = new ArrayList<>();
        collection.add("1");
        collection.add("2");
        collection.add("3");

        String[] s = new String[3];

        Object[] dest = collection.toArray(s);

        System.out.println(Arrays.toString(s));
        System.out.println(Arrays.toString(dest));

    }

    @Test
    public void testSpliterator() {
        Collection<String> collection = new ArrayList<>();
        collection.add("1");
        collection.add("2");
        collection.add("3");
        Spliterator<String> spliterator = collection.spliterator();
        System.out.println(spliterator.characteristics());
    }

    @Test
    public void testVector() {
        Person p1 = new Student("A", 15, "15130052");
        Person p2 = new Student("B", 16, "15130136");
        Person p3 = new Student("C", 17, "15130174");
        Vector<Person> vt = new Vector<>();
        vt.add(p1);
        vt.add(p2);
        vt.add(p3);
    }

    @Test
    public void testAsList() {
        List<String> ds = Arrays.asList("hau", "bv", "xcz");
        ds.add("555");
    }
}
