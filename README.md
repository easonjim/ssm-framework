# ssm-framework
SSM脚手架  
# 使用
## 日志
日志统一放在/data/weblog/business/下，所以一开始需要创建该目录并赋予权限  
```shell
mkdir -p /data/weblog/business/
chmod -R 777 /data/weblog/business/
```
日志划分类error、info、debug、warn，其余再按业务进行细分  
日志保存策略：  
- 当天日志不写日期，其余日志按天划分并压缩（前提条件是当天日志超过1G才进行，如果当天日志不超过则还是在当前文件记录）
- 每天日志操作1G自动压缩
- 默认保存30天
## MyBatis代码生成
MyBatis采用Maven原生生成方式，统一的配置文件放置在resources/mybatis/mybatis-generator-config.xml，生成命令如下：  
```shell
mvn mybatis-generator:generate
mvn -Dmybatis.generator.overwrite=true -Dmybatis.generator.configurationFile=resources/mybatis/mybatis-generator-config.xml mybatis-generator:generate
```
注意：MyBatis不采用注解的方式，采用XML方式，原因是复杂的SQL用XML会更适合后续的维护  
dao：生成放在根目录，后续可根据需求按模块划分文件夹  
model：pojo生成放在根目录，后续可根据需求按模块划分文件夹  
划分文件夹的好处：后续生成的文件可以不用覆盖，而是拷贝对应更新的部分，也不用划分专门的生成文件夹进行管理  
MyBatis注解方式的使用放在dao/sys/user2的包下，此文件是通过代码生成器生成，但不建议使用注解方式！  
## 基于PageHelper的MyBatis分页组件使用
使用此组件可以减少在XML配置上手写分页参数limit，默认只在dao层写这几个参数即可实现分页：
```java
@Param("start") int pageNum, @Param("limit") int pageSize, @Param("order") String orderBy
```
如果要纯手写分页，需要避开上面的特定参数，比如：
```java
@Param("pageNum") int pageNum, @Param("pageSize") int pageSize
```
注意：对于分页的条件查询需要手动实现，比如where后面的条件
## 多环境打包处理
针对多环节，从源头打包入手，当然这些都可以在运维阶段用脚本进行替换来代替  
resources/environment/下有四个环境，local本地、dev开发、test测试、pre预上线、prod生产，打包命令如下：  
```shell
# 本地
mvn clean package -P local
# 开发
mvn clean package -P dev
# 测试
mvn clean package -P test
# 预上线
mvn clean package -P pre
# 生产
mvn clean package -p prod
```
说明：每个环境的文件夹下的配置文件可以全量放，也可以是增量，最终会覆盖  
## 实体
放在model文件夹下，可以按业务分模块分文件夹，也可以不分  
实体分类：
- 数据对象：xxxDO，xxx即为数据表名
- 数据传输对象：xxxDTO，xxx为业务领域相关的名称
- 展示对象：xxxVO，xxx一般为网页名称
- POJO是DO/DTO/BO/VO的统称，禁止命名成xxxPOJO

使用：
- 大小写不强烈要求，比如：DO可以是大写，也可以是小写Do
- 各实体间可以使用继承去实现，目的是各实体字段都相同时可以减少代码量，比如：model/sys/user下的实现
## Spring配置文件
配置文件采用import方式引入，入口为spring/spring-base.xml  
好处：每次新建配置文件只需要管理这个入口即可，而无需关心web.xml配置，让web.xml专心服务于web  
## 单元测试
用的最多的是Dao和Service的单元测试，其余测试可以参考MockMVC  
在test/resources文件夹下的文件文件名相同会覆盖main/resources  
