package com.task.platform.tcp.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.task.platform.tcp.entity.User;
import com.task.platform.tcp.mapper.UserMapper;
import com.task.platform.tcp.vo.UserVO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    public UserVO register(String username, String password){

        // 先查数据库，判断用户名是否已存在
        User existUser = userMapper.selectOne(
                new QueryWrapper<User>()
                        .eq("username", username)
        );

        // 如果存在，直接抛异常（这是业务异常）
        if (existUser != null) {
            throw new RuntimeException("用户名已存在");
        }

        // 不存在才创建新用户
        User user = new User();
        user.setUsername(username);
        user.setPassword(password); // 现在还是明文，后面会加密
        userMapper.insert(user);

        UserVO vo = new UserVO();
        vo.setId(user.getId());
        vo.setUsername(username);

        return vo;
    }

    public User login(String username, String password){
        return userMapper.selectOne(
                /*new QueryWrapper()
                建条件容器 → .eq() 拼等值条件 → selectOne() 执行查询返回单条结果；*/
                new QueryWrapper<User>()
                .eq("username", username)
                .eq("password", password)
        );
    }
}
