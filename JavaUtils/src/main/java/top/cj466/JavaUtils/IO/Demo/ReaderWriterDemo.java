package top.cj466.JavaUtils.IO.Demo;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @ClassName ReaderWriterDemo
 * @Description TODO FileReader FileWriter 使用实例
 * @Author w
 * @Date 2019/4/23 16:42
 * @Version 1.0
 * @Since JDK 1.8
 */
public class ReaderWriterDemo {

    private static File FILE = new File("d:" + File.separator + "test.txt");

    /**
     * @return void
     * @Author w
     * @Description //TODO 文件字符输出流
     * @Date 2019/4/23 16:45
     * @Param []
     */
    @Test
    public void test01() throws Exception {
        if (FILE.exists()) {
            FILE.delete();
        }
        FileWriter fw = new FileWriter(FILE);
        String str = "你好";
        fw.write(str);
        fw.close();
    }

    /**
     * @return void
     * @Author w
     * @Description //TODO 文件字符输入流
     * @Date 2019/4/23 16:46
     * @Param []
     */
    @Test
    public void test02() throws Exception {
        FileReader fr = new FileReader(FILE);
        char[] cbuf = new char[1024];
        int i = 0;
        i = fr.read(cbuf);
        fr.close();
        if (-1 == i) {
            System.out.println("文件无数据");
        } else {
            System.out.println(new String(cbuf, 0, i));
        }
    }
}
