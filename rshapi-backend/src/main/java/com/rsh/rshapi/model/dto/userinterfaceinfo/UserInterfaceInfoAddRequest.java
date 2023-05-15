package com.rsh.rshapi.model.dto.userinterfaceinfo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 创建请求
 *
 *
 *
 */
@Data
public class UserInterfaceInfoAddRequest implements Serializable {

    private static final long serialVersionUID = 1L;
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

}