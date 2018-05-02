package com.nsfc.platform.ws;

import com.nsfc.platform.base.PlatformWsApplication;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class) //使用SpringRunner进行测试，它继承自SpringJUnit4ClassRunner
@SpringBootTest(classes = PlatformWsApplication.class)  //关于SpringApplicationConfiguration在1.4版本之后已经被替换掉了  所以找不到
@AutoConfigureMockMvc  //注入一个MockMvc实例
@WebAppConfiguration
public class PlatformWsApplicationTests {

    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() throws Exception{
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();   //注入ApplicationContext容器
    }

}
