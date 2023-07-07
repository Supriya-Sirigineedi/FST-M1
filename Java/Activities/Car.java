package activities;

public class Car {
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    public Car (){
        this.tyres =4;
        this.doors =4;
    }
    public void displayCharacteristics(){
        System.out.println(color);
        System.out.println(transmission);
        System.out.println(make);
        System.out.println(doors);
        System.out.println(tyres);
    }
    public void accelerate(){
        System.out.println("Car is moving forward.");
    }
    public void brake(){
        System.out.println("Car has stopped.");
    }

}
