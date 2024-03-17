package peoplefund;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<2;i++) {
            String input = sc.nextLine();
            Car suv = new SUV();
            if(input.equals("topSpeed")){
                suv.topSpeed();
            }
            if(input.equals("fuelType")){
                suv.fuelType();
            }
            Car car = new Car();
            if(input.equals("topSpeed")){
                car.topSpeed();
            }
            if(input.equals("fuelType")){
                car.fuelType();
            }
        }
    }
}

class Car {
    public void topSpeed() {
        System.out.println("Top Speed of the vehicle is 100 kmph");
    }

    public void fuelType() {
        System.out.println("Car fuel type is Petrol");
    }
}

class SUV extends Car {
    @Override
    public void fuelType() {
        System.out.println("SUV fuel type is Diesel");
    }
}
