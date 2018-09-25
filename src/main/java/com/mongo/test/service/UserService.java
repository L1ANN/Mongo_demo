package com.mongo.test.service;

import com.mongo.test.dao.IBaseDao;
import com.mongo.test.dao.IUserDao;
import com.mongo.test.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 下午1:27 2018/9/25
 * @Modified By:
 */
@Service
public class UserService extends BaseService<UserInfo> {
    @Autowired
    private IUserDao userDao;

    @Override
    protected IBaseDao<UserInfo> getDao(){
        return userDao;
    }


}
