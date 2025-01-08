package com.example.shardingjdbc5demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shardingjdbc5demo.domain.Bill;
import com.example.shardingjdbc5demo.domain.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 主账单明细表 Mapper 接口
 * </p>
 *
 * @author zbm
 * @since 2024-05-22
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

}
