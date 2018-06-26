package com.imooc.lombok;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Slf4j
public class Chapter29ApplicationTests {

    @Test
    public void testLombok() {
        //测试Getter/Setter
        UserBean user = new UserBean();
        user.setName("测试lombok");
        System.out.println(user.getName());
    }

}
