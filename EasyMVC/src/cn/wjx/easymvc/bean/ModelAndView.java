package cn.wjx.easymvc.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 模型对象和视图对象的合体
 * 模型对象：需要共享的数据
 * 视图对象：跳转的页面
 */
public class ModelAndView {
    //视图名称
    private String viewName;
    //存放共享的数据
    private Map<String,Object> model = new HashMap<>();

    public void addAttribute(String key, String value) {
        model.put(key,value);
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }

}
