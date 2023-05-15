package com.rsh.rshapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rsh.rshapi.common.ErrorCode;
import com.rsh.rshapi.exception.ThrowUtils;
import com.rsh.rshapi.mapper.InvokeInterfaceInfoMapper;
import com.rsh.rshapicommon.entity.InvokeInterfaceInfo;
import com.rsh.rshapicommon.entity.InvokeUser;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author rsh
 * @date 2023/3/14 15:09
 */
@DubboService
public class InvokeInterfaceInfoCommonServiceImpl  extends ServiceImpl<InvokeInterfaceInfoMapper, InvokeInterfaceInfo>
        implements com.rsh.rshapicommon.service.InvokeInterfaceInfoCommonService {

    @Override
    public InvokeInterfaceInfo getInvokeInterfaceInfo(String path, String method) {
        ThrowUtils.throwIf(StringUtils.isAnyBlank(path,method), ErrorCode.PARAMS_ERROR);
        LambdaUpdateWrapper<InvokeInterfaceInfo> queryWrapper = new LambdaUpdateWrapper<>();
        queryWrapper.eq(InvokeInterfaceInfo::getUrl,path);
        queryWrapper.eq(InvokeInterfaceInfo::getMethod,method);
        return this.baseMapper.selectOne(queryWrapper);
    }
}
