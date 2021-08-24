package utils;

import java.math.BigDecimal;

/**
 * @description: 金额小写转大写
 * @author:
 * @createDate: 2021/3/22
 */
public class MoneyUtil {
    public static final String[] HanDigiStr = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    public static final String[] HanDiviStr = new String[]{"", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "万", "拾", "佰", "仟"};

    public static void main(String[] args) {
        System.out.println(MoneyUtil.positiveIntegerToHanStr("84650000000"));
    }

    public static String positiveIntegerToHanStr(String var0) {
        String var1 = "";
        boolean var2 = false;
        boolean var3 = false;
        int var4 = var0.length();
        if (var4 > 15) {
            return "数值过大!";
        } else {
            for(int var6 = var4 - 1; var6 >= 0; --var6) {
                if (var0.charAt(var4 - var6 - 1) != ' ') {
                    int var5 = var0.charAt(var4 - var6 - 1) - 48;
                    if (var5 < 0 || var5 > 9) {
                        return "输入含非数字字符!";
                    }

                    if (var5 != 0) {
                        if (var2) {
                            var1 = var1 + HanDigiStr[0];
                        }

                        if (var5 != 1 || var6 % 4 != 1 || var6 != var4 - 1) {
                            var1 = var1 + HanDigiStr[var5];
                        }

                        var1 = var1 + HanDiviStr[var6];
                        var3 = true;
                    } else if (var6 % 8 == 0 || var6 % 8 == 4 && var3) {
                        var1 = var1 + HanDiviStr[var6];
                    }

                    if (var6 % 8 == 0) {
                        var3 = false;
                    }

                    var2 = var5 == 0 && var6 % 4 != 0;
                }
            }

            if (var1.length() == 0) {
                return HanDigiStr[0];
            } else {
                return var1;
            }
        }
    }

    public static String numToRMBStr(BigDecimal var0) {
        return numToRMBStr(var0.doubleValue());
    }

    public static String numToRMBStr(double var0) {
        String var2 = "";
        String var3 = "";
        if (var0 < 0.0D) {
            var0 = -var0;
            var2 = "负";
        }

        if (var0 <= 1.0E14D && var0 >= -1.0E14D) {
            long var10 = Math.round(var0 * 100.0D);
            long var6 = var10 / 100L;
            long var4 = var10 % 100L;
            int var8 = (int)var4 / 10;
            int var9 = (int)var4 % 10;
            if (var8 == 0 && var9 == 0) {
                var3 = "整";
            } else {
                var3 = HanDigiStr[var8];
                if (var8 != 0) {
                    var3 = var3 + "角";
                }

                if (var6 == 0L && var8 == 0) {
                    var3 = "";
                }

                if (var9 != 0) {
                    var3 = var3 + HanDigiStr[var9] + "分";
                }
            }

            return "￥" + var2 + positiveIntegerToHanStr(String.valueOf(var6)) + "元" + var3;
        } else {
            return "数值位数过大!";
        }
    }
}
