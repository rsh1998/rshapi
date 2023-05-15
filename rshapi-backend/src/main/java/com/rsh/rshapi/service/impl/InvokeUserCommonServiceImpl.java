package com.rsh.rshapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rsh.rshapi.common.ErrorCode;
import com.rsh.rshapi.exception.ThrowUtils;
import com.rsh.rshapi.mapper.InvokeUserInterfaceInfoMapper;
import com.rsh.rshapi.mapper.InvokeUserMapper;
import com.rsh.rshapicommon.entity.InvokeUser;
import com.rsh.rshapicommon.entity.InvokeUserInterfaceInfo;
import com.rsh.rshapicommon.service.InvokeUserCommonService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author rsh
 * @date 2023/3/14 15:15
 */
@DubboService
public class InvokeUserCommonServiceImpl extends ServiceImpl<InvokeUserMapper, InvokeUser>
        implements InvokeUserCommonService {
//    @Override
//    public InvokeUser getInvokeUser(String accessKey, String secretKey) {
//        ThrowUtils.throwIf(StringUtils.isAnyBlank(secretKey,secretKey), ErrorCode.PARAMS_ERROR);
//        LambdaUpdateWrapper<InvokeUser> queryWrapper = new LambdaUpdateWrapper<>();
//        queryWrapper.eq(InvokeUser::getAccessKey,accessKey);
//        queryWrapper.eq(InvokeUser::getSecretKey,secretKey);
//        return this.baseMapper.selectOne(queryWrapper);
//    }

    @Override
    public InvokeUser getInvokeUserByAccessKey(String accessKey) {
        ThrowUtils.throwIf(StringUtils.isBlank(accessKey), ErrorCode.PARAMS_ERROR);
        LambdaUpdateWrapper<InvokeUser> queryWrapper = new LambdaUpdateWrapper<>();
        queryWrapper.eq(InvokeUser::getAccessKey,accessKey);
        return this.baseMapper.selectOne(queryWrapper);
    }
}
