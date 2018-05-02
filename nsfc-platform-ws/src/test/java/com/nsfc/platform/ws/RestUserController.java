package com.nsfc.platform.ws;

import org.junit.Test;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * 测试restful的User接口
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/2
 */
public class RestUserController extends PlatformWsApplicationTests {


    @Test
    public void testRestUser() throws  Exception{

        MockMvcRequestBuilders builders = null;

        //查询用户信息列表
        mockMvc.perform(builders.get("/users/"))
                .andExpect(MockMvcResultMatchers.status().isOk())  //查询是否响应
                .andExpect(MockMvcResultMatchers.content().string("success")); //是否返回相应的内容

        //创建用户
        mockMvc.perform(MockMvcRequestBuilders.post("/users/")
                .param("id", "12")
                .param("username", "测试名字")
                .param("password", "123")
                .param("ages", "18"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("success"));

        //查询指定用户  id 为1
        mockMvc.perform(MockMvcRequestBuilders.get("users/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());




    }
}
