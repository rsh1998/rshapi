package com.rsh.rshapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rsh.rshapi.common.ErrorCode;
import com.rsh.rshapi.exception.ThrowUtils;
import com.rsh.rshapi.mapper.InvokeUserInterfaceInfoMapper;
import com.rsh.rshapi.model.enums.UserInterfaceInfoStatusEnum;
import com.rsh.rshapicommon.entity.InvokeUserInterfaceInfo;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author rsh
 * @date 2023/3/14 15:09
 */
@DubboService
public class InvokeUserInterfaceInfoCommonServiceImpl extends ServiceImpl<InvokeUserInterfaceInfoMapper, InvokeUserInterfaceInfo>
        implements com.rsh.rshapicommon.service.InvokeUserInterfaceInfoCommonService {

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        ThrowUtils.throwIf(userId<=0||interfaceInfoId<=0, ErrorCode.PARAMS_ERROR);
        LambdaUpdateWrapper<InvokeUserInterfaceInfo> updateWrapper = new LambdaUpdateWrapper();
        updateWrapper.eq(InvokeUserInterfaceInfo::getUserId,userId);
        updateWrapper.eq(InvokeUserInterfaceInfo::getInterfaceInfoId,interfaceInfoId);
        updateWrapper.eq(InvokeUserInterfaceInfo::getStatus, UserInterfaceInfoStatusEnum.OK.getValue());
        updateWrapper.gt(InvokeUserInterfaceInfo::getLeftNum,0);
        updateWrapper.setSql("leftNum = leftNum-1,totalNum = totalNum+1");
        return  this.update(updateWrapper);
    }

    @Override
    public boolean hasAuthAndLeft(long interfaceInfoId, long userId) {
        ThrowUtils.throwIf(userId<=0||interfaceInfoId<=0, ErrorCode.PARAMS_ERROR);
        LambdaQueryWrapper<InvokeUserInterfaceInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(InvokeUserInterfaceInfo::getInterfaceInfoId,interfaceInfoId);
        queryWrapper.eq(InvokeUserInterfaceInfo::getUserId,userId);
        queryWrapper.eq(InvokeUserInterfaceInfo::getStatus, UserInterfaceInfoStatusEnum.OK.getValue());
        queryWrapper.gt(InvokeUserInterfaceInfo::getLeftNum,0);
        return this.getOne(queryWrapper)!=null;
    }
}
