package com.rsh.rshapi.model.vo;

import com.google.gson.Gson;
import com.rsh.rshapi.model.entity.InterfaceInfo;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @author rsh
 * @date 2023/3/9 1:12
 */
@Data
public class InterfaceInfoAnalysisVO extends InterfaceInfoVO implements Serializable {
    private final static Gson GSON = new Gson();
    /**
     * 接口调用次数
     */
    private Integer totalNum;
    /**
     * 包装类转对象
     *
     * @param interfaceInfoAnalysisVO
     * @return
     */
    public static InterfaceInfo voToObj(InterfaceInfoAnalysisVO interfaceInfoAnalysisVO) {
        if (interfaceInfoAnalysisVO == null) {
            return null;
        }
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        BeanUtils.copyProperties(interfaceInfoAnalysisVO, interfaceInfo);
        return interfaceInfo;
    }

    /**
     * 对象转包装类
     *
     * @param interfaceInfo
     * @return
     */
    public static InterfaceInfoAnalysisVO objToVo(InterfaceInfo interfaceInfo) {
        if (interfaceInfo == null) {
            return null;
        }
        InterfaceInfoAnalysisVO interfaceInfoAnalysisVO = new InterfaceInfoAnalysisVO();
        BeanUtils.copyProperties(interfaceInfo, interfaceInfoAnalysisVO);
        return interfaceInfoAnalysisVO;
    }
    private static final long serialVersionUID = 1L;
}
