package Test.Collection;

import objects.SinhVien;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author JINX_NHI on 3/21/2018.
 */
public class PriQueue {

    @Test
    public void testQueue() {
        PriorityQueue<SinhVien> queue = new PriorityQueue<>();
        queue.add(new SinhVien("C", 19));
        queue.add(new SinhVien("B", 18));
        queue.add(new SinhVien("A", 17));
        queue.add(new SinhVien("D", 20));

        System.out.println(queue.poll());System.out.println(queue.poll());System.out.println(queue.poll());
    }
}
