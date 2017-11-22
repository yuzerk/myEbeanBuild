package com.example.ebean.util;


import jodd.util.StringUtil;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;


/**
 * 校验工具类
 *
 * @author christ
 * @date 2014年9月3日
 */
public class ValidateUtil {

    /**
     * email正则表达式
     */
    public static final String EMAIL_REG = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";

    /**
     * 空校验
     * <li> 如果value为null返回true
     * <li> 如果value是String类型，如果其中包含的是空白字符则返回true
     * <li> 如果value是Collection类型，如果内容为空则返回true
     * <li> 如果value是Map类型，如果内容为空则返回true
     * <li> 如果value是Array类型，如果长度为0则返回true
     *
     * @param value
     * @return
     * @author christ
     * @date 2014年9月3日 下午2:59:46
     */
    public static boolean isEmpty(Object value) {

        return !isNotEmpty(value);
    }

    /**
     * 不为空校验
     * <li> 如果value为null返回false
     * <li> 如果value是String类型，如果其中包含的是空白字符则返回false
     * <li> 如果value是Collection类型，如果内容为空则返回false
     * <li> 如果value是Map类型，如果内容为空则返回false
     * <li> 如果value是Array类型，如果长度为0则返回false
     *
     * @param value
     * @return
     * @author christ
     * @date 2014年9月3日 下午3:02:40
     */
    public static boolean isNotEmpty(Object value) {

        if (value == null) {
            return false;
        }

        if (value instanceof String) {
            return !StringUtil.isBlank((CharSequence) value);
        }

        if (value instanceof Collection) {
            return !((Collection<?>) value).isEmpty();
        }

        if (value instanceof Map) {
            return !((Map<?, ?>) value).isEmpty();
        }

        if (value.getClass().isArray()) {
            return Array.getLength(value) != 0;
        }
        return true;
    }

    public static boolean isMail(String email) {

        return match(email,EMAIL_REG);
    }

    public static boolean isNotMail(String email) {

        return !isMail(email);
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
        if (isEmpty(strSrc)) {
            return false;
        } else {
            String reg = "^\\d+$";
            return Pattern.compile(reg).matcher(strSrc).find();
        }
    }


    /**
     * 是否满足正则表达式
     *
     * @param str
     * @param reg
     * @return
     */
    public static boolean match(String str, String reg) {

        if (str == null || reg == null) {
            return false;
        }

        return match(str, Pattern.compile(reg));
    }

    /**
     * 是否满足正则表达式
     *
     * @param str
     * @param pattern
     * @return
     */
    public static boolean match(String str, Pattern pattern) {

        if (str == null || pattern == null) {
            return false;
        }

        return pattern.matcher(str).find();
    }

    /**
     * 是否满足日期格式
     *
     * @param date
     * @param format
     * @return
     */
    public static boolean isValidDate(String date, String format) {
        boolean valid = true;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            //设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            simpleDateFormat.setLenient(false);

            simpleDateFormat.parse(date);
        } catch (ParseException e) {
            valid = false;
        }
        return valid;
    }

}