package DesignPattern.demo.abstractfactory;

/**
 * @author  JINX_NHI on 3/21/2018.
 */
public class LuxuryCar extends Car {
    public LuxuryCar(Location location) {
        super(CarType.LUXURY, location);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Connecting to luxury car");
    }
}
