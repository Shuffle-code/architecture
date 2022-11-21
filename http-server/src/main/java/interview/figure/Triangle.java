package interview.figure;

public class Triangle extends Figure {
    private double angle;
    private double side;


    public Triangle(double area, float prm, double angle, double side) {
        super(area, prm);
        this.angle = angle;
        this.side = side;
    }

    @Override
    public void draw() {
        System.out.println("draw a triangle");
    }

//    @Override
//    public void areaCalculation() {
//
//    }
}
