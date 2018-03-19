package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.StringTokenizer;
import java.util.function.Consumer;

public class IterableJava {
	private List<String> st = new ArrayList<>();

	public void add(String item) {
		st.add(item);
	}

	public List<String> iteratorJava() {
		String re = "";
		Iterable<String> s = Arrays.asList("1", "2", "3");
		Iterator<String> iter = s.iterator();
		// iter.remove(); // UnsupportedOperationException
		iter.forEachRemaining(this::add);
		return st;
	}

	public String SpliteratorJava() {
		String re = "";
		Iterable<String> s = Arrays.asList("1", "2", "3", "4");
		Spliterator<String> splIter = s.spliterator();
		System.out.println(splIter.characteristics()); // 16464
		System.out.println(splIter.hasCharacteristics(16464));
		System.out.println(splIter.getExactSizeIfKnown());
		System.out.println(splIter.estimateSize()); // 4
		return re;
	}

	String re = "";

	public void addString(String item) {
		re += item;
	}

	public String forEachJava() {
		Iterable<String> s = Arrays.asList("1", "2", "3");
		s.forEach(this::addString);
		return re;
	}

	public boolean listIter() {
		List<Integer> ds = Arrays.asList(1, 2, 3);
		ListIterator<Integer> listIterator = ds.listIterator();
		listIterator.next();
		listIterator.next();
		listIterator.next();
		return listIterator.hasPrevious() && !listIterator.hasNext();
	}

	public static void main(String[] args) {
		IterableJava ij = new IterableJava();
		ij.listIter();
		StringTokenizer tokenizer = new StringTokenizer("hau nguyen", " ");
		Iterator<String> s = (Iterator<String>) tokenizer;
System.out.println(s);

	}
}
