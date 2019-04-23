package top.cj466.JavaUtils.Thread.Demo.CreateThread;

/**
 * @ClassName MyThread
 * @Description TODO 继承 Thread 类
 * @Author w
 * @Date 2019/4/23 17:16
 * @Version 1.0
 * @Since JDK 1.8
 */
public class MyThread01 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "在运行！");
        }
    }
}
