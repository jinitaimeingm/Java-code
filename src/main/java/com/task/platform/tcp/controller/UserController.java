package com.task.platform.tcp.controller;

import com.task.platform.tcp.common.Result;
import com.task.platform.tcp.entity.User;
import com.task.platform.tcp.service.UserService;
import com.task.platform.tcp.vo.UserVO;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/register")
    public Result<UserVO> registerUser(@RequestParam String username,
                                     @RequestParam String password) {

        //  基础参数校验（Controller 只做“是否合法”，不做业务）

//                    先把用户名的前后空格删掉，再判断是不是空字符串。
        if (username == null || username.trim().isEmpty()) {

//            快速创建一个 “操作失败” 的返回结果对象。
            return Result.fail("username不能为空");
        }
        if (password == null || password.trim().isEmpty()) {
            return Result.fail("password不能为空");
        }

        //  业务交给 Service
        UserVO userVO = userService.register(username, password);

        return Result.success(userVO);

    }

    @PostMapping("user/login")
    public Result<User> login(@RequestParam String username,
                              @RequestParam String password){
        User user = userService.login(username, password);
        if(user == null){
            return Result.success(null);
        }
        return Result.success(user);
    }
}
