# nsfc-platform
test use spring boot project

登录接口没有  进行测试

接下来
<<<<<<< HEAD
（1）解决mybatis的扫描位置问题（不使用无xml的形式）  已经解决
（2）解决Springboot的继承问题
（3）
=======
（1）解决mybatis的扫描位置问题（不使用无xml的形式） 完成
（2）解决Springboot的继承问题    暂时没有解决  优先级低
（3）json格式化处理和拦截  查看所有用户的接口
（4）Spring Boot 的热部署（优先级低）  redis的实践
（5）多环境配置
（6）扫描性事务配置  事务的问题
（7）多数据源配置（优先级低）
（8）前后端分离的实践  用户管理系统
（9）配置启动页面
（10）添加shrio

服务器端  搭建部署环境
（5）nginx 配置策略
（6）jenkins + docker + git + alians配置

log4J日志代码

idea的默认maven的编译java版本是1.5  需要处理一下

尝试了一下单元测试，网上的很多版本太老了（或者是因为我的版本太新了）

20180503
添加Swagger2Api工具  地址http://localhost:8080/swagger-ui.html#/user-controller

添加redis配置
redis配置使用的是最简单的方式而不是2.0.0之后的方式

============================================================================
出现一些问题
连接远程redis出现一些timeout  本地redis是可以的
redis如果没有配置的话，默认是存储到本地的是Unicode（貌似是redisTemplate的默认编码，这个看着不好看，但是可以处理）