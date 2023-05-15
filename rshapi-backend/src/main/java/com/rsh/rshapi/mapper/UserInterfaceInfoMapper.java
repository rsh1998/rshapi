package com.rsh.rshapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rsh.rshapi.model.entity.UserInterfaceInfo;

import java.util.List;


/**
 * @Entity generator.com.rsh.rshapi.UserInterfaceInfo
 */
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {
    //select interfaceInfoId,sum(totalNum) as totalNum
    //from user_interface_info
    //group by interfaceInfoId
    //order by totalNum desc
    //limit 3
    List<UserInterfaceInfo> getListTopInvokeInterfaceInfo(int limit);
}




