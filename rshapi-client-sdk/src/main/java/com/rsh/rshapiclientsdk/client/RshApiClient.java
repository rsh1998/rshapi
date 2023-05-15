package com.rsh.rshapiclientsdk.client;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.rsh.rshapiclientsdk.model.User;
import com.rsh.rshapiclientsdk.util.SignUtil;

import javax.lang.model.element.VariableElement;
import java.util.HashMap;
import java.util.Map;

import static com.rsh.rshapiclientsdk.constant.UserConstant.*;


/**
 * 调用第三发接口的客户端
 * @author rsh
 * @date 2023/3/10 11:29
 */
public class RshApiClient {
    private String accessKey;
    private String secretKey;

    public RshApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getNameByGet(User user){
        String json = JSONUtil.toJsonStr(user);
        if(json==null){
            return "调用失败！";
        }
        String[] split = json.split(":");
        final String name = split[1].substring(1, split[1].length() - 2);
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        HttpResponse httpResponse = HttpRequest.get(GET_URL).addHeaders(getHeaderMap(name)).form(paramMap).execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }
    public String getNameByPost(User user){
        String json = JSONUtil.toJsonStr(user);
        if(json==null){
            return "调用失败！";
        }
        String[] split = json.split(":");
        final String name = split[1].substring(1, split[1].length() - 2);
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        HttpResponse httpResponse = HttpRequest.post(POST_URL).addHeaders(getHeaderMap(name)).form(paramMap).execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }
    private Map<String,String> getHeaderMap(String body){
        Map<String,String> headerMap = new HashMap<>();
        headerMap.put("accessKey",accessKey);
        //私钥一定不要直接发送给后端
        //headerMap.put("secretKey",SECRET_KEY);
        headerMap.put("nonce", RandomUtil.randomNumbers(RANDOM_NUMBERS_LENGTH));
        headerMap.put("body",body);
        headerMap.put("timestamp", String.valueOf(System.currentTimeMillis()/1000));
        headerMap.put("sign", SignUtil.genSign(body,secretKey));
        return headerMap;
    }



    public String getUsernameByPost(User user){
        String json = JSONUtil.toJsonStr(user);
        if(json==null){
            return "调用失败！";
        }
        HttpResponse httpResponse = HttpRequest.post(USER_URL)
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }
}
