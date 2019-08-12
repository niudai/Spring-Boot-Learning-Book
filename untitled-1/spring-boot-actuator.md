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

{% hint style="info" %}
  Actuator：机械系统中的控制，激励模块。

Endpoint：Web应用向外界提供的API，这里特指Actuator提供的API。
{% endhint %}

### 启动项目 - 实际体验

打开 [https://start.spring.io/](https://start.spring.io/) , 进入 Spring Boot Initilizer 页面, 只需选择两个 starter, 分别是 `spring-boot-starter-web` 和 `spring-boot-starter-actuator`

