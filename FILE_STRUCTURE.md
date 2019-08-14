# 《零基础入门 Spring Boot》文件结构

```
CONTRIBUTING.md // 代码贡献指南
LAYOUT.md // 文章基本排版
TEMPLATE.md // 行文规范
SUMMARY.md // 目录
FILE_STRUCTION.md // 项目文件结构
Spring Boot快速入门 // 快速入门 Spring Boot
    +- spring-boot-{章节名}.md // 章节主文件
    +- spring-boot-{章节名}-assets // 该章节静态资源
        |
        +- images // 该章节所有图片
            +- {descriptive name}.md
        +- code
            +- {sourcecode} // 该章节教程源代码(统一用 Spring initializer 生成)
    +- READEME.md // 分区简介 + 子目录
Spring Boot核心组件 // 核心组件 + 源码刨析
    +- {content}
    +- README.md
Spring Framework核心概念 // Spring Boot 的前置知识
    +- {content}
    +- README.md
```

该书的最大分类不是"章节", 而是"区"，我们对书内容进行大类分区，暂时分为 `Spring Boot快速入门`、`Spring Boot核心组件`、`Spring Framework核心概念`。

