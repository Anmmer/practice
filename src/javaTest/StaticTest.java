package javaTest;

/**
 * @description: 静态方法加载时会加载静态变量，静态方法和静态内部类不会加载中
 * @author:
 * @createDate: 2021/6/30
 */
class Car2 {

//    private static javaTest.Car2 car2 = new javaTest.Car2();

    private Car2() {
        System.out.println("car");
    }

    private static class innerCar2 {
        private static Car2 car2 = new Car2();
    }

    public static Car2 getCar2() {
        return innerCar2.car2;
    }

    public static void get() {

    }
}

public class StaticTest {
    public static void main(String[] args) {
        Car2.getCar2();
//        javaTest.Car2.get();
    }

}
