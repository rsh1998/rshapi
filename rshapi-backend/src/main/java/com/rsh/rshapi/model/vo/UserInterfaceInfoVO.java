package com.rsh.rshapi.model.vo;

import com.google.gson.Gson;
import com.rsh.rshapi.model.entity.UserInterfaceInfo;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户接口关系
 *
 */
@Data
public class UserInterfaceInfoVO implements Serializable {
    private final static Gson GSON = new Gson();
    /**
     * 主键
     */
    private Long id;

    /**
     * 调用人id
     */
    private Long userId;

    /**
     * 接口id
     */
    private Long interfaceInfoId;

    /**
     * 总调用次数
     */
    private Integer totalNum;

    /**
     * 剩余调用次数
     */
    private Integer leftNum;

    /**
     * 状态（0-正常，1-禁用）
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除(0-未删, 1-已删)
     */
    private Integer isDeleted;
    /**
     * 包装类转对象
     *
     * @param userInterfaceInfoVo
     * @return
     */
    public static UserInterfaceInfo voToObj(UserInterfaceInfoVO userInterfaceInfoVo) {
        if (userInterfaceInfoVo == null) {
            return null;
        }
        UserInterfaceInfo userInterfaceInfo = new UserInterfaceInfo();
        BeanUtils.copyProperties(userInterfaceInfoVo, userInterfaceInfo);
        return userInterfaceInfo;
    }

    /**
     * 对象转包装类
     *
     * @param userInterfaceInfo
     * @return
     */
    public static UserInterfaceInfoVO objToVo(UserInterfaceInfo userInterfaceInfo) {
        if (userInterfaceInfo == null) {
            return null;
        }
        UserInterfaceInfoVO userInterfaceInfoVo = new UserInterfaceInfoVO();
        BeanUtils.copyProperties(userInterfaceInfo, userInterfaceInfoVo);
        return userInterfaceInfoVo;
    }

    private static final long serialVersionUID = 1L;
}