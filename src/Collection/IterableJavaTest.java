package Collection;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
public class IterableJavaTest {
	IterableJava ij = new IterableJava();
	
	@Test
	public void testIterator() {
		assertEquals("2", ij.iteratorJava().get(1));
	}
	@Test
	public void testforEachJava() {
		assertEquals("123", ij.forEachJava());
	}
	
	@Test
	public void testListIter() {
		assertEquals(true, ij.listIter());
	}
}
