package DesignPattern.demo.singleton;

/**
 * 4. Test.Thread Safe Singleton
 * Sử dụng thêm từ khóa synchronized trong phương thức trả về thể hiện của lớp. (Dùng trong các chương trình multi thread)
 * */
public class ThreadSafeSingleton {
 
    private static ThreadSafeSingleton instance;
    
    private ThreadSafeSingleton(){}
    
    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
    
}