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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.util.Map;
@Api(value = "处理登录请求操作", tags = {"登录以及用户操作"})
@Slf4j
@RestController
@RequestMapping("/api/")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private EncryptComponent encryptComponent;
    @Autowired
    private PasswordEncoder encoder;
    @ApiOperation("处理登录请求")
    @PostMapping("login")
    public ResultVO login(@RequestBody User user, HttpServletResponse response){
        User u = userService.getUser(user.getUserName());
        log.debug("{}",encoder.encode(u.getPassword()));
        if(u == null || !encoder.matches(user.getPassword(),u.getPassword())){
            return ResultVO.error(401,"用户名密码错误");
        }
        log.debug("{}",encoder.encode(u.getPassword()));
        log.debug("{}\n{}",user.getPassword(),u.getPassword());
//        userService.UserCache(u.getId());
        String token = encryptComponent.encrypt(Map.of("uid",u.getId(),"role",u.getRole()));
        response.addHeader("token",token);
        log.debug("{}",token);
        return ResultVO.success(Map.of("user",u));
    }
    @ApiOperation(value = "查询个人信息")
    @GetMapping("get/{userName}")
    public ResultVO getInformation(@PathVariable String userName) {
        log.debug("111");
        User user = userService.getUser(userName);
        return ResultVO.success(Map.of("user",user));
    }
    @ApiOperation(value = "修改个人信息")
    @PatchMapping("changeInformation")
    public void changeInfomation(@RequestBody User user) {
        log.debug("111");
        userService.updateUser(user.getUserName(), user.getName(), user.getAge(), user.getGender(), user.getDetail());
    }
    @ApiOperation(value = "修改密码")
    @PatchMapping("changePassword/{userName}")
    public ResultVO changePassword(@PathVariable String userName, @RequestBody String oldPwd, @RequestBody String newPwd) {
        User u = userService.getUser(userName);
        if(u == null || !encoder.matches(oldPwd,u.getPassword())){
            return ResultVO.error(401,"用户名密码错误");
        }
        userService.changePassword(userName, newPwd);
        return ResultVO.success(Map.of());
    }

}
