package com.rsh.rshapi.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rsh.rshapi.model.dto.userinterfaceinfo.UserInterfaceInfoQueryRequest;
import com.rsh.rshapi.model.entity.UserInterfaceInfo;
import com.rsh.rshapi.model.vo.UserInterfaceInfoVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 *
 */
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {
    /**
     * 校验
     *
     * @param userInterfaceInfo
     * @param add
     */
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);
    /**
     * 重新计算剩余调用次数
     *
     * @param interfaceInfoId
     * @param userId
     *
     */
    boolean invokeCount(long interfaceInfoId,long userId);
    /**
     * 获取查询条件
     *
     * @param userInterfaceInfoQueryRequest
     * @return
     */
    QueryWrapper<UserInterfaceInfo> getQueryWrapper(UserInterfaceInfoQueryRequest userInterfaceInfoQueryRequest);
    /**
     * 获取api封装
     *
     * @param userInterfaceInfo
     * @param request
     * @return
     */
    UserInterfaceInfoVO getUserInterfaceInfoVO(UserInterfaceInfo userInterfaceInfo, HttpServletRequest request);
    /**
     * 分页获取api封装
     *
     * @param userInterfaceInfoPage
     * @param request
     * @return
     */
    Page<UserInterfaceInfoVO> getUserInterfaceInfoVOPage(Page<UserInterfaceInfo> userInterfaceInfoPage, HttpServletRequest request);

    /**
     *
     * @param limit 数量
     * @return
     */
    List<UserInterfaceInfo> getListTopInvokeInterfaceInfo(int limit);
}
