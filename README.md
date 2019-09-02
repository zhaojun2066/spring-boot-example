
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
    ---------------------------
    Spring Boot 默认提供配置的形式非常简单，只适合简单的日志应用，虽然说日志输出格式可以自定义，
    但日志文件如何按天滚动等其他更复杂的策略却不能配置，只能通过自定义引用日志文件的形式。
    Spring Boot 定制日志文件:
    简单的日志配置不能满足实际项目需求，那可以通过引用定制日志文件的形式达到目的。Spring Boot能根据类路径下的
    类库和配置文件自动配置对应的日志框架。
    
    日志框架	              配置文件
    Logback	                  logback-spring.xml, logback-spring.groovy, logback.xml, or logback.groovy
    Log4j2	                  log4j2-spring.xml or log4j2.xml
    JDK (Java Util Logging）  logging.properties
    
    按对应类库在 classpath 下创建对应支持的日志配置文件就行，或者通过配置 logging.config 指定。
    既然默认是支持 Logback 的，那现在只要在资源根目录下创建一个 logback-spring.xml 文件即可。xx-spring 这是 Spring Boot 
    推荐的命名方式，否则 Spring Boot 不能完全控制日志初始化，因为默认命名配置文件 logback.xml 加载较早不能获取到 application.properties 
    中的配置信息
            
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
    jdbc 配置 ，默认走 HikariPool  连接池 
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
    RestTemplate默认依赖JDK提供http连接的能力（HttpURLConnection），如果有需要的话也可以通过setRequestFactory
    方法替换为例如Apache HttpComponents、Netty或OkHttp等其它HTTP library。
    RestTemplate方法的名称遵循命名约定，第一部分指出正在调用什么HTTP方法，第二部分指示返回的内容
    如： getForObject ，get方法 返回 具体的Object
         getForEntity, get 方法，返回原始Entity 
### example-030
     send mail
### example-031
    任务执行
    在上下文中没有 Executor bean 的情况下，Spring Boot 会自动配置一个有合理默认值的 ThreadPoolTask​​Executor，
    它可以自动与异步任务执行（@EnableAsync）和 Spring MVC 异步请求处理相关联  
    本次使用默认配置实现
    Spring Boot线程调度有以下几个参数可以配置(2.1版本之后才有)：
    spring.task.execution.pool.core-size # 核心线程数，默认为8
    spring.task.execution.pool.queue-capacity # 队列容量，默认为无限大
    spring.task.execution.pool.max-size # 最大线程数，默认为无限大
    这三个参数的关系如下：
    如果当前要执行的任务数超过core-size，则任务会放到队列里面等待执行，等核心线程中有任务执行完成之后，再取出队列中的任务进行调度执行。
    如果等待队列已经满了，再收到新任务时，则核心线程会自动扩容，最大扩展到max-size。
    spring.task.execution.pool.allow-core-thread-timeout # 是否允许回收空闲的线程，默认为true
    spring.task.execution.pool.keep-alive # 空闲的线程可以保留多少秒，默认为60。如果超过这个时间没有任务调度，则线程会被回收
    spring.task.execution.thread-name-prefix # 线程名前缀，默认为thread-
### example-032
    任务执行    
    在上下文中没有 Executor bean 的情况下，Spring Boot 会自动配置一个有合理默认值的 ThreadPoolTask​​Executor，
    它可以自动与异步任务执行（@EnableAsync）和 Spring MVC 异步请求处理相关联  
    实现ThreadPoolTask​​Executor 可以覆盖默认的 @EnableAsync 使用的线程池
    Spring MVC 的异步请求支持 需要 `AsyncTaskExecutor` 实现（名为 `applicationTaskExecutor`）
    本次为 自定义 ThreadPoolTaskExecutor 的实现
### example-033    
     ThreadPoolTaskExecutor 的监控
### example-034    
     任务调度 配置 @EnableScheduling  spring-boot 会自动配置一个ThreadPoolTaskScheduler，
     默认情况下，线程池使用一个线程，可以使用 spring.task.scheduling 命名空间对这些设置进行微调，参考spring.task.execution
     当然你自己也可以定义ThreadPoolTaskScheduler 来覆盖默认的 
     本例使用自定义线程池
     常用的cron 表达式
     "*/5 * * * * ? "    每隔5秒执行一次
     "0 */1 * * * ? "   每隔1分钟执行一次
     "0 0 12 * * ?"    每天中午十二点触发
     "0 0 23 * * ?"    每天23点执行一次
     "0 0 1 * * ?"    每天凌晨1点执行一次
     "0 0 1 1 * ?"    每月1号凌晨1点执行一次
     "0 0 23 L * ?"    每月最后一天23点执行一次
     "0 0 1 ? * L"    每周星期天凌晨1点实行一次
     "0 26,29,33 * * * ?"    在26分、29分、33分执行一次
     "0 0 0,13,18,21 * * ?"    每天的0点、13点、18点、21点都执行一次
     "0 15 10 ? * *"    每天早上10：15触发
     "0 15 10 * * ?"    每天早上10：15触发
     "0 15 10 * * ? *"    每天早上10：15触发
     "0 15 10 * * ? 2005"    2005年的每天早上10：15触发
     "0 * 14 * * ?"    每天从下午2点开始到2点59分每分钟一次触发
     "0 0/5 14 * * ?"    每天从下午2点开始到2：55分结束每5分钟一次触发
     "0 0/5 14,18 * * ?"    每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发
     "0 0-5 14 * * ?"    每天14:00至14:05每分钟一次触发
     "0 10,44 14 ? 3 WED"    三月的每周三的14：10和14：44触发
     "0 15 10 ? * MON-FRI"    每个周一、周二、周三、周四、周五的10：15触发
### example-035   
     @Conditional 注解，和@Configuration @Bean 配合使用
     实现 Condition 接口，根据条件决定创建哪个bean 
     
     其他spring 自带的条件注解
     @ConditionalOnClass 某个class位于类路径上，才会实例化一个Bean
     @ConditionalOnMissingClass  某个class类路径上不存在的时候，才会实例化一个Bean
     @ConditionalOnBean 仅仅在当前上下文中存在某个对象时，才会实例化一个Bean
     @ConditionalOnMissingBean  仅仅在当前上下文中不存在某个对象时，才会实例化一个Bean
     @ConditionalOnProperty 注解允许基于 Spring Environment 属性包含配置。使用 prefix 和 name 属性指定需要检查的属性
     @ConditionalOnResource 注解仅允许在存在特定资源时包含配置
     @ConditionalOnWebApplication当前是web环境
     @ConditionalOnNotWebApplication	当前不是web环境
     @ConditionalOnExpression 注解允许根据 SpEL 表达式的结果包含配置
### example-036   
     @ConditionalOnBean  仅仅在当前上下文中存在某个对象时，才会实例化一个Bean
     只有班级bean的情况下 ，才能创建学生的bean   
     配置类中定义Bean，如果使用@ConditionalOnBean注解依赖的Bean是通过配置类触发解析的，则执行结果依赖配置类加载顺序  
### example-037 
     创建自己的自动化配置 starter，本例为一个汽车自动配置引擎的例子,spring.factories方式
### example-038
    example-037 试验进行结果验证          
### example-039
     创建自己的自动化配置 starter，本例为一个汽车自动配置引擎的例子, ennable注解的方式
     EnableCar ,加上这个注解就会启动Car的自动化配置和spring.factories 一样 
### example-040
    example-039 试验进行结果验证          
### example-041
    actuator
    通过 Actuator 端点，你可以监控应用程序并与之交互。Spring Boot 包含许多内置端点，也允许你添加自己的端点。
    例如，health 端点提供基本的应用程序健康信息      .
    健康状况：http://localhost:8080/actuator/health
    spring2.x之前默认情况下，Actuator 启用除 shutdown 之外的所有端点。要配置端点的启用，请使用其 management.endpoint.<id>.enabled 属性
    agement.endpoint.shutdown.enabled=true
    如果你希望端点启用是选择性加入而不是选择性退出，请将 management.endpoints.enabled-by-default 属性设置为 false，
    并使用各个端点的 enabled 属性重新加入。以下示例启用 info 端点并禁用所有其他端点：
    management.endpoints.enabled-by-default=false
    management.endpoint.info.enabled=true 
    
    注意的是 spring boot2.x中，默认只开放了info、health两个端点，
    其余的需要自己通过配置management.endpoints.web.exposure.include属性来加载（有include自然就有exclude）。
    如果想单独操作某个端点可以使用management.endpoint.端点.enabled属性进行启用或者禁用。
    
    http://localhost:8080/actuator 查看所有可以用的端点
    参考文档：https://docs.spring.io/spring-boot/docs/2.1.3.RELEASE/actuator-api//html/
    
    查看支持的监控指标list
    http://localhost:8080/actuator/metrics/
    查看某个指标的值
    http://localhost:8080/actuator/metrics/jvm.memory.committed
    
    
### example-042    
    SpringBoot页面展示Thymeleaf
    Spring Boot默认存放模板页面的路径在src/main/resources/templates或者src/main/view/templates，这个无论是使用什么模板语言都一样，
    当然默认路径是可以自定义的，不过一般不推荐这样做。另外Thymeleaf默认的页面文件后缀是.html
    <html xmlns:th="http://www.thymeleaf.org"> 引用 th 标签
    thymeleaf 语法：https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#using-texts
### example-043
    mvc 参数验证  + @RestControllerAdvice 统一返回异常结果