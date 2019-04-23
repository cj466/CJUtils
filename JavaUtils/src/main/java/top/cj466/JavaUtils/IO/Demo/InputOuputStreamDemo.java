package top.cj466.JavaUtils.IO.Demo;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @ClassName Demo03
 * @Description TODO FileInputStream FileOutputStream 使用实例
 * @Author w
 * @Date 2019/4/23 16:20
 * @Version 1.0
 * @Since JDK 1.8
 */
public class InputOuputStreamDemo {

    private static File FILE = new File("d:" + File.separator + "test.txt");

    /**
     * @return void
     * @Author w
     * @Description //TODO 文件字节输出流
     * @Date 2019/4/23 16:26
     * @Param []
     */
    @Test
    public void test01() throws Exception {
        // true 表示文件存在是否追加
        FileOutputStream fo = new FileOutputStream(FILE, true);
        byte b[] = "fffffffff".getBytes();
        fo.write(b);
        fo.close();
    }

    /**
     * @return void
     * @Author w
     * @Description //TODO 文件字节输入流
     * @Date 2019/4/23 16:29
     * @Param []
     */
    @Test
    public void test02() throws Exception {
        FileInputStream fi = new FileInputStream(FILE);
        byte[] b = new byte[(int) FILE.length()];
        int i = 0;
        // i 保存实际读取字节数
        i = fi.read(b);
        fi.close();

        if (-1 == i) {
            System.out.println("无数据");
        } else {
            System.out.println(i);
            // 转换成字符串
            System.out.println(new String(b, 0, i));
        }
    }
}
