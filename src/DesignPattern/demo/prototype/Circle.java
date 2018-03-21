package DesignPattern.demo.prototype;

public class Circle extends Shape {

   Circle(){
     type = "Circle";
   }

   @Override
   public void draw() {
      System.out.println("Inside Circle::draw() Test.method.");
   }
}