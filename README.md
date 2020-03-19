**阅读顺序**

    1 README.md
    2 README-eureka.md
    3 README-hystrix.md
    4 README-hystrixdashboard.md
    5 README-hystrix-turbine.md
    6 README-config.md
    7 README-cloudbus.md
    8 README-zuul.md


**什么是微服务**

    要了解 Spring Cloud 就绕不开微服务这个概念。因为 Spring Cloud 是 Spring 为微服务架构思想做的一个一站式实现。
    从某种程度是可以简单的理解为，微服务是一个概念、一个项目开发的架构思想。
    Spring Cloud 是微服务架构的一种 Java 实现
    微服务架构模式（Microservices Architecture Pattern）的目的是将大型的、复杂的、长期运行的应用程序
    构建为一组相互配合的服务，每个服务都可以很容易得局部改良

**微服务架构优势**

    复杂度可控： 
    在将应用分解的同时，规避了原本复杂度无止境的积累。每一个微服务专注于单一功能，
    并通过定义良好的接口清晰表述服务边界。由于体积小、复杂度低，每个微服务可由一个小规模开发团队完全掌控，
    易于保持高可维护性和开发效率。
                
    独立部署：
    由于微服务具备独立的运行进程，所以每个微服务也可以独立部署。当某个微服务发生变更时无需编译、部署整个应用。
    由微服务组成的应用相当于具备一系列可并行的发布流程，使得发布更加高效，同时降低对生产环境所造成的风险，
    最终缩短应用交付周期。
              
    技术选型灵活：
    微服务架构下，技术选型是去中心化的。每个团队可以根据自身服务的需求和行业发展的现状，自由选择最适合的技术栈。
    由于每个微服务相对简单，故需要对技术栈进行升级时所面临的风险就较低，甚至完全重构一个微服务也是可行的。
                 
    容错：
    当某一组建发生故障时，在单一进程的传统架构下，故障很有可能在进程内扩散，形成应用全局性的不可用。
    在微服务架构下，故障会被隔离在单个服务中。若设计良好，其他服务可通过重试、平稳退化等机制实现应用层面的容错。
          
    扩展：
    每个服务可以各自进行 x 扩展和 z 扩展，而且，每个服务可以根据自己的需要部署到合适的硬件服务器上。
    当应用的不同组件在扩展需求上存在差异时，微服务架构便体现出其灵活性，因为每个服务可以根据实际需求独立进行扩展


**为什么微服务架构需要 Spring Cloud**
    
    简单来说，服务化的核心就是将传统的一站式应用根据业务拆分成一个一个的服务，
    而微服务在这个基础上要更彻底地去耦合（不再共享 DB、KV，去掉重量级 ESB），并且强调 DevOps 和快速演化。
    这就要求我们必须采用与一站式时代、泛 SOA 时代不同的技术栈，而 Spring Cloud 就是其中的佼佼者

**Spring Cloud 与  Dubbo** 

![image](https://gitee.com/heguangchuan/springcloud/raw/master/img/springcloud-dubbo.png)


**spring cloud 组件**

![image](https://gitee.com/heguangchuan/springcloud/raw/master/img/springcloud-framework.png)

    服务治理：
    
    这是 Spring Cloud 的核心。目前 Spring Cloud 主要通过整合 Netflix 的相关产品来实现这方面的功能（Spring Cloud Netflix）
    包括用于服务注册和发现的 Eureka，调用断路器 Hystrix，调用端负载均衡 Ribbon，Rest 客户端 Feign，智能服务路由 Zuul，
    用于监控数据收集和展示的 Spectator、Servo、Atlas，用于配置读取的 Archaius 和提供 Controller 层 Reactive 封装的 RxJava。
    除此之外，针对于服务的注册和发现，除了 Eureka，Spring Cloud 也整合了 Consul 和 Zookeeper 作为备选，
    但是因为这两个方案在 CAP 理论上都遵循 CP 而不是 AP（下一篇会详细介绍这点），所以官方并没有推荐使用。
    Feign 和 RxJava 并不是 Netiflix 的产品，但是被整合到了 Spring Cloud Netflix 中
    
    分布式链路监控：
    Spring Cloud Sleuth 提供了全自动、可配置的数据埋点，以收集微服务调用链路上的性能数据，
    并发送给 Zipkin 进行存储、统计和展示
    
    消息组件：
    Spring Cloud Stream 对于分布式消息的各种需求进行了抽象，包括发布订阅、分组消费、消息分片等功能，
    实现了微服务之间的异步通信。Spring Cloud Stream 也集成了第三方的 RabbitMQ 和 Apache Kafka 作为消息队列的实现。
    而 Spring Cloud Bus 基于 Spring Cloud Stream，主要提供了服务间的事件通信（比如刷新配置）
    
    
    配置中心：
    基于 Spring Cloud Netflix 和 Spring Cloud Bus，Spring 又提供了 Spring Cloud Config，
    实现了配置集中管理、动态刷新的配置中心概念。配置通过 Git 或者简单文件来存储，支持加解密
    
    
    安全控制：
    Spring Cloud Security 基于 OAuth2 这个开放网络的安全标准，提供了微服务环境下的单点登录、资源授权、令牌管理等功能
    
    命令行工具：
    Spring Cloud Cli 提供了以命令行和脚本的方式来管理微服务及 Spring Cloud 组件的方式
    
    集群工具：
    Spring Cloud Cluster 提供了集群选主、分布式锁（暂未实现）、一次性令牌（暂未实现）等分布式集群需要的技术组件
    

**Thanks**

https://windmt.com/2018/04/14/spring-cloud-0-microservices/