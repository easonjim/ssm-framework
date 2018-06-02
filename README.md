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
- 当天日志不写日期，其余日志按天划分并压缩
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
## 多环节打包处理
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