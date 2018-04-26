package com.jsoft.framework.ssm.model.sys.user;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * User 数据对象
 *
 * @author jim
 * @date 2018/04/26
 */
@Getter
@Setter
@ToString
public class UserDO {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户名
     */
    @JsonProperty("name")
    private String userName;

    /**
     * 手机
     */
    @JsonProperty("phone")
    private String userPhone;

    /**
     * 邮箱
     */
    @JsonProperty("email")
    private String userEmail;

    /**
     * 密码
     */
    @JsonProperty("pwd")
    private String userPwd;

    /**
     * 性别
     */
    @JsonProperty("sex")
    private Short userSex;

    /**
     * 创建时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonProperty("ctime")
    protected Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonProperty("mtime")
    private Date modifyTime;

    /**
     * 是否删除
     */
    @JsonProperty("delete")
    private Short isDelete;
}
