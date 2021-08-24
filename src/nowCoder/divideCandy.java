package nowCoder;

/**
 * @description:
 * @author:
 * @createDate: 2021/7/14
 */
public class divideCandy {
    //[1,2,5,2,2,1]
    public static int divide(int[] ints) {
        int[] score = new int[ints.length];
        int sum = 0;
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] > ints[i - 1]) {
                score[i] = score[i - 1] + 1;
            }
        }
        for (int i = ints.length - 2; i >= 0; i--) {
            if (ints[i] > ints[i + 1] && score[i] <= score[i + 1]) {
                score[i] = score[i+1] + 1;
            }
            sum += score[i];
        }
        return sum + ints.length;
    }

    public static void main(String[] args) {
        int[] ints = {1,2,5,2,2,1};
        System.out.println(divide(ints));
    }
}
