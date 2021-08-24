package javaTest;

/**
 * @description: C继承B实现A，A中的抽象方法由B实现
 * @author:
 * @createDate: 2021/8/13
 */
public class C extends B implements A{
    public static void main(String[] args) {
        C c = new C();
        c.print();
    }
}
