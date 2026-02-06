package com.task.platform.tcp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.task.platform.tcp.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
