> 统一《零基础入门 Spring Boot》的行文规范。

## 目录

- [空格](#空格)
  - [中英文之间需要增加空格](#中英文之间需要增加空格)
  - [中文与数字之间需要增加空格](#中文与数字之间需要增加空格)
  - [数字与单位之间需要增加空格](#数字与单位之间需要增加空格)
  - [全角标点与其他字符之间不加空格](#全角标点与其他字符之间不加空格)
- [专业词汇](#专业词汇)
- [代码块](#代码块)
- [词条解释](#词条解释)
- [文件命名](#文件命名)
- [标点符号](#标点符号)
  - [不重复使用标点符号](#不重复使用标点符号)
  - [破折号前后需要增加一个空格](#破折号前后需要增加一个空格)
  - [省略号](#省略号)
- [全角和半角](#全角和半角)
  - [使用全角中文标点](#使用全角中文标点)
  - [数字使用半角字符](#数字使用半角字符)
  - [遇到完整的英文整句、特殊名词，其內容使用半角标点](#遇到完整的英文整句特殊名词其內容使用半角标点)
- [名词](#名词)
  - [专有名词使用正确的大小写](#专有名词使用正确的大小写)
  - [不要使用不地道的缩写](#不要使用不地道的缩写)
- [排版](#排版)
  - [斜体文字使用加粗样式代替](#斜体文字使用加粗样式代替)
  - [如果文章中有脚注怎么办](#如果文章中有脚注怎么办)
- [争议](#争议)
  - [链接之间增加空格](#链接之间增加空格)
  - [简体中文使用直角引号](#简体中文使用直角引号)
- [工具](#工具)
- [参考文献](#参考文献)

## 空格

### 中英文之间需要增加空格

正确：

> 在 LeanCloud 上，数据存储是围绕 `AVObject` 进行的。

错误：

> 在LeanCloud上，数据存储是围绕`AVObject`进行的。

> 在 LeanCloud上，数据存储是围绕`AVObject` 进行的。

完整的正确用法：

> 在 LeanCloud 上，数据存储是围绕 `AVObject` 进行的。每个 `AVObject` 都包含了与 JSON 兼容的 key-value 对应的数据。数据是 schema-free 的，你不需要在每个 `AVObject` 上提前指定存在哪些键，只要直接设定对应的 key-value 即可。

例外：「豆瓣FM」等产品名词，按照官方所定义的格式书写。

### 中文与数字之间需要增加空格

正确：

> 今天出去买菜花了 5000 元。

错误：

> 今天出去买菜花了 5000元。

> 今天出去买菜花了5000元。

### 数字与单位之间需要增加空格

正确：

> 我家的光纤入户宽带有 10 Gbps，SSD 一共有 20 TB。

错误：

> 我家的光纤入户宽带有 10Gbps，SSD 一共有 10TB。

例外：度／百分比与数字之间不需要增加空格：

正确：

> 今天是 233° 的高温。

> 新 MacBook Pro 有 15% 的 CPU 性能提升。

错误：

> 今天是 233 ° 的高温。

> 新 MacBook Pro 有 15 % 的 CPU 性能提升。

### 全角标点与其他字符之间不加空格

正确：

> 刚刚买了一部 iPhone，好开心！

错误：

> 刚刚买了一部 iPhone ，好开心！

## 专业词汇

有些词汇，它们有专业的性质，但是却不是代码，比如 **IoC容器**、 **Spring Boot**、 **Maven**, 这类词, 两边(如果有汉字)空格, 加黑。

正确：

>**IoC容器** 是 **Spring** 框架中的核心元素。

错误：

>**IoC容器**时**Spring**框架中的核心元素。

## 代码块

所有超过一行的代码块，请用 Markdown 的代码块语法包围，并声明 **语言标签**。

正确：

```java
public class Student {
    private String name;
    public void walk() {
        // do sth
    }
}
```

错误:

public class Student {
    private String name;
    public void walk() {
        // do sth
    }
}

错误:

    public class Student {
    private String name;
    public void walk() {
        // do sth
    }

## 词条解释

若文中出现了一些非主要内容相关，又不是很新手友好的词汇，比如 **jdbc**，**elasticsearch**，应在该段落后或本小节后加一个词条解释段落：

格式：

>**{解释词汇}**: {解释}

示例：

>**Elasticsearch**：一个基于 **Lucene** 的数据搜索，分析工具。


## 标点符号

### 不重复使用标点符号

正确：

> 德国队竟然战胜了巴西队！

> 她竟然对你说「喵」？！

错误：

> 德国队竟然战胜了巴西队！！

> 德国队竟然战胜了巴西队！！！！！！！！

> 她竟然对你说「喵」？？！！

> 她竟然对你说「喵」？！？！？？！！

### 破折号前后需要增加一个空格

正确：

> 你好，我是破折号 —— 一个不苟言笑的符号。

错误：

> 你好，我是破折号——一个不苟言笑的符号。

### 省略号

正确：

> 省略号是一格三点，连续两格…… 如果省略号后还有内容，则省略号与后面的内容之间加一个空格。

> 目前关于省略号的讨论还存在争议，讨论区详见：https://github.com/sparanoid/chinese-copywriting-guidelines/issues/58

错误：

> 一格一点，连续三个点... 或者连续六个点...... 这种方式是错误的。

> 一格一点，连续三个点。。。 或者连续六个点。。。。。。 这种方式是错误的。

## 全角和半角

不明白什么是全角（全形）与半角（半形）符号？请查看维基百科词条『[全角和半角](http://zh.wikipedia.org/wiki/%E5%85%A8%E5%BD%A2%E5%92%8C%E5%8D%8A%E5%BD%A2)』。

### 使用全角中文标点

正确：

> 嗨！你知道嘛？今天前台的小妹跟我说「喵」了哎！

> 核磁共振成像（NMRI）是什么原理都不知道？JFGI！

错误：

> 嗨! 你知道嘛? 今天前台的小妹跟我说 "喵" 了哎!

> 嗨!你知道嘛?今天前台的小妹跟我说"喵"了哎!

> 核磁共振成像 (NMRI) 是什么原理都不知道? JFGI!

> 核磁共振成像(NMRI)是什么原理都不知道?JFGI!

### 数字使用半角字符

正确：

> 这件蛋糕只卖 1000 元。

错误：

> 这件蛋糕只卖 １０００ 元。

例外：在设计稿、宣传海报中如出现极少量数字的情形时，为方便文字对齐，是可以使用全角数字的。

### 遇到完整的英文整句、特殊名词，其內容使用半角标点

正确：

> 乔布斯那句话是怎么说的？「Stay hungry, stay foolish.」

> 推荐你阅读《Hackers & Painters: Big Ideas from the Computer Age》，非常的有趣。

错误：

> 乔布斯那句话是怎么说的？「Stay hungry，stay foolish。」

> 推荐你阅读《Hackers＆Painters：Big Ideas from the Computer Age》，非常的有趣。

## 名词

### 专有名词使用正确的大小写

大小写相关用法原属于英文书写范畴，不属于本 wiki 讨论內容，在这里只对部分易错用法进行简述。

正确：

> 使用 GitHub 登录

> 我们的客户有 GitHub、Foursquare、Microsoft Corporation、Google、Facebook, Inc.。

错误：

> 使用 github 登录

> 使用 GITHUB 登录

> 使用 Github 登录

> 使用 gitHub 登录

> 使用 gｲんĤЦ8 登录

> 我们的客户有 github、foursquare、microsoft corporation、google、facebook, inc.。

> 我们的客户有 GITHUB、FOURSQUARE、MICROSOFT CORPORATION、GOOGLE、FACEBOOK, INC.。

> 我们的客户有 Github、FourSquare、MicroSoft Corporation、Google、FaceBook, Inc.。

> 我们的客户有 gitHub、fourSquare、microSoft Corporation、google、faceBook, Inc.。

> 我们的客户有 gｲんĤЦ8、ｷouЯƧquﾑгє、๓เςг๏ร๏Ŧt ς๏гק๏гคtเ๏ภn、900913、ƒ4ᄃëв๏๏к, IПᄃ.。

### 不要使用不地道的缩写

正确：

> 我们需要一位熟悉 JavaScript、HTML5，至少理解一种框架（如 Backbone.js、AngularJS、React 等）的前端开发者。

错误：

> 我们需要一位熟悉 Js、h5，至少理解一种框架（如 backbone、angular、RJS 等）的 FED。

## 排版

### 斜体文字使用加粗样式代替

正确：

> **斜体本身是为西文文字所设计，为了保持良好的阅读效果，在中文排版时不应出现斜体，因此统一使用加粗样式代替。**

错误：

> *斜体本身是为西文文字所设计，为了保持良好的阅读效果，在中文排版时不应出现斜体，因此统一使用加粗样式代替。*

### 如果文章中有脚注怎么办

~英文原文中经常会出现脚注的情况，但是众所周知，GitHub 目前还不支持脚注功能。但是我们可以选择如下的折中方案：~

~```~
~你看，这里是折中的脚注显示方案 <sup>[\[1\]](#note1)</sup>~

~1. <a name="note1"></a> [how-to-add-footnotes-to-github-flavoured-markdown](http://stackoverflow.com/questions/25579868/how-to-add-footnotes-to-github-flavoured-markdown)~
~```~

~预览效果如下：~

~> 你看，这里是折中的脚注显示方案 <sup>[\[1\]](#note1)</sup>~

~1. <a name="note1"></a> [how-to-add-footnotes-to-github-flavoured-markdown](http://stackoverflow.com/questions/25579868/how-to-add-footnotes-to-github-flavoured-markdown)~

英文原文中经常会出现脚注的情况，我们在译者 [LeopPro](https://github.com/LeopPro) 的推荐下，选择如下的方案：

```
这里是修改后的脚注显示方案 <sup><a href="#note1">[1]</a></sup>

1. <a name="note1"></a> [how-to-add-footnotes-to-github-flavoured-markdown](http://stackoverflow.com/questions/25579868/how-to-add-footnotes-to-github-flavoured-markdown)
```
预览效果如下：

> 这里是修改后的脚注显示方案 <sup><a href="#note1">[1]</a></sup>  

1. <a name="note1"></a> [how-to-add-footnotes-to-github-flavoured-markdown](http://stackoverflow.com/questions/25579868/how-to-add-footnotes-to-github-flavoured-markdown)

> 详见译者 [LeopPro](https://github.com/LeopPro) 提的 Issue：https://github.com/xitu/gold-miner/issues/3153

## 争议

以下用法略带有个人色彩，即：无论是否遵循下述规则，从语法的角度来讲都是**正确**的，但**同一篇文章风格要保持一致**。

### 链接之间增加空格

用法：

> 请 [提交一个 issue](#) 并分配给相关同事。

> 访问我们网站的最新动态，请 [点击这里](#) 进行订阅！

对比用法：

> 请[提交一个 issue](#) 并分配给相关同事。

> 访问我们网站的最新动态，请[点击这里](#)进行订阅！

### 简体中文使用直角引号

用法：

> 「老师，『有条不紊』的『紊』是什么意思？」

对比用法：

> “老师，‘有条不紊’的‘紊’是什么意思？”

> 目前建议使用这种方法

## 工具

仓库 | 语言
--- | ---
[vinta/paranoid-auto-spacing](https://github.com/vinta/paranoid-auto-spacing) | JavaScript
[huei90/pangu.node](https://github.com/huei90/pangu.node) | Node.js
[huacnlee/auto-correct](https://github.com/huacnlee/auto-correct) | Ruby
[sparanoid/space-lover](https://github.com/sparanoid/space-lover) | PHP (WordPress)
[nauxliu/auto-correct](https://github.com/NauxLiu/auto-correct) | PHP
[hotoo/pangu.vim](https://github.com/hotoo/pangu.vim) | Vim
[sparanoid/grunt-auto-spacing](https://github.com/sparanoid/grunt-auto-spacing) | Node.js (Grunt)
[hjiang/scripts/add-space-between-latin-and-cjk](https://github.com/hjiang/scripts/blob/master/add-space-between-latin-and-cjk) | Python

## 参考文献

* [Chinese Copywriting Guidelines](https://github.com/mzlogin/chinese-copywriting-guidelines)

