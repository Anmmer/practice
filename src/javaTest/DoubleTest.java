package javaTest;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: 长安
 * @createDate: 2021/3/16
 * @version: 1.0
 */
public class DoubleTest {
    public static void main(String[] args) throws ParseException {
        /*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String str = simpleDateFormat.format(new Date());
        Date date = simpleDateFormat.parse("2021/03/30");
        System.out.println(str);
        System.out.println(date);*/
        Integer a = 128;
        Integer c = 128;
        int b = 128;
        System.out.println(b==a);
//        System.out.println(toBinary(8.9375, 15));
    }

    /***
     * 十进制转二进制
     * @Param: [d, index]
     * @Return: java.lang.String
     */
    public static String toBinary(Double d, int index) {
        String[] initArray = String.valueOf(d).split("\\.");
        String init = "";
        String decimalValue = "";
        String integerValue = "";

        if (!(Double.doubleToLongBits(0) < Double.doubleToLongBits(d))) {
            return "数据要为正数";
        }

        if (!(new BigDecimal(initArray[0]).doubleValue() == 0)) {
            System.out.println("十进制整数" + initArray[0] + "转二进制:除二取余获取二进制数。");
            init = initArray[0];
            int i = 0;
            do {
                BigDecimal[] split = new BigDecimal(init).divideAndRemainder(new BigDecimal("2"));
                integerValue += split[1];
                init = split[0].toString();
                i++;
                System.out.println("计算次数" + i + ",除以2为:" + init + ",余数为:" + split[1]);
            } while (!(new BigDecimal(init).doubleValue() == 0));
            StringBuffer buffer = new StringBuffer(integerValue);
            integerValue = buffer.reverse().toString();
        } else {
            integerValue = "0";
        }

        if (!(new BigDecimal(initArray[1]).doubleValue() == 0)) {
            init = "0." + initArray[1];
            decimalValue = ".";
            int i = 0;
            System.out.println("十进制小数" + init + "转二进制:乘二取整获取二进制数。");
            do {
                BigDecimal a = new BigDecimal(init).multiply(new BigDecimal("2"));
                String[] split = String.valueOf(a).split("\\.");
                decimalValue += split[0];
                init = new BigDecimal("0." + split[1]).toString();
                i++;
                System.out.println("计算次数" + i + ",乘以2为:" + a + ",整数为:" + split[0] + ",小数为" + init);
            } while (!(new BigDecimal(init).doubleValue() == 0) && i < index);
        } else {
            decimalValue = "0";
        }

        if (!(new BigDecimal(init).doubleValue() == 0)) {
            System.out.println("...");
            System.out.println();
            return "结果约等于：" + integerValue + decimalValue;
        }

        System.out.println();
        return "结果：" + integerValue + decimalValue;
    }


}
