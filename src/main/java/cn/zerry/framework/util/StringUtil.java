package cn.zerry.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author linzengrui
 * @Description 字符串工具类
 * @date 2018年07月03日 8:40
 */
public final class StringUtil {
    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str){
        if (str != null){
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否非空
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

}
