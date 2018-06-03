package com.jsoft.framework.ssm.service.impl.sys.user;

import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.jsoft.framework.ssm.dao.sys.user.UserMapper;
import com.jsoft.framework.ssm.model.sys.user.UserDO;
import com.jsoft.framework.ssm.model.sys.user2.User;
import com.jsoft.framework.ssm.model.sys.user2.UserExample;
import com.jsoft.framework.ssm.service.sys.user.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService
 *
 * @author jim
 * @date 2018/04/27
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Resource(name = "userMapper2")
    private com.jsoft.framework.ssm.dao.sys.user2.UserMapper userMapper2;

    /**
     * 获取一个用户
     *
     * @param id 主键ID
     * @return UserDO
     */
    @Override
    public UserDO getUser(Long id) {
        log.info("调用Service方法：{},id:{}", "UserServiceImpl#getUser", id);
        return userMapper.getUser(id);
    }

    /**
     * 获取用户列表
     *
     * @return List#UserDO
     */
    @Override
    public List<UserDO> listUser() {
        log.info("调用Service方法：{}", "UserServiceImpl#listUser");
        return userMapper.listUser();
    }

    /**
     * 删除一个用户
     *
     * @param id 主键ID
     * @return 删除是否成功
     */
    @Override
    public Boolean removeUser(Long id) {
        log.info("调用Service方法：{},id:{}", "UserServiceImpl#removeUser", id);
        return userMapper.removeUser(id);
    }

    /**
     * 更新一个用户
     *
     * @param userDO 用户数据实体
     * @return 更新是否成功
     */
    @Override
    public Boolean updateUser(UserDO userDO) {
        log.info("调用Service方法：{},userDO:{}", "UserServiceImpl#updateUser", userDO);
        return userMapper.updateUser(userDO);
    }

    /**
     * 保存一个用户
     *
     * @param userDO 用户数据实体
     * @return 保存是否成功，自增ID放在实体上
     */
    @Override
    public Boolean saveUser(UserDO userDO) {
        log.info("调用Service方法：{},userDO", "UserServiceImpl#saveUser", userDO);
        return userMapper.saveUser(userDO);
    }

    /**
     * 分页查询，使用PageHelper进行分页，count信息放在PageInfo中
     *
     * @param userName 用户名
     * @param pageNum  第几条，从1开始
     * @param pageSize 一次返回多少条
     * @param orderBy  排序字段，动态输入
     * @return List#UserDO
     */
    @Override
    public List<UserDO> listUserByPage(String userName, int pageNum, int pageSize, String orderBy) {
        log.info("调用Service方法：{},userName:{},pageNum:{},pageSize:{},orderBy:{}", "UserServiceImpl#listUserByPage", userName, pageNum, pageSize, orderBy);
        return userMapper.listUserByPage(userName, pageNum, pageSize, orderBy);
    }

    /**
     * 分页查询，纯手写SQL，不支持排序字段动态输入，count查询需要重新写
     *
     * @param userName 用户名
     * @param pageNum  第几条，从0开始
     * @param pageSize 一次返回多少条
     * @return List#UserDO
     */
    @Override
    public List<UserDO> listUserByPage2(String userName, int pageNum, int pageSize) {
        log.info("调用Service方法：{},userName:{},pageNum:{},pageSize:{}", "UserServiceImpl#listUserByPage2", userName, pageNum, pageSize);
        return userMapper.listUserByPage2(userName, pageNum, pageSize);
    }

    /**
     * 根据条件返回总条数
     *
     * @param userName 用户名
     * @return Integer#count
     */
    @Override
    public Integer countUserByPage2(String userName) {
        log.info("调用Service方法：{},userName:{}", "UserServiceImpl#countUserByPage2", userName);
        return userMapper.countUserByPage2(userName);
    }

    /**
     * 分页查询，使用PageHelper进行分页，count信息放在PageInfo中
     *
     * @param userName 用户名
     * @param pageNum  第几条，从1开始
     * @param pageSize 一次返回多少条
     * @param orderBy  排序字段，动态输入
     * @return List#UserDO
     */
    @Override
    public List<UserDO> listUserByPage3(String userName, int pageNum, int pageSize, String orderBy) {
        log.info("调用Service方法：{},userName:{}", "UserServiceImpl#listUserByPage3", userName);
        PageHelper.startPage(pageNum, pageSize, orderBy);
        return userMapper.listUserByPage3(userName);
    }

    /**
     * 基于注解方式实现获取一个用户
     *
     * @param id 主键ID
     * @return UserDO
     */
    @Override
    public User getUser2(Long id) {
        log.info("调用Service方法：{},id:{}", "UserServiceImpl#getUser2", id);
        return userMapper2.selectByPrimaryKey(id);
    }

    // 以下方法服务于列表，采用注解的方式实现，Mapper采用MyBatis自动生成
    @Override
    public int insertUser(User user) {
        return userMapper2.insertSelective(user);
    }
    @Override
    public int deleteByExample(UserExample example) {
        return userMapper2.deleteByExample(example);
    }
    @Override
    public int updateByPrimaryKeySelective(User user) {
        return userMapper2.updateByPrimaryKeySelective(user);
    }
    @Override
    public List<User> getAllUserByExample(UserExample example) {
        return userMapper2.selectByExample(example);
    }
}
