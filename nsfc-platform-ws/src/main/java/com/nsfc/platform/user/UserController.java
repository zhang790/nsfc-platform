package com.nsfc.platform.user;

import com.nsfc.platform.user.service.UserService;
import com.nsfc.platform.userinfo.model.UserInfo;
import com.zhang.util.bean.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 用户操作信息
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/4/17
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SelfProperties selfProperties;

    /**
     * 登录方法
     * @param username 用户名称
     * @param pwd   用户密码
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public String login(String username, String pwd, ModelMap modelMap){

        ReturnData returnData = userService.login(username,pwd);
        modelMap.clear();
        modelMap.putAll(returnData.getReturnMap());

        return returnData.toString();
    }

    /**
     * 注册方法
     * @param vo  登录信息
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public String register(UserInfo vo, ModelMap modelMap){

        ReturnData returnData = userService.register(vo);
        modelMap.clear();
        modelMap.putAll(returnData.getReturnMap());

        return returnData.toString();
    }

    /**
     * 获取用户信息列表
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.POST)
    @ResponseBody
    public String userInfoList(ModelMap modelMap){

        ReturnData returnData = userService.getUserList();
        return returnData.toString();
    }

    /**
     * 获取user的登录信息
     * @param modelMap
     * @return
     */
    public String getUserLoginInfo(ModelMap modelMap){

        return null;
    }

    /**
     * 测试获取属性
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "properties", method = RequestMethod.POST)
    public String getProperties(String name,ModelMap modelMap){
        return name + "" + selfProperties.toString();
    }

    /**
     * 删除一个用户
     * @param params
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "deleteUser", method = RequestMethod.POST)
    public String deleteUserInfo(String params, ModelMap modelMap){
        return null;
    }

    @RequestMapping(value = "/userById/{id}")
    public String getUserById(@PathVariable("id") String id, ModelMap modelMap){
        return null;
    }

    /**
     * 测试事务
     * @return
     */
    @RequestMapping(value = "/testTransactions")
    public String testTransaction(){
        userService.testTransaction();
        return null;
    }
}
