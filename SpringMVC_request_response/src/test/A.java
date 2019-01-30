package test;

import org.springframework.beans.factory.annotation.Autowired;

public class A {

    private B bbb;

    public B getBbb() {
        return bbb;
    }
    @Autowired
    public void setBbb(B bbb) {
        this.bbb = bbb;
    }
}
