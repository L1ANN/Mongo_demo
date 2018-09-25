package com.mongo.test.service;

import com.mongo.test.entity.UserInfo;
import com.mongo.test.util.PageModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.List;


/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 下午1:34 2018/9/25
 * @Modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/spring-mgo.xml")

public class UserServiceTest {
    @Autowired
    private UserService service;

    @Test
    public void save() {
        UserInfo user = new UserInfo();
        user.setName("张三");
        user.setAge(25);
        user.setBirth(Timestamp.valueOf("2017-4-12 16:52:00"));
        service.save(user);
        System.out.println("已生成ID:" + user.getId());

    }

    @Test
    public void find() {
        UserInfo user = service.find("5ba9e91c77c8b1aaaf001ddd");
        System.out.println(user.getName());
    }

    @Test
    public void update() {
        UserInfo user = service.find("5ba9e91c77c8b1aaaf001ddd");
        user.setAge(18);
        service.update(user);
        System.out.println(user.getAge());
    }

    @Test
    public void delete() {
        service.delete("58edef886f03c7b0fdba51b9");
    }

    @Test
    public void findAll() {
        List<UserInfo> list = service.findAll("age desc");
        for (UserInfo u : list) {
            System.out.println(u.getName());
        }
    }

    @Test
    public void findByProp() {
        List<UserInfo> list = service.findByProp("name", "张三");
        for (UserInfo u : list) {
            System.out.println(u.getName());
        }
    }

    @Test
    public void findByProps() {
        List<UserInfo> list = service.findByProps(new String[] { "name", "age" }, new Object[] { "张三", 18 });
        for (UserInfo u : list) {
            System.out.println(u.getName());
        }
    }

    @Test
    public void pageAll() {
        PageModel<UserInfo> page = service.pageAll(1, 10);
        System.out.println("总记录：" + page.getTotalCount() + "，总页数：" + page.getTotalPage());
        for (UserInfo u : page.getList()) {
            System.out.println(u.getName());
        }
    }

    @Test
    public void pageByProp() {
        PageModel<UserInfo> page = service.pageByProp(1, 10, "name", "张三");
        System.out.println("总记录：" + page.getTotalCount() + "，总页数：" + page.getTotalPage());
        for (UserInfo u : page.getList()) {
            System.out.println(u.getName());
        }
    }

}