package com.wjx;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MyTest2 {

    @Test
    public void test1(){
        String filename = "hello.jsp";
        Path c= Paths.get("/a/b",filename);
        System.out.println(c);
    }
}
