# 注解

> 在现代 **java** 框架中,注解无处不在,因此我们完全有必要搞明白注解到底是什么。

**注解** 是 **元数据**（matadata）的一种。

> **元数据** (matadata): 在程序语言中，它往往用来表明代码的一些基本的，但却与代码本身无关的信息，如，代码的作者，创作日期，在 java 中，也可以表示一个 class 的类型，作用等，是独立于逻辑之外的，代码的一些基本信息。如果把代码比做人，代码里面的逻辑就是你的血肉，而元数据则是你的名字，出生日期，班级，工作岗位等。

在 **java** 的 **Spring** 背景下，**元数据** 的含义和配置信息类似，比如我们对 **bean**

事实上，在注解出现之前，**元数据** 往往用 **xml** 格式写成，比如在 **Spring** 项目中，我们要声明一个 **bean**，以往是在 **xml** 文件中写上这几行：

```xml
<beans>
    <bean id="apple" class="x.y.Apple"/>

    <bean id="dog" class="x.y.Dog"/>
</beans>
```

但随着注解的引入，我们无需繁琐的 **xml** 配置文件，而是只需在我们的类名上加上 `@Component` 注解即可,随后 **Spring** 框架会 `@ComponentScan` 指定路径内的所有类进行扫描,凡是加有`@Component`注解的类,都注册到 **IoC容器** 中。

```java
@Configuration
public class AppConfig {

    @Bean
    public Apple apple() {
        return new Apple();
    }

    @Bean
    public Dog dog() {
        return new Dog();
    }
}
```

上面的两种配置，最终效果一模一样，但是显然，第二种 **注解式** 更为容易被 java 程序员所接受，而且，也更易维护，也容易提升代码的可读性。

除此之外,脱离开框架,回到语言本身,你最常见到的注解是哪个?

一定是 `@Override`。

当你的类继承了一个父类的时候，你常常需要将父类的一个方法进行 override，也就是重写，或覆写，实现接口也是一样的，在代码的编译期，当编译器读到 `@Override` 注解是,它会运行一个 **注解处理器(Annotation Processor)**, 以 `@Override` 举例,注解处理器会用 **反射(Reflection)** 机制来检查当前方法是否在它的父类中存在，如果不存在，就会报编译错误，从而在编译器降低了 bug 的发生率。

如果你还用过 **Lombok**,你一定对它影响深刻,在 **Jpa** 的实体（Entity）类中，我们常常需要对每一个类的私有 properties实现一组 `getter` 和 `setter`，这样我们的 Jpa 才能正常访问并改写它们，但是这种代码很简单，又很冗长，有了 **Lombok**，你只需在实体上加上 `@Data` 注解,在编译器，**Lombok** 会介入，在我们的代码基础上增添 `getter/setter`。

所以总结一下，注解在 Java 帝国中，主要有如下三个作用：

* 供编译器检查，提早发现错误（如`@Override`)
* 改变编译器的行为,生成代码（如 **Lombok**）
* 代码运行过程中做处理。（如 `@Bean`)

我们要知道，注解本身不做任何事，它只是一种预定义的元数据格式，真正起作用的是 编译期的注解处理器，代码运行过程中的反射代码去起作用。

现在，我们学习如何创建自己的注解，并且运用反射，在代码运行中提取注解信息，对信息做一些处理。

写一个注解和写一个接口很类似，基本语法是这样：

```java
@interface MataData {
    String author();
    String date();
}
```

区别主要在于，注解的定义是在注解名前加 `@interface` 而不是 `Interface`。

内部有一些方法,和接口一样,没有实现,只有声明,这些方法事实上最后会成为注解的属性.

使用注解的时候，我们这样既可：

```java
@MataData (
    author = "taylor swift"，
    date = "8/18/2019"
)
public class SampleClass {
    // 业务代码
}
```

为了更好地对注解的作用进行分类，**J2SE 5.0** 提供了四个注解对自定义注解进行配置：

* `@Documented` 是否添加到 Javadoc 中。
* `@Target` 注解可以添加到哪些地方（类名，方法名等）
* `@Retention` 注解的用途
* `@Inherited` 用于配置继承后的子类是否也享有该注解。

### @Documented

在上面的代码中，我们希望`MataData`中的数据被加到 JavaDoc 中,所以我们加上 `@Documented` 注解.

### @Target

注解可以注在方法名上，类名上，函数参数前,等等,于是我们需要它来限制我们的注解存在的位置，它接受如下参数：

* **ElementType.ANNOTATION_TYPE** 可以在注解上添加。
* **ElementType.CONSTRUCTOR** 可以在构造函数上添加
* **ElementType.FIELD** 可以在变量或属性上添加
* **ElementType.LOCAL_VARIABLE** 可以在局部变量上添加
* **ElementType.METHOD** 可以在方法上添加
* **ElementType.PACKAGE** 可以在包名上添加
* **ElementType.PARAMETER** 可以在函数参数上添加
* **ElementType.TYPE** 可以在类中的任意元素上添加

### @Retention

`@Retention`有三个选项:

* **RetentionPolicy.SOURCE** 只在源码中起作用，只是用作编译器编译的参考, 不会进入编译后的 bytecode 中，比如 `@Override` 和 `@SuppressWarnings`.
* **RetentionPolicy.CLASS** 在编译期会起作用，一般和注解插件一起使用，从而起到在编译器增添代码的作用，比如 **Lombok** 中的 `@Data`，在 bytecode 执行的过程中，JVM 会忽略它的存在。
* **RetentionPolicy.RUNTIME** 该类型的注解信息会进入编译后的 bytecode 中，注解信息可以在程序执行过程中被获取，典型的例子有 **Spring** 中的`@Component`, `@Bean`等。

> **Retention**：在英文中，它的本意是记忆的维持，物质的保存等，在这里即是表示注解的存活时间。

我们现在可以看一下`@Autowired` 注解的源码：

```java
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {

    /**
     * Declares whether the annotated dependency is required.
     * <p>Defaults to {@code true}.
     */
    boolean required() default true;

}
```

这是 **Spring** 学习者再熟悉不过的注解，它是 **RUNTIME** 类型的，表示注解会最终进入 bytecode 中，供运行时程序调用，注解可以加在构造函数，方法，参数，变量，注解上，且注解进入 javadoc 中。

接下来，我们尝试使用注解，在程序运行过程中，运用反射（Spring 框架等的做法），获取类的注解信息，然后改变我们程序的行为。








