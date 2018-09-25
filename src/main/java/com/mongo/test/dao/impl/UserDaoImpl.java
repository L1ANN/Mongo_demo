package com.mongo.test.dao.impl;

import com.mongo.test.dao.IUserDao;
import com.mongo.test.entity.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 下午1:13 2018/9/25
 * @Modified By:
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<UserInfo> implements IUserDao {

    @Override
    protected Class<UserInfo> getEntityClass() {
        return UserInfo.class;
    }
}
