@[TOC](springboot+shardingJdbc5 实现) 

## 1、shardingJdbc 分片策略和分片算法

分片策略和分片算法是组合使用的。
分片策略中，分片键确定了数据的拆分依据。
分片算法则决定了如何对分片键值运算，将数据路由到哪个物理分片中。


