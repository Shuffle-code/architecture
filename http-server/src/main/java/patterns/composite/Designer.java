package patterns.composite;

import java.lang.reflect.Array;

public class Designer implements Employee{
    private String name;
    private float salary;
    private Array[] roles;

    public Designer(String name, float salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float setSalary(float salary) {
        return salary;
    }

    @Override
    public float getSalary() {
        return this.salary;
    }

    @Override
    public Array[] getRoles() {
        return this.roles;
    }
}
