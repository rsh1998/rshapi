package com.rsh.rshapiinterface;

import com.rsh.rshapiclientsdk.client.RshApiClient;
import com.rsh.rshapiclientsdk.model.User;
import com.rsh.rshapiclientsdk.util.SignUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class RshapiInterfaceApplicationTests {

    @Resource
    RshApiClient rshApiClient;
    @Test
    void contextLoads() {
        rshApiClient.getNameByGet("rsh");
        rshApiClient.getNameByPost("rsh");
        User user = new User();
        user.setUsername("rsh");
        rshApiClient.getUsernameByPost(user);
    }
    @Test
    void myTest() {
        //System.out.println(SignUtil.genSign("rsh", "abcdefgh"));
        System.out.println(System.currentTimeMillis() / 1000);
    }

}
