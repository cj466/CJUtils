package top.cj466.JavaUtils.test;

/**
 * @ClassName Test01
 * @Description TODO 被final修饰不可变的是变量的引用，而不是引用指向的内容，引用指向的内容是可以改变的
 * @Author w
 * @Date 2019/4/25 11:39
 * @Version 1.0
 * @Since JDK 1.8
 */
public class Test01 {

    public static void main(String[] args) {
        final FinalString finalString01 = new FinalString("111");
        finalString01.setName("222");
        System.out.println(finalString01); // 222

        // 被final修饰的方法，JVM会尝试为之寻求内联，这对于提升Java的效率是非常重要的。
        // 因此，假如能确定方法不会被继承，那么尽量将方法定义为final的

        // 被final修饰的常量，在编译阶段会存入调用类的常量池中
    }
}
