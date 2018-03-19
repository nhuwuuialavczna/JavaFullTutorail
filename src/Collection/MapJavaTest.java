package Collection;


import objects.Person;
import objects.Student;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class MapJavaTest {
    @Test
    public void testMap() {
        Person p1 = new Student("A", 12, "Nguyen Tan Hau");
        Person p2 = new Student("B", 12, "Nguyen Tan Hau");
        Person p3 = new Student("C", 12, "Nguyen Tan Hau");
        Person p4 = new Student("A", 12, "Nguyen Tan Hau");
        Person p5 = new Student("A", 12, "Nguyen Tan Hau");
        Person p6 = new Student("B", 12, "Nguyen Tan Hau");
        Person p7 = new Student("B", 12, "Nguyen Tan Hau");
        Map<String, Person> map = new HashMap<>();
        map.put(p1.getName(), p1);
        map.put(p2.getName(), p2);
        map.put(p3.getName(), p3);
        Person p = map.computeIfAbsent("D", (a) -> p2);

        assertEquals(p, p2);

        Person pp = map.computeIfPresent("D15130052", (a, b) -> p2);
        assertEquals(p, p2);
    }
}
