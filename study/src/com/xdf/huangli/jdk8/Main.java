package com.xdf.huangli.jdk8;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Object a = null;
        Integer ia = (Integer)a;
        System.out.println(String.valueOf(60015));


//        final Car car = Car.create(Car::new);
//        final List<Car> cars = Arrays.asList(car);

//        cars.forEach( Car::collide );

//        cars.forEach( Car::repair );

//        final String separator = ",";
//        Arrays.asList( "a", "b", "d" ).forEach(
//                ( String e ) -> System.out.print( e + separator ) );

//        Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
    }
}
