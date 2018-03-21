package DesignPattern.demo.singleton;

/**
 * 3. Lazy Initialization
 * Là một cách làm mang tính mở rộng hơn so với 2 cách làm trên, hoạt động tốt trong từng thread đơn lẻ.
 * Và tất nhiên vấn đề xấu sẽ xảy ra nếu chúng ta đang dùng nó với multi thread. (Để khắc phục nhược điểm này, làm theo cách thứ 4).
 */
public class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton() {
    }

    public static LazyInitializedSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}