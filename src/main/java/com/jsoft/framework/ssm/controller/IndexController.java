package com.jsoft.framework.ssm.controller;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.jsoft.framework.ssm.model.sys.user.UserDO;
import com.jsoft.framework.ssm.service.sys.user.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Index Controller
 *
 * @author jim
 * @date 2018/04/25
 */
@Controller
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView index() {
        logger.info("访问index视图");
        ModelAndView index = new ModelAndView("index");
        index.addObject("message", "hello world");
        return index;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String hello(ModelMap modelMap) {
        logger.info("访问hello视图");
        modelMap.addAttribute("message", "hello world");
        return "hello";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String test() {
        try {
            logger.info("测试基于XML配置的数据库");
            UserDO userDO = new UserDO();
            userDO.setCreateTime(new Date());
            userDO.setIsDelete((short) 0);
            userDO.setModifyTime(new Date());
            userDO.setUserEmail("easonjim@163.com");
            userDO.setUserName("jim");
            userDO.setUserPhone("13800138000");
            userDO.setUserPwd("123456");
            userDO.setUserSex((short) 0);
            Boolean saveUser = userService.saveUser(userDO);
            logger.info("新增用户：{}", userDO.getId());
            UserDO user = userService.getUser(userDO.getId());
            logger.info("获取一个用户：{}", user);
            user.setUserPwd("654321");
            Boolean updateUser = userService.updateUser(user);
            UserDO user1 = userService.getUser(userDO.getId());
            logger.info("更新一个用户：{}", user1);
            List<UserDO> listUser = userService.listUser();
            logger.info("批量查询用户：{}", listUser);
            /*for (UserDO tmp : listUser) {
                Boolean deleteUser = userService.removeUser(tmp.getId());
                logger.info("删除一个用户：{}", deleteUser);
            }*/
            List<UserDO> userDOS1 = userService.listUserByPage("%ji%", 0, 10, "create_time desc");
            PageInfo pageInfo = new PageInfo(userDOS1);
            logger.info("分页获取：{}", pageInfo.getPageSize());
            List<UserDO> userDOS = userService.listUserByPage2("%ji%", 0, 10);
            Integer countUserByPage2 = userService.countUserByPage2("%ji%");
            logger.info("分页获取：{}", countUserByPage2);
            
        } catch (Exception ex) {
            logger.info("有异常：", ex);
        }

        return "index";
    }
}
