package interview.errors;

 public abstract class Car implements Stoppable, Movable { // добавил реализацию интерфейсов
    private String engine; // заменил класс на String, чтобы не писать новый, сделал его приватным(т.к есть getter)
    private String color;
    private String name;

     public Car(String engine, String color, String name) { // добавил конструктор
         this.engine = engine;
         this.color = color;
         this.name = name;
     }

    protected void start() {
         System.out.println("Car starting");
     }
    protected void open(){
        System.out.println("Car is open");
    };
    @Override
    public abstract void move(); // метод используемый в обойх реализациях сделал абстрактным, как обязательнвый

     @Override
     public void stop() {
         System.out.println("Car is stop"); // сделал реализацию для интерфейса.
     }

    public String getEngine() {
        return engine;
    }
    public void setEngine(String engine) {
        this.engine = engine;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
 }
