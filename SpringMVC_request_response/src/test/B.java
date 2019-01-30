package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class B {
    C ccc;
    @Autowired @Value("test")
    public void setParamTwo(String cb) {
        ccc = new C(cb);
    }
}
