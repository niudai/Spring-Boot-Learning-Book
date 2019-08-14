---
description: '实时获取你应用的健康指标, 流量动态。'
---

# Spring Boot Actuator

> Spring Boot Actuator includes a number of additional features to help you monitor and manage your application when you push it to production. You can choose to manage and monitor your application by using HTTP endpoints. Auditing, health, and metrics gathering can also be automatically applied to your application.

> Spring Boot Actuator 包含了一系列用于生产环境中的监控和管理功能。你可以通过基于HTTP协议的API去管理和监控你的应用。审计，健康，和指标等功能可以一次性整合到你的应用中。

以上是关于**Spring Boot Actuator** 的官方介绍，看到这里，你已经对它有了一个整体性的认知，它在我们的整个 **Web应用结构** 下扮演的是“监控”的角色，比如，我们希望实时获取我们网站每天的用户浏览量，假如我们的网站是一个视频网站，我们还希望获取每天有多少人上传视频，总共上传了多少，我们的服务器的储存空间还剩多少，当巨大流量冲击我们的网站时，网站的内存占用，数据库的压力等等信息。

所以为了完成一个完善的，生产级的应用，我们急需这样一个“监控审计员”对我们的应用进行一个完善又全面的监控。

#### 配置 Spring Boot Actuator

得益于Spring Boot的依赖整合能力，我们只需在`pom` 文件中声明`spring-boot-starter-actuator` 依赖即可：

```text
<dependencies>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-actuator</artifactId>
	</dependency>
</dependencies>
```

完成配置后，我们来学习如何使用。

#### **Endpoints**

Actuator 不仅要对我们的应用进行监控，而且还要把监控结果“送出去”，要让外界可以获取，怎么获取呢？当然是以 API 的形式（绝大多数情况下就是HTTP协议），在这里，我们将其称作 Endpoint 。

Actuator 本身给我们提供几个预设的 Endpoint，比如 health，info，metrics ，每个 Endpoint 都可以关闭或打开，在启动应用后，我们的 Endpoint 的 id 就会和默认的路径 `/actuator` 合并, 比如, 我们 ID 为 health 的 Endpoint, 它最终会被映射到`/actuator/health` 这个API路径上, 为我们提供应用健康情况的数据一下。

Actuator 为我们提供预设的如下监控 Endpoint \(部分\)：

| ID | 作用 |
| :--- | :--- |
| `beans` | 返回所有注册到 IoC 容器中的 bean  |
| `env` | 返回应用中所有的配置环境变量 |
| `health` | 返回应用的健康信息 |
| `httptrace` | 返回最近100次 HTTP 请求的信息 |
| `metrics` | 返回应用的各项指标信息 |
| `mappings` | 返回请求和方法映射的信息 |

{% hint style="info" %}
  Actuator：机械系统中的控制，激励模块。

Endpoint：Web应用向外界提供的API，这里特指Actuator提供的API。
{% endhint %}

### 启动项目 - 实际体验

打开 [https://start.spring.io/](https://start.spring.io/) , 进入 Spring Boot Initilizer 页面, 只需选择两个 starter, 分别是 `spring-boot-starter-web` 和 `spring-boot-starter-actuator` 。很容易理解，我们需要 web 相关的依赖去提供 http 接口服务，因为 actuator 最终也是通过 endpoint 的形式向外暴露 Http based API。

![web &#x548C; actuator](./assets/images/spring-ini.png)

生成项目后，找到我们的配置文件，填写这样一行配置信息：

```text
management.endpoints.web.exposure.include = *
```

事实上，只有 health 和 info 这两个 Endpoint 是默认开启的，剩下的都默认关闭，所以我们需要上面的一行去开启所有的 Endpoint，以便于我们的教学展示。

因为 Actuator 提供给我们的这些信息，都是比较敏感的，具有一定安全级别的信息，总不能让所有人都随便访问，所以事实上，Actuator 本身是和 Spring Security 在一起结合使用，当我们的 pom 里声明了 spring-boot-starter-security 后，Actuator 暴露的 API 就自动会接受 Spring Security 的认证，但是为了保证每篇教程的独立性，我们的教学项目中不包含 Spring Security。

在终端打开生成的项目文件夹，输入 mvn spring-boot:run 命令，直接启动项目，不需要做任何代码上的操作，因为 Actuator 本身就是独立提供的。

在终端中，看到了一些输出，这是最后三行输出：

```text
INFO 19956 --- [  restartedMain] o.s.b.a.e.web.EndpointLinksResolver : 
    Exposing 15 endpoint(s) beneath base path '/actuator'
INFO 19956 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer : 
    Tomcat started on port(s): 8080 (http) with context path ''
INFO 19956 --- [  restartedMain] i.n.g.GsSpringBootActuatorApplication : 
    Started GsSpringBootActuatorApplication in 3.965 seconds (JVM running for 4.742)
```

分别告知我们，Actuator 暴露了 15 个 Endpoint，基地址是 /actuator，Tomcat 在8080端口启动了服务，我们的应用 GsSpringBootActuatorApplication 在3.965秒内启动。

很好理解，那么我们现在就直接可以去测试 Actuator 提供给我们的 API 了！

#### **/beans 测试**

好的，我们开始用 Postman 发送请求，对 /beans 进行测试，那么路径就是\`[http://localhost:8080/actuator/beans](http://localhost:8080/actuator/beans)\`：

返回的内容非常之多, 我们节选部分内容:

```text
"dispatcherServlet": {
    "aliases": [],
    "scope": "singleton",
    "type": "org.springframework.web.servlet.DispatcherServlet",
    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/DispatcherServletAutoConfiguration$DispatcherServletConfiguration.class]",
    "dependencies": []
}
```

我们看到了这个 bean，你一定对它比较熟悉，它就是我们 Spring MVC 中的 dispatcherServlet，起到分发请求到合适的 servlet 的作用，那么我们看一下它的信息, 属性 aliases \(备注\) 是空，这个不重要，属性 scope 是 singleton，说明 IoC容器工厂返回它的时候，是按照单例模式返回的，也就是说，在整个应用运行的过程中，它就被创建了一次，就一个 dispatchServlet，这也符合我们对 Spring MVC 的理解。

{% hint style="info" %}
单例模式 \(Singleton pattern\): 工厂

模式中的特殊情形, 指工厂初始化时就创建该实例, 每次向工厂获取该类型的实例时, 都返回那个相同的实例, 像这种高度可复用的实例, 一般为单例模式, 也是 IoC 模式中的默认模式，与之相对应的是 多例模式 , 即每向工厂请求一个 bean, 工厂就创建并返回一个新的实例, 它的 scope 为 prototype。
{% endhint %}

接下来，type 很简单，就是这个 bean 的类型，那当然是 DispatcherServlet 这个类型了，而 resource 值得我们注意，我们打开这个 resource 文件，看到这个：

```text
@Bean(name = DEFAULT_DISPATCHER_SERVLET_BEAN_NAME)
public DispatcherServlet dispatcherServlet() {
   DispatcherServlet dispatcherServlet = new DispatcherServlet();
   dispatcherServlet.setDispatchOptionsRequest(this.webMvcProperties.isDispatchOptionsRequest());
   dispatcherServlet.setDispatchTraceRequest(this.webMvcProperties.isDispatchTraceRequest());
   dispatcherServlet.setThrowExceptionIfNoHandlerFound(this.webMvcProperties.isThrowExceptionIfNoHandlerFound());
   dispatcherServlet.setEnableLoggingRequestDetails(this.httpProperties.isLogRequestDetails());
   return dispatcherServlet;
}
```

首先，当前文件隶属于  org.springframework.boot.autoconfigure ，所以正是 Spring Boot 在起着自动配置的作用，很显然，我们并没有自己配置 DispatcherServlet ，而上面的代码，就是对它的配置，这也是对 Spring Boot 核心功能 **自动配置** 的一个见证。

换句话说，刚才 Actuator 返回的所有 bean，全部是 Spring Boot 帮我们配置的，我们一个都没配置，这也是 **约定优于配置** 的一个体现。

#### /health 测试

使用 Postman 发送请求：[http://localhost:8080/actuator/beans](http://localhost:8080/actuator/beans)

返回了一个简单json数据：

```text
{
    "status": "UP"
}
```

没什么高深含义，含义就是 _应用正在运行_ 。

信息很少，因为这个 Endpoint 默认经过 Spring Security 的认证才能返回详细信息，但是我们没有 Spring Security，所以就只能得到省略后的信息，所以我们需要在 application.properties 中加这样一行：

 `management.endpoint.health.show-details = always`

表示任何时候都返回详细的健康信息，然后我们再请求一次:

```java
{
    "status": "UP",
    "details": {
        "diskSpace": {
            "status": "UP",
            "details": {
                "total": 213890060288,
                "free": 48489132032,
                "threshold": 10485760
            }
        }
    }
}
```

我们看到还返回了磁盘的信息，显示磁盘运行正常，总共的存储空间是 

$$
213890060288 bit \cong  213890060 Kb \cong 213890Mb \cong  213Gb
$$

空闲空间约是 48 Gb, 而 threshold , 即是门槛, 它表示应用所需的最小空间, 当磁盘的空闲空间少于 10 Mb 时, diskSpace 的状态就会由 `UP` 转为 `DOWN`, 表示磁盘空间不够了。

#### /mappings 测试

发送请求：[http://localhost:8080/actuator/mappings](http://localhost:8080/actuator/beans)/

在 Spring MVC 中我们知道, 一个请求是通过 dispather servlet 进行一个接收和分发, 然后每个请求最后会被映射到一个方法\(Handler\)上, 去处理请求并返回数据, 那么这个 /mappings 就是给我们提供这样的信息。

```text
{
    "handler": "Actuator web endpoint 'beans'",
    "predicate": "{GET /actuator/beans, produces [application/vnd.spring-boot.actuator.v2+json || application/json]}",
    "details": {
        "handlerMethod": {
            "className": "org.springframework.boot.actuate.endpoint.web.servlet.AbstractWebMvcEndpointHandlerMapping.OperationHandler",
            "name": "handle",
            "descriptor": "(Ljavax/servlet/http/HttpServletRequest;Ljava/util/Map;)Ljava/lang/Object;"
        },
        "requestMappingConditions": {
            "consumes": [],
            "headers": [],
            "methods": [
                "GET"
            ],
            "params": [],
            "patterns": [
                "/actuator/beans"
            ],
            "produces": [
                {
                    "mediaType": "application/vnd.spring-boot.actuator.v2+json",
                    "negated": false
                },
                {
                    "mediaType": "application/json",
                    "negated": false
                }
            ]
        }
    }
}
```

节选了关于 /actuator/beans 的映射信息，可以看到 patterns 属性里面对应我们的请求 url， 在 predicate 属性中显示了我们请求的基本信息，比如，方法（GET），url （/actuator/beans），还有返回的数据类型（Json）。

那么我们也可以得到该请求映射后的 servlet 是哪个类 ：

```text
AbstractWebMvcEndpointHandlerMapping
```

该请求的 handler 方法是:

```text
OperationHandler
```

有了  /mappings 的帮助，我们可以将这个数据推送给前端，前端再进行一个可视化渲染，就可以做出类似于 swagger 的图形界面的 API 管理系统了！

{% hint style="info" %}
更多 Actuator 的信息，请参考链接：[https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready.html](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready.html)
{% endhint %}

