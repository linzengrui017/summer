package cn.zerry.framework.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author linzengrui
 * @Description 数组工具类
 * @date 2018年07月03日 10:40
 */
public final class ArrayUtil {
    /**
     * 判断数组是否为空
     */
    public static boolean isNotEmpty(Object[] array){
        return !ArrayUtils.isEmpty(array);
    }
    /**
     * 判断数组是否非空
     */
    public static boolean isEmpty(Object[] array){
        return ArrayUtils.isEmpty(array);
    }
}
