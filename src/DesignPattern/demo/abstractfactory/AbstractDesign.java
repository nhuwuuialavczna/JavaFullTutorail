package DesignPattern.demo.abstractfactory;

/**
 * Created by JINX_NHI on 3/21/2018.
 */
public  class AbstractDesign
{
    public static void main(String[] args)
    {
        System.out.println(CarFactory.buildCar(CarType.MICRO));
        System.out.println(CarFactory.buildCar(CarType.MINI));
        System.out.println(CarFactory.buildCar(CarType.LUXURY));
    }
}
