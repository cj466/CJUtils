package top.cj466.JavaUtils.Thread.Demo.CreateThread;

import java.util.concurrent.Callable;

/**
 * @ClassName MyThread03
 * @Description TODO
 * @Author w
 * @Date 2019/4/23 17:27
 * @Version 1.0
 * @Since JDK 1.8
 */
public class MyThread03 implements Callable {

    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "在运行！");
        }
        return null;
    }
}
