package javaTest;

/**
 * @description:
 * @author:
 * @createDate: 2021/6/25
 */
public class TryCatchFinallyTest {
    public static void main(String[] args) {
        TryCatchFinallyTest test = new TryCatchFinallyTest();//基本数据类型为值传递，对象为引用传递
        System.out.println(test.fun2());
        System.out.println(test.fun1());
        System.out.println(test.fun());
//        System.out.println(System.currentTimeMillis());

    }

    public int fun2(){
        try{
            return 1;
        }catch (Exception e){
            return 2;
        } finally {
            return 3;
        }
    }

    public int fun1() {
        int i = 10;
        try {
            //doing something

            return i;
        } catch (Exception e) {
            return i;
        } finally {
            i = 20;
        }
    }

    public StringBuilder fun() {
        StringBuilder s = new StringBuilder("Hello");
        try {
            //doing something
            s.append("Word");

            return s;
        } catch (Exception e) {
            return s;
        } finally {
            s.append("finally");
        }
    }

}
