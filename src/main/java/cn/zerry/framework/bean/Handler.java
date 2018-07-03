package cn.zerry.framework.bean;

import java.lang.reflect.Method;

/**
 * @author linzengrui
 * @Description 封装 Action 信息
 * @date 2018年07月03日 10:49
 */
public class Handler {
    /**
     * Controller 类
     */
    private Class<?> controllerClass;

    /**
     * Action方法
     */
    private Method actionMethod;

    public Handler(Class<?> controllerClass, Method actionMethod){
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
