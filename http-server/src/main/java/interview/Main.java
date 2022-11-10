package interview;

import interview.errors.Car;
import interview.errors.LightWeightCar;
import interview.errors.Lorry;
import interview.figure.Circle;
import interview.figure.Figure;
import interview.figure.Square;
import interview.figure.Triangle;

import java.util.Arrays;
import java.util.List;

public class Main {
        public static void main(String[] args) {
            Person person = new Person.Builder()
                    .addFirstName("Evgeniy")
                    .addLastname("Malyugin")
                    .addMiddleName("Vasilevich")
                    .addCountry("USSR")
                    .addAddress("NSK")
                    .addPhone("12")
                    .addAge(47)
                    .addGender("m")
                    .build();
            System.out.println(person.getAddress() + " " +  person.getAge());
            Car car = new LightWeightCar("caring", "green", "BWM");
            Car c = new Lorry("as", "red", "s");
            List<Car> cars = Arrays.asList(c, car);
            for (Car carInList : cars
                 ) {
                System.out.println(carInList.getColor());
                carInList.move();
                carInList.stop();
            }

            Figure figure = new Figure(12, 32);
            Figure circle = new Circle(12, 32, 23);
            Figure triangle = new Triangle(12, 34, 35, 21);
            Figure square = new Square(2, 3, 5);
            List<Figure> lst = Arrays.asList(figure, triangle, square, circle);
            for (Figure f : lst
                 ) {
                f.draw();
            }

            System.out.println(figure.getArea());
        }


}
