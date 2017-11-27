package com.example.ebean.util;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yjz 字符串处理工具类
 */
public class StringUtil extends jodd.util.StringUtil {

    /**
     * The Constant REGULAR_IP.
     */
    private static final String REGULAR_IP = "(^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$)";

    /**
     * The Constant EMAIL_REGULAR.
     */
    private static final String REGULAR_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";

    /**
     * 所有十六进制的字符.
     */
    private static final String HEX_CHARS = "0123456789ABCDEF";

    /**
     * is a url String or not
     */
    private static final String URL = "^http[s]?=\\/\\/([\\w-]+\\.)+[\\w-]+([\\w-./?%&=]*)?$";

    private static final int LONG_SIZE = 18;

    /**
     * ***************************************************** 功
     * 能：判断一个字符串是否为空值（null或者(压缩空格后)） 入口参数：param str:待判断的字符串 出口参数： 返
     * 回：true：空，false：非空
     * <p>
     * 编写日期：20051220 修改备注：
     * ******************************************************
     */
    public static boolean isStrEmpty(String str) {
        return (str == null) || (str.trim().length() < 1);
    }

    /**
     * 截取字符串两边的空格，<br/>
     * 如果字符串为null或者为空内容，则返回""<br/>
     * 如果为"   abc   "，则截取后为"abc"<br/>
     * 如果为"   abc"，则截取后为"abc"<br/>
     * 如果为"abc   "，则截取后为"abc".
     *
     * @param str 需要截取的字符串
     * @return 截取后的字符串
     */
    public static String trim(String str) {
        if (isStrEmpty(str)) {
            return "";
        }
        return str.trim();
    }

    /**
     * *****************************************************<br/>
     * 功 能：判断一个字符串是否含有非数字的字符<br/>
     * 如果该字符串为空或者空内容，则认为不是数字<br/>
     * 入口参数：param strSrc:待判断的字符串<br/>
     * 出口参数： 返 回：return true：全是数字，false:不全是数字
     * <p>
     * 编写日期：20051220<br/>
     * 修改备注：lbt 2014-5-6修改，使用正则表达式检测
     * ******************************************************
     */
    public static boolean isNum(String strSrc) {
        if (isStrEmpty(strSrc)) {
            return false;
        } else {
            String reg = "^\\d+$";
            return Pattern.compile(reg).matcher(strSrc).find();
        }
    }

    /**
     * ***************************************************** 功 能：判断一个字符是否是英文字母
     * 入口参数：param ch:待判断的字符 出口参数： 返 回：return true：是英文字母，false:不是英文字母
     * <p>
     * 编写日期：20051220 修改备注：
     * ******************************************************
     */
    public static boolean isCharLetter(char ch) {
        return ((ch >= 65 && ch <= 90) && (ch >= 97 && ch <= 122));
    }

    /**
     * 转义一下字符串的特殊字符，使得能够在XML文档中使用，特殊字符包含：<, >, ", ', &
     *
     * @param str 原始的字符串
     * @return 经过转义后的字符串，如果str为空则返回为空。例如abc<def，返回abc&lt;def
     * @author yl0167
     */
    public static String escapeForXML(String str) {
        if (isStrEmpty(str)) {
            return str;
        }
        String newString = str;

        newString = newString.replaceAll("&amp;", "&");
        newString = newString.replaceAll("&lt;", "<");
        newString = newString.replaceAll("&gt;", ">");
        newString = newString.replaceAll("&quot;", "\"");
        newString = newString.replaceAll("&apos;", "'");

        newString = newString.replaceAll("&", "&amp;");
        newString = newString.replaceAll("<", "&lt;");
        newString = newString.replaceAll(">", "&gt;");
        newString = newString.replaceAll("\"", "&quot;");
        newString = newString.replaceAll("'", "&apos;");

        return newString;
    }

    /**
     * 判断串是不是邮箱格式
     *
     * @param email 邮箱的串
     * @return true 是, false 不是
     */
    public static boolean isEmail(String email) {
        return isRegular(email, REGULAR_EMAIL);
    }

    /**
     * 判断字符串是不是http(s) 的 url格式
     *
     * @param url
     * @return true  是， false 不是
     */
    public static boolean isUrl(String url) {
        return isRegular(url, URL);
    }

    /**
     * 校验是否满足正则表达式
     *
     * @param str     字符串
     * @param regular 正则表达式
     * @return true满足, false不满足
     */
    public static boolean isRegular(String str, String regular) {
        if (!StringUtil.isStrEmpty(str) && !StringUtil.isStrEmpty(regular)) {
            Pattern pattern = Pattern.compile(regular.trim());
            Matcher matcher = pattern.matcher(str.trim());
            if (!matcher.find()) {
                return false;
            }
        }

        return true;
    }

    /**
     * 校验是否是IP地址.
     *
     * @param value 需要检测的值
     * @return true, if is IP address
     */
    public static boolean isIPAddress(String value) {
        return isRegular(value, REGULAR_IP);
    }

    /**
     * 将byte转化成十六进制的字符串（全部大写）<br/>
     * 如果byte为空或者空内容，则返回空的内容.
     *
     * @param bytes 字符串的byte数据
     * @return 转化后的十六进制字符串
     * @author lbt
     */
    public static String bytesToHexString(final byte[] bytes) {
        if (bytes == null || bytes.length <= 0) {
            return "";
        }
        int bytesLength = bytes.length;
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytesLength; i++) {
            final int hexIntValue = bytes[i] & 0xFF;
            final String hexString = Integer.toHexString(hexIntValue);
            // Integer转化成十六进制不足两位时，前面补0
            if (hexString.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hexString);
        }
        return stringBuilder.toString().toUpperCase();
    }

    /**
     * 将十六进制转化成byte数组.
     *
     * @param hexString 十六进制的字符串，如果字符串为空或者空内容则返回null
     * @return byte[]
     * @author lbt
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (StringUtil.isStrEmpty(hexString)) {
            return null;
        }
        hexString = hexString.toUpperCase();
        final int length = hexString.length() / 2;
        final char[] hexChars = hexString.toCharArray();
        final byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++) {
            final int pos = i * 2;
            bytes[i] = (byte) (StringUtil.charToByte(hexChars[pos]) << 4 | StringUtil
                    .charToByte(hexChars[pos + 1]));
        }
        return bytes;
    }

    /**
     * 将字符转化成字节.
     *
     * @param c 字符
     * @return 字节
     * @author lbt
     */
    private static byte charToByte(final char c) {
        return (byte) StringUtil.HEX_CHARS.indexOf(c);
    }

    /**
     * 将字符串转换成字符串列表，默认采用,作为分割符<br/>
     * 如果字符串为空或者空内容，则返回空内容的列表.
     *
     * @param str 要转换的字符串
     * @return string 殂
     * @author lbt
     */
    public static List<String> stringToArray(String str) {
        if (isStrEmpty(str)) {
            return new ArrayList<String>();
        }
        String[] arrayStr = str.split(",");
        return Arrays.asList(arrayStr);
    }

    /**
     * 将字符串转为int类型，如果字符串为null或者为空内容或者不是数字，则返回0.
     *
     * @param strValue 字符串，例如123456
     * @return 字符串对应的数字
     */
    public static int convertToInt(String strValue) {
        if (isStrEmpty(strValue)) {
            return 0;
        }

        try {
            return Integer.parseInt(strValue);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * 将字符串转为long类型，如果字符串为null或者为空内容或者不是数字，则返回0.
     *
     * @param strValue 字符串，例如123456
     * @return 字符串对应的数字
     */
    public static long convertToLong(String strValue) {
        if (isStrEmpty(strValue)) {
            return 0;
        }

        try {
            return Long.parseLong(strValue);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * Convert to double.
     *
     * @param value the value
     * @return the double
     */
    public static double convertToDouble(String value) {
        if (isStrEmpty(value)) {
            return 0;
        }

        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException exc) {
            return 0;
        }
    }

    /**
     * Convert to boolean.
     *
     * @param value the value
     * @return true, if successful
     */
    public static boolean convertToBoolean(String value) {
        return Boolean.parseBoolean(value);
    }

    /**
     * 判断字符串是否超过长度限制
     *
     * @param str    字符串
     * @param length 最大长度
     * @return true 超过, false 不超过
     */
    public static boolean isOverLengthLimit(String str, int length) {
        if (!StringUtil.isStrEmpty(str)) {
            return str.trim().length() > length;
        }

        return false;
    }

    /**
     * 删除字符串指定位置的字母
     *
     * @param srcStr
     * @param index
     * @return 返回删除完的结果字符串（string类型不是对象引用）
     */
    public static String removeByIndex(String srcStr, int index) {

        if (index <= 1) {
            return srcStr.substring(1, srcStr.length());
        }

        String temp1 = "";
        try {
            temp1 = srcStr.substring(0, index - 1);
        } catch (Exception e) {
            System.out.println(index + ":" + srcStr + ":   too short");
        }
        String temp2 = "";
        try {

            temp2 = srcStr.substring(index, srcStr.length());
        } catch (Exception e) {
            System.out.println(index + ":" + srcStr + ":   too long");
        }
        return temp1 + temp2;
    }
    /**
     * 将字符串中超过maxLeng长度的字符随机删除.
     *
     * @param src
     * @return
     */
    private static String randomCutString(String src, int maxLength) {
        if (src.length() > maxLength) {
            int le = src.length() - maxLength;
            Random random = new Random();
            for (int i = 0; i < le; i++) {
                int randomi = random.nextInt(src.length());
                src = StringUtil.removeByIndex(src, randomi);
            }
        } else {
            src = addZeroFront(src, maxLength);
        }
        return src;
    }

    /**
     * 在数字字符串前面补零
     *
     * @param src
     * @param length
     * @return
     */
    private static String addZeroFront(String src, int length) {

        if (src.length() >= length) {
            return src;
        }

        int le = length - src.length();
        String result = src;
        for (int i = 0; i < le; i++) {
            result = "0" + result;
        }

        return result;
    }

    /**
     * 指定随机种子和范围，生成随机数
     *
     * @param max
     * @param seed
     * @return
     */
    public static int getRandomWithSeed(int max, Long seed) {

        Random rd = new Random();
        rd.setSeed(seed);
        return rd.nextInt(max);
    }

    /**
     * 指定随机种子和范围，生成随机数
     *
     * @param seed
     * @return
     */
    public static Long getRandomWithSeed(Long seed) {

        Random rd = new Random();
        rd.setSeed(seed);
        return rd.nextLong();
    }

    //---------------------------------new method here------------------------------

    /**
     * 转byte[]
     *
     * @param s
     * @return
     */
    public static byte[] getBytesUtf8(String s) {

        if (ValidateUtil.isEmpty(s)) {
            return null;
        }

        try {
            return s.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * endsWith
     *
     * @param str
     * @param suffix
     * @return
     */
    public static boolean endsWith(String str, String suffix) {
        if (str == null) {
            return false;
        }
        return str.endsWith(suffix);
    }

    /**
     * 加星号
     *
     * @param str
     * @return
     */
    public static String maskMiddle(String str) {

        if (ValidateUtil.isEmpty(str)) {
            return str;
        }

        char[] cs = str.toCharArray();
        if (cs.length == 1) {
            return str;
        }
        if (cs.length == 2) {
            cs[1] = '*';
            return String.valueOf(cs);
        }

        //长度超过3
        int step = cs.length / 3;
        for (int i = step; i <= (cs.length - step - 1); i++) {
            cs[i] = '*';
        }

        return String.valueOf(cs);
    }

    /**
     * 集合转字符串
     *
     * @param datas
     * @return
     */
    public static String join(Collection<String> datas) {
        return myjoin(datas, ",");
    }

    /**
     * 集合转字符串
     *
     * @param src
     * @param separator
     * @return
     */
    public static String myjoin(Collection<String> src, String separator) {
        if (ValidateUtil.isEmpty(src)) {
            return null;
        }

        Iterator iterator = src.iterator();

        if (!iterator.hasNext()) {
            return "";
        }

        Object first = iterator.next();
        if (!iterator.hasNext()) {
            return first == null ? "" : first.toString();
        }

        StringBuilder result = new StringBuilder();
        if (first != null) {
            result.append(first);
        }

        while (iterator.hasNext()) {
            if (separator != null) {
                result.append(separator);
            }

            Object obj = iterator.next();
            if (obj != null) {
                result.append(obj);
            }
        }

        return result.toString();
    }
}
