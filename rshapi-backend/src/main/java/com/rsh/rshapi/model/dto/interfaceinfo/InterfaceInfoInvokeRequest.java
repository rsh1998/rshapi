package com.rsh.rshapi.model.dto.interfaceinfo;

import lombok.Data;

/**
 * @author rsh
 * @date 2023/3/10 23:27
 */
@Data
public class InterfaceInfoInvokeRequest {
    /**
     * 主键
     */
    private Long id;

    /**
     * 请求参数
     */
    private String userRequestParams;

}
