package string;


import javafx.beans.binding.StringBinding;
import objects.Person;
import objects.Student;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class StringJavaTest {
    StringJava s = new StringJava();

    @Test
    public void testJionStringFromList() {
        List<String> a = Arrays.asList("1", "2", "3");
        assertEquals("1,2,3", s.jionStringFromList1(",", "1", "2", "3"));
        assertEquals("1,2,3", s.jionStringFromList2(",", a));
        assertEquals("1,2,3", s.jionStringFromList3(",", new String[]{"1", "2", "3"}));
        assertEquals("1,2,3", s.jionStringFromList4(",", a));
    }

    @Test
    public void testStringStream() {
        String s = "nguyen tan hau"; // tim va in ra cac ki tu nho hon ki tu n trong alphabet
        String result = s.chars()
                .distinct() // bo ki tu trung nhau
                .filter(c -> c < "n".charAt(0)) // tim cac ki tu be hon n
                .mapToObj(c -> String.valueOf((char) c)) // chuyen cac char ve string
                .collect(Collectors.joining()); // tap hop lai thanh 1 chuoi
        assertEquals(result,"ge ah");
    }
    @Test
    public void testStringBinding(){
        StringBinding sbd = new StringBinding() {
            @Override
            protected String computeValue() {
                return "hau";
            }
        };
        System.out.println(sbd.length().getValue());
    }
    @Test
    public void testStringStringBuffer(){
        StringBuffer sbf = new StringBuffer("hau");
        sbf.insert(2,"z");
        assertEquals(sbf.length(),4);
        assertEquals(sbf.toString(),"hazu");

        StringBuffer str = new StringBuffer("nguyen  hau");
        str.insert(7,"tan",0,3); // lay chuoi chen them vao chuoi str o vi tri 2 va lay tu ki tu 1 den ki tu 3 - 1
        assertEquals(str.toString(),"nguyen tan hau");

        StringBuffer str2 = new StringBuffer("nguyen tan hau");
        int length1 = str2.length();
        Person p1 = new Student("A",15,"15130052");
        str2.insert(0,p1); // covert p1 to String with method toString()
        int length2 = str2.length();
        str2.insert(length2-length1," ");

        assertEquals(str2.toString(),"A\t15\t15130052 nguyen tan hau");
    }

    @Test
    public void testStringBuilder(){
        StringBuilder sb = new StringBuilder("nguyen tan hau");
    }


}
