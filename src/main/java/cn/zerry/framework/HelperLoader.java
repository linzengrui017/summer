package cn.zerry.framework;

import cn.zerry.framework.helper.*;
import cn.zerry.framework.util.ClassUtil;

/**
 * @author linzengrui
 * @Description 加载相应的helper类
 * @date 2018年07月03日 11:40
 */
public class HelperLoader {
    public static void init(){
        Class<?>[] classList = {ClassHelper.class, BeanHelper.class, AopHelper.class, IocHelper.class, ControllerHelper.class};
        for (Class<?> cls : classList){
            ClassUtil.loadClass(cls.getName(), true);
        }
    }
}
