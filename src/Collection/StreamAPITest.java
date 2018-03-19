package Collection;



import objects.Person;
import objects.Student;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class StreamAPITest {

    @Test
    public void testMatch() {
        List<String> ds = Arrays.asList("nguyen", "hau", "hau");
        boolean allMatch = ds.stream().allMatch((a) -> {
            return a.equals("hau");
        }); // tất cả fai giống
        boolean anyMatch = ds.stream().anyMatch((a) -> {
            return a.equals("hau");
        }); // 1 cái giống là đủ
        boolean noneMatch = ds.stream().noneMatch((a) -> {
            return a.equals("hau");
        }); // 1 cái gì đó không nằm trong list
        assertTrue(!allMatch);
        assertTrue(anyMatch);
        assertFalse(noneMatch);
    }

    @Test
    public void testCollect() {
        List<String> ds = Arrays.asList("nguyen", "tan", "hau");
        String joinList1 = ds.stream().collect(Collectors.joining(","));
        String joinList2 = ds.stream().collect(Collectors.joining(":", ",", "."));
        assertEquals(joinList1, "nguyen,tan,hau");
        assertEquals(joinList2, ".nguyen,tan,hau:");
    }

    @Test
    public void testSmall() {
        List<String> ds = Arrays.asList("nguyen", "tan", "hau");
        List<String> a = ds.stream().skip(2).collect(Collectors.toList()); // bỏ qua 2 phần tử đầu tiên
        List<String> b = ds.stream().limit(2).collect(Collectors.toList()); // lấy 2 phần tử đầu tiên còn lại bỏ
        assertEquals(a.size(), 1);
        assertEquals(a.get(0), "hau");
        assertEquals(b.size(), 2);
//		assertThrows(a.get(2), new IndexOutOfBoundsException(), "");
    }

    @Test
    public void testMap() {
        List<String> ds = Arrays.asList("nguyen", "tan", "hau");
        List<String> a = ds.stream().map(p -> p + "a").collect(Collectors.toList());// gán từng phần tử bằng chính nó cộng với chữ a
        assertEquals(a.stream().anyMatch((c) -> {
            return c.equals("tana");
        }), true);

    }

    @Test
    public void covertToMap() {
        Person p1 = new Student("A", 15, "15130052");
        Person p2 = new Student("B", 16, "15130136");
        Person p3 = new Student("C", 17, "15130174");
        List<Person> ds = Arrays.asList(p1, p2, p3);
        Map<String, Person> map = ds.stream().collect(Collectors.toMap(Person::getName, p -> p));// key = name, value = person
        assertEquals(map.get("A").getAge(), 15);

        Person p4 = new Student("A", 18, "15130174");
        List<Person> ds1 = Arrays.asList(p1, p2, p3, p4);
        //Map<String,Person> map1 = ds1.stream().collect(Collectors.toMap(Person::getName,p->p)); // trung key se bi loi
        Map<String, Person> map1 = ds1.stream().collect(Collectors.toMap(Person::getName, p -> p, (oldVal, newVal) -> newVal));// key = name, value = person, neu trung key thi lay value moi
        assertEquals(map1.get("A").getAge(), 18);

        // create new linkedList map
        Map<String, Person> map2 = ds1.stream().collect(Collectors.toMap(Person::getName, p -> p, (oldVal, newVal) -> newVal, LinkedHashMap::new));
        assertEquals(map2.getClass().getName(), "java.util.LinkedHashMap");
    }

    @Test
    public void findAny() {
        Person p1 = new Student("A", 15, "15130052");
        Person p2 = new Student("A", 16, "15130136");
        Person p3 = new Student("C", 17, "15130174");
        List<Person> ds = Arrays.asList(p1, p2, p3);
        Optional<Person> optional = ds.stream().filter(p -> p.getName().equals("D")).findAny();
        assertEquals(optional.isPresent(), false);
    }

    @Test
    public void findFirst() {
        Person p1 = new Student("A", 15, "15130052");
        Person p2 = new Student("A", 16, "15130136");
        Person p3 = new Student("C", 17, "15130174");
        List<Person> ds = Arrays.asList(p1, p2, p3);
        Optional<Person> optional = ds.stream().filter(p -> p.getName().equals("C")).findFirst();
        assertEquals(optional.get(), p3);
    }

    @Test
    public void testReduce() {
        Person p1 = new Student("A", 15, "15130052");
        Person p2 = new Student("A", 16, "15130136");
        Person p3 = new Student("C", 17, "15130174");
        List<Person> ds = Arrays.asList(p1, p2, p3);
        Optional<Person> s = ds.stream().reduce((p, i) -> {
            return p.getAge() > 15 ? p : i;
        });
        assertEquals(s.get(), p2);
    }
    @Test
    public void testTakeWhile(){// takewhile se lay lan luot tung phan tu cho den khi khong hop le nua
        Person p1 = new Student("A", 15, "15130052");
        Person p2 = new Student("A", 16, "15130136");
        Person p3 = new Student("C", 17, "15130174");
        List<Person> ds = Arrays.asList(p1, p2, p3);
    }
}
