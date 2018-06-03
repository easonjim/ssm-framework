package com.jsoft.framework.ssm.model.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Base Result
 * 
 * @author jim 
 * @date 2018/06/03
 */
@Getter
@Setter
@ToString
public class BaseResult {
    private boolean success;
    private Object data;
    private String msg;
}
