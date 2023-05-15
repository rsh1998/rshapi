package com.rsh.rshapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rsh.rshapi.common.ErrorCode;
import com.rsh.rshapi.exception.BusinessException;
import com.rsh.rshapi.exception.ThrowUtils;
import com.rsh.rshapi.mapper.InterfaceInfoMapper;
import com.rsh.rshapi.model.dto.interfaceinfo.InterfaceInfoQueryRequest;
import com.rsh.rshapi.model.entity.InterfaceInfo;
import com.rsh.rshapi.model.vo.InterfaceInfoVO;
import com.rsh.rshapi.service.InterfaceInfoService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String name = interfaceInfo.getName();

        // 创建时，参数不能为空
        if (add) {
            ThrowUtils.throwIf(StringUtils.isAnyBlank(name), ErrorCode.PARAMS_ERROR);
        }
        // 有参数则校验
        if (StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }
    }

    @Override
    public QueryWrapper<InterfaceInfo> getQueryWrapper(InterfaceInfoQueryRequest interfaceInfoQueryRequest) {
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        if (interfaceInfoQueryRequest == null) {
            return queryWrapper;
        }
        return queryWrapper;
    }

    @Override
    public InterfaceInfoVO getInterfaceInfoVO(InterfaceInfo interfaceInfo, HttpServletRequest request) {
        InterfaceInfoVO interfaceInfoVO = InterfaceInfoVO.objToVo(interfaceInfo);
        return interfaceInfoVO;
    }

    @Override
    public Page<InterfaceInfoVO> getInterfaceInfoVOPage(Page<InterfaceInfo> interfaceInfoPage, HttpServletRequest request) {
        List<InterfaceInfo> infos = interfaceInfoPage.getRecords();
        Page<InterfaceInfoVO> infoVOPage = new Page<>(interfaceInfoPage.getCurrent(), interfaceInfoPage.getSize(), interfaceInfoPage.getTotal());
        if (CollectionUtils.isEmpty(infos)) {
            return infoVOPage;
        }
        // 填充信息
        List<InterfaceInfoVO> infoVOList = infos.stream().map(info -> {
            InterfaceInfoVO interfaceInfoVO = InterfaceInfoVO.objToVo(info);
            return interfaceInfoVO;
        }).collect(Collectors.toList());
        infoVOPage.setRecords(infoVOList);
        return infoVOPage;
    }
}




