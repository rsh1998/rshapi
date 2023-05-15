package com.rsh.rshapi.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 更新请求
 *
 *
 *
 */
@Data
public class InterfaceInfoUpdateRequest implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 接口名
     */
    private String name;

    /**
     * 接口地址
     */
    private String url;

    /**
     * 请求类型
     */
    private String method;

    /**
     * 接口描述
     */
    private String description;
    /**
     * 请求参数
     */
    private String requestParams;
    /**
     * 请求头
     */
    private String requestHeader;

    /**
     * 响应头
     */
    private String responseHeader;

    /**
     * 创建人
     */
    private Long userId;

    /**
     * 接口状态（0-关闭，1-开启）
     */
    private Integer status;

}