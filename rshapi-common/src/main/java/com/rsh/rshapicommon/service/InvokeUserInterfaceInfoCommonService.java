package com.rsh.rshapicommon.service;
import com.rsh.rshapicommon.entity.InvokeInterfaceInfo;

/**
 *
 * @author rsh
 */
public interface InvokeUserInterfaceInfoCommonService {

    /**
     * 重新计算剩余调用次数
     *
     * @param interfaceInfoId
     * @param userId
     *
     */
    boolean invokeCount(long interfaceInfoId, long userId);
    /**
     * 查询该用户是否开通该接口且剩余调用次数大于0
     *
     * @param
     *
     */
    boolean hasAuthAndLeft(long interfaceInfoId,long userId);
}
