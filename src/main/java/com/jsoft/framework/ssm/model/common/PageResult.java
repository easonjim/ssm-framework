package com.jsoft.framework.ssm.model.common;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Page Result
 *
 * @param <T>
 * @author jim
 * @date 2018/06/03
 */
@Getter
@Setter
@ToString
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 768549219446295665L;
    //成功与否
    private boolean success;
    //信息
    private String msg;
    //状态
    private Integer status;
    //总条数
    private Integer total;
    //当前页显示数据
    private List<T> records;
}
