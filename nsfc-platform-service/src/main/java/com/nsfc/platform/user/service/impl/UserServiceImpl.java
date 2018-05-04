package com.nsfc.platform.user.service.impl;

import com.nsfc.common.util.ReturnData;
import com.nsfc.platform.user.service.UserService;
import com.nsfc.platform.userinfo.mapper.UserInfoMapper;
import com.nsfc.platform.userinfo.model.UserInfo;
import com.nsfc.platform.userinfo.model.UserInfoExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl  implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Resource
    private RedisTemplate redisTemplate;

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


    @Override
    public ReturnData getUserList() {

        ReturnData returnData = new ReturnData();


        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andIdIsNotNull();
        List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);

        for (UserInfo userInfo: userInfos){

            if (redisTemplate.hasKey(userInfo.getId().toString())){
                //存在值  调用redis
                logger.info("查询redis");
                UserInfo userInfo1 = (UserInfo) redisTemplate.opsForValue().get(userInfo.getId().toString());

            }else {
                //不存在值
                logger.info("存储redis");
                redisTemplate.opsForValue().set(userInfo.getId().toString(), userInfo.toString());
            }
        }

        logger.info("未调用redis");

        returnData.setData(userInfos);
        returnData.setRetCode(1);
        return returnData;
    }

    @Transactional
    @Override
    public void testTransaction() {

        List<UserInfo> userInfos = new ArrayList<>();

        for (int i=1; i<=4; i++){
            UserInfo userInfo = new UserInfo();
            userInfo.setId(i);
            userInfo.setAges(18 + i);
            userInfo.setUsername("zhang790" + i);
            userInfo.setPassword("xxxxxxxx");
            userInfo.setMobilephone("1232112412");
            userInfo.setGender(true);
            userInfo.setEmail("dsadada@dsada.com");
            userInfos.add(userInfo);
        }

        for (UserInfo info : userInfos){
//            if (info.getId().equals(3)){
//                int k = 1/0;
//            }
            userInfoMapper.updateByPrimaryKey(info);
        }
    }

}