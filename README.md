@[TOC](springboot+shardingJdbc5 实现) 

## 一、shardingJdbc 分片策略和分片算法

分片策略和分片算法是组合使用的。
分片策略中，分片键确定了数据的拆分依据。
分片算法则决定了如何对分片键值运算，将数据路由到哪个物理分片中。

分片策略来指定使用哪种分片算法、选择哪个字段作为分片键以及如何将数据分配到不同的节点上。
分片策略是由分片算法和分片健组合而成，分片策略中可以使用多种分片算法和对多个分片键进行运算。
分片算法则是用于对分片键进行运算，将数据划分到具体的数据节点中。

## 二、shardingJdbc 自定义分库分表
1、引入jar包
```java
 <dependency>
    <groupId>org.apache.shardingsphere</groupId>
    <artifactId>shardingsphere-jdbc-core-spring-boot-starter</artifactId>
    <version>5.2.1</version>
</dependency>
```
2、编写配置文件
见代码配置文件
application-self.yml


## 三、问题
启动报错，我们引入snakeyaml覆盖即可




