
## 一、项目简介

LokHub 包括认证、流程、项目管理、系统、网关等服务。包含了 Redis 缓存、RocketMQ 消息队列、Docker 容器化、Jenkins 自动化部署、Spring Security 安全框架、Nacos 服务注册和发现、sentinel 分布式事务、Spring Boot Actuator 服务监控、SkyWalking 链路追踪、OAuth2 统一认证、OpenFeign 服务调用，Vue3 前端框架等互联网开发中需要用到的主流技术栈，可以帮助同学们快速掌握微服务/分布式项目的核心知识点。

并且同时 LokHub 也是一套企业工作流的开发框架，您可以根据自身需求，快速定制出适合自己公司的企业工作流系统。

目前已经推出两个版本：

- 单体架构版本：直接运行 LokHub-boot 模块下的 LokHub-admin 中的 LokHubApplication 类即可。
- 微服务架构版本：适合有一定基础，想进阶学习微服务/分布式的同学，可以分别启动网关、认证、流程、项目管理、代码生成等多个服务。



## 二、项目详情
### 2.1、技术架构

如下技术架构图以及各个模块之间的交互关系

![LokHub-技术架构图](https://s21.ax1x.com/2024/07/17/pkoSAqU.jpg)



### 2.2 项目演示
![首页展示](https://cdn.tobebetterjavaer.com/stutymore/20240407163006.png)
![项目概览页](https://cdn.tobebetterjavaer.com/stutymore/202404071500496.png)
![任务编辑页](https://cdn.tobebetterjavaer.com/stutymore/20240407163256.png)

### 2.3、代码展示
![LokHub代码展示](https://cdn.tobebetterjavaer.com/stutymore/20240529152747.png)

### 2.4、代码结构

```
com.laigeoffer.LokHub     
├── LokHub-ui              // 前端框架 [1024]
├── LokHub-gateway         // 网关模块 [6880]
├── LokHub-auth            // 认证中心 [6800]
├── LokHub-api             // 接口模块
│       └── LokHub-api-system                          // 系统接口
│       └── LokHub-api-workflow                        // 流程接口
├── LokHub-base          // 通用模块
│       └── LokHub-base-core                           // 核心模块组件
│       └── LokHub-base-datasource                     // 多数据源组件
│       └── LokHub-base-seata                          // 分布式事务组件
│       └── LokHub-base-security                       // 安全模块组件
│       └── LokHub-base-swagger                        // 系统接口组件
│       └── LokHub-base-notice                         // 消息组件组件
├── LokHub-modules         // 业务模块
│       └── LokHub-system                              // 系统模块 [6801]
│       └── LokHub-gen                                 // 代码生成 [6802]
│       └── LokHub-job                                 // 定时任务 [6803]
│       └── LokHub-project                             // 项目服务 [6806]
│       └── LokHub-workflow                            // 流程服务 [6808]
├── LokHub-monitor             						  // 监控中心 [6888]                 
├──pom.xml                                            // 公共依赖
```

## 三、项目部署
### 4.1、环境准备
|    | 技术                  | 名称        | 版本         | 官网                                                                                                 |
|----|---------------------|-----------|------------|----------------------------------------------------------------------------------------------------|
| 1  | Spring Boot         | 基础框架      | 2.7.18     | [https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot)                   |
| 2  | SpringCloud         | 微服务框架     | 2021.0.8   | [https://spring.io/projects/spring-cloud](https://spring.io/projects/spring-cloud)                 |
| 3  | SpringCloud Alibaba | 阿里微服务框架   | 2021.0.5.0 | [https://github.com/alibaba/spring-cloud-alibaba](https://github.com/alibaba/spring-cloud-alibaba) |
| 4  | SpringCloud Gateway | 服务网关      | 3.1.8      | [https://spring.io/projects/spring-cloud-gateway](https://spring.io/projects/spring-cloud-gateway) |
| 5  | MyBatis-Plus        | 持久层框架     | 3.5.1      | [https://baomidou.com](https://baomidou.com)                                                       |
| 6  | Redis               | 分布式缓存数据库  | Latest     | [https://redis.io](https://redis.io)                                                               |
| 7  | RocketMQ            | 消息队列      | 2.2.3      | [https://rocketmq.apache.org](https://rocketmq.apache.org)                                         |
| 8  | HuTool              | 小而全的工具集项目 | 5.8.11     | [https://hutool.cn](https://hutool.cn)                                                             |
| 9  | Maven               | 项目构建管理    | 3.9.1      | [http://maven.apache.org](http://maven.apache.org)                                                 |
| 10 | Sentinel            | 流控防护框架    | 1.8.6      | [https://github.com/alibaba/Sentinel](https://github.com/alibaba/Sentinel)                         |
| 11 | Java                | 开发版本      | 1.8        | [https://www.oracle.com/java/technologies](https://www.oracle.com/java/technologies)               |



### 3.2、后端项目启动

#### 第一步，下载项目源码

①、使用 Git 命令

```
git clone git@github.com:laigeoffer/LokHub.git
```

②、直接下载压缩包

也可以直接下载 GitHub 上的压缩包，然后解压到本地。

- GitHub 地址：[https://github.com/laigeoffer/LokHub](https://github.com/laigeoffer/LokHub)

#### 第二步，使用 Intellij IDEA 导入项目

![](https://cdn.tobebetterjavaer.com/stutymore/20240601234905.png)
#### 第三步，导入数据库

推荐使用 [Navicat](https://javabetter.cn/nice-article/itmind/navicatmacyjpx.html) 这款图形化数据库管理工具。


数据库文件路径在 LokHub/sql/,在Navicat中导入所有数据库文件（每一个微服务对应一个数据库）

![](https://cdn.tobebetterjavaer.com/stutymore/20240629223138.png)

可以直接右键在 terminal 终端中打开，然后通过 pwd 和 ls 命令查看文件的绝对路径。

![](https://cdn.tobebetterjavaer.com/images/20240324/24f0cbafe1fb4995827015c294196eb2.png)



#### 第四步，基础环境准备
* 1、启动 MySQL（必须）

可以选择本机直接安装 MySQL，也可以通过 Docker 的方式，但需要做好磁盘挂载，推荐本机安装！


* 2、启动 Redis（必须）

①、如果你是 macOS 用户，可以直接在终端输入`redis-server`启动 Redis。

![](https://cdn.tobebetterjavaer.com/images/README/1711692102829.png)

②、如果你是 Windows 用户，可以直接双击 redis-server.exe 启动 Redis。

③、当然也可以直接通过 Docker 启动 Redis。
```shell
# 拉取 Redis 镜像:
docker pull redis
# 启动 Redis 容器:
docker run --name my-redis -d redis
```

* 3、启动 Nacos（必须）

[官网](https://nacos.io/download/nacos-server/)下载 Nacos，找到 /conf/application.properties 文件，修改数据库连接信息。可以直接复制 LokHub/docker/nacos/conf/application.properties 内容。

修改下数据库配置信息为你自己的数据库，本地启动可以把鉴权关了。

```
1. 如果数据库名也是 laigeoffer-LokHub，那么只需要修改用户名和密码即可。
2. 如果用户名也是 root，那么只需要修改密码即可。
3. 如果密码也一样，那么就不需要修改了（不可能，绝对不可能这么巧😂）。
```

![修改nacos配置文件](https://cdn.tobebetterjavaer.com/stutymore/20240529173446.png)

①、如果你是 macOS 用户，可以直接在终端输入`sh startup.sh -m standalone`启动 Nacos。

②、如果你是 Windows 用户，可以直接双击 startup.cmd 启动 Nacos。

启动成功后访问 http://localhost:8848/nacos 即可看到 Nacos 控制台。默认用户名密码都是 nacos。

![nacos启动成功界面](https://cdn.tobebetterjavaer.com/stutymore/20240529173621.png)

* 4、启动 SkyWalking 分布式链路追踪（非必须）

参考手册：[SkyWalking 启动手册]()

* 5、启动 Sentinel 分布式熔断和降级（非必须）

参考手册：[Sentinel 启动手册]()


* 6、启动 Seata 分布式事务（非必须）

参考手册：[Seata 启动手册]()

* 7、启动 Rocketmq 消息队列（非必须）

参考手册：[Rocketmq 启动手册]()



#### 第五步，启动各个微服务

> 注意：如果遇到服务启动失败，可自行查看 nacos 配置是否做了修改，如数据库连接信息等。

①、启动 LokHub-gateway 网关服务

找到 LokHub-gateway 项目，右键 Run LokHubGatewayApplication.main()。

②、启动 LokHub-auth 认证服务

找到 LokHub-auth 项目，右键 Run LokHubAuthApplication.main()。

③、启动 LokHub-system 系统服务

找到 LokHub-system 项目（在LokHub-modules 下），右键 Run LokHubSystemApplication.main()。
LokHub-system 启动前需要修改 nacos 中的 LokHub-system-dev.yml 配置文件，修改数据库连接信息为你自己的数据库。


![修改LokHub-system配置](https://cdn.tobebetterjavaer.com/stutymore/img.png)

④、启动 LokHub-project 项目管理服务

找到 LokHub-project 项目（在LokHub-modules 下），右键 Run LokHubProjectApplication.main()。

启动前需要修改 nacos 中的 LokHub-project-dev.yml 配置文件，修改数据库连接信息为你自己的数据库。

⑤、启动 LokHub-workflow 流程管理服务

找到 LokHub-workflow 项目（在LokHub-modules 下），右键 Run LokHubWorkflowApplication.main()。

启动前需要修改 nacos 中的 LokHub-workflow-dev.yml 配置文件，修改数据库连接信息为你自己的数据库。

⑥、启动 LokHub-gen 代码生成服务

找到 LokHub-gen 项目（在LokHub-modules 下），右键 Run LokHubGenApplication.main()。

启动前需要修改 nacos 中的 LokHub-gen-dev.yml 配置文件，修改数据库连接信息为你自己的数据库。

⑦、启动 LokHub-job 定时任务调度服务

找到 LokHub-job 项目（在LokHub-modules 下），右键 Run LokHubJobApplication.main()。

启动前需要修改 nacos 中的 LokHub-job-dev.yml 配置文件，修改数据库连接信息为你自己的数据库。

⑧、启动 LokHub-monitor 监控服务

找到 LokHub-monitor 项目，右键 Run LokHubMonitorApplication.main()。

启动前需要修改 nacos 中的 LokHub-monitor-dev.yml 配置文件，修改监控后台的用户名和密码，以及首页展示标题。

启动成功后可访问：http://localhost:6888/wallboard

可以在线实时查案各个服务的状态以及日志：

![主界面](https://cdn.tobebetterjavaer.com/stutymore/image.webp)




### 3.3、前端项目启动

请参考 LokHub-ui 项目的 README.md 文档，[前端工程结构说明](LokHub-ui/README.md)


### 3.4、Swagger 地址

http://localhost:1024/dev-api/swagger-ui/index.html

### 3.5、服务器部署（Docker 方式）

请参考 [云容器部署系统]()

## 四、技术选型

后端技术栈

|         技术          | 说明                   | 官网                                                                                                                         |
|:-------------------:|----------------------|----------------------------------------------------------------------------------------------------------------------------|
| Spring & SpringMVC  | Java全栈应用程序框架和WEB容器实现 | [https://spring.io/](https://spring.io/)                                                                                   |
|     SpringBoot      | Spring应用简化集成开发框架     | [https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot)                                           |
|     SpringCloud     | 微服务框架                | [https://spring.io/projects/spring-cloud](https://spring.io/projects/spring-cloud)                                         |
|    mybatis-plus     | 数据库orm框架             | [https://baomidou.com/](https://baomidou.com/)                                                                             |
| mybatis PageHelper  | 数据库翻页插件              | [https://github.com/pagehelper/Mybatis-PageHelper](https://github.com/pagehelper/Mybatis-PageHelper)                       |
|    elasticsearch    | 近实时文本搜索              | [https://www.elastic.co/cn/elasticsearch/service](https://www.elastic.co/cn/elasticsearch/service)                         |
|        redis        | 内存数据存储               | [https://redis.io](https://redis.io)                                                                                       |
|      rocketmq       | 消息队列                 | [https://rocketmq.apache.org/](https://rocketmq.apache.org/)                                                               |
|       mongodb       | NoSql数据库             | [https://www.mongodb.com/](https://www.mongodb.com/)                                                                       |
|        nginx        | 服务器                  | [https://nginx.org](https://nginx.org)                                                                                     |
|       docker        | 应用容器引擎               | [https://www.docker.com](https://www.docker.com)                                                                           |
|      hikariCP       | 数据库连接                | [https://github.com/brettwooldridge/HikariCP](https://github.com/brettwooldridge/HikariCP)                                 |
|         oss         | 对象存储                 | [https://help.aliyun.com/document_detail/31883.html](https://help.aliyun.com/document_detail/31883.html)                   |
|        https        | 证书                   | [https://letsencrypt.org/](https://letsencrypt.org/)                                                                       |
|         jwt         | jwt登录                | [https://jwt.io](https://jwt.io)                                                                                           |
|       lombok        | Java语言增强库            | [https://projectlombok.org](https://projectlombok.org)                                                                     |
|        guava        | google开源的java工具集     | [https://github.com/google/guava](https://github.com/google/guava)                                                         |
|      thymeleaf      | html5模板引擎            | [https://www.thymeleaf.org](https://www.thymeleaf.org)                                                                     |
|       swagger       | API文档生成工具            | [https://swagger.io](https://swagger.io)                                                                                   |
| hibernate-validator | 验证框架                 | [hibernate.org/validator/](hibernate.org/validator/)                                                                       |
|     quick-media     | 多媒体处理                | [https://github.com/liuyueyi/quick-media](https://github.com/liuyueyi/quick-media)                                         |
|      liquibase      | 数据库版本管理              | [https://www.liquibase.com](https://www.liquibase.com)                                                                     |
|       jackson       | json/xml处理           | [https://www.jackson.com](https://www.jackson.com)                                                                         |
|      ip2region      | ip地址                 | [https://github.com/zoujingli/ip2region](https://github.com/zoujingli/ip2region)                                           |
|      websocket      | 长连接                  | [https://docs.spring.io/spring/reference/web/websocket.html](https://docs.spring.io/spring/reference/web/websocket.html)   |
|   sensitive-word    | 敏感词                  | [https://github.com/houbb/sensitive-word](https://github.com/houbb/sensitive-word)                                         |
|       chatgpt       | chatgpt              | [https://openai.com/blog/chatgpt](https://openai.com/blog/chatgpt)                                                         |
|        讯飞星火         | 讯飞星火大模型              | [https://www.xfyun.cn/doc/spark/Web.html](https://www.xfyun.cn/doc/spark/Web.html#_1-%E6%8E%A5%E5%8F%A3%E8%AF%B4%E6%98%8E) |



## 五、环境搭建

### 开发工具

|        工具        | 说明           | 官网                                                                                                                       | 
|:----------------:|--------------|--------------------------------------------------------------------------------------------------------------------------|
|       IDEA       | java开发工具     | [https://www.jetbrains.com](https://www.jetbrains.com)                                                                   |
|   visualstudio   | web开发工具      | [https://code.visualstudio.com/](https://code.visualstudio.com/)                                                         |
|      Chrome      | 浏览器          | [https://www.google.com/intl/zh-CN/chrome](https://www.google.com/intl/zh-CN/chrome)                                     |
|   ScreenToGif    | gif录屏        | [https://www.screentogif.com](https://www.screentogif.com)                                                               |
|     SniPaste     | 截图           | [https://www.snipaste.com](https://www.snipaste.com)                                                                     |
|     PicPick      | 图片处理工具       | [https://picpick.app](https://picpick.app)                                                                               |
|     MarkText     | markdown编辑器  | [https://github.com/marktext/marktext](https://github.com/marktext/marktext)                                             |
|       curl       | http终端请求     | [https://curl.se](https://curl.se)                                                                                       |
|     Postman      | API接口调试      | [https://www.postman.com](https://www.postman.com)                                                                       |
|     draw.io      | 流程图、架构图绘制    | [https://www.diagrams.net/](https://www.diagrams.net/)                                                                   |
|      Axure       | 原型图设计工具      | [https://www.axure.com](https://www.axure.com)                                                                           |
|     navicat      | 数据库连接工具      | [https://www.navicat.com](https://www.navicat.com)                                                                       |
|     DBeaver      | 免费开源的数据库连接工具 | [https://dbeaver.io](https://dbeaver.io)                                                                                 |
|      iTerm2      | mac终端        | [https://iterm2.com](https://iterm2.com)                                                                                 |
| windows terminal | win终端        | [https://learn.microsoft.com/en-us/windows/terminal/install](https://learn.microsoft.com/en-us/windows/terminal/install) |
|   SwitchHosts    | host管理       | [https://github.com/oldj/SwitchHosts/releases](https://github.com/oldj/SwitchHosts/releases)                             |


### 开发环境

|      工具       | 版本        | 下载                                                                                                                     |
|:-------------:|:----------|------------------------------------------------------------------------------------------------------------------------|
|      jdk      | 1.8+      | [https://www.oracle.com/java/technologies/downloads/#java8](https://www.oracle.com/java/technologies/downloads/#java8) |
|     maven     | 3.4+      | [https://maven.apache.org/](https://maven.apache.org/)                                                                 |
|     mysql     | 5.7+/8.0+ | [https://www.mysql.com/downloads/](https://www.mysql.com/downloads/)                                                   |
|     redis     | 5.0+      | [https://redis.io/download/](https://redis.io/download/)                                                               |
| elasticsearch | 8.0.0+    | [https://www.elastic.co/cn/downloads/elasticsearch](https://www.elastic.co/cn/downloads/elasticsearch)                 |
|     nginx     | 1.10+     | [https://nginx.org/en/download.html](https://nginx.org/en/download.html)                                               |
|   rocketmq    | 5.0.4+    | [https://www.rabbitmq.com/news.html](https://www.rabbitmq.com/news.html)                                               |
|    ali-oss    | 3.15.1    | [https://help.aliyun.com/document_detail/31946.html](https://help.aliyun.com/document_detail/31946.html)               |
|      git      | 2.34.1    | [http://github.com/](http://github.com/)                                                                               |
|    docker     | 4.10.0+   | [https://docs.docker.com/desktop/](https://docs.docker.com/desktop/)                                                   |
|    freessl    | https证书   | [https://freessl.cn/](https://freessl.cn/)                                                                             |

### 搭建步骤

#### 本地部署教程

> [本地开发环境手把手教程]()

### 云服务器部署教程

> [环境搭建 & 基于源码的部署教程](docs/安装环境.md)

> [服务器docker启动教程]()

## 六、内置功能
> 内置功能使用了若依的框架，为什么要用若依，一来我们觉得基础的后台功能没有必要再重复造轮子，我们需要节省时间花力气在项目核心业务上，二来我们希望站在巨人的肩膀上，若依是后台系统中很优秀的框架，我们基于其做的二次开发，相信也能再创辉煌！

1.  用户管理：用户是系统操作者，该功能主要完成系统用户配置。
2.  部门管理：配置系统组织机构（公司、部门、小组），树结构展现支持数据权限。
3.  岗位管理：配置系统用户所属担任职务。
4.  菜单管理：配置系统菜单，操作权限，按钮权限标识等。
5.  角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
6.  字典管理：对系统中经常使用的一些较为固定的数据进行维护。
7.  参数管理：对系统动态配置常用参数。
8.  通知公告：系统通知公告信息发布维护。
9.  操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
10. 登录日志：系统登录日志记录查询包含登录异常。
11. 在线用户：当前系统中活跃用户状态监控。
12. 定时任务：在线（添加、修改、删除)任务调度包含执行结果日志。
13. 代码生成：前后端代码的生成（java、html、xml、sql）支持CRUD下载 。
14. 系统接口：根据业务代码自动生成相关的api接口文档。
15. 服务监控：监视当前系统CPU、内存、磁盘、堆栈等相关信息。
16. 缓存监控：对系统的缓存信息查询，命令统计等。
17. 在线构建器：拖动表单元素生成相应的HTML代码。
18. 连接池监视：监视当前系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈。

## 七、友情链接

- [paicoding](https://github.com/itwanger/paicoding?tab=readme-ov-file) ：⭐️一款好用又强大的开源社区，基于 Spring Boot、MyBatis-Plus、MySQL、Redis、ElasticSearch、MongoDB、Docker、RabbitMQ 等主流技术栈
- [toBeBetterjavaer](https://github.com/itwanger/toBeBetterJavaer) ：🚀一份通俗易懂、风趣幽默的Java学习指南，内容涵盖Java基础、Java并发编程、Java虚拟机、Java企业级开发、Java面试等核心知识点。学Java，就认准二哥的Java进阶之路😄
- [CodeCanvas](https://github.com/freestylefly/CodeCanvas) ：📚本代码仓库是作者苍何多年从事一线互联网Java开发的学习历程技术汇总，旨在为大家提供一个清晰详细的学习教程，侧重点更倾向编写Java核心内容。💪🏻
