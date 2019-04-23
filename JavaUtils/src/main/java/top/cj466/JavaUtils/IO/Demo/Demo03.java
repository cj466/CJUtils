package top.cj466.JavaUtils.IO.Demo;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @ClassName Demo03
 * @Description TODO InputStream OutputStream 使用实例
 * @Author w
 * @Date 2019/4/23 16:20
 * @Version 1.0
 * @Since JDK 1.8
 */
public class Demo03 {

    /**
     * @Author w
     * @Description //TODO 文件字节输出流
     * @Date 2019/4/23 16:26
     * @Param []
     * @return void
     */
    @Test
    public void test01() throws Exception {
        File file = new File("d:" + File.separator + "test.txt");
        FileOutputStream fo = new FileOutputStream(file);
        byte b[] = "fffffffff".getBytes();
        fo.write(b);
        fo.close();
    }
}
