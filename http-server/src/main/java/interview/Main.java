package interview;

import interview.errors.Car;
import interview.errors.LightWeightCar;
import interview.errors.Lorry;
import interview.figure.Circle;
import interview.figure.Figure;
import interview.figure.Square;
import interview.figure.Triangle;
import interview.list.ArrayList;
import interview.list.LinkedList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class Main {
        public static void main(String[] args) {
//            Person person = new Person.Builder()
//                    .addFirstName("Evgeniy")
//                    .addLastname("Malyugin")
//                    .addMiddleName("Vasilevich")
//                    .addCountry("USSR")
//                    .addAddress("NSK")
//                    .addPhone("12")
//                    .addAge(47)
//                    .addGender("m")
//                    .build();
//            System.out.println(person.getAddress() + " " +  person.getAge());
//            Car car = new LightWeightCar("caring", "green", "BWM");
//            Car c = new Lorry("as", "red", "s");
//            List<Car> cars = Arrays.asList(c, car);
//            for (Car carInList : cars
//                 ) {
//                System.out.println(carInList.getColor());
//                carInList.move();
//                carInList.stop();
//            }
//
//            Figure figure = new Figure(12, 32);
//            Figure circle = new Circle(12, 32, 23);
//            Figure triangle = new Triangle(12, 34, 35, 21);
//            Figure square = new Square(2, 3, 5);
//            List<Figure> lst = Arrays.asList(figure, triangle, square, circle);
//            for (Figure f : lst
//                 ) {
//                f.draw();
//            }
//            System.out.println(figure.getArea());


            ArrayList arrayList = new ArrayList();
            ArrayList a = new ArrayList();
            a.add(12);
            System.out.println("_+_+_+_+_+_+_+_+_+_+");
            a.iterable();
            System.out.println("++++++++++++++++++++");
            int[] array = arrayList.getEmptyArray();
            array = arrayList.add(array,34);
            array = arrayList.add(array,12);
            arrayList.printArray(array);
            array = arrayList.add(array, 1);
            array = arrayList.add(array, 2);
            array = arrayList.add(array,3);
            array = arrayList.add(array,4);
            array = arrayList.add(array,5);

            arrayList.printArray(array);
            System.out.println("********************");
            int[] values = {1, 4, 3, 5, 98};

            ArrayList arr = new ArrayList(values);
        arrayList.printArray(values);
        arr.insert(99, 0);
        arrayList.printArray(values);
            System.out.println(arr.get(0));

            System.out.println("********************");
            arr.add(100);
            arr.iterable();
            System.out.println("********************");

            arr.delete(99);
            arr.printArray(values);
//            doIteratorForListCollectionsDemo(doLinkedListDemo());
            System.out.println("__________________");
            arr.iterable();

            LinkedList linkedList = new LinkedList();
            linkedList.add(23);
            linkedList.add(45);
            linkedList.add(9);
            linkedList.iterable();
//            linkedList.delete(45);
            linkedList.iterable();
            System.out.println(linkedList.get(45));
            System.out.println(linkedList.get(9));
            System.out.println(linkedList.get(23));
            linkedList.insert(99, 2);
            linkedList.insert(100, 3);
            linkedList.iterable();

        }
//    static List<Integer> doLinkedListDemo() {
//        List<Integer> digits = new LinkedList<>();
//        digits.add(123);
//        digits.add(null);
//        digits.add(-12);
//        digits.add(-12);
//        return digits;
//    }
//
//
//    static void doIteratorForListCollectionsDemo(List<Integer> digits) {
//        System.out.println("Value of index 2: " + digits.get(1));
//
//        Iterator<Integer> iterator = digits.iterator();
//        while (iterator.hasNext()) {
//            Integer value = iterator.next();
//            System.out.println("Value:  " + value);
//        }
//        for (Integer digit : digits) {
//            System.out.println("ForEach Value:  " + digit);
//        }
//        System.out.println(digits);
//    }
}
