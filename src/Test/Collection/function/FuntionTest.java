package Test.Collection.function;

import org.junit.Test;

import java.util.function.*;

import static org.junit.Assert.assertEquals;

public class FuntionTest {

    @Test
    public void testConsumer() {
        Consumer<VS> consumer1 = (sv) -> {
            sv.setName("Anh");
        };

        Consumer<VS> consumer2 = (sv) -> {
            sv.setName("Dũng");
        };

        VS sv1 = new VS("Hau", 1);
        VS sv2 = new VS("Hau2", 1);
        consumer1.andThen(consumer2).accept(sv1);
        assertEquals("Dũng", sv1.getName());

    }

    @Test
    public void testBiConsumer() {
        VS sv1 = new VS("Hau", 1);
        VS sv2 = new VS("Hau2", 1);
        BiConsumer<VS, VS> biConsumer1 = (s1, s2) -> {
            s1.setName("Change 1");
            s2.setName("Change 2");
        };
        biConsumer1.accept(sv1, sv2);

        assertEquals("Change 1", sv1.getName());
        assertEquals("Change 2", sv2.getName());
    }

    @Test
    public void testFunction() {
        VS sv1 = new VS("Hau", 1);
        VS sv2 = new VS("Hau2", 1);
        Function<VS, String> function = (sv) -> {
            return sv.toString();
        };

        System.out.println(function.apply(sv1));

    }

    @Test
    public void testBiFunction() {
        VS sv1 = new VS("Hau", 1);
        VS sv2 = new VS("Hau2", 1);
        BiFunction<VS, VS, String> biFunction = (sinhVien, sinhVien2) -> {
            return sinhVien.toString() + sinhVien2.toString();
        };
        biFunction.apply(sv1, sv2);
    }

    @Test
    public void testBiPredicate() {
        VS sv1 = new VS("Hau", 1);
        VS sv2 = new VS("Hau2", 1);
        BiPredicate<VS, VS> p = VS::equals;
        BiPredicate<VS, VS> p2 = (sinhVien, sinhVien2) -> {
            return sinhVien.getTuoi() == sinhVien2.getTuoi();
        };
        assertEquals(false, p.test(sv1, sv2));
        assertEquals(true, p.negate().test(sv1, sv2));
        assertEquals(false, p.and(p2).test(sv1, sv2));
        assertEquals(true, p.or(p2).test(sv1, sv2));
    }


    @Test
    public void testSupplier() {
        VS sv1 = new VS("Hau", 1);
        VS sv2 = new VS("Hau2", 1);
        Supplier<VS> s = () -> {
            return new VS("Hậu", 3);
        };
        assertEquals(s.get().getName(), "Hậu");
    }


}

