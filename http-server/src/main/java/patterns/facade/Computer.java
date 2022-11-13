package patterns.facade;

public class Computer {
    public void getElectricShock(){
        System.out.print("Ouch! ");
    }
    public void makeSound(){
        System.out.print("Beep beep! ");
    }
    public void showLoadingScreen(){
        System.out.print("Loading.. ");
    }
    public void bam(){
        System.out.println("Ready to be used!");
    }
    public void closeEverything(){
        System.out.print("Bup bup bup buzzzz! ");
    }
    public void sooth(){
        System.out.println("Zzzzz ");
    }
    public void pullCurrent(){
        System.out.print("Haaah!");
    }
}
