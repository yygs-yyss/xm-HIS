package com.example.demo.controller;

import com.example.demo.VO.ResultVO;
import com.example.demo.common.EncryptComponent;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.beans.Encoder;
import java.util.Map;

@Api(value = "用户管理", tags = {"管理员用户操作"})
@Slf4j
@RestController
@RequestMapping("/api/admin")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private EncryptComponent encryptComponent;
    @Autowired
    private PasswordEncoder encoder;
    @ApiOperation(value = "添加用户")
    @PostMapping("/add")
    public ResultVO insert(@RequestBody User user) {
        user.setRole(2);
        user.setPassword(encoder.encode(user.getPassword()));
        userService.insert(user);
        return ResultVO.success(Map.of());
    }
}
