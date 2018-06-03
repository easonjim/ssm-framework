package com.jsoft.framework.ssm;

import java.util.List;

import com.jsoft.framework.ssm.dao.sys.user.UserMapper;
import com.jsoft.framework.ssm.model.sys.user.UserDO;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * DAO测试
 *
 * @author jim
 * @date 2018/06/03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-base.xml"})
public class DaoTest {

    private static final Logger logger = LoggerFactory.getLogger(DaoTest.class);

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        List<UserDO> listUser = userMapper.listUser();
        logger.info("{}", listUser);
        Assert.assertTrue(listUser.size() > 0);
    }

}
