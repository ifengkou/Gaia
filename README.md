ZSE5 APP 后台接口，SpringMVC+Mybatis+SqlServer

主要包含用户权限，合同工程、任务计划报审、供货进度等模块

## 项目搭建：

[idea利用maven 快速搭建多module 的Web开发框架](./doc/IDEA利用maven 快速搭建SpringMvc开发框架.md)

## 打包

    1.修改 controller modules 下的 resources  - data sqlserver.properties(参考sqlserver_demo.properties)
    2.打包
    mvn clean package -Dmaven.test.skip=true