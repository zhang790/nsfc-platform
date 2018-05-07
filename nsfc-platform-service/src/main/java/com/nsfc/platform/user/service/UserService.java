package com.nsfc.platform.user.service;
import com.nsfc.platform.userinfo.model.UserInfo;
import com.zhang.util.bean.ReturnData;

public interface UserService {
/**
 * 无法引入本地打的包  怀疑是路径问题
 */

   /**
    * 登录
    * @param username
    * @param pwd
    * @return
    */
   ReturnData login(String username, String pwd);

   /**
    * 注册
    * @param vo
    * @return
    */
   ReturnData register(UserInfo vo);

   /**
    * 获取用户信息列表
    * @return
    */
   ReturnData getUserList();

   /**
    * 测试事务
    */
   void testTransaction();

}
