# IoC 容器 和 依赖注入

> IoC 容器的本质是一个“生产 Bean 的工厂”，当我们的 bean 注册到容器中后，在程序的运行过程中，或是代码中，我们可以直接向 IoC 索取我们想要的 bean 实例，而不是使用传统的 `new` 这种方式。

## 理解 IoC 和 依赖注入

学习 IoC 容器前，先要明白 IoC 到底代表什么。

IoC 是控制反转（Inversion of control）的含义，给人一种很难懂的感觉，没关系，我们先谈场景，再谈概念。

假设我们现在有一个类，名叫 `Car`，为了创造一台完整的汽车，我们需要`Wheel`(轮胎)。

```java
public class Car {
    private IWheel wheel;

    public Car() {
        this.wheel = new SmallWheel();
    }
}
```

`IWheel` 是一个接口,它规定了一个轮胎必须要有的方法和属性: 

```java

public Interface IWheel {
    private int size; //轮胎尺寸
    public void roll ();
}

```

关于这个接口,有两个实现,分别是`SmallWheel`和`BigWheel`:

一个是小轮胎，适合跑车，一个是大轮胎，适合大脚车或越野车，实现类分别是：

```java
public class SmallWheel {
    private int size = 5; //轮胎尺寸
    public void roll () {
        System.out.println("I can roll very fast");
    };
}
```

```java
public class BigWheel {
    private int size = 5; //轮胎尺寸
    public void roll () {
        System.out.println("I can roll on steaper road");
    };
}
```

那么如果我们直接在 `Car` 中创建一个满足 `IWheel` 接口的实例,我们必须选择一种实现,比如,小轮胎,这样就让`Car`本身和轮胎深度绑定在一起,不具有"可定制"性，我们希望轮胎能以一种类似于组装车的感觉,`Car`本身不包含轮胎,轮胎是从外界"注入"进去的。

当我创建一个 `Car` 的实例的时候,如果不传入具体的轮胎实例,汽车就像是一个没有轮胎的,不完整的汽车.

为了实现上述目的,我们将 `Car` 的代码做如下改动:

```java
public class Car {
    private IWheel wheel;

    public Car(IWheel wheel) {
        this.wheel = wheel;
    }
}
```

现在轮胎的确是从外界“注入”进去的，光看`Car`的代码,我们也不知道这个`Car`最终组装完毕,它的轮胎到底什么类型的.

这就是所谓的 **依赖注入** 模式, 即汽车所依赖的轮胎不是从汽车内部直接创造,而是从外界注入进来,降低了汽车和轮胎的耦合程度.

那么这时,用户使用 `Car` 的时候, 就可以这样:

```java

// 创造一个大脚车
IWheel wheel = new BigWheel();
Car car = new Car(wheel);

// 创造一个跑车
IWheel wheel = new SmallWheel();
Car car = new Car(wheel);

```

那么这时,轮胎类型和具体实现的控制权,由汽车内部反转到了用户手里,这就是所谓的 **控制反转**.

## 依赖链

那么更多的问题来了,如果轮胎本身又依赖于别的东西呢?

如果轮胎又依赖于轮毂,那么我们为了创造一个汽车,变得更加的麻烦!

我们需要先创造一个轮毂实例,再创建一个轮胎实例,把轮毂传到轮胎里,然后再创建一个汽车实例,把轮胎传入汽车里,这就构成了一个很恐怖的 **依赖链**.

而真实的企业级应用中,或是框架中,充斥着大量的依赖链,给各种对象的实例化带来了巨大麻烦(在 Spring 的场景下, 就是 **bean**),所以我们希望能有一个类似于工厂的东西，我们让这个工厂帮助我们管理依赖，创建实例，最后达到这样的效果：

```java

// 向 bean 工厂要一个 汽车 实例
Car car = beanFactory.getBean("car");

// 向 bean 工厂要一个 轮胎 实例

IWheel wheel = beanFactory.getBean("wheel");
```

有了 `BeanFactory` 这个工厂,客户端就能很轻松的获取各种实例了,而不用向我们之前那样为了创造汽车而创造轮子.

但是这样的话，我们仿佛失去了由 **依赖注入** 赋予我们的控制权。

## 配置与业务分离

没关系，这时我们就要用到一种新的设计思想，就是 **配置与业务分离**。

我们在 **配置区** ，告诉 `BeanFactory` 我们要哪些 `bean`,比如,像这样:

```java
@Configuration // 该注解表示这个类是负责配置的，而不是业务代码
public class CarConfig {
    // 对汽车相关的 bean 进行配置

    @Bean
    public IWheel wheel() { // bean 的名字默认是方法名
        return new SmallWheel(); // 配置成 小轮胎
    }

    @Bean
    public Car car(IWheel wheel) {
        return new Car(wheel); // 外界传入轮胎，返回完整的汽车实例
    }
}

```

我们对轮胎和汽车进行了配置之后，IoC容器会扫描到我们的配置文件，然后在应用开始的时候，将这些 `bean` 装在到容器中,供我们使用。

## 总结

控制反转就是指在使用Spring Framework之后，对象的实例 `bean` 不再由调用者来创建，而是由Spring容器来创建，Spring容器会负责控制程序之间的关系，而不是由调用者的程序代码直接控制（不用自己写Car里面的wheel了）。这样，控制权由应用代码转移到了Spring容器，控制权发生了反转。

## NOTE

DI的全称是Dependency Injection，中文称之为依赖注入。它与控制反转（IoC）的含义相同，只不过这两个称呼是从两个角度描述的 **同一个概念** 。从Spring容器的角度来看，Spring容器负责将被依赖对象赋值给调用者的成员变量，这相当于为调用者注入了它依赖的实例，这就是Spring的依赖注入。
