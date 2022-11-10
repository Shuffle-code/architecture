package patterns.decorator;

public class SimpleCoffee implements Coffee{
    @Override
    public float getCost() {
        return 10f;
    }

    @Override
    public String getDescription() {
        return "Simple coffee";
    }
}
