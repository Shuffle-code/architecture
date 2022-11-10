package interview.figure;

public class Figure implements Draw{
    private double area;
    private float perimeter;

    public Figure(double area, float perimeter) {
        this.area = area;
        this.perimeter = perimeter;
    }
    public double getArea() {
        return area;
    }


//    public abstract void areaCalculation();

    public void draw(){
        System.out.println("Draw a shape");
    };
}
