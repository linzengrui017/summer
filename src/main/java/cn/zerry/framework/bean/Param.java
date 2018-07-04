package cn.zerry.framework.bean;

import cn.zerry.framework.util.CastUtil;
import cn.zerry.framework.util.CollectionUtil;

import java.util.Map;

/**
 * @author linzengrui
 * @Description 请求参数对象
 * @date 2018年07月03日 11:45
 */
public class Param {
    private Map<String, Object> paramMap;
    public Param(Map<String, Object> paramMap){
        this.paramMap = paramMap;
    }

    /**
     * 根据参数名获取long型参数值
     */
    public long getLong(String name){
        return CastUtil.castLong(paramMap.get(name));
    }

    /**
     * 获取所有字段信息
     */
    public Map<String, Object> getMap() {
        return paramMap;
    }

    /**
     * 验证参数是否为空
     */
    public boolean isEmpty(){
        return CollectionUtil.isEmpty(paramMap);
    }
}
