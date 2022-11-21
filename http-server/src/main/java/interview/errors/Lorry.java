package interview.errors;

public class Lorry extends Car{ // не допускается расширение от разных родителей
    public Lorry(String engine, String color, String name) {
        super(engine, color, name);
    }

    @Override
    public void move(){
        System.out.println("Lorry is moving"); // конкретизировал реализацию
    }
    @Override
    public void stop(){
        System.out.println("Lorry is stop"); // конкретизировал реализацию
    }
}
