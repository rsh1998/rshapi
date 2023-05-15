package com.rsh.rshapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rsh.rshapi.common.ErrorCode;
import com.rsh.rshapi.exception.ThrowUtils;
import com.rsh.rshapi.mapper.UserInterfaceInfoMapper;
import com.rsh.rshapi.model.dto.userinterfaceinfo.UserInterfaceInfoQueryRequest;
import com.rsh.rshapi.model.entity.UserInterfaceInfo;
import com.rsh.rshapi.model.vo.UserInterfaceInfoVO;
import com.rsh.rshapi.service.UserInterfaceInfoService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService {

    @Resource
    UserInterfaceInfoMapper userInterfaceInfoMapper;
    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        Long userId = userInterfaceInfo.getUserId();
        Long interfaceInfoId = userInterfaceInfo.getInterfaceInfoId();
        Integer totalNum = userInterfaceInfo.getTotalNum();
        Integer leftNum = userInterfaceInfo.getLeftNum();
        // 创建时，参数不能为空
        ThrowUtils.throwIf(userInterfaceInfo==null
                ||userId==null||interfaceInfoId==null
                ||totalNum==null||leftNum==null, ErrorCode.PARAMS_ERROR);
        // 有参数则校验
        if (add) {
            ThrowUtils.throwIf(userId<=0||interfaceInfoId<=0
                    ||totalNum<0, ErrorCode.PARAMS_ERROR,"参数值存在错误");
        }
    }

    @Override
    public boolean invokeCount(long interfaceInfoId,long userId) {
        ThrowUtils.throwIf(userId<=0||interfaceInfoId<=0,ErrorCode.PARAMS_ERROR);
        LambdaUpdateWrapper<UserInterfaceInfo> updateWrapper = new LambdaUpdateWrapper();
        updateWrapper.eq(UserInterfaceInfo::getUserId,userId);
        updateWrapper.eq(UserInterfaceInfo::getInterfaceInfoId,interfaceInfoId);
        updateWrapper.gt(UserInterfaceInfo::getLeftNum,0);
        updateWrapper.setSql("leftNum = leftNum-1,totalNum = totalNum+1");
        return  this.update(updateWrapper);
    }

    @Override
    public QueryWrapper<UserInterfaceInfo> getQueryWrapper(UserInterfaceInfoQueryRequest userInterfaceInfoQueryRequest) {
        QueryWrapper<UserInterfaceInfo> queryWrapper = new QueryWrapper<>();
        if (userInterfaceInfoQueryRequest == null) {
            return queryWrapper;
        }
        return queryWrapper;
    }

    @Override
    public UserInterfaceInfoVO getUserInterfaceInfoVO(UserInterfaceInfo userInterfaceInfo, HttpServletRequest request) {
        UserInterfaceInfoVO userInterfaceInfoVo = UserInterfaceInfoVO.objToVo(userInterfaceInfo);
        return userInterfaceInfoVo;
    }

    @Override
    public Page<UserInterfaceInfoVO> getUserInterfaceInfoVOPage(Page<UserInterfaceInfo> userInterfaceInfoPage, HttpServletRequest request) {
        List<UserInterfaceInfo> userInterfaceInfos = userInterfaceInfoPage.getRecords();
        Page<UserInterfaceInfoVO> userInterfaceInfoVOPage =
                new Page<>(userInterfaceInfoPage.getCurrent(),
                        userInterfaceInfoPage.getSize(), userInterfaceInfoPage.getTotal());
        if (CollectionUtils.isEmpty(userInterfaceInfos)) {
            return userInterfaceInfoVOPage;
        }
        // 填充信息
        List<UserInterfaceInfoVO> userInterfaceInfoVOList = userInterfaceInfos.stream().map(userInterfaceInfo -> {
            UserInterfaceInfoVO userInterfaceInfoVO = UserInterfaceInfoVO.objToVo(userInterfaceInfo);
            return userInterfaceInfoVO;
        }).collect(Collectors.toList());
        userInterfaceInfoVOPage.setRecords(userInterfaceInfoVOList);
        return userInterfaceInfoVOPage;
    }

    @Override
    public List<UserInterfaceInfo> getListTopInvokeInterfaceInfo(int limit) {
        return userInterfaceInfoMapper.getListTopInvokeInterfaceInfo(limit);
    }
}




