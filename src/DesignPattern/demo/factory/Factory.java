package DesignPattern.demo.factory;

/**
 * @author JINX_NHI on 3/21/2018.
 */
public class Factory {

    public static IPhone getPhone(String name, String type) {
        switch (type) {
            case "Samsung":
                return new SamSung(name);
            default:
                return new Nokia(name);
        }
    }
}
