/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.rsh.rshapigateway;
import com.rsh.rshapicommon.service.InvokeInterfaceInfoCommonService;
import com.rsh.rshapicommon.service.InvokeUserCommonService;
import com.rsh.rshapicommon.service.InvokeUserInterfaceInfoCommonService;
import com.rsh.service.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.concurrent.TimeUnit;
@Component
//public class Task implements CommandLineRunner {
public class Task {
    @DubboReference
    private InvokeUserInterfaceInfoCommonService userInterfaceInfoCommonService;
    @DubboReference
    private InvokeUserCommonService userCommonService;
    @DubboReference
    private InvokeInterfaceInfoCommonService infoCommonService;
    @DubboReference
    private DemoService demoService;

//    @Override
//    public void run(String... args) throws Exception {
//        new Thread(()-> {
//            while (true) {
//                try {
//                    TimeUnit.SECONDS.sleep(3);
//                    System.out.println(new Date() + " Receive result ======> "
//                            + userCommonService.getInvokeUser("rsh","abcdefgh"));
//                    System.out.println(new Date() + " Receive result ======> "
//                            + infoCommonService.getInvokeInterfaceInfo
//                            ("localhost:8102/api/name/user","POST"));
//                    System.out.println(new Date() + " Receive result ======> "
//                            + userInterfaceInfoCommonService.invokeCount(1,1));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                    Thread.currentThread().interrupt();
//                }
//            }
//        }).start();
//    }


//    @DubboReference
//    private DemoService demoService;
//
//    @Override
//    public void run(String... args) throws Exception {
//        String result = demoService.sayHello("world");
//        System.out.println("Receive result ======> " + result);
//
//        new Thread(()-> {
//            while (true) {
//                try {
//                    TimeUnit.SECONDS.sleep(3);
//                    System.out.println(new Date() + " Receive result ======> " + demoService.sayHello("world"));
//                    System.out.println(new Date() + " Receive result ======> " + demoService.addCount(1024));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                    Thread.currentThread().interrupt();
//                }
//            }
//        }).start();
//    }
}
