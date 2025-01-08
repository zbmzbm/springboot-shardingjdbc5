package com.example.shardingjdbc5demo.config;

import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

public class CustomTableShardingAlgorithm implements StandardShardingAlgorithm<String> {

    private Properties properties=new Properties();


    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
        String payNo = shardingValue.getValue();
        //获取payNo倒数二位数
        String tableIndex=payNo.substring(payNo.length()-1);
        Object tableName = properties.get("tableName");
        for (String each : availableTargetNames) {
            if (each.endsWith((tableName+"_"+tableIndex))) {
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<String> shardingValue) {
        // 范围查询时返回所有可用表
        return availableTargetNames;
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
