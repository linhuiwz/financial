package com.imooc.lombok;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Slf4j
public class LombokHelloTest {

    @Test
    public void lombokHello(){
        SimpleUser simpleUser = new SimpleUser();
        simpleUser.setUsername("summer");
        Assert.assertEquals(simpleUser.getUsername(), "summer");
        log.info("username: " + simpleUser.getUsername());
    }

    @Test
    public void constructorTest(){
        SimpleUser simpleUser = new SimpleUser("username", "password", 18);
        Assert.assertEquals("username", simpleUser.getUsername());
        log.info("user: " + simpleUser.toString());
    }


}
