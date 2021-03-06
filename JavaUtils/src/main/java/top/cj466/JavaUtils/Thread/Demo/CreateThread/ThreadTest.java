package top.cj466.JavaUtils.Thread.Demo.CreateThread;

import org.junit.Test;

import java.util.concurrent.FutureTask;

/**
 * @ClassName ThreadTest
 * @Description TODO 测试类
 * @Author w
 * @Date 2019/4/23 17:17
 * @Version 1.0
 * @Since JDK 1.8
 */
public class ThreadTest {

    @Test
    public void test() throws Exception {
        for (int i = 0; i < 5; i++) {
            MyThread01 thread01 = new MyThread01();
            thread01.start();
            thread01.join();
            // join()方法通常由使用线程的程序调用，以将大问题划分成许多小问题，每个小问题分配一个线程。
            // 当所有的小问题都得到处理后，再调用主线程来进一步操作。
        }
    }

    @Test
    public void test01() throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "在运行！");
            new MyThread01().start();
            Thread.sleep(100);
        }
    }

    @Test
    public void test02() throws Exception {
        MyThread02 myThread = new MyThread02();
        Thread thread = new Thread(myThread);
        thread.start();
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "在运行！");
            Thread.sleep(100);
        }
    }

    @Test
    public void test03() throws Exception {
        MyThread03 myThread03 = new MyThread03();
        FutureTask<Object> futureTask = new FutureTask<Object>(myThread03);
        new Thread(futureTask).start();
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "在运行！");
            Thread.sleep(100);
        }
    }
}

