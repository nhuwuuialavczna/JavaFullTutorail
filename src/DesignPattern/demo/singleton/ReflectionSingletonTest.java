package DesignPattern.demo.singleton;

import java.lang.reflect.Constructor;

/**
 * 6. Using Reflection to destroy Singleton Pattern
 * Reflection được dùng để destroy tất cả các singleton mà chúng ta đã tạo ra.
 * */
public class ReflectionSingletonTest {
 
    public static void main(String[] args) {
        EagerInitializedSingleton instanceOne = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton instanceTwo = null;
        try {
            Constructor[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (EagerInitializedSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }
 
}