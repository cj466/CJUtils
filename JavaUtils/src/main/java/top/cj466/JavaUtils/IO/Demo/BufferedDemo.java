package top.cj466.JavaUtils.IO.Demo;

import org.junit.Test;

import java.io.*;

/**
 * @ClassName BufferedDemo
 * @Description TODO 字符流进阶 BufferedWriter BufferedReader
 * @Author w
 * @Date 2019/4/23 16:52
 * @Version 1.0
 * @Since JDK 1.8
 */
public class BufferedDemo {

    /* 为了达到最高的效率，避免频繁地进行字符与字节之间的相互转换，最好不要直接使用FileReader和FileWriter这两个类进行读写，
    而使用BufferedWriter包装OutputStreamWriter，使用BufferedReader包装InputStreamReader */

    private static File FILE = new File("d:" + File.separator + "test.txt");

    @Test
    public void test01() throws Exception {
        Writer writer = new FileWriter(FILE);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("1234\n");
        bw.write("2345\n");
        bw.write("3456\n");
        bw.write("\n");
        bw.write("4567\n");
        bw.close();
        writer.close();

        if (FILE.exists() && FILE.getName().endsWith(".txt")) {
            Reader reader = new FileReader(FILE);
            BufferedReader br = new BufferedReader(reader);
            String str = null;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
            reader.close();
            br.close();
        }
    }

}
