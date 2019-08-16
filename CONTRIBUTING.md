# 贡献 《零基础入门 Spring Boot》

>《零基础入门 Spring Boot》还在初创阶段，诚挚邀请各位为该书的建设贡献一份力量，该书完成后，将会联系出版，部分优秀贡献者将写入共同作者名单。

 - [本书特点](#feature)
 - [建议 Issue](#issue)
 - [贡献 PR](#submit)

## <a name = "feature"></a> 写作规范

* 本书的所有章节文章用 Markdown 格式写成，贡献者应熟练基本的 Markdown 语法，章节内容模板请按照[模板](./TEMPLATE.md)和[排版规则](./LAYOUT.md)
* 本书是面向新手的教程，原则上，本书只假定读者有 **Java SE** 和 **Maven** 基础，所以在行文上，应尽可能通俗，不应该有强烈的死板教条感，尤其是在概念的讲解上，尽可能避免晦涩难懂的专业词汇，多运用类比，降低读者理解难度。
* 贡献者应当细读该项目代码的 [文件结构](./FILE_STRUCTURE.md), 遵循统一的文件结构和文件命名。
* 本书提纲，章节由项目拥有者 [牛岱](https://github.com/niudai) 制定, 章节提纲发布后将接受所有同学提交 PR 完成内容填充。
* 本书所有内容以 **Spring Boot 2.1.7**, **Spring Framework 5.1.9** 版本为教学版本（现最新稳定版本），在未来通过开启新分支的形式增加更新版本的教程。


## <a name="issue"></a> Issue

### Bug反馈

在教程的开源写作中，教程本身难免会有缺陷，比如，目录和文章不匹配，部分链接失效等，可以直接提issue，让项目管理者第一时间得知问题，解决问题。

### 内容建议

如果你认为该书应该增添某些内容，或是删除某些内容，抑或是对文章语言风格的建议，都可以随时通过 issue 提出你宝贵的建议。

## <a name="submit"></a> 贡献指引

### <a name="submit-pr"></a> 提交 (PR)

在提交PR之前:

1. Fork 该项目.
2. 创建一个新 branch，切换至该 branch，:

     ```shell
     git checkout -b my-fix-branch master
     ```

3. 完成内容创作/校对。
4. 检查你的内容是否满足 [模板](./TEMPLATE.md) 和 [排版规则](./LAYOUT.md)。
5. commit你的新增内容，并在 commit 信息中简单扼要地说明你的更新内容。

     ```shell
     git commit -a
     ```
    >小贴士: 参数 `-a` 会自动进行 "add" 和 "rm" 操作。

6. 将你的内容 push 到你的 Github Repository:

    ```shell
    git push origin my-fix-branch
    ```

7. 在 Github 中，向原项目的 master 分支发起 Pull Request，请在 PR 中准确描述你的 PR 类型是 **校对** 还是 **内容**，校对指对现有内容的校对，**内容**指在已经提供好的提纲下填充了知识内容。

经过项目管理者的审核，通过后会将你的 PR 和 master 进行合并。


#### PR 被接收后

如果你的 PR 成功被我们 merge 到主干，你就可以将你原来开的 branch 删除了（因为你的branch 已经成为我们的 master 了）:

* 删除你的 github 上的 PR 分支：

    ```shell
    git push origin --delete my-fix-branch
    ```

* 切换至 master 分支:

    ```shell
    git checkout master -f
    ```

* 删除本地的 PR 分支:

    ```shell
    git branch -D my-fix-branch
    ```

* 使用 git pull 命令将你的本地代码和原项目进行同步：

    ```shell
    git pull --ff upstream master
    ```
