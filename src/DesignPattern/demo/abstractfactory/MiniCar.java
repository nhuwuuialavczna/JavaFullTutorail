package DesignPattern.demo.abstractfactory;

/**
 * @author  JINX_NHI on 3/21/2018.
 */
public class MiniCar extends Car {
    public MiniCar(Location location) {
        super(CarType.MINI, location);
        construct();
    }

    @Override
    void construct() {
        System.out.println("Connecting to Mini car");
    }
}
