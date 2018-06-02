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
### MyBatis代码生成
MyBatis采用Maven原生生成方式，统一的配置文件放置在resources/mybatis/mybatis-generator-config.xml，生成命令如下：  
```shell
    mvn mybatis-generator:generate
    mvn -Dmybatis.generator.overwrite=true -Dmybatis.generator.configurationFile=resources/mybatis/mybatis-generator-config.xml mybatis-generator:generate
```
注意：MyBatis不采用注解的方式，采用XML方式，原因是复杂的SQL用XML会更适合后续的维护  
dao：生成放在根目录，后续可根据需求按模块划分文件夹  
model：pojo生成放在根目录，后续可根据需求按模块划分文件夹  
划分文件夹的好处：后续生成的文件可以不用覆盖，而是拷贝对应更新的部分，也不用划分专门的生成文件夹进行管理  
