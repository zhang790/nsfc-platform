package com.nsfc.platform.user;

import com.nsfc.platform.userinfo.model.UserInfo;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 *
 * rest风格的接口设计与实现
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/2
 */
@RestController
@RequestMapping("/users")
public class RestUserController {

    static Map<Integer, UserInfo> users = Collections.synchronizedMap(new HashMap<>());

    /**
     * POST请求获取所有的用户
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public List<UserInfo>  getUserList(){
        return new ArrayList<>(users.values());
    }

    /**
     * GET请求创建用户
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String createUser(@ModelAttribute UserInfo userInfo){
        users.put(userInfo.getId(), userInfo);
        return "success";
    }

    /**
     * 获取指定id的用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserInfo getUser(@PathVariable("id") Integer id){
        return users.get(id);
    }

    /**
     * 更新指定id的用户
     * @param id
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateUserById(@PathVariable("id") Integer id, @ModelAttribute UserInfo userInfo){

        UserInfo setUser = users.get(id);
        setUser.setAges(userInfo.getAges());
        setUser.setEmail(userInfo.getEmail());
        setUser.setGender(userInfo.getGender());
        setUser.setMobilephone(userInfo.getMobilephone());
        setUser.setPassword(userInfo.getPassword());
        setUser.setUsername(userInfo.getUsername());

        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUserById(@PathVariable("id") Integer id){

        users.remove(id);
        return "success";
    }

}
