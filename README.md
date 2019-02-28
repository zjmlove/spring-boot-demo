Spring boot demo

系统开发环境 - 
    操作系统： Windows 7 、 MacOS 、 Linux 
    集成开发工具： Eclipse EE 4.7 或 Intellij Idea
    编译环境：JDK 1.8及以上
    Web服务器：Tomcat 8.0及以上
    
系统框架 - 
    SPRING-BOOT 2 框架，基于spring5 、jdk 8
    数据库 - MySQL（多数据源使用）
    数据连接池 - dbcp2（spring-boot 2 默认支持dbcp2、取消了对dbcp的支持，改变：dbcp2中没有maxActive、maxWait两个变量，转而是maxTotal、maxWaitMillis）
    ORM框架 - MyBatis
    Nosql数据库 - Redis
    NoSql数据库Redis连接池 - lettuce（spring boot 2 之后取消了jedis的数据库连接池，采用了更为高级、使用nio技术实现的letruce）
    缓存管理 - 基于redis的缓存管理（CacheManager）
    日志框架 - Logback
    安全验证框架
    shiro安全框架
    layui前端框架
    单元测试 - junit4 + mockito（spring boot 2 默认支持了junit和mockito框架，但是spring boot 2 支持的是junit5，这里我们强制修改为junti4）
    热部署 - devtools
    
系统关键性技术 - 
    基于角色的权限访问控制RBCA（Role-Based Access Control）
    spring+springmvc+mybatis三大框架
    Ajax技术
    springmvc文件上传
    shiro安全框架
    redis 缓存
    JavaMail邮件
    Springmvc 基于aop切面 的日志管理
    Layui 前端框架
    登录验证码