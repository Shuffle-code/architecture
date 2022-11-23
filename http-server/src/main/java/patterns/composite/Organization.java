package patterns.composite;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Organization {
    private final ArrayList<Employee> employees = new ArrayList<>();


    public void addOrganization (Employee employee){
        employees.add(employee);
    }

    public float getNetSalary(){
        float netSalary = 0;
        for (Employee employee : employees) {
            netSalary += employee.getSalary();
        }
        return netSalary;
    }


}
