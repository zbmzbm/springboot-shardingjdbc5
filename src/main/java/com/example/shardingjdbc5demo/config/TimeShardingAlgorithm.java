package com.example.shardingjdbc5demo.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;
import java.util.*;

/**
 * <p> @Title TimeShardingAlgorithm
 * <p> @Description 分片算法，按月分片
 *
 * @author ACGkaka
 * @date 2022/12/20 11:33
 */
@Slf4j
public class TimeShardingAlgorithm implements StandardShardingAlgorithm<String> {

    /**
     * 精准匹配
     * @param collection
     * @param preciseShardingValue
     * @return
     */
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
        //精确分片
        log.info("logic table name:{},rout column:{},column value:{}", preciseShardingValue.getLogicTableName(), preciseShardingValue.getColumnName(),preciseShardingValue.getValue());
        // 根据当前日期 来 分库分表
        String date = preciseShardingValue.getValue();
        // 选择表
        String tb_name = preciseShardingValue.getLogicTableName() + "_" + date;
        log.info("Precise路由到的真实表:" + tb_name);
        if(collection.contains(tb_name)) {
            return tb_name;
        }
        throw new IllegalArgumentException();
    }

    /**
     * 范围查询
     * @param collection
     * @param rangeShardingValue
     * @return
     */
    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<String> rangeShardingValue) {
        log.info("collection:{},rangeShardingValue:{}", collection, rangeShardingValue);
        Set<String> set = new HashSet<>();
        String lowerEndpoint = rangeShardingValue.getValueRange().lowerEndpoint();
        String upperEndpoint = rangeShardingValue.getValueRange().upperEndpoint();
        int start = Integer.parseInt(lowerEndpoint);
        int end = Integer.parseInt(upperEndpoint);
        for(String item:collection){
            String[] tem = item.split("_");
            int dateMonth=Integer.parseInt(tem[tem.length-1]);
            if(dateMonth >= start && dateMonth <= end){
                set.add(item);
            }
        }
        log.info("range真实路由的表:{}", set);
        return set;
    }


    @Override
    public String getType() {
        return null;
    }

    @Override
    public Properties getProps() {
        return null;
    }

    @Override
    public void init(Properties properties) {

    }
}

