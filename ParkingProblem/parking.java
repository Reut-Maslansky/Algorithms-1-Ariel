package ParkingProblem;

import java.util.ArrayList;
import java.util.LinkedList;

public class parking {

    static ArrayList<Boolean> initParking(){
        ArrayList<Boolean> cars= new ArrayList<>();
        cars.add(true);
        cars.add(true);
        cars.add(false);
        cars.add(false);
        cars.add(true);
        cars.add(true);
        cars.add(true);
        cars.add(true);
        cars.add(false);
        cars.add(true);
        System.out.println(cars.size()+ " size");
        return cars;
    }

    static int numberOfCars(ArrayList<Boolean> cars){
        int current= 0;
        cars.set(current,true);
        current++;
        int steps;
        int count=1;
        boolean flag=true;
        while(flag){
            if(!cars.get(current%cars.size())){
                current++;
                count++;
            }
            else {
                cars.set(current%cars.size(),false);
                steps=count;
                while (steps > 0) {
                    current--;
                    steps--;
                }
                if(!cars.get(current%cars.size())){
                    flag=false;
                }
                else {
                    count=1;
                    current=1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<Boolean> cars= initParking();
        System.out.println(numberOfCars(cars));
    }
}
