package com.rsh.rshapi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rsh.rshapi.annotation.AuthCheck;
import com.rsh.rshapi.common.BaseResponse;
import com.rsh.rshapi.common.ErrorCode;
import com.rsh.rshapi.common.ResultUtils;
import com.rsh.rshapi.exception.ThrowUtils;
import com.rsh.rshapi.model.entity.InterfaceInfo;
import com.rsh.rshapi.model.entity.UserInterfaceInfo;
import com.rsh.rshapi.model.vo.InterfaceInfoAnalysisVO;
import com.rsh.rshapi.service.InterfaceInfoService;
import com.rsh.rshapi.service.UserInterfaceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author rsh
 * @date 2023/3/15 0:30
 */
@RestController
@RequestMapping("/analysis")
@Slf4j
public class AnalysisController {

    @Resource
    UserInterfaceInfoService userInterfaceInfoService;
    @Resource
    InterfaceInfoService interfaceInfoService;
    @AuthCheck(mustRole = "admin")
    @GetMapping("/top/interface/invoke")
    public BaseResponse<List<InterfaceInfoAnalysisVO>> listTopInvokeInterfaceInfo(){
        List<UserInterfaceInfo> userUserInterfaceInfoList =
                userInterfaceInfoService.getListTopInvokeInterfaceInfo(3);
        Map<Long, List<UserInterfaceInfo>> interfaceInfoObjMap = userUserInterfaceInfoList.stream()
                .collect(Collectors.groupingBy(UserInterfaceInfo::getInterfaceInfoId));
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.in("id",interfaceInfoObjMap.keySet());
        List<InterfaceInfo> list = interfaceInfoService.list(queryWrapper);
        ThrowUtils.throwIf(CollectionUtils.isEmpty(list), ErrorCode.SYSTEM_ERROR);
        List<InterfaceInfoAnalysisVO> interfaceInfoAnalysisVOList = list.stream().
                map(interfaceInfo -> {
                    InterfaceInfoAnalysisVO interfaceInfoAnalysisVO
                            = new InterfaceInfoAnalysisVO();
                    BeanUtils.copyProperties(interfaceInfo, interfaceInfoAnalysisVO);
                    int totalNum = interfaceInfoObjMap.get(interfaceInfo.getId()).get(0).getTotalNum();
                    interfaceInfoAnalysisVO.setTotalNum(totalNum);
                    return interfaceInfoAnalysisVO;
                }).collect(Collectors.toList());
        return ResultUtils.success(interfaceInfoAnalysisVOList);
    }
}
