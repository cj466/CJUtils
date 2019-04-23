package top.cj466.JavaUtils.IO.Demo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName Demo01
 * @Description TODO File类使用实例
 * @Author w
 * @Date 2019/4/23 15:24
 * @Version 1.0
 * @Since JDK 1.8
 */
public class Demo01 {

    public static void main(String[] args) {
        String fileName = "D:" + File.separator + "响应式编程资料";
        File file = new File(fileName);

        // 判断路径指向的文件是否存在、是否目录
        if (file.exists() && file.isDirectory()) {
            System.out.println("file是一个文件夹\n");

            // 获取当前目录下所有文件 / 文件夹
            File[] files = file.listFiles();
            System.out.println("路径下有文件：");
            for (File fl : files) {
                System.out.println(fl + "\t");
            }
            System.out.println();
            System.out.println("file[0]的文件名：" + files[0].getName());
            System.out.println("file[0]的文件路径：" + files[0].getPath());
            System.out.println("file[0]的绝对路径：" + files[0].getAbsolutePath());
            System.out.println("file[0]的父文件夹名：" + files[0].getParent());
            System.out.println("file[0]的最后修改时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(files[0].lastModified())));
            System.out.println("file[0]的大小：" + files[0].getName());
            System.out.println("file[0]的文件名：" + files[0].length() + "bytes");
            System.out.println("file[0]的路径转换为URI：" + files[0].toURI());

            System.out.println(files[0].exists() ? "files[0]的存在" : "files[0]的不存在");
            System.out.println(files[0].canWrite() ? "files[0]的可写" : "files[0]的不可写");
            System.out.println(files[0].canRead() ? "files[0]的可读" : "files[0]的不可读");
            System.out.println(files[0].canExecute() ? "file[0]可执行" : "file[0]不可执行");
            System.out.println(files[0].isDirectory() ? "files[0]的是目录" : "files[0]的不是目录");
            System.out.println(files[0].isFile() ? "files[0]的是文件" : "files[0]的不是文件");
            System.out.println(files[0].isAbsolute() ? "files[0]的路径名是绝对路径" : "files[0]的路径名不是绝对路径");

            // 删除为delete()
        }
    }
}
