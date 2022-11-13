package patterns.composite;

import java.lang.reflect.Array;

public interface Employee {
//    String name = new String();
    String getName();
    float setSalary(float flo);
    float getSalary();
    Array[] getRoles();

}
