package javaTest;

/**
 * @description: 子类调用父类构造方法时调用子类重写方法,不会调用原有父类方法
 * @author:
 * @createDate: 2021/6/30
 */
class Animal {
    private String food = "肉";

    public Animal() {
        eat();
    }

    public void eat() {
        System.out.println("动物吃" + food);
    }
}

class Cat extends Animal {
    private String food = "鱼";

    public Cat() {
        eat();
    }

    public void eat() {
        System.out.println("猫吃" + food);
    }
}

public class ExtendsTest {
    public static void main(String[] args) {
        new Cat();
    }

}
