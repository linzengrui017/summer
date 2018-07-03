package cn.zerry.framework.proxy;

/**
 * @author linzengrui
 * @Description 代理接口
 * @date 2018年07月03日 21:10
 */
public interface Proxy {
    /**
     * 执行代理接口
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
