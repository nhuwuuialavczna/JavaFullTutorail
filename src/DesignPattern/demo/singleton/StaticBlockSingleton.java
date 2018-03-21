package DesignPattern.demo.singleton;

/**
 * 2. Static block initialization
 * Cũng tương tự Eager initialization nhưng có thêm phần static block cung cấp thêm tuỳ chọn để xử lý việc khác (chẳng hạn như lỗi).
 */
public class StaticBlockSingleton {

    private static StaticBlockSingleton instance;

    private StaticBlockSingleton() {
    }

    //static block initialization for exception handling 
    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Test.Exception occured in creating singleton instance");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}