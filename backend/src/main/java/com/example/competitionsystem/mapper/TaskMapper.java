package com.example.competitionsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.competitionsystem.entity.Task;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskMapper extends BaseMapper<Task> {
}
