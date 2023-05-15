package com.rsh.rshapi;

import com.rsh.rshapi.config.WxOpenConfig;
import javax.annotation.Resource;

import com.rsh.rshapi.model.enums.InterfaceInfoStatusEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 主类测试
 *
 *
 *
 */
@SpringBootTest
class MainApplicationTests {

    @Resource
    private WxOpenConfig wxOpenConfig;

    @Test
    void contextLoads() {
        System.out.println(wxOpenConfig);
    }@Test
    void myTest() {
        System.out.println(InterfaceInfoStatusEnum.OFFLINE.getValue());
    }
}
