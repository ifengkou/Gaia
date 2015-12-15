# idea利用maven 快速搭建多module 的Web开发框架 #

**key words:** IntelliJ,IDEA,module,web,maven

## create a project ##

create a project -> 左侧选择maven -> 弹出页填好groupid 和 artifactid -> 填好project name

建好后删除主module 的src文件夹

## create modules ##

右键项目，再新建 commons,model,dal,service,controller 四个module

根据需要修改这些module的pom.xml，例如其中parent module 的pom.xml

	<groupId>cn.ifengkou</groupId>
    <artifactId>Gaia</artifactId>
    <packaging>pom</packaging>
    <version>1.0-SNAPSHOT</version>
    <modules>
        <module>gaia.dal</module>
        <module>gaia.service</module>
        <module>gaia.controller</module>
        <module>gaia.common</module>
    </modules>

controller module pom.xml 中多一个

	<parent>
        <artifactId>Gaia</artifactId>
        <groupId>cn.ifengkou</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <packaging>war</packaging>  <!--表示打包成war-->
    <artifactId>gaia.controller</artifactId>

其他的module，根据引用关系，添加依赖关系，如：

    <dependencies>
        <dependency>
            <groupId>cn.ifengkou</groupId>
            <artifactId>gaia.common</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
		<!--..其他..-->

一开始无法在module里面加package，因为一开始项目的Sources Root 只有 parent 的src - main -java 

所以在各个子module 的java文件夹上，右键 make Directory as -> Sources Root

变为Sources Root 后，就可以右键 新建 package 了


## add Frameworks Support ##

右键controller module，点击  **add Frameworks Support...**

勾选Web Application，（右侧有创建web.xml），点击确定后，就会自动创建好web.xml


## Run/Debug Configuration  ##

菜单run - edit configuration (或者运行工具栏)

弹出配置页面，点左上角 的 '+' 号，选择tomcat-local
右侧 填上 name , 选项卡 deployment + controller:war exploded


## 完善 pom.xml ##

parent module pom 采用 dependencyManagement 形式：

	<dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>${junit.version}</version>
            </dependency>
			......

子module 按需加入dependency，不需要带version，version交给parent pom统一管理：

	<dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <scope>test</scope>
        </dependency>
		......

## web.xml,Spring.*.xml，dataSrouce，cache 等等 配置 ##

根据项目情况自己配置

## maven 命令 ##






	

