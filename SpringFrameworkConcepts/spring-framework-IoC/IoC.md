## IoC 容器
> IoC 容器的本质是一个“生产 Bean 的工厂”，当我们的 bean 注册到容器中后，在程序的运行过程中，或是代码中，我们可以直接向 IoC 索取我们想要的 bean 实例，而不是使用传统的 `new foo` 这种方式。

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

那么更多的问题来了,如果轮胎本身又依赖于别的东西呢?

如果轮胎又依赖于轮毂,那么我们为了创造一个汽车,变得更加的麻烦!

我们需要先创造一个轮毂实例,再创建一个轮胎实例,把轮毂传到轮胎里,然后再创建一个汽车实例,把轮胎传入汽车里,这就构成了一个很恐怖的 **依赖链**.

而真实的企业级应用中,或是框架中,充斥着大量的依赖链,给各种对象的实例化带来了巨大麻烦(在 Spring 的场景下, 就是 **bean**),所以我们希望能有一个类似于工厂的东西，我们让这个工厂帮助我们管理依赖，创建实例，最后达到这样的效果：








很好理解，因为汽车需要轮胎，所以我们在 `Car`的 Constructor 中创建了一个轮胎实例，那么到现在为止，我们的`Car`就依赖于`Wheel`, 因为`Wheel`确实出现在了 `Car` 的内部，那么当我们使用 `Car` 的时候, 我们当然要创建一个实例,就像这样:

```java
Car car = new Car();
```

因为 `Wheel` 是在 `Car` 的内部创造的, 所以说, 当我们创造了一个 `Car` 的时候,相当于把 `Car` 和它所依赖的所有东西,比如轮胎,也一并创建了,而且最关键的是,这个轮胎的创建,是在你的控制之外的,也就是说,是 `Car` 自身的实现去控制着它将要创建哪个轮胎。

我们希望，我们可以自由地控制这个汽车使用什么轮胎,我们希望我们从外界去传入轮胎,