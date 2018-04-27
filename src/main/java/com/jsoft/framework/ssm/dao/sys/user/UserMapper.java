package com.jsoft.framework.ssm.dao.sys.user;

import java.util.List;

import com.jsoft.framework.ssm.model.sys.user.UserDO;

import org.apache.ibatis.annotations.Param;

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
     * @param id 主键ID
     * @return UserDO
     */
    UserDO getUser(Long id);

    /**
     * 获取用户列表
     * 
     * @return List#UserDO
     */
    List<UserDO> listUser();

    /**
     * 删除一个用户
     * 
     * @param id 主键ID
     * @return 删除是否成功
     */
    Boolean removeUser(Long id);

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

    /**
     * 分页查询，使用PageHelper进行分页，count信息放在PageInfo中
     * 
     * @param userName 用户名
     * @param pageNum 第几条，从1开始
     * @param pageSize 一次返回多少条
     * @param orderBy 排序字段，动态输入
     * @return List#UserDO
     */
    List<UserDO> listUserByPage(@Param("userName") String userName, @Param("start") int pageNum, @Param("limit") int pageSize, @Param("order") String orderBy);

    /**
     * 分页查询，纯手写SQL，不支持排序字段动态输入，count查询需要重新写
     *
     * @param userName 用户名
     * @param pageNum 第几条，从0开始
     * @param pageSize 一次返回多少条
     * @return List#UserDO
     */
    List<UserDO> listUserByPage2(@Param("userName") String userName, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    /**
     * 根据条件返回总条数
     * 
     * @param userName 用户名
     * @return Integer#count
     */
    Integer countUserByPage2(@Param("userName") String userName);
    
    //==========基于注解==========
    
    
}
