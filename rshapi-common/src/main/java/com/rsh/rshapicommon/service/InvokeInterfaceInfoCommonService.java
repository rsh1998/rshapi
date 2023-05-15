package com.rsh.rshapicommon.service;
import com.rsh.rshapicommon.entity.InvokeInterfaceInfo;
import com.rsh.rshapicommon.entity.InvokeUser;

/**
 *
 * @author rsh
 */
public interface InvokeInterfaceInfoCommonService {

    /**
     * 从数据库中查询模拟接口是否存在，以及请求方法是否匹配，(还可以校验请求参数）
     *
     * @param path
     * @param method
     */
    InvokeInterfaceInfo getInvokeInterfaceInfo(String path, String method);
}
