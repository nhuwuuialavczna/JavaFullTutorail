package LapTrinhDaLuong.producerconsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

	}

	private static void producer() throws InterruptedException {
		Random random = new Random();
		while (true) {
			if (queue.size() <= 10) {
				queue.put(random.nextInt(100));
				Thread.sleep(650);
			}
		}
	}

	private static void consumer() throws InterruptedException {
		Random random = new Random();

		while (true) {

			Thread.sleep(150);

			if (random.nextInt(5) == 0 && queue.size() > 0) {
				Integer value = queue.take();
				System.out.println("Người tới lấy : " + value + " , Sản phẩm còn lại : " + queue.size());
			}
		}
	}
}
