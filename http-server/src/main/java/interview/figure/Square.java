package interview.figure;

public class Square extends Figure{
    private double side;

    public Square(double area, float prm, double side) {
        super(area, prm);
        this.side = side;
    }


    @Override
    public void draw() {
        System.out.println("draw a square");
    }

//    @Override
//    public void areaCalculation() {
//
//    }
}
