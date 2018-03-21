package DesignPattern.demo.singleton;


/**
 * 1. Eager initialization
 * Thể hiện của lớp sẽ được tạo ngay khi được gọi đến.
 * Đây là cách dễ nhất nhưng nó có một nhược điểm là mặc dù thể hiện (instance) đã được khởi tạo nhưng có thể sẽ không dùng tới.
 */
public class EagerInitializedSingleton {
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
    private EagerInitializedSingleton() {
    }
    public static EagerInitializedSingleton getInstance() {
        return instance;
    }
}