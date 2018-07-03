package cn.zerry.framework.helper;

import cn.zerry.framework.annotation.Action;
import cn.zerry.framework.bean.Handler;
import cn.zerry.framework.bean.Request;
import cn.zerry.framework.util.ArrayUtil;
import cn.zerry.framework.util.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author linzengrui
 * @Description 控制器助手类
 * @date 2018年07月03日 11:24
 */
public final class ControllerHelper {
    /**
     * 用于存放请求与处理器的映射关系（简称 Action Map）
     */
    private static final Map<Request, Handler> ACTION_MAP = new HashMap<>();

    static {
        //获取所有的Controller类
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtil.isNotEmpty(controllerClassSet)){
            //遍历Controller类
            for (Class<?> controllerClass : controllerClassSet){
                //获取Controller类中定义的方法
                Method[] methods = controllerClass.getDeclaredMethods();
                if (ArrayUtil.isNotEmpty(methods)){
                    //遍历Controller类中的方法
                    for (Method method : methods){
                        //判断当前方法是否带有Action注解
                        if (method.isAnnotationPresent(Action.class)){
                            //从Action注解中获取URL映射规则
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();
                            //验证URL映射规则
                            if (mapping.matches("\\w+:/\\w*")){
                                String[] array = mapping.split(":");
                                if (ArrayUtil.isNotEmpty(array) && array.length == 2){
                                    //获取请求方法与请求路径
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod, requestMethod);
                                    Handler handler = new Handler(controllerClass, method);
                                    //初始化 Action_Map
                                    ACTION_MAP.put(request, handler);

                                }
                            }
                        }
                    }
                }
            }
        }
    }


    /**
     * 获取 Handler
     */
    public static Handler getHandler(String requestMethod, String requstPath){
        Request request = new Request(requestMethod, requstPath);
        return ACTION_MAP.get(request);
    }

}
