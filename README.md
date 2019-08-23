
## 项目说明
### example-001
    启动第一个springboot 程序，委托给静态的 SpringApplication.run 方法运行，默认端口8080，日志级别默认是INFO
### example-002
    修改spring-boot banner
    在banner 内可以使用的占位符有：
    ${application.version} 应用版本号
    ${application.formatted-version}   应用格式化显示的版本号  声明在 MANIFEST.MF 中，格式化之后打印（用括号括起来，以 v 为前缀），例如 (v1.0)。
    ${spring-boot.version} spring-boot 版本号
    ${spring-boot.formatted-version} spring-boot格式化显示的版本号，使用的 Spring Boot 版本格式化之后显示（用括号括起来，以 v 为前缀）。例如 (v2.1.1.RELEASE)
    ${application.title} 应用的标题
    MANIFEST.MF 在打包的时候生成
    颜色具体参考：org.springframework.boot.ansi.AnsiColor
 
 ### example-003
    事件监听
    注意：同一个事件注册多个监听器的时候，handler 发生是无序的
    定义事件 继承 ApplicationEvent，详见SportEvent
    发布事件：通过 ApplicationEventPublisher 对象的 publishEvent(new Sport(this,user))方法发布;
    实现监听：可以通过@EventListener 或者实现ApplicationListener泛型接口、实现SmartApplicationListener接口等
              SportListener 通过@EventListener注解的方式实现
              SportApplicationListener 直接实现ApplicationListener 接口
              顺序监听 实现 SmartApplicationListener，详见SayEvent， SayHelloLister，SayWordLister，PublishEvent
    开启异步   
    首先 @EnableAsync  开启异步
         @Aysnc 注解处理的方法即可           
### example-004
    获取访问应用程序参数： 如 java -jar xx.jar  --debug  file=100 hello
### example-005
    CommandLineRunner ApplicationRunner 可以在spring 启动的时候 运行一些代码，或者bean 实例化和注入完成后运行一段代码              
    
### example-006
    监听spring 退出的钩子
    所有标准的 Spring 生命周期回调（比如 DisposableBean 接口，或者 @PreDestroy 注解）都可以使用。   
 
### example-007
    Spring Boot 使用了一个非常特别的 PropertySource 指令，用于智能覆盖默认值。属性将按照以下顺序处理：
    在您的主目录（当 devtools 被激活，则为 ~/.spring-boot-devtools.properties ）中的 Devtools 全局设置属性。
    在测试中使用到的 @TestPropertySource 注解。
    在测试中使用到的 properties 属性，可以是 @SpringBootTest 和用于测试应用程序某部分的测试注解。
    命令行参数。
    来自 SPRING_APPLICATION_JSON 的属性（嵌入在环境变量或者系统属性【system propert】中的内联 JSON）。
    ServletConfig 初始化参数。
    ServletContext 初始化参数。
    来自 java:comp/env 的 JNDI 属性。
    Java 系统属性（System.getProperties()）。
    操作系统环境变量。
    只有 random.* 属性的 RandomValuePropertySource。
    在已打包的 jar 外部的指定 profile 的应用属性文件（application-{profile}.properties 和 YAML 变量）。
    在已打包的 jar 内部的指定 profile 的应用属性文件（application-{profile}.properties 和 YAML 变量）。
    在已打包的 jar 外部的应用属性文件（application.properties 和 YAML 变量）。
    在已打包的 jar 内部的应用属性文件（application.properties 和 YAML 变量）。
    在 @Configuration 类上的 @PropertySource 注解。
    默认属性（使用 SpringApplication.setDefaultProperties 指定）。
    事例：
    @Value  
    随机数
    @ConfigurationProperties
### example-008
    特定 Profile 的属性文件的说明：
    没有default 默认走    application.properties
    没有指定 有 default 走default 
    命令行指定了 --spring.profiles.active = dev  就走dev，可以指定多个，可以指定多个逗号相隔
    还可以在application.propterties中指定 spring.profiles.active=prod ，就走prod，可以指定多个逗号相隔
    如果用 --spring.config.location，则走spring.config.location 的指定的配置文件
    在类上 @Profile("prod") 指定
    注意： 命令行的优先级最高
    在application.propterties中增加加激活的配置文件：spring.profiles.include=pre
    通过代码：SpringApplication 中的 setAdditionalProfiles() 方法。
    
    
    
         