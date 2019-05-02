package com.example.songr;

import com.example.songr.controllers.HelloController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class HelloControllerTest {

    @Test
    public void testHello() {
        HelloController hello = new HelloController();
        String results = hello.helloWorld();
        Assert.assertEquals("Hello World", results);
    }
    @Test
    public void testCaps() {
        HelloController hello = new HelloController();
        String results = hello.toStringCaps("Tiller");
        Assert.assertEquals("TILLER", results);
    }


}
