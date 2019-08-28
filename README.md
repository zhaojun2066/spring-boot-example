
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
### 009
    spring-boot-starter 默认是 使用 Logback 进行日志记录，当然你可以使用其他日志框架使用SLF4J 
    日志级别：Logback 没有 FATAL 【打印严重错误，会导致程序退出】 级别。该级别映射到 ERROR 
              ERROR 打印错误日志，但是不会影响程序继续运行
              WARN 警告信息，潜在的问题信息，在生产日志中，作为给程序员的一种提醒而使用
              INFO 粗粒度级别上突出强调应用程序的运行过程
              DEBUG 开发过程中打印一些运行信息
              TRACE  较低的日志级别，通常不会被使用  
    日志组：logging.group.tomcat=org.apache.catalina, org.apache.coyote, org.apache.tomcat
            logging.level.tomcat=TRACE 
            Spring Boot 包含以下预定义的日志记录组，可以直接使用：
            logging.level.web【org.springframework.core.codec、org.springframework.http、org.springframework.web】
            logging.level.sql	【org.springframework.jdbc.core、org.hibernate.SQL】
### example-010
    spring mvc,springboot 能够为spring mvc 提供自动化配置
    这里只是提供一个mvc的demo，包含接受get参数，json body ，restful 接口 ，都是返回json，更多事例参考相关spring mvc的文档事例。
### example-011
    HttpMessageConverters
    HttpMessageConverter 接口是用来来转换 HTTP 的请求和响应，默认是jackson 来处理请求和响应json，字符串默认是utf-8。
    自定义转换器 , 可以实现HttpMessageConverter 接口 或者继承 AbstractHttpMessageConverter 抽象类
    自定义转化器案例： MyHttpMessageConverter，MyConfiguration  会覆盖默认的  HttpMessageConverters  
### example-012
    自定义 JSON Serializer 和 Deserializer
    使用 Jackson 序列化和反序列化 JSON 数据，可能需要自己编写 JsonSerializer 和 JsonDeserializer 类
    或者使用spring-boot 提供的@JsonComponent 注解
    ApplicationContext 中所有的 @JsonComponent bean 将被自动注册到 Jackson 中，由于 @JsonComponent 
    使用 @Component 注解标记，因此组件扫描（component-scanning）规则将对其生效
### example-013
    统一异常处理  ErrorController
### example-014
    统一异常处理 ,处理自定义异常 RestControllerAdvice or ControllerAdvice  ,最后统一返回json格式的错误信息  
### example-015
    自定义错误页面，自动处理和错误code 相关的页面展示信息.  会自动寻找/public/error/404.html 或者 xxx.html  
### example-016
    跨域支持
### example-017
    统一返回体 response 拦截   @ControllerAdvice  ResponseBodyAdvice
### example-018
    异步线程池的设置和异步请求
### example-019
    servlet filter, filter 只是针对servlet 进行过滤，不会对spring controller进行过滤 
    @WebFilter @WebServlet 实现,@ServletComponentScan 用于发现前面的两个annotation
    @Order 在 @WebFilter 上的类不起作用
    @ServletComponentScan 在独立（standalone）容器中不起作用，因容器将使用内置发现机制来代替。
### example-020
    servlet filter, filter 只是针对servlet 进行过滤，不会对spring controller进行过滤 
    ServletRegistrationBean FilterRegistrationBean 实现
### example-021
    tomcat 配置 ，详见reade
### example-022
    tomcat 配置 ，代码方式WebServerFactoryCustomizer
    注意：TomcatServletWebServerFactory、JettyServletWebServerFactory 和 UndertowServletWebServerFactory 
    是 ConfigurableServletWebServerFactory 的具体子类，它们分别为 Tomcat、Jetty 和 Undertow 提供了额外的自定义
    setter 方法
### example-023
    tomcat 配置 ，直接注入bean ，TomcatServletWebServerFactory、JettyServletWebServerFactory 或 UndertowServletWebServerFactory
### example-024
    mvc 安全配置，简单用户名和密码    
### example-025
    jdbc 配置     
### example-026
    jpa 配置         
### example-027
    连接redis cluster 配置
    StringRedisTemplate与RedisTemplate
    两者的关系是StringRedisTemplate继承RedisTemplate。    
    StringRedisTemplate默认采用的是String的序列化策略，保存的key和value都是采用此策略序列化保存的。
    RedisTemplate默认采用的是JDK的序列化策略，保存的key和value都是采用此策略序列化保存的
### example-028
    连接redis cluster 配置,序列化和反序列化改为fastJson    
### example-029
    RestTemplate 
    Spring Boot 不提供任何自动配置的 RestTemplate bean。但是，它会自动配置 RestTemplateBuilder，
    可在需要时创建 RestTemplate 实例。自动配置的 RestTemplateBuilder 确保将合适的 HttpMessageConverters
    应用于 RestTemplate 实例。 
    RestTemplate方法的名称遵循命名约定，第一部分指出正在调用什么HTTP方法，第二部分指示返回的内容
    如： getForObject ，get方法 返回 具体的Object
         getForEntity, get 方法，返回原始Entity 
       