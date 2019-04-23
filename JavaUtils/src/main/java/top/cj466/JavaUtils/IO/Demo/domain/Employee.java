package top.cj466.JavaUtils.IO.Demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Employee
 * @Description TODO
 * @Author w
 * @Date 2019/4/23 15:59
 * @Version 1.0
 * @Since JDK 1.8
 */
@Data
@NoArgsConstructor
public class Employee {

    private String name;
    private int age;
    private static final int LEN = 8;

    public Employee(String name, int age) {
        if (name.length() > LEN) {
            name = name.substring(0, 8);
        } else {
            while (name.length() < LEN) {
                name = name + "\u0000";
            }
        }
        this.name = name;
        this.age = age;
    }
}
