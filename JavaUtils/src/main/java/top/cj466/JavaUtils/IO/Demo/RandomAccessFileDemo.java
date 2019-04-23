package top.cj466.JavaUtils.IO.Demo;

import top.cj466.JavaUtils.IO.Demo.domain.Employee;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * @ClassName Demo02
 * @Description TODO RandomAccessFile 使用实例
 * @Author w
 * @Date 2019/4/23 16:02
 * @Version 1.0
 * @Since JDK 1.8
 */
public class RandomAccessFileDemo {

    public static void main(String[] args) throws Exception {
        Employee zhangsan = new Employee("zhangsan", 23);
        Employee lisi = new Employee("lisi", 24);
        Employee wangwu = new Employee("wangwu", 25);

        RandomAccessFile raf = new RandomAccessFile("e:" + File.separator + "employee.txt", "rw");
        raf.writeBytes(zhangsan.getName());
        raf.writeInt(zhangsan.getAge());
        raf.writeBytes(lisi.getName());
        raf.writeInt(lisi.getAge());
        raf.writeBytes(wangwu.getName());
        raf.writeInt(wangwu.getAge());
        // 写入后关闭资源
        raf.close();
        // 测试
        change();
    }

    private static void change() throws Exception {
        RandomAccessFile raf1 = new RandomAccessFile("e:/employee.txt", "r");
        int len = 8;
        // 尝试跳过输入的n个字节以丢弃跳过的字节，返回跳过的字节数
        raf1.skipBytes(12); // 跳过第一个员工的信息，其姓名8字节，年龄4字节
        System.out.println("第二个员工的信息：");
        String str = "";
        for (int i = 0; i < len; i++) {
            str = str + (char) raf1.readByte();
        }
        System.out.println("name：" + str);
        System.out.println("age：" + raf1.readInt());
        System.out.println("第一个员工的信息：");

        // 设置到此文件开头测量到的文件指针偏移量，在该位置发生下一个读取或写入操作
        raf1.seek(0);

        str = "";
        for (int i = 0; i < len; i++) {
            str = str + (char) raf1.readByte();
        }
        System.out.println("name：" + str);
        System.out.println("age：" + raf1.readInt());
        System.out.println("第三个员工的信息：");
        raf1.skipBytes(12); // 跳过第二个员工的信息
        str = "";
        for (int i = 0; i < len; i++) {
            str = str + (char) raf1.readByte();
        }
        System.out.println("name：" + str.trim());
        System.out.println("age：" + raf1.readInt());
        raf1.close();
    }
}
