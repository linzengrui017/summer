package cn.zerry.framework.helper;

import cn.zerry.framework.annotation.Inject;
import cn.zerry.framework.util.CollectionUtil;
import cn.zerry.framework.util.ReflectionUtil;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author linzengrui
 * @Description 依赖注入 助手类
 * @date 2018年07月02日 17:05
 */
public final class IocHelper {
    static {
        // 获取所有的Bean类与Bean实例之间的映射关系（简称Bean Map）
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)){
            // 遍历 Bean Map
            for (Map.Entry<Class<?>, Object> beanEntity: beanMap.entrySet()){
                // 从 BeanMap 中获取Bean 类与Bean实例
                Class<?> beanClass = beanEntity.getKey();
                Object beanInstance = beanEntity.getValue();
                // 获取 Bean类定义的所有成员变量（简称Bean Field）
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtils.isNotEmpty(beanFields)){
                    // 遍历 Bean Field
                    for (Field beanField : beanFields){
                        // 判断当前 Bean Field 是否带有 Inject 注解
                        if (beanField.isAnnotationPresent(Inject.class)){
                            // 在Bean Map中获取Bean Field对应的实例
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null){
                                // 通过反射初始化BeanField的值
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
