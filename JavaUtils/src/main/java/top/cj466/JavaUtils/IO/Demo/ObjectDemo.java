package top.cj466.JavaUtils.IO.Demo;

import org.junit.Test;
import top.cj466.JavaUtils.IO.Demo.domain.Employee;

import java.io.*;

/**
 * @ClassName ObjectDemo
 * @Description TODO 对象流
 * @Author w
 * @Date 2019/4/23 17:03
 * @Version 1.0
 * @Since JDK 1.8
 */
public class ObjectDemo {

    private static File FILE = new File("d:" + File.separator + "test.txt");

    /**
     * @return void
     * @Author w
     * @Description //TODO 序列化对象
     * @Date 2019/4/23 17:06
     * @Param []
     */
    @Test
    public void test01() throws Exception {
        Employee zhangsan = new Employee("zhangsan", 23);
        OutputStream o = new FileOutputStream(FILE);
        ObjectOutputStream os = new ObjectOutputStream(o);
        os.writeObject(zhangsan);
        os.close();
        o.close();
    }

    @Test
    public void test02() throws Exception {
        FileInputStream i = new FileInputStream(FILE);
        ObjectInputStream oi = new ObjectInputStream(i);
        Object o = oi.readObject();
        if (o instanceof Employee) {
            Employee person = (Employee) o;
            System.out.println(person);
        }else{
            System.out.println("不是对象");
        }

    }
}
