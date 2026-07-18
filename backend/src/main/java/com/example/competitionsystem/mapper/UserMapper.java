package com.example.competitionsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.competitionsystem.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
