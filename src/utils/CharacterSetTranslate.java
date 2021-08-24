package utils;

import java.nio.charset.StandardCharsets;

/**
 * @description: 字符编码转换
 * @author:
 * @createDate: 2021/7/12
 */
public class CharacterSetTranslate {

    public static void main(String[] args) {
        System.out.println(CharacterSetTranslate.translate("说"));
    }

    public static String translate (String str) {
        String tempStr = "";
        try {
            tempStr = new String(str.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            tempStr = tempStr.trim();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return tempStr;
    }
}
