package interview.errors;

public class LightWeightCar  extends Car{ // убрал реализацию интерфейса, т.к. реализовал эти интерфейсы в родителе.
    public LightWeightCar(String engine, String color, String name) {
        super(engine, color, name);
    }

    @Override
    public void open() {
        System.out.println("LightWeightCar is open");
    } // конкретизировал реализацию
    @Override
    public void move() {
        System.out.println("LightWeightCar is moving");
    } // конкретизировал реализацию
}
