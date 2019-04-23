package top.cj466.JavaUtils.Thread.Demo.CreateThread;

/**
 * @ClassName MyThread02
 * @Description TODO
 * @Author w
 * @Date 2019/4/23 17:25
 * @Version 1.0
 * @Since JDK 1.8
 */
public class MyThread02 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "在运行！");
        }
    }
}
