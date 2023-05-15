package com.rsh.rshapicommon.service;

import com.rsh.rshapicommon.entity.InvokeUser;

/**
 * @author rsh
 * @date 2023/3/14 15:12
 */
public interface InvokeUserCommonService {
    /**
     * 数据库中是否已分配给用户秘钥
     *
     * @param accessKey
     *
     */
    InvokeUser getInvokeUserByAccessKey(String accessKey);
}
