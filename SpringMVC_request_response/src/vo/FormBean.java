package vo;

import java.util.ArrayList;
import java.util.List;

//封装表单提交的数据
public class FormBean {
    private List<Long> ids = new ArrayList<>();

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
