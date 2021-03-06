package cn.wjx.easymvc.bean;

import java.lang.reflect.Method;

/**
 * 封装每一个处理请求的方法的信息（以方法为单位）
 */
public class ControllerBean {
    //当前方法所属的字节码
    private Class<?> controllerClass;
    //当前方法
    private Method controllerMethod;

    public ControllerBean(Class<?> controllerClass, Method controllerMethod) {
        this.controllerClass = controllerClass;
        this.controllerMethod = controllerMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getControllerMethod() {
        return controllerMethod;
    }
}
