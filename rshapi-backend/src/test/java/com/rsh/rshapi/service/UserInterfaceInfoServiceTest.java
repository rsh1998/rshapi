package com.rsh.rshapi.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author rsh
 * @date 2023/3/11 15:31
 */
@SpringBootTest
public class UserInterfaceInfoServiceTest {
    @Resource
    UserInterfaceInfoService userInterfaceInfoService;

    @Test
    void testInvokeCount(){
        System.out.println(userInterfaceInfoService.invokeCount(1L,1L));
    }
}
