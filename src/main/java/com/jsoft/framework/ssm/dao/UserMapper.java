package com.jsoft.framework.ssm.dao;

import java.util.List;

import com.jsoft.framework.ssm.model.sys.user.UserDO;

/**
 * User DAO
 *
 * @author jim
 * @date 2018/04/26
 */
public interface UserMapper {

    //============基于XML配置===========
    
    /**
     * 获取一个用户
     * 
     * @param Id 主键ID
     * @return UserDO
     */
    UserDO getUser(Long Id);

    /**
     * 获取用户列表
     * 
     * @return List#UserDO
     */
    List<UserDO> listUser();

    /**
     * 删除一个用户
     * 
     * @param Id 主键ID
     * @return 删除是否成功
     */
    Boolean removeUser(Long Id);

    /**
     * 更新一个用户
     * 
     * @param userDO 用户数据实体
     * @return 更新是否成功
     */
    Boolean updateUser(UserDO userDO);

    /**
     * 保存一个用户
     * 
     * @param userDO 用户数据实体
     * @return 保存是否成功，自增ID放在实体上
     */
    Boolean saveUser(UserDO userDO);
    
    //==========基于注解==========
    
    
}
