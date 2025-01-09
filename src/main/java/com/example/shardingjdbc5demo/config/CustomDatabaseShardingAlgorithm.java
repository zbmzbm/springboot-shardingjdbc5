package com.example.shardingjdbc5demo.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

@Slf4j
public class CustomDatabaseShardingAlgorithm implements StandardShardingAlgorithm<String> {

    private Properties properties=new Properties();

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
        String payNo = shardingValue.getValue();
        String dbIndex=payNo.substring(payNo.length() - 2,payNo.length() - 1);
        Object dbName = properties.get("dbName");
        for (String each : availableTargetNames) {
            if (each.endsWith(String.valueOf(dbName+dbIndex))) {
                log.info("选择的数据库是：{}",each);
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<String> rangeShardingValue) {
        // 范围查询时返回所有可用数据源
        return collection;
    }

    @Override
    public Properties getProps() {
        return null;
    }

    @Override
    public void init(Properties properties) {
        this.properties=properties;
    }

}
