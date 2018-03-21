package DesignPattern.demo.singleton;

/***
 *5. Bill Pugh Singleton Implementation
 * Với cách làm này sẽ tạo ra static nested class để tạo thể hiện (Cách mình hay dùng)
 */

public class BillPughSingleton {

    private BillPughSingleton() {
    }

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}