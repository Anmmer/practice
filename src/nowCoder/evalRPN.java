package nowCoder;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * @description:
 * @author:
 * @createDate: 2021/7/14
 */
public class evalRPN {
    public static BigDecimal evalRPNFun(String[] tokens) {
        // write code here
        Stack<String> stack = new Stack<>();
        for (String str : tokens) {
            if ("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str)) {
                if (stack.size() < 2) return new BigDecimal(0);
                String a = stack.peek();
                stack.pop();
                String b = stack.peek();
                stack.pop();
//                BigDecimal sum = null;
//                if ("+".equals(str)) sum = new BigDecimal(b).add(new BigDecimal(a));
//                if ("-".equals(str)) sum = new BigDecimal(b).subtract(new BigDecimal(a));
//                if ("*".equals(str)) sum = new BigDecimal(b).multiply(new BigDecimal(a));
//                if ("/".equals(str)) sum = new BigDecimal(b).divide(new BigDecimal(a));
                stack.push(get(a, b, str).toString());
            } else {
                stack.push(str);
            }
        }
        return new BigDecimal(stack.peek());
    }

    public static BigDecimal get(String a, String b, String operator) {
        switch (operator) {
            case "+":
                return new BigDecimal(b).add(new BigDecimal(a));
            case "-":
                return new BigDecimal(b).subtract(new BigDecimal(a));
            case "*":
                return new BigDecimal(b).multiply(new BigDecimal(a));
            case "/":
                BigDecimal num = new BigDecimal(0);
                try {
                    num = new BigDecimal(b).divide(new BigDecimal(a));
                } catch (Exception e) {
                    System.out.println("分母不为零");
                }
                return num;
            default:
                return new BigDecimal(0);
        }

    }


    public static void main(String[] args) {
        String[] strings = {"-3.5", "2", "/"};
        System.out.println(evalRPNFun(strings));
    }
}
