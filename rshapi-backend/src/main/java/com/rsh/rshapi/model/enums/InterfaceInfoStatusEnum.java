package com.rsh.rshapi.model.enums;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * 接口信息状态枚举
 * @author rsh
 * @date 2023/3/10 19:16
 */
public enum InterfaceInfoStatusEnum {
    ONLINE("上线", 1),
    OFFLINE("关闭", 0);

    private final String status;

    private final int value;

    InterfaceInfoStatusEnum(String status, int value) {
        this.status = status;
        this.value = value;
    }

    /**
     * 获取值列表
     *
     * @return
     */
    public static List<Integer> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    /**
     * 根据 value 获取枚举
     *
     * @param value
     * @return
     */
    public static InterfaceInfoStatusEnum getEnumByValue(int value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (InterfaceInfoStatusEnum infoStatusEnum : InterfaceInfoStatusEnum.values()) {
            if (infoStatusEnum.value==(value)) {
                return infoStatusEnum;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    public String getStatus() {
        return status;
    }
}
