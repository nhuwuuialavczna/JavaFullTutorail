package Test.Collection;

import objects.Person;
import objects.Student;
import org.junit.Test;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class SetJavaTest {
    @Test
    public void testSet() {
        Person p1 = new Student("A", 15, "15130052");
        Person p2 = new Student("B", 16, "15130136");
        Person p3 = new Student("C", 17, "15130174");
//        Set<Person> set = Set.of(p1, p2, p3);
//        assertEquals(set.size(), 3);

        // set.removeIf(p->p.getAge()>15); //UnsupportedOperationException
    }

    @Test
    public void covertListToSet() {
        Person p1 = new Student("A", 15, "15130052");
        Person p2 = new Student("B", 16, "15130136");
        Person p3 = new Student("C", 17, "15130174");
//        List<Person> list = List.of(p1, p2, p3);
//        Set<Person> set = list.stream().sorted()
//                .collect(Collectors.toSet());
//        assertEquals(set.getClass().getName(), "java.util.HashSet");
    }
    @Test
    public void testSortSet() {
        SortedSet<Person> set = new TreeSet<>();
        Person p1 = new Student("A", 15, "15130052");
        Person p2 = new Student("B", 16, "15130136");
        Person p3 = new Student("C", 17, "15130174");
        set.add(p1);set.add(p2);set.add(p3);
    }
    @Test
    public void testConcurrentSkipSet() {
        ConcurrentSkipListSet<Person> set = new ConcurrentSkipListSet<>();
        Person p1 = new Student("A", 15, "15130052");
        Person p2 = new Student("B", 16, "15130136");
        Person p3 = new Student("C", 17, "15130174");
        set.add(p1);set.add(p2);set.add(p3);
    }
}
