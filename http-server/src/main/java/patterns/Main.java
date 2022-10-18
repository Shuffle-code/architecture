package patterns;

import patterns.adapter.AfricanLion;
import patterns.adapter.Hunter;
import patterns.adapter.WillDog;
import patterns.adapter.WillDogAdapter;
import patterns.bridge.About;
import patterns.bridge.Careers;
import patterns.bridge.DarkThem;
import patterns.chain.Bank;
import patterns.chain.Bitcoin;
import patterns.chain.Paypal;
import patterns.composite.Designer;
import patterns.composite.Developer;
import patterns.composite.Employee;
import patterns.composite.Organization;
import patterns.decorator.MilkCoffee;
import patterns.decorator.SimpleCoffee;
import patterns.decorator.VanillaCoffee;
import patterns.decorator.WhipCoffee;
import patterns.facade.Computer;
import patterns.facade.ComputerFacade;
import patterns.proxy.Door;
import patterns.proxy.LabDoor;
import patterns.proxy.SecuredDoor;

public class Main {
    public static void main(String[] args) throws Exception {
        WillDog willDog = new WillDog();
        WillDogAdapter adapter = new WillDogAdapter(willDog);
        Hunter hunter = new Hunter();
        AfricanLion africanLion = new AfricanLion();
//        hunter.hunt(africanLion);
        hunter.hunt(adapter);
        System.out.println("/");

        DarkThem darkThem = new DarkThem();
        About about = new About(darkThem);
        Careers careers = new Careers(darkThem);
        about.getContent();
        careers.getContent();
        System.out.println("/");

        Employee john = new Designer("John Doe", 1200);
        Employee jane = new Developer("Jane Doe", 1500);
        Organization organization = new Organization();
        organization.addOrganization(jane);
        organization.addOrganization(john);
        System.out.println(organization.getNetSalary());
        System.out.println("/");

        SimpleCoffee simpleCoffee = new SimpleCoffee();
        System.out.println(simpleCoffee.getCost());
        System.out.println(simpleCoffee.getDescription());
        MilkCoffee milkCoffee = new MilkCoffee(simpleCoffee);
        System.out.println(milkCoffee.getCost());
        System.out.println(milkCoffee.getDescription());
        WhipCoffee whipCoffee = new WhipCoffee(milkCoffee);
        System.out.println(whipCoffee.getCost());
        System.out.println(whipCoffee.getDescription());
        VanillaCoffee vanillaCoffee = new VanillaCoffee(whipCoffee);
        System.out.println(vanillaCoffee.getCost());
        System.out.println(vanillaCoffee.getDescription());
        System.out.println("/");

        ComputerFacade computerFacade = new ComputerFacade(new Computer());
        computerFacade.turnOn();
        computerFacade.turnOff();
        System.out.println("/");

        SecuredDoor door = new SecuredDoor(new LabDoor());
        door.open("12345");
        door.open("1234");
        door.close();

        Bank bank = new Bank(100);
        Bitcoin bitcoin = new Bitcoin(200);
        Paypal paypal = new Paypal(300);
        System.out.println(bank.balance);
        System.out.println(bitcoin.balance);
        bank.setNext(paypal);
        paypal.setNext(bitcoin);
//
        bank.pay(220);


    }
}
