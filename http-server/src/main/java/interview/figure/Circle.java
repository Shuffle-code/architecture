package interview.figure;

public class Circle extends Figure{
    private double radius;

    public Circle(double area, float prm, double radius) {
        super(area, prm);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("draw a circle");
    }

//    @Override
//    public void areaCalculation() {
//        System.out.println("Вычисляем площадь");
//    }
}
