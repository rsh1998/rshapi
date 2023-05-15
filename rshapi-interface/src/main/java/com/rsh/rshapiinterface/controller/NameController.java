package com.rsh.rshapiinterface.controller;

import com.rsh.rshapiclientsdk.model.User;
import com.rsh.rshapiclientsdk.util.SignUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import static com.rsh.rshapiclientsdk.constant.UserConstant.RANDOM_NUMBERS_LENGTH;
import static com.rsh.rshapiinterface.constant.UserConstant.ACCESS_KEY;
import static com.rsh.rshapiinterface.constant.UserConstant.SECRET_KEY;

/**
 * @author rsh
 * @date 2023/3/10 11:06
 */

@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/get")
    public String getNameByGet(String name,HttpServletRequest request) {
        System.out.println(request.getHeader("rsh"));
        return "GET 你的名字是"+name;
    }
    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name){
        return "POST 你的名字是"+name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request){
//        String accessKey = request.getHeader("accessKey");
//        String nonce = request.getHeader("nonce");
//        String body = request.getHeader("body");
//        //String timestamp = request.getHeader("timestamp");
//        String signFront = request.getHeader("sign");
//        //todo 实际情况应该要去数据库中查找相应的accessKey
//        if(!ACCESS_KEY.equals(accessKey)){
//            throw new RuntimeException("无权限！");
//        }
//        if(Long.parseLong(nonce) > Math.pow(10,RANDOM_NUMBERS_LENGTH)){
//            throw new RuntimeException("无权限！");
//        }
//        //时间不能相差5分钟，后续实现
////        Long.parseLong(timestamp)
////        if(){
////
////        }
//        //todo 实际情况应该要去数据库中查找相应的secretKey
//        String signAfter = SignUtil.genSign(body,SECRET_KEY);
//        if(!signAfter.equals(signFront)){
//            throw new RuntimeException("无权限！");
//        }
// 调用成功后次数+1
        return "POST 用户名是"+user.getUsername();
    }
}
