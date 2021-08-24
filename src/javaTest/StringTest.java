package javaTest;

/**
 * @description:
 * @author:
 * @createDate: 2021/7/9
 */
public class StringTest {
    static String s = new String("hello");
    static int i = 2;


    public static void main(String[] args) {
        StringTest.change(StringTest.s,StringTest.i);
        System.out.println(StringTest.s + " and "+StringTest.i);
    }

    public static void change(String str, int i) {
        str = "se";
        i = 3;
    }
}
