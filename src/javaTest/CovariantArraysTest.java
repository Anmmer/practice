package javaTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 泛型数组
 * @author:
 * @createDate: 2021/7/13
 */
class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}

public class CovariantArraysTest {
    public static void main(String[] args) {
        //上界
        List<? extends Fruit> flistTop = new ArrayList<Apple>();
        flistTop.add(null);
        //add Fruit对象会报错
//        flistTop.add(new javaTest.Fruit());
        Fruit fruit1 = flistTop.get(0);

        //下界
        List<? super Apple> flistBottem = new ArrayList<Apple>();
        flistBottem.add(new Apple());
        flistBottem.add(new Jonathan());
        //get Apple对象会报错
        Apple apple = (Apple) flistBottem.get(0);
        Object object = flistBottem.get(0);
    }
}
