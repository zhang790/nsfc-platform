package com.nsfc.platform.user.service.impl;

import com.nsfc.common.util.ReturnData;
import com.nsfc.platform.user.service.UserService;
import com.nsfc.platform.userinfo.mapper.UserInfoMapper;
import com.nsfc.platform.userinfo.model.UserInfo;
import com.nsfc.platform.userinfo.model.UserInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * Spring Boot的缓存 V是test sync 保持lock condition 选择条件缓存
     *
     * 也支持自定义的注解 包括自定义的redisManager
     */
    @Cacheable(value = "test", sync = true, condition = "#name.length() < 32")
    public  void testRedis(){

    }

    public ReturnData login(String username, String pwd) {

        ReturnData returnData = new ReturnData();
        returnData.setRetCode(0);

        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(pwd);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);

        if (userInfos.size() > 0){
            returnData.setRetCode(1);
        }

        return returnData;
    }

    public ReturnData register(UserInfo userInfo) {

        ReturnData returnData = new ReturnData();
        returnData.setRetCode(0);

        userInfoMapper.insert(userInfo);

        returnData.setRetCode(1);
        return returnData;
    }
}