package com.nsfc.platform.user;

import com.nsfc.platform.userinfo.model.UserInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 *
 * 添加swagger2文档  使用@apiIngore进行忽略
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
    @ApiOperation(value = "获取用户列表" )
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public List<UserInfo>  getUserList(){
        return new ArrayList<>(users.values());
    }

    /**
     * GET请求创建用户
     * @param userInfo
     * @return
     */
    @ApiOperation(value = "创建用户" ,notes = "根据返回的User创建新用户")
    @ApiImplicitParam(name = "userInfo", value = "用户信息实体", required = true, dataType = "User")
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
    @ApiOperation(value = "获取指定用户信息", notes = "根据id获取指定用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Integer")
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
    @ApiOperation(value = "根据id更新指定用户信息", notes = "根据id更新指定用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "userInfo", value = "更新内容", required = true, dataType = "UserInfo")
    })
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

    @ApiOperation(value = "删除指定id的用户", notes = "删除指定id的用户")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Integer")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUserById(@PathVariable("id") Integer id){
        users.remove(id);
        return "success";
    }

}
