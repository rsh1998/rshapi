package com.rsh.rshapiclientsdk.util;

import cn.hutool.crypto.digest.DigestUtil;


/**
 * 签名工具类
 * @author rsh
 * @date 2023/3/10 14:49
 */

public class SignUtil {
    /**
     * 生成签名
     * @param body
     * @param secretKey
     * @return
     */
    public static String genSign(String body, String secretKey) {
        String content = body+"."+secretKey;
        return DigestUtil.sha256Hex(content);
    }
}
