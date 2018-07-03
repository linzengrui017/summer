package cn.zerry.framework.bean;

/**
 * @author linzengrui
 * @Description 返回数据对象
 * @date 2018年07月03日 11:51
 */
public class Data {
    /**
     * 模型数据
     */
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}
