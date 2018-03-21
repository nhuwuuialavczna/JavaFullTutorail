package Test.Relection;

import objects.Person;
import objects.Student;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
//        printPrivateValue(VS.class,new VS());

        Person p1 = new Student("A", 15, "15130052");
        Person p2 = new Student("B", 16, "15130136");
        Person p3 = new Student("C", 17, "15130174");
        List<Person> ds = Arrays.asList(p1, p2, p3);
        ds.removeIf(p -> p.getAge() > 15); // removeIf :UnsupportedOperationException (deo hieu)
    }


    /**
     * @param cla
     * @param initObject
     *
     * cla là 1 đố tượng class của đố tượng, còn initobject là khỏi tạo đối tượng
     * Xem test bên dưới
     *
     * @Test printPrivateValue(VS.class,new VS());
     * */

    public static void printPrivateValue(Class cla,Object initObject) throws NoSuchFieldException, IllegalAccessException {
        Field[] listField = cla.getDeclaredFields();
        for (Field field : listField) {
            Field f = cla.getDeclaredField(field.getName());
            f.setAccessible(true);
            System.out.println(f.getName()+"\t"+f.get(initObject));
        }
    }
    /**
     * <code>
     *     public class VS {
             private int intA = 10;
             private String stringB = "hau";
             private short shortC = 12;
             private boolean booleanD = true;
         }
     * </code>
     *
     * */
}
