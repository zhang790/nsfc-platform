package com.nsfc.platform.user;

import com.nsfc.common.util.ReturnData;
import com.nsfc.platform.user.service.UserService;
import com.nsfc.platform.userinfo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户操作信息
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/4/17
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录方法
     * @param username 用户名称
     * @param pwd   用户密码
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String username, String pwd, ModelMap modelMap){

        ReturnData returnData = userService.login(username,pwd);
        modelMap.clear();
        modelMap.putAll(returnData.getReturnMap());

        return null;
    }

    /**
     * 注册方法
     * @param vo  登录信息
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(UserInfo vo, ModelMap modelMap){

        ReturnData returnData = userService.register(vo);
        modelMap.clear();
        modelMap.putAll(returnData.getReturnMap());

        return null;
    }

}
